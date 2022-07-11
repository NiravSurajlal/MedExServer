"""
Module for the asynchronous PROCESS. Not all functions in this module can be called as
an async process.

Many functions that are called within an async process are also located here (not async
themselves).

This module defines the process flow for the medical quote creator.
"""

import logging
import os
from re import I
from time import ctime
import json
from turtle import up
import yaml
import pandas as pd
from time import sleep

from medex.celery import medex_Celery 
from .emails import send_feedback_email, send_error_mail
from medex.settings import __CACHEPATH__
from .shipment_order_bank import read_spreadsheet, make_new_cases
from .creation_bot import QuoteBot
from .rabbitmq_api import get_all_queue_items

__taskhandler_LOG = logging.getLogger("taskhandler")

@medex_Celery.task(name="rabbitmq_pinging_task", )
def rabbitmq_pinging_task(uptime, sleeptime, ping='PING'):
    """ ASYNC task. 
        Pings the RabbitMQ service during the bot process. """

    uptime += sleeptime
    print(f"Current Process time: {uptime} seconds. ")
    return uptime

def send_feedback_email_task(email, message="test"):
    """ Sends a feedback (the result) email. """

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
    sleep(1)
    __taskhandler_LOG.info(f"Updating queue for {users_name}.")
    get_all_queue_items()

    
    if excel_doc_path is None:
        __taskhandler_LOG.debug("File not uploaded.")
        return
    # excel_doc = pd.ExcelFile(os.path.join(__CACHEPATH__, "Medex.xlsb"))
    excel_doc = pd.ExcelFile(excel_doc_path)
    
    username = users_name
    task_data = {"email": email, "username":username, "start_time": ctime(), "excel_data": excel_doc}

    __taskhandler_LOG.info(f"Generating raw_data for {task_data['username']}. ") 
    raw_data, spread_sheet_errors = read_spreadsheet(excel_doc)
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
    if isinstance(result, dict):
        send_feedback_email(email, username, result)
        __taskhandler_LOG.info(f"Email sent to {task_data['email']}")
        __taskhandler_LOG.info(f"Cleaning up and removing files for {task_data['email']}.")
        clean_up(excel_doc_path, yaml_path)
        __taskhandler_LOG.info(f"Files deleted and process for {task_data['email']} complete.")
    else:
        send_error_mail(result, email=email, username=username)
        __taskhandler_LOG.info(f"Error Email sent to {task_data['email']}")

def generate_yaml(json_data, yaml_path):
    """ Generates yaml from xlsx by converting to JSON then to YAML. 
        Saves the YAML in the cache. 
        Returns yaml file location. """

    data = json_to_yaml(json_data)
    with open(yaml_path, 'w+') as yml:
        yaml.dump(data, yml)

def json_to_yaml(json_data):
    """ Converts json data (already loaded) to the YAML format required by the bot. """
    data = {}
    data['SalesforceURL'] = 'Implement Choice'
    data['Username1'] = 'fe_testing@tecex.com + CHANGE SOME HOW'
    data['Password1'] = 'Medex1234@!'
    data["Wait1"] = "15"

    data['ShipmentOrdersSearch1'] = "Medical BOT SO's - IS THIS USED ?"
    data['Account1'] = json_data['SOSetup']['Account']
    data['Contact1'] = json_data['SOSetup']['Contact']
    data['Project'] = json_data['SOSetup']['Project']
    data['ProjectName'] = json_data['SOSetup']['Project Name']
    data['ClinicalTrial'] = json_data['SOSetup']['Is this a clinical trial?']
    data['ShipFromDifferent'] = json_data['SOSetup']['Ship From Different for each Shipment']
    data['ShipFromCountry'] = json_data['SOSetup']['Ship From Country']
    data['AddPickUpAddress'] = json_data['SOSetup']['Add pickup address (optional)']
    data['ServiceTypeDifferent'] = json_data['SOSetup']['Service Type Different for each Shipment']
    data['ServiceType'] = json_data['SOSetup']['Service Type']
    data['InternationalFreightDifferent'] = json_data['SOSetup']['International Freight Different for each Shipment']
    data['InternationalFreight'] = json_data['SOSetup']['International Freight']
    data['UnitsOfMeasurement'] = json_data['SOSetup']['Units of Measurement']

    so_detail_nums = json_data['SOSetup']['SODetails'].split(';')
    for so_detail_num in so_detail_nums:
        so_data = json_data['SODetails'][so_detail_num]
        data[f"ShipFromCountry{so_detail_num}"] = so_data['Ship From Country']
        data[f"ServiceType{so_detail_num}"] = so_data['Service Type']
        data[f"ShipToCountry{so_detail_num}"] = so_data['Ship To Country']
        data[f"SecondHandOrRefurbished{so_detail_num}"] = so_data['Second hand or Refurbished Goods?']
        data[f"InternationalFreight{so_detail_num}"] = so_data['International Freight']
        data[f"TypeOfProduct{so_detail_num}"] = so_data['Type Of Product']
        data[f"TemperatureControlRequirements{so_detail_num}"] = so_data['Temperature Control Requirements']
        data[f"TemperatureControlRange{so_detail_num}"] = so_data['Temperature Control Range']
        data[f"NumofDeliverySites{so_detail_num}"] = so_data['# of Delivery Sites']

        # requires for loop?
        data[f"AddDeliveryAddress{so_detail_num}"] = so_data['Add Delivery address (optional)']

        data[f"ShipmentValue{so_detail_num}"] = so_data['Shipment Value (USD)']
        data[f"EstChargeableWeight{so_detail_num}"] = so_data['Est. Chargeable Weight (KG)']
        data[f"AddLineItems{so_detail_num}"] = so_data['LineItems']

        if so_data['Shipment Order Packages'] is not None: 
            try:
                package_nums = str(so_data['Shipment Order Packages']).split(';')
                i = 0
                for package_num in package_nums:
                    # requires for loop for package num?
                    sop_data = json_data['SOPs'][package_num]
                    data[f"PackageHowManyPacks{so_detail_num}.{i}"] = sop_data['How many packages?']
                    data[f"PackageWeightUnit{so_detail_num}.{i}"] = sop_data['Weight Unit']
                    data[f"PackageActualWeight{so_detail_num}.{i}"] = sop_data['Actual Weight']
                    data[f"PackageDimensionUnit{so_detail_num}.{i}"] = sop_data['Dimension Unit']
                    data[f"PackageLength{so_detail_num}.{i}"] = sop_data['Length']
                    data[f"PackageBreadth{so_detail_num}.{i}"] = sop_data['Breadth']
                    data[f"PackageHeight{so_detail_num}.{i}"] = sop_data['Height']
                    data[f"PackageContainsBatteries{so_detail_num}.{i}"] = sop_data['Contains batteries?']
                    i = i + 1
            except AttributeError as e:
                error_msg = f"No packages. "
                
        data[f"ClientReference{so_detail_num}"] = so_data['Client Reference (optional)']
        data[f"VendorReference{so_detail_num}"] = so_data['Vendor Reference (optional)']

        try:
            line_items_keys = list(json_data['SODetails']['1']['LineItems'].keys())
        except AttributeError as e:
            line_items_keys = None
            
        if data[f"AddLineItems{so_detail_num}"]:
            try:
                data[f"AddLineItems{so_detail_num}"] = ', '.join([str(elem) for elem in line_items_keys])
                li_data = so_data['LineItems']
                num_LI = len(li_data)
                for i in range(0, num_LI):
                    li_num = str(i)
                    for li_key in line_items_keys:
                        data[f"AddLineItems{so_detail_num}"] = ", ".join([data[f"AddLineItems{so_detail_num}"], str(li_data[li_key][li_num])])
            except TypeError as e:
                print('No Line Items')
        
    return data

def run_bot(username, project_name, account_name):
    """ Runs the selnium bot to generate the quote. 
        Returns a result. """
    print(f"\n\n    Running bot for {username} ... \n\n\n")
    bot = QuoteBot(username)
    bot.execute(rabbitmq_pinging_task)
    result = bot.get_result(project_name, account_name)
    return result

def clean_up(excel_doc_path, yaml_path):
    os.remove(excel_doc_path)
    os.remove(yaml_path)
