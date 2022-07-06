import logging
import pandas as pd
import json

def read_spreadsheet(excel_spreadsheet):
    __qc_LOGGER = logging.getLogger("quote_creator")

    raw_data = {}
    f = pd.ExcelFile(excel_spreadsheet)    

    sheet = 'SOSetup'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    df = pd.read_excel(f, sheet_name=sheet, index_col='Setup Reference')
    df = df[~df.index.isna()]
    raw_data['SO'] = df[~df.index.str.contains('WIP')]
    raw_data['WIP'] = df[df.index.str.contains('WIP')]

    sheet = 'SODetails'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    df = pd.read_excel(f, sheet_name=sheet, index_col="Index")
    raw_data[sheet] = df

    sheet = 'Shipment Order Packages'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    df = pd.read_excel(f, sheet_name=sheet, index_col="Index")
    df = df[~df.index.isna()]
    raw_data['SOPs'] = df.iloc[:, : 10]

    sheet = 'Test Outcomes'
    __qc_LOGGER.debug(f"Reading {sheet}. ")
    try:
        df = pd.read_excel(f, sheet_name=sheet, index_col="TO Number").fillna('-')
        df = df[~df.index.isna()]
        raw_data['Test Outcomes'] = df.iloc[:, :6]
    except Exception as e:
        print(e)

    raw_data['Line Items'] = {}
    for sheet in f.sheet_names:
        if 'Line Item List' in sheet:
            __qc_LOGGER.debug(f'Reading the Line Items sheet -> {sheet}')
            df = pd.read_excel(f, sheet_name=sheet)
            df = df[[c for c in df.columns if not(c.startswith('Unnamed:'))]]
            raw_data['Line Items'][sheet] = df
    
    __qc_LOGGER.debug('Reading the expected results sheet')
    try:
        sheet = 'Expected Results (Python)'
        df = pd.read_excel(f, sheet_name=sheet)
        df = df[~df.index.isna()]
    except Exception as e:
        print(e)
    __qc_LOGGER.debug('Closing up and keep clean')
    f.close()
    del f
    return raw_data

def make_new_cases(spreadsheet_data):
    on_creation_sos = {}
    for case_name in spreadsheet_data['SO'].index:
        test_case_data = build_shipment_dict(spreadsheet_data, case_name, wip=False)
        on_creation_sos[case_name] = test_case_data

    return on_creation_sos

def build_shipment_dict(spreadsheet_data, shipment_name, wip=False):
    data = spreadsheet_data.copy()
    if not wip:
        test_case_data = data['SO'].T[shipment_name].to_json()
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

    full_dict = {'SOSetup': test_case_data,
                 'SODetails': so_details}
    return full_dict

def get_ALL_SODetails(data, so_list):
    """ Gets SODetails from spreadsheets & corres LineItem data & Shipmnet Order Packages 
        data['SOPs']. """
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
