import imp
import keyring
import os
import time
import subprocess
import re 
import threading
import logging
from medex.settings import __CREDENTIALS__, __MY_DEBUG__
from .salesforce import ComplexSF

class QuoteBot():
    def __init__(self, username):
        self.username = username
        self.lambdacreds = self.get_lambda_creds
        self.bot_dir = self.get_bot_dir
        self.stdout_name = f"stdout{self.username}"
        if __MY_DEBUG__:
            self.temp_dir = os.path.join(os.getcwd(), 'medex', 'temp')
            if not os.path.exists(self.temp_dir):
                os.mkdir(self.temp_dir)
        else:
            self.temp_dir = os.path.join(os.getcwd(), 'temp')
            if not os.path.exists(self.temp_dir):
                os.mkdir(self.temp_dir)

        self.qc_logger = logging.getLogger("quote_creator")
        self.mvn_output_loc = None
        self.session_id = None
        self.subproc = None
        self.follow_up_url = None

    @property
    def get_lambda_creds(self):
        temp_creds = __CREDENTIALS__["LambdaTest"]
        creds = {}
        creds['username'] = temp_creds['username']
        creds['password'] = keyring.get_password(temp_creds['service_name'], temp_creds['username'])
        assert creds['password'] is not None, 'Lambda_credentials unavailable. Check the Windows Credential manager'
        return creds
    
    @property
    def get_bot_dir(self):
        if __MY_DEBUG__:
            return os.path.join(os.getcwd(), 'medex', 'bot', 'medex_2022_06_17')
        else:
            return os.path.join(os.getcwd(), 'bot', 'medex_2022_06_17')

    @property
    def command_list(self):
        return ['mvn', 'test', f'-Dcucumber.options="--tags @uid1379562945"', '-DenvironmentType=staging', '-DbrowserName=Lambda']

    @property
    def bot_command(self):
        return ' '.join(self.command_list)

    @property
    def output_filename(self):
        if self.mvn_output_loc is None:
            return None
        o_path = os.path.join(self.mvn_output_loc, 'report.html')
        return os.path.join(o_path)

    @property
    def stdout_txt(self):
        return os.path.join(self.temp_dir, f'{self.stdout_name}.txt')

    @property
    def feature_files(self):
        path = os.path.join(self.bot_dir, 'src', 'test', 'java', 'features')
        return [os.path.join(path, f) for f in os.listdir(path)]

    def execute(self):
        try:
            self.qc_logger.info("Triggering bot.")
            self.trigger_bot()
        except Exception as e:
            print(e)
    
    def trigger_bot(self):
        id_pattern = re.compile(r"SESSION ID => [a-z|A-Z|0-9]{32} <=")
        path_pattern = re.compile(r"PATH :[^\n]*Run_[0-9]{13}")
        with open(self.stdout_txt, 'w+') as f:
            f.write("Command executed:\n")
            f.write(f"{self.bot_command}\n")
            f.write("Location:\n")
            f.write(self.bot_dir)
            f.write('\n\n')
            f.write("Start StdOut:\n\n")
        with threading.RLock():
            subproc = subprocess.Popen(self.bot_command,
                                       stdout=subprocess.PIPE,
                                       stderr=subprocess.STDOUT,
                                       shell=True,
                                       cwd=self.bot_dir)
            time.sleep(1)
        self.qc_logger.info("Started subprocess. ")
        with open(self.stdout_txt, 'a') as stdoutfile:
            while subproc.poll() is None: # poll returns None when the process is still running -> https://stackoverflow.com/questions/2995983/using-subprocess-wait-and-poll
                line = subproc.stdout.readline()
                line_dec = line.decode('utf-8')
                if line:
                    stdoutfile.write(line.decode('utf-8'))
                    if path_pattern.match(line_dec):
                        mvn_output_loc = line_dec.replace('PATH :', '')
                        mvn_output_loc = os.path.split(os.path.abspath(mvn_output_loc))[0]
                        self.mvn_output_loc = mvn_output_loc
                    elif id_pattern.match(line_dec):
                        self.session_id = line_dec[len("SESSION ID => "):-len(" <=")-1]
                else:
                    time.sleep(0.1)
        time.sleep(2) # to let mvn finish up and shut down safely
        # for troubleshooting purposes the subproc is stored
        self.subproc = subproc
        if self.mvn_output_loc is not None:
            for f in os.listdir(self.mvn_output_loc):
                file_to_grab = os.path.join(self.mvn_output_loc, f)
                self.grab_diagnostic_file(file_to_grab)
        return subproc
    
    def get_result(self, project_name, account_name, environment='production'):
        self.qc_logger.info(f"Querying for acc_name: {account_name} on env: {environment}, with proj_name: {project_name}.")
        sf = ComplexSF(environment='staging')
        result = {}
        if project_name:
            print("Project API")
            query_str = f"SELECT Id,Name FROM Shipment_Order__c WHERE CreatedDate >= TODAY AND RecordType.Name LIKE 'Medical%' AND CreatedBy.Name = 'AmDo Testing' AND Account__r.Name = '{account_name}' AND Project__r.Name = '{project_name}'"
            query_result = sf.query_all(query_str)
        else:
            print("Standalone API")
            query_str = f"SELECT Id,Name FROM Shipment_Order__c WHERE CreatedDate >= TODAY AND RecordType.Name LIKE 'Medical%' AND CreatedBy.Name = 'AmDo Testing' AND Account__r.Name = '{account_name}' ORDER BY CreatedDate DESC LIMIT 1"
            query_result = sf.query_all(query_str)
        
        result['Project Name'] = project_name
        result['Id'] = query_result['records'][0]['Id']
        result['Name'] = query_result['records'][0]['Name']
        

        if project_name:
            if environment.lower() != 'production':
                result['Link'] = f"https://tecex--staging.lightning.force.come/lightning/r/Shipment_Order__c/{result['Id']}/view"
            else:
                result['Link'] = f"https://tecex.lightning.force.com/lightning/r/Shipment_Order__c/{result['Id']}/view"
        else:
            if environment.lower() != 'production':
                result['Link'] = f"https://tecex--staging.lightning.force.come/lightning/r/Project__c/{result['Id']}/view"
            else:
                result['Link'] = f"https://tecex.lightning.force.com/lightning/r/Project__c/{result['Id']}/view"

        return result
        # return so_number
