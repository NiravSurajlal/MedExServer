""" 
Module with the functions for reading and parsing the .xlsx data.
"""

import logging
import pandas as pd
import json
from .emails import send_error_mail

def read_spreadsheet(excel_spreadsheet):
    """ Takes the excel spreadsheet (bytes), parses it and returns a 
        dictionary and a list of errors. 
        
        Test outcome and Expected results caught errors are okay in this process. 
        They may not be populated. """

    errors = {}

    __qc_LOGGER = logging.getLogger("quote_creator")

    raw_data = {}
    f = pd.ExcelFile(excel_spreadsheet)    

    sheet = 'SOSetup'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    try:
        df = pd.read_excel(f, sheet_name=sheet, index_col='Setup Reference')
    except ValueError as e:
        error_msg = f"Worksheet {sheet} or index not found: Error {e}"
        errors['SOSetup'] = error_msg

    # df = df[~df.index.isna()]
    raw_data['SOSetup'] = df[~df.index.str.contains('WIP')]
    raw_data['WIP'] = df[df.index.str.contains('WIP')]

    sheet = 'SODetails'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    try:
        df = pd.read_excel(f, sheet_name=sheet, index_col="Index")
    except ValueError as e:
        error_msg = f"Worksheet {sheet} or index not found: Error {e}"
        errors['SODetails'] = error_msg

    raw_data[sheet] = df

    sheet = 'Shipment Order Packages'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    try:
        df = pd.read_excel(f, sheet_name=sheet, index_col="Index")
    except ValueError as e:
        error_msg = f"Worksheet {sheet} or index not found: Error {e}"
        errors['ShipmentOrderPackages'] = error_msg
        
    df = df[~df.index.isna()]
    raw_data['SOPs'] = df.iloc[:, : 10]

    sheet = 'Test Outcomes'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    try:
        df = pd.read_excel(f, sheet_name=sheet, index_col="TO Number").fillna('-')
        df = df[~df.index.isna()]
        raw_data['Test Outcomes'] = df.iloc[:, :6]
    except ValueError as e:
        error_msg = f"Worksheet {sheet} or index not found: Error {e}"
        errors['TestOutcomes'] = error_msg

    raw_data['Line Items'] = {}
    for sheet in f.sheet_names:
        if 'Line Item List' in sheet:
            __qc_LOGGER.debug(f'Reading the Line Items sheet -> {sheet}')
            try:
                df = pd.read_excel(f, sheet_name=sheet)
            except ValueError as e:
                error_msg = f"Worksheet {sheet} or index not found: Error {e}"
                errors['LIList'] = error_msg

            df = df[[c for c in df.columns if not(c.startswith('Unnamed:'))]]
            raw_data['Line Items'][sheet] = df
    
    __qc_LOGGER.debug('Reading the expected results sheet')
    sheet = 'Expected Results (Python)'
    try:
        df = pd.read_excel(f, sheet_name=sheet)
        df = df[~df.index.isna()]
    except ValueError as e:
        error_msg = f"Worksheet {sheet} or index not found: Error {e}"
        errors['ExpectedResults'] = error_msg

    __qc_LOGGER.debug('Closing up and keep clean.')
    f.close()
    del f
    return raw_data, errors

def make_new_cases(spreadsheet_data):
    """ Makes new cases from a dictionary and returns a dictionary. 
        Should be called after read_spreadsheet on the data it returns. """
    on_creation_sos = {}
    for case_name in spreadsheet_data['SOSetup'].index:
        test_case_data = build_shipment_dict(spreadsheet_data, case_name, wip=False)
        on_creation_sos[case_name] = test_case_data

    return on_creation_sos

def build_shipment_dict(spreadsheet_data, shipment_name, wip=False):
    """ Takes the dictionary data, parses it and returns a 
    dictionary. """

    data = spreadsheet_data.copy()
    if not wip:
        test_case_data = data['SOSetup'].T[shipment_name].to_json()
    else:
        test_case_data = data['WIP'].T[shipment_name].to_json()
    test_case_data = json.loads(test_case_data)
    test_case_data['Setup Reference'] = shipment_name
    for key in test_case_data.keys():
        so_list = []
        if 'sodetails' in key.lower():
            temp = str(test_case_data[key])
            so_list = temp.split(';')
        if so_list:
            so_details = get_ALL_SODetails(data, so_list)
            break
    
    sops_dict = {}
    for i in data['SOPs'].index: 
        sops_dict[str(i)] = json.loads(data['SOPs'].iloc[i-1].to_json())

    full_dict = {'SOSetup': test_case_data,
                 'SODetails': so_details,
                 'SOPs': sops_dict}
    return full_dict

def get_ALL_SODetails(data, so_list):
    """ Gets SODetails from spreadsheets & corres LineItem data & Shipmnet Order Packages 
        data['SOPs']. 
        
        Some may not have Line Items, so the KeyError is caught and handled. """

    so_details_dict = {}
    for so_detail_index in so_list:
        so_detail_index_str = str(so_detail_index)
        # adds SODetails
        so_details_dict[so_detail_index_str] = json.loads(data['SODetails'].loc[int(so_detail_index)].to_json())
        line_item_index = so_details_dict[so_detail_index_str]['Line Items List']
        try:
            line_item_data = json.loads(data['Line Items'][f"Line Item List {line_item_index}"].to_json())
        except KeyError as e:
            line_item_data = None
        # adds Line Item data
        so_details_dict[so_detail_index_str]['LineItems'] = line_item_data
        # adds SOPs
        try:
            sop_list = so_details_dict[so_detail_index_str]['Shipment Order Packages'].split(';')
        except AttributeError as e:
            # only one or less SOP thus cannot split
            sop_list = []
            sop_list.append(str(so_details_dict[so_detail_index_str]['Shipment Order Packages']))
        sop_data = data['SOPs']
        sop_dict = {}
        for sop_index in sop_list:
            try:
                sop_dict[sop_index] = json.loads(sop_data.iloc[int(sop_index)-1].to_json())
            except ValueError as e:
                print(e)
            
        so_details_dict[so_detail_index_str]['SOP'] = sop_dict

    return so_details_dict
