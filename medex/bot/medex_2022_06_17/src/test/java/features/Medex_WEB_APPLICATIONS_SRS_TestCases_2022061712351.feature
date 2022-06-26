Feature: GWT file1
#Regression Type
#Correct Values = true
#Incorrect Values = false
#Illegal Values = false
#Invalid Values = false
#Boundary Values = false
#Edge Cases Values = false

@Shipmentorders2
@uid1379562945
@Shipmentorders
@set21
@test001
@Shipmentorders
Scenario Outline: Creating a quote using a stand alone project no clinical trial with technical equipment adding delivery address parts and line items From Canada To Mexico
Given I have access to TecEx Medical application
When I Entered Username in salesforce login as '<Username>'
And I Entered Password in salesforce login as '<Password>'
And I Selected Log In to Sandbox in salesforce login
And I Selected Shipment Orders dropdown in shipment
And I Entered Shipment Orders Search in shipment as '<Shipment Orders Search>'
And I Selected Medical Bot SO in shipment
And I Selected SO New in shipment
And I Selected Quote in shipment
And I Entered Account in shipment as '<Account>'
And I Selected Select Account in shipment
And I Entered Contact in shipment as '<Contact>'
And I Selected Select Contact in shipment
And I Selected Project in shipment
And I Selected Select Project in shipment
And I Selected Clinical trial in shipment
And I Selected Select Clinical trial in shipment
And I Entered Ship from country in shipment as '<Ship from country1>'
And I Selected Ship from country select in shipment
And I Selected Service type in shipment
And I Selected Select Service type in shipment
And I Selected International Freight in shipment
And I Selected Select International Freight in shipment
And I Selected Add to table in shipment
And I Selected Proceed in shipment
And I Entered Ship to country TB in shipment as '<Ship to country TB2>'
And I Selected Ship to country in shipment
And I Selected Type of Product in shipment
And I Selected Tech equipment in shipment
And I Selected Add Delivery Address Optional in shipment
And I checked Add Delivery Address Checkbox in shipment
And I selected Add Delivery Address OK in shipment
And I Entered Shipment Value in shipment as '<Shipment Value3>'
#And I Selected Add Parts in shipment
#And I add line items Add Line items Tecex in shipment as '<Add Line items Tecex>'
#And I add Headers Add headers in shipment as '<Add headers>'
#And I Selected Add Line items Save in shipment
And I Selected PD Add First Package in package details
And I Selected PD Add Row in package details
And I ClearAndEnterText PD How many packages TB in package details as '<PD How many packages TB>'
And I Selected PD Weight Unit in package details
And I Selected PD Weight Unit value in package details
And I ClearAndEnterText PD Actual Weight in package details as '<PD Actual Weight>'
And I Selected PD Dimension Unit in package details
And I Selected PD Dimension Unit value in package details
And I ClearAndEnterText PD Length in package details as '<PD Length>'
And I ClearAndEnterText PD Breadth in package details as '<PD Breadth>'
And I ClearAndEnterText PD Heigth in package details as '<PD Heigth>'
And I Selected PD Save in package details
And I Selected PD Add Second Package in package details
And I Selected PD Add Row in package details
And I ClearAndEnterText PD How many packages TB in package details as '<PD How many packages TB4>'
And I Selected PD Weight Unit in package details
And I Selected PD Weight Unit value in package details
And I ClearAndEnterText PD Actual Weight in package details as '<PD Actual Weight5>'
And I Selected PD Dimension Unit in package details
And I Selected PD Dimension Unit value in package details
And I ClearAndEnterText PD Length in package details as '<PD Length6>'
And I ClearAndEnterText PD Breadth in package details as '<PD Breadth7>'
And I ClearAndEnterText PD Heigth in package details as '<PD Heigth8>'
And I Selected PD Contains Batteries in package details
And I Selected PD Save in package details
And I Selected Create Quote in shipment
And I Selected Shipment Orders dropdown in shipment
And I Entered Shipment Orders Search in shipment as '<Shipment Orders Search>'
And I Selected Medical Bot SO in shipment
And I Wait in Seconds Wait in shipment as '<Wait>'
And I Selected Shipment orders refresh in shipment
Then Verify text SO ID Copy in shipment
And '<page>' is displayed with '<content>'

Examples:
|SlNo.	|Username	|Password	|Shipment Orders Search	|Account	|Contact	|Ship from country1	|Ship to country TB2	|Shipment Value3	|Add Line items Tecex	|Add headers	|PD How many packages TB	|PD Actual Weight	|PD Length	|PD Breadth	|PD Heigth	|PD How many packages TB4	|PD Actual Weight5	|PD Length6	|PD Breadth7	|PD Heigth8	|Wait	|page	|content	|
|1|Username1	|Password1	|ShipmentOrdersSearch1	|Account1	|Contact1	|Canada	|Mexico	|1500	|AddLineitemsTecex1	|Addheaders1	|PDHowmanypackagesTB1	|PDActualWeight1	|PDLength1	|PDBreadth1	|PDHeigth1	|2	|85	|14	|12	|8	|Wait1	|Page1	|NA	|


#Total No. of Test Cases : 1

@Shipmentorders3
@uida1673393088
@Shipmentorders
@set21
@test002
@Shipmentorders
Scenario Outline: Creating a quote with different combinations of countries for an Existing project with Medical devices Investigational Products and Tech Equipment
Given I have access to TecEx Medical application
When I Entered Username in salesforce login as '<Username>'
And I Entered Password in salesforce login as '<Password>'
And I Selected Log In to Sandbox in salesforce login
And I Selected Shipment Orders dropdown in shipment
And I Entered Shipment Orders Search in shipment as '<Shipment Orders Search>'
And I Selected Medical Bot SO in shipment
And I Selected SO New in shipment
And I Selected Quote in shipment
And I Entered Account in shipment as '<Account>'
And I Selected Select Account in shipment
And I Entered Contact in shipment as '<Contact>'
And I Selected Select Contact in shipment
And I Selected Project in shipment
And I selected Yes Add to existing project in shipment
And I entered Search Project in shipment as '<Search Project>'
And I selected Search Project select in shipment
And I Selected Toggle button shipment in Ship from country in shipment
And I Selected Toggle button shipment in Service type in shipment
And I Selected Toggle button shipment in International freight in shipment
And I Selected Add to table in shipment
And I Selected Proceed in shipment
And I Entered NS Ship from country US in new shipment order as '<NS Ship from country US>'
And I Selected NS Ship from country US value in new shipment order
And I Selected NS Service type in new shipment order
And I Selected NS Service type Value in new shipment order
And I Entered NS Ship TO country South Africa in new shipment order as '<NS Ship TO country South Africa>'
And I Selected NS Ship TO country South Africa value in new shipment order
And I Selected NS Do you ship second hand or refurbished goods in new shipment order
And I Selected NS ship second hand in new shipment order
And I Selected NS Who Handles International Freight in new shipment order
And I Selected NS Tecex Handles International Freight in new shipment order
And I Selected NS Type of Product in new shipment order
And I Selected NS Type of Product Medical Equipment in new shipment order
And I Entered Shipment Value in shipment as '<Shipment Value1>'
#And I Selected Add Parts in shipment
#And I add multiple line items Add Line items in shipment as '<Add Line items>'
#And I Selected Add Line items Save in shipment
And I Selected PD Add First Package in package details
And I Selected PD Add Row in package details
And I ClearAndEnterText PD How many packages TB in package details as '<PD How many packages TB>'
And I Selected PD Weight Unit in package details
And I Selected PD Weight Unit value in package details
And I ClearAndEnterText PD Actual Weight in package details as '<PD Actual Weight>'
And I Selected PD Dimension Unit in package details
And I Selected PD Dimension Unit value in package details
And I ClearAndEnterText PD Length in package details as '<PD Length>'
And I ClearAndEnterText PD Breadth in package details as '<PD Breadth>'
And I ClearAndEnterText PD Heigth in package details as '<PD Heigth>'
And I Selected PD Save in package details
And I Selected PD Add Second Package in package details
And I Selected PD Add Row in package details
And I ClearAndEnterText PD How many packages TB in package details as '<PD How many packages TB2>'
And I Selected PD Weight Unit in package details
And I Selected PD Weight Unit value in package details
And I ClearAndEnterText PD Actual Weight in package details as '<PD Actual Weight3>'
And I Selected PD Dimension Unit in package details
And I Selected PD Dimension Unit value in package details
And I ClearAndEnterText PD Length in package details as '<PD Length4>'
And I ClearAndEnterText PD Breadth in package details as '<PD Breadth5>'
And I ClearAndEnterText PD Heigth in package details as '<PD Heigth6>'
And I Selected PD Contains Batteries in package details
And I Selected PD Save in package details
And I Entered Client reference in shipment as '<Client reference7>'
And I Selected Add row in Table in shipment
And I Entered NS Ship from country Bermuda in new shipment order as '<NS Ship from country Bermuda>'
And I Selected NS Ship from country Bermuda value in new shipment order
And I Selected NS Service type two in new shipment order
And I Selected NS Service type Value two in new shipment order
And I Entered NS Ship TO country Canada in new shipment order as '<NS Ship TO country Canada>'
And I Selected NS Ship TO country Canada value in new shipment order
And I Selected NS Do you ship second hand or refurbished goods two in new shipment order
And I Selected NS Refurbished in new shipment order
And I Selected NS Who Handles International Freight two in new shipment order
And I Selected NS client Handles International Freight in new shipment order
And I Selected NS Type of Product two in new shipment order
And I Selected NS Type of Product Investigational in new shipment order
And I Selected NS Temperature Control Requirements two in new shipment order
And I Selected NS Temperature Control Transit two in new shipment order
And I ClearAndEnterText Shipment Value two in shipment as '<Shipment Value two8>'
And I ClearAndEnterText Estimated Chargeable weight two in shipment as '<Estimated Chargeable weight two9>'
And I ClearAndEnterText Client reference two in shipment as '<Client reference two10>'
And I Selected Add row in Table in shipment
And I Entered NS Ship from country Algeria in new shipment order as '<NS Ship from country Algeria>'
And I Selected NS Ship from country Algeria value in new shipment order
And I Selected NS Service type three in new shipment order
And I Selected NS Service type Value three in new shipment order
And I Entered NS Ship TO country Brazil in new shipment order as '<NS Ship TO country Brazil>'
And I Selected NS Ship TO country Brazil value in new shipment order
And I Selected NS Do you ship second hand or refurbished goods three in new shipment order
And I Selected NS Neither of them in new shipment order
And I Selected NS Who Handles International Freight three in new shipment order
And I Selected NS Tecex Handles two in new shipment order
And I Selected NS Type of Product three in new shipment order
And I Selected NS Type of Product Tech Equipment two in new shipment order
And I ClearAndEnterText Shipment Value three in shipment as '<Shipment Value three11>'
And I ClearAndEnterText Estimated Chargeable weight three in shipment as '<Estimated Chargeable weight three12>'
And I ClearAndEnterText Client reference three in shipment as '<Client reference three13>'
And I Selected Create Quote in shipment
And I wait in seconds Wait in shipment as '<Wait14>'
And I copied text Shipment orders one in shipment
And I copied text Shipment orders two in shipment
And I copied text Shipment orders three in shipment
Then '<page>' is displayed with '<content>'

Examples:
|SlNo.	|Username	|Password	|Shipment Orders Search	|Account	|Contact	|Search Project	|NS Ship from country US	|NS Ship TO country South Africa	|Shipment Value1	|Add Line items	|PD How many packages TB	|PD Actual Weight	|PD Length	|PD Breadth	|PD Heigth	|PD How many packages TB2	|PD Actual Weight3	|PD Length4	|PD Breadth5	|PD Heigth6	|Client reference7	|NS Ship from country Bermuda	|NS Ship TO country Canada	|Shipment Value two8	|Estimated Chargeable weight two9	|Client reference two10	|NS Ship from country Algeria	|NS Ship TO country Brazil	|Shipment Value three11	|Estimated Chargeable weight three12	|Client reference three13	|Wait14	|page	|content	|
|1|Username1	|Password1	|ShipmentOrdersSearch1	|Account1	|Contact1	|SearchProject1	|NSShipfromcountryUS1	|NSShipTOcountrySouthAfrica1	|1500	|AddLineitems1	|PDHowmanypackagesTB1	|PDActualWeight1	|PDLength1	|PDBreadth1	|PDHeigth1	|2	|85	|14	|12	|8	|test shipment	|NSShipfromcountryBermuda1	|NSShipTOcountryCanada1	|1000	|20	|test shipment	|NSShipfromcountryAlgeria1	|NSShipTOcountryBrazil1	|1000	|46	|test shipment	|30	|Page1	|NA	|


#Total No. of Test Cases : 2

@Shipmentorders4
@uid557413194
@Shipmentorders
@set21
@test003
@Shipmentorders
Scenario Outline: Creating a quote with different combinations of countries for a new project having a clinical trial using Investigational Products and Tech Equipment 
Given I have access to TecEx Medical application
When I Entered Username in salesforce login as '<Username>'
And I Entered Password in salesforce login as '<Password>'
And I Selected Log In to Sandbox in salesforce login
And I Selected Shipment Orders dropdown in shipment
And I Entered Shipment Orders Search in shipment as '<Shipment Orders Search>'
And I Selected Medical Bot SO in shipment
And I Selected SO New in shipment
And I Selected Quote in shipment
And I Entered Account in shipment as '<Account>'
And I Selected Select Account in shipment
And I Entered Contact in shipment as '<Contact>'
And I Selected Select Contact in shipment
And I Selected Project in shipment
And I Selected Yes new project in shipment
And I entered Project Name in shipment as '<Project Name>'
And I selected This a Clinical Trial in shipment
And I selected Create New Project in shipment
And I Entered Ship from country in shipment as '<Ship from country1>'
And I Selected Ship from country select in shipment
And I selected Add pickup address in shipment
And I selected Radio button Juli test in shipment
And I selected select pickup address ok in shipment
And I Selected Service type in shipment
And I Selected Select Service type in shipment
And I Selected Toggle button shipment in International freight in shipment
And I Selected Units Of Measurement in shipment
And I Selected Imperial UM in shipment
And I Selected Add to table in shipment
And I Selected Proceed in shipment
And I entered SOT Ship to country Canada in shipment order two as '<SOT Ship to country Canada>'
And I selected SOT Ship to country Canada value in shipment order two
And I selected SOT Do you ship second hand or refurbished goods in shipment order two
And I selected SOT Refurbished goods in shipment order two
And I selected SOT Type of Product in shipment order two
And I selected SOT client Type of Product in shipment order two
And I selected SOT Who Handles International Freight in shipment order two
And I selected SOT Investigational Products in shipment order two
And I selected SOT Temperature Control Requirements in shipment order two
And I selected SOT Temperature Control Transit in shipment order two
And I Entered Shipment Value in shipment as '<Shipment Value2>'
And I Entered Estimated Chargeable weight in shipment as '<Estimated Chargeable weight3>'
And I Entered Client reference in shipment as '<Client reference4>'
And I ClearAndEnterText Vendor Reference in shipment as '<Vendor Reference5>'
And I Selected Add row in Table in shipment
And I entered SOT Ship to country United Arab Emirates in shipment order two as '<SOT Ship to country United Arab Emirates>'
And I selected SOT Ship to country United Arab Emirates value in shipment order two
And I selected SOT Type of Product two in shipment order two
And I selected SOT client Type of Product two in shipment order two
And I selected SOT Who Handles International Freight two in shipment order two
And I selected SOT Tech Equipment in shipment order two
And I ClearAndEnterText Shipment Value two in shipment as '<Shipment Value two6>'
#And I Selected Add Parts in shipment
#And I add line items Add Line items Tecex in shipment as '<Add Line items Tecex>'
#And I Selected Add Line items Save in shipment
And I Selected PD Add Package in second Row in package details
And I Selected PD Add Row in package details
And I ClearAndEnterText PD How many packages TB in package details as '<PD How many packages TB>'
And I ClearAndEnterText PD Actual Weight in package details as '<PD Actual Weight>'
And I ClearAndEnterText PD Length in package details as '<PD Length>'
And I ClearAndEnterText PD Breadth in package details as '<PD Breadth>'
And I ClearAndEnterText PD Heigth in package details as '<PD Heigth>'
And I Selected PD Save in package details
And I Selected PD Add Second Package in package details
And I Selected PD Add Row in package details
And I ClearAndEnterText PD How many packages TB in package details as '<PD How many packages TB7>'
And I ClearAndEnterText PD Actual Weight in package details as '<PD Actual Weight8>'
And I ClearAndEnterText PD Length in package details as '<PD Length9>'
And I ClearAndEnterText PD Breadth in package details as '<PD Breadth10>'
And I ClearAndEnterText PD Heigth in package details as '<PD Heigth11>'
And I Selected PD Contains Batteries in package details
And I Selected PD Save in package details
And I ClearAndEnterText Client reference two in shipment as '<Client reference two12>'
And I ClearAndEnterText Vendor Reference two in shipment as '<Vendor Reference two13>'
And I Selected Create Quote in shipment
And I wait in seconds Wait in shipment as '<Wait14>'
And I copied text project name copy in shipment
Then '<page>' is displayed with '<content>'

Examples:
|SlNo.	|Username	|Password	|Shipment Orders Search	|Account	|Contact	|Project Name	|Ship from country1	|SOT Ship to country Canada	|Shipment Value2	|Estimated Chargeable weight3	|Client reference4	|Vendor Reference5	|SOT Ship to country United Arab Emirates	|Shipment Value two6	|Add Line items Tecex	|PD How many packages TB	|PD Actual Weight	|PD Length	|PD Breadth	|PD Heigth	|PD How many packages TB7	|PD Actual Weight8	|PD Length9	|PD Breadth10	|PD Heigth11	|Client reference two12	|Vendor Reference two13	|Wait14	|page	|content	|
|1|Username1	|Password1	|ShipmentOrdersSearch1	|Account1	|Contact1	|ProjectName1	|United States	|SOTShiptocountryCanada1	|1000	|20	|test shipment	|vendor identifier	|SOTShiptocountryUnitedArabEmirates1	|1000	|AddLineitemsTecex1	|PDHowmanypackagesTB1	|PDActualWeight1	|PDLength1	|PDBreadth1	|PDHeigth1	|2	|85	|14	|12	|8	|test shipment	|vendor identifier	|30	|Page1	|NA	|


#Total No. of Test Cases : 3

 
