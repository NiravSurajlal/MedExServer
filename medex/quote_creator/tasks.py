import logging
import os
from time import ctime
import json
from turtle import up
import yaml
import pandas as pd
from time import sleep

from medex.celery import medex_Celery 
from .emails import send_feedback_email
from medex import __CACHEPATH__
from .shipment_order_bank import read_spreadsheet, make_new_cases
from .creation_bot import QuoteBot

__taskhandler_LOG = logging.getLogger("taskhandler")

@medex_Celery.task(name="rabbitmq_pinging_task", )
def rabbitmq_pinging_task(uptime, sleeptime, ping='PING'):
    uptime += sleeptime
    print(f"Current Process time: {uptime} seconds. ")
    return uptime

def send_feedback_email_task(email, message="test"):
    __taskhandler_LOG.info("Attempting to send email. ") 
    return send_feedback_email(email, message) 

@medex_Celery.task(name="add_task")
def add_task(email, excel_doc_path=None, users_name=None):
    """ Passes the task to celery. 
        Performs the process of generating the json then yml from the excel uploaded.
        Stores the information in a json of the users name.
        Runs the bot.
        Emails the result to the user.  
        """

    __taskhandler_LOG.info(f"Attempting to create quote for {users_name}.")
    if excel_doc_path is None:
        __taskhandler_LOG.debug("File not uploaded.")
        return
    # excel_doc = pd.ExcelFile(os.path.join(__CACHEPATH__, "Medex.xlsb"))
    excel_doc = pd.ExcelFile(excel_doc_path)
    
    username = users_name
    task_data = {"email": email, "username":username, "start_time": ctime(), "excel_data": excel_doc}

    __taskhandler_LOG.info(f"Generating raw_data for {task_data['username']}. ") 
    raw_data = read_spreadsheet(excel_doc)
    __taskhandler_LOG.info(f"Generating json_data for {task_data['username']}. ")
    json_data = make_new_cases(raw_data)

    __taskhandler_LOG.info(f"Generating YAML for {task_data['username']}. ")
    for case_name in json_data.keys():
        account_name = json_data[case_name]['SOSetup']['Account']
        if json_data[case_name]['SOSetup']['Project Name']:
            project_name = json_data[case_name]['SOSetup']['Project Name']
        else:
            project_name = None 
        yaml_path = os.path.join(__CACHEPATH__, f"{task_data['username']}_{case_name}.yaml") 
        generate_yaml(json_data[case_name], yaml_path)

    __taskhandler_LOG.info(f"Running {task_data['username']} bot. ")
    result = run_bot(username, project_name, account_name)
    task_data['result'] = result
    task_data['end_time'] = ctime()

    task_data.pop('excel_data')
    json_path = os.path.join(__CACHEPATH__, f"{task_data['username']}_task.json")  
    __taskhandler_LOG.info(f"Saving data to {json_path}.")
    with open(json_path, 'w+') as f:
        json.dump(task_data, f)

    __taskhandler_LOG.info(f"Sending email to {task_data['email']}. ")
    send_feedback_email(email, username, result)
    __taskhandler_LOG.info(f"Email sent to {task_data['email']}, and process complete. ")

def generate_yaml(json_data, yaml_path):
    """ Generates yaml from xlsx by converting to JSON then to YAML. 
        Saves the YAML in the cache. 
        Returns yaml file location. """

    data = json_to_yaml(json_data)
    with open(yaml_path, 'w+') as yml:
        yaml.dump(data, yml)

def json_to_yaml(json_data):
    data = {}
    data['Username1'] = 'fe_testing@tecex.com'
    data['Password1'] = 'Medex1234@!'
    data['ShipmentOrdersSearch1'] = "Medical BOT SO's"
    data['Account1'] = json_data['SOSetup']['Account']
    data['Contact1'] = json_data['SOSetup']['Contact']
    data["Wait1"] = "15"
    line_items_keys = list(json_data['SODetails']['1']['LineItems'].keys())

    for so_detail_num in json_data['SODetails'].keys():
        so_data = json_data['SODetails'][so_detail_num]
        data[f"Shipfromcountry{so_detail_num}"] = so_data['Ship From Country']
        data[f"Shiptocountry{so_detail_num}"] = so_data['Ship To Country']
        data[f"EstimatedChargeableweight{so_detail_num}"] = so_data['Est. Chargeable Weight (KG)']
        data[f"ShipmentValue1{so_detail_num}"] = so_data['Shipment Value (USD)']
        data[f"Clientreference{so_detail_num}"] = so_data['Client Reference (optional)']
        data[f"AddLineItems{so_detail_num}"] = ', '.join([str(elem) for elem in line_items_keys])
        
        li_data = so_data['LineItems']
        num_LI = len(li_data)
        for i in range(0, num_LI):
            li_num = str(i)
            for li_key in line_items_keys:
                data[f"AddLineItems{so_detail_num}"] = ", ".join([data[f"AddLineItems{so_detail_num}"], str(li_data[li_key][li_num])])

    return data

def run_bot(username, project_name, account_name):
    """ Runs the selnium bot to generate the quote. 
        Returns a result. """
    print(f"\n\n    Running bot for {username} ... \n\n\n")
    bot = QuoteBot(username)
    bot.execute(rabbitmq_pinging_task)
    result = bot.get_result(project_name, account_name)
    return result
