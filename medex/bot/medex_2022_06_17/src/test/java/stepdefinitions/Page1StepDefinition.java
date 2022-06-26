package stepdefinitions;
import common.WebBrowser;
import common.WebBrowserUtil;
import common.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import workflows.Page1WorkFlow;
import org.junit.Assert;
	 public class Page1StepDefinition
	{
		  

 		 @When("^I Selected Log In to Sandbox in salesforce login$")
	 	 public void WhenISelectedLogIntoSandboxinsalesforcelogin()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedLogIntoSandbox();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Shipment Orders dropdown in shipment$")
	 	 public void WhenISelectedShipmentOrdersdropdowninshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedShipmentOrdersdropdown();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Shipment Orders Search in shipment as '(.*)'$")
	 	 public void WhenIEnteredShipmentOrdersSearchinshipmentasShipmentOrdersSearch(String shipmentOrdersSearch)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterShipmentOrdersSearch(shipmentOrdersSearch);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Medical Bot SO in shipment$")
	 	 public void WhenISelectedMedicalBotSOinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedMedicalBotSO();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected SO New in shipment$")
	 	 public void WhenISelectedSONewinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSONew();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Quote in shipment$")
	 	 public void WhenISelectedQuoteinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedQuote();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Account in shipment as '(.*)'$")
	 	 public void WhenIEnteredAccountinshipmentasAccount(String account)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterAccount(account);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Select Account in shipment$")
	 	 public void WhenISelectedSelectAccountinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSelectAccount();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Contact in shipment as '(.*)'$")
	 	 public void WhenIEnteredContactinshipmentasContact(String contact)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterContact(contact);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Select Contact in shipment$")
	 	 public void WhenISelectedSelectContactinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSelectContact();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Project in shipment$")
	 	 public void WhenISelectedProjectinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedProject();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Select Project in shipment$")
	 	 public void WhenISelectedSelectProjectinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSelectProject();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Clinical trial in shipment$")
	 	 public void WhenISelectedClinicaltrialinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedClinicaltrial();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Select Clinical trial in shipment$")
	 	 public void WhenISelectedSelectClinicaltrialinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSelectClinicaltrial();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Ship from country in shipment as '(.*)'$")
	 	 public void WhenIEnteredShipfromcountryinshipmentasShipfromcountry1(String shipfromcountry)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterShipfromcountry(shipfromcountry);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Ship from country select in shipment$")
	 	 public void WhenISelectedShipfromcountryselectinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedShipfromcountryselect();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Service type in shipment$")
	 	 public void WhenISelectedServicetypeinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedServicetype();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Select Service type in shipment$")
	 	 public void WhenISelectedSelectServicetypeinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSelectServicetype();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected International Freight in shipment$")
	 	 public void WhenISelectedInternationalFreightinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedInternationalFreight();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Select International Freight in shipment$")
	 	 public void WhenISelectedSelectInternationalFreightinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSelectInternationalFreight();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Add to table in shipment$")
	 	 public void WhenISelectedAddtotableinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedAddtotable();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Proceed in shipment$")
	 	 public void WhenISelectedProceedinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedProceed();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Ship to country TB in shipment as '(.*)'$")
	 	 public void WhenIEnteredShiptocountryTBinshipmentasShiptocountryTB2(String shiptocountryTB)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterShiptocountryTB(shiptocountryTB);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Ship to country in shipment$")
	 	 public void WhenISelectedShiptocountryinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedShiptocountry();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Type of Product in shipment$")
	 	 public void WhenISelectedTypeofProductinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedTypeofProduct();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Tech equipment in shipment$")
	 	 public void WhenISelectedTechequipmentinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedTechequipment();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Add Delivery Address Optional in shipment$")
	 	 public void WhenISelectedAddDeliveryAddressOptionalinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedAddDeliveryAddressOptional();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I checked Add Delivery Address Checkbox in shipment$")
	 	 public void WhenIcheckedAddDeliveryAddressCheckboxinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.checkAddDeliveryAddressCheckbox();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected Add Delivery Address OK in shipment$")
	 	 public void WhenIselectedAddDeliveryAddressOKinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedAddDeliveryAddressOK();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Shipment Value in shipment as '(.*)'$")
	 	 public void WhenIEnteredShipmentValueinshipmentasShipmentValue3(String shipmentValue)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterShipmentValue(shipmentValue);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Add Parts in shipment$")
	 	 public void WhenISelectedAddPartsinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedAddParts();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I add line items Add Line items Tecex in shipment as '(.*)'$")
	 	 public void WhenIaddlineitemsAddLineitemsTecexinshipmentasAddLineitemsTecex(String lineItems)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.TextBoxAddLineitemsTecexaddlineitems(lineItems);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I add Headers Add headers in shipment as '(.*)'$")
	 	 public void WhenIaddHeadersAddheadersinshipmentasAddheaders(String lineItems)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.TextBoxAddheadersaddHeaders(lineItems);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Add Line items Save in shipment$")
	 	 public void WhenISelectedAddLineitemsSaveinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedAddLineitemsSave();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Add First Package in package details$")
	 	 public void WhenISelectedPDAddFirstPackageinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDAddFirstPackage();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Add Row in package details$")
	 	 public void WhenISelectedPDAddRowinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDAddRow();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText PD How many packages TB in package details as '(.*)'$")
	 	 public void WhenIClearAndEnterTextPDHowmanypackagesTBinpackagedetailsasPDHowmanypackagesTB(String pDHowmanypackagesTB)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForPDHowmanypackagesTB(pDHowmanypackagesTB);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Weight Unit in package details$")
	 	 public void WhenISelectedPDWeightUnitinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDWeightUnit();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Weight Unit value in package details$")
	 	 public void WhenISelectedPDWeightUnitvalueinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDWeightUnitvalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText PD Actual Weight in package details as '(.*)'$")
	 	 public void WhenIClearAndEnterTextPDActualWeightinpackagedetailsasPDActualWeight(String pDActualWeight)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForPDActualWeight(pDActualWeight);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Dimension Unit in package details$")
	 	 public void WhenISelectedPDDimensionUnitinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDDimensionUnit();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Dimension Unit value in package details$")
	 	 public void WhenISelectedPDDimensionUnitvalueinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDDimensionUnitvalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText PD Length in package details as '(.*)'$")
	 	 public void WhenIClearAndEnterTextPDLengthinpackagedetailsasPDLength(String pDLength)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForPDLength(pDLength);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText PD Breadth in package details as '(.*)'$")
	 	 public void WhenIClearAndEnterTextPDBreadthinpackagedetailsasPDBreadth(String pDBreadth)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForPDBreadth(pDBreadth);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText PD Heigth in package details as '(.*)'$")
	 	 public void WhenIClearAndEnterTextPDHeigthinpackagedetailsasPDHeigth(String pDHeigth)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForPDHeigth(pDHeigth);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Save in package details$")
	 	 public void WhenISelectedPDSaveinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDSave();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Add Second Package in package details$")
	 	 public void WhenISelectedPDAddSecondPackageinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDAddSecondPackage();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Contains Batteries in package details$")
	 	 public void WhenISelectedPDContainsBatteriesinpackagedetails()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedPDContainsBatteries();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Create Quote in shipment$")
	 	 public void WhenISelectedCreateQuoteinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedCreateQuote();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Wait in Seconds Wait in shipment as '(.*)'$")
	 	 public void WhenIWaitinSecondsWaitinshipmentasWait(String time)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.WaitTextBoxWaitinSeconds(time);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Shipment orders refresh in shipment$")
	 	 public void WhenISelectedShipmentordersrefreshinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedShipmentordersrefresh();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @Then("^Verify text SO ID Copy in shipment$")
	 	 public void ThenVerifytextSOIDCopyinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			Assert.assertTrue(page1WorkFlow.VerifytextSOIDCopy());
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @Then("^'(.*)' is displayed with '(.*)'$")
	 	 public void Thenpageisdisplayedwithcontent(String defaultpage,String message)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			Assert.assertTrue(page1WorkFlow.VerifyDefaultpageIsdisplayed(defaultpage));
			Assert.assertTrue(page1WorkFlow.VerifymessageIsDisplayed(message));
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected Yes Add to existing project in shipment$")
	 	 public void WhenIselectedYesAddtoexistingprojectinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedYesAddtoexistingproject();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I entered Search Project in shipment as '(.*)'$")
	 	 public void WhenIenteredSearchProjectinshipmentasSearchProject(String searchProject)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.enterSearchProject(searchProject);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected Search Project select in shipment$")
	 	 public void WhenIselectedSearchProjectselectinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSearchProjectselect();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Toggle button shipment in Ship from country in shipment$")
	 	 public void WhenISelectedTogglebuttonshipmentinShipfromcountryinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedTogglebuttonshipmentinShipfromcountry();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Toggle button shipment in Service type in shipment$")
	 	 public void WhenISelectedTogglebuttonshipmentinServicetypeinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedTogglebuttonshipmentinServicetype();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Toggle button shipment in International freight in shipment$")
	 	 public void WhenISelectedTogglebuttonshipmentinInternationalfreightinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedTogglebuttonshipmentinInternationalfreight();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered NS Ship from country US in new shipment order as '(.*)'$")
	 	 public void WhenIEnteredNSShipfromcountryUSinnewshipmentorderasNSShipfromcountryUS(String nSShipfromcountryUS)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterNSShipfromcountryUS(nSShipfromcountryUS);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Ship from country US value in new shipment order$")
	 	 public void WhenISelectedNSShipfromcountryUSvalueinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSShipfromcountryUSvalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Service type in new shipment order$")
	 	 public void WhenISelectedNSServicetypeinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSServicetype();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Service type Value in new shipment order$")
	 	 public void WhenISelectedNSServicetypeValueinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSServicetypeValue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered NS Ship TO country South Africa in new shipment order as '(.*)'$")
	 	 public void WhenIEnteredNSShipTOcountrySouthAfricainnewshipmentorderasNSShipTOcountrySouthAfrica(String nSShipTOcountrySouthAfrica)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterNSShipTOcountrySouthAfrica(nSShipTOcountrySouthAfrica);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Ship TO country South Africa value in new shipment order$")
	 	 public void WhenISelectedNSShipTOcountrySouthAfricavalueinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSShipTOcountrySouthAfricavalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Do you ship second hand or refurbished goods in new shipment order$")
	 	 public void WhenISelectedNSDoyoushipsecondhandorrefurbishedgoodsinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSDoyoushipsecondhandorrefurbishedgoods();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS ship second hand in new shipment order$")
	 	 public void WhenISelectedNSshipsecondhandinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSshipsecondhand();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Who Handles International Freight in new shipment order$")
	 	 public void WhenISelectedNSWhoHandlesInternationalFreightinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSWhoHandlesInternationalFreight();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Tecex Handles International Freight in new shipment order$")
	 	 public void WhenISelectedNSTecexHandlesInternationalFreightinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTecexHandlesInternationalFreight();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Type of Product in new shipment order$")
	 	 public void WhenISelectedNSTypeofProductinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTypeofProduct();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Type of Product Medical Equipment in new shipment order$")
	 	 public void WhenISelectedNSTypeofProductMedicalEquipmentinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTypeofProductMedicalEquipment();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I add multiple line items Add Line items in shipment as '(.*)'$")
	 	 public void WhenIaddmultiplelineitemsAddLineitemsinshipmentasAddLineitems(String lineItems)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.TextBoxAddLineitemsaddmultiplelineitems(lineItems);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Client reference in shipment as '(.*)'$")
	 	 public void WhenIEnteredClientreferenceinshipmentasClientreference7(String clientreference)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterClientreference(clientreference);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Add row in Table in shipment$")
	 	 public void WhenISelectedAddrowinTableinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedAddrowinTable();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered NS Ship from country Bermuda in new shipment order as '(.*)'$")
	 	 public void WhenIEnteredNSShipfromcountryBermudainnewshipmentorderasNSShipfromcountryBermuda(String nSShipfromcountryBermuda)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterNSShipfromcountryBermuda(nSShipfromcountryBermuda);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Ship from country Bermuda value in new shipment order$")
	 	 public void WhenISelectedNSShipfromcountryBermudavalueinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSShipfromcountryBermudavalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Service type two in new shipment order$")
	 	 public void WhenISelectedNSServicetypetwoinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSServicetypetwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Service type Value two in new shipment order$")
	 	 public void WhenISelectedNSServicetypeValuetwoinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSServicetypeValuetwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered NS Ship TO country Canada in new shipment order as '(.*)'$")
	 	 public void WhenIEnteredNSShipTOcountryCanadainnewshipmentorderasNSShipTOcountryCanada(String nSShipTOcountryCanada)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterNSShipTOcountryCanada(nSShipTOcountryCanada);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Ship TO country Canada value in new shipment order$")
	 	 public void WhenISelectedNSShipTOcountryCanadavalueinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSShipTOcountryCanadavalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Do you ship second hand or refurbished goods two in new shipment order$")
	 	 public void WhenISelectedNSDoyoushipsecondhandorrefurbishedgoodstwoinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSDoyoushipsecondhandorrefurbishedgoodstwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Refurbished in new shipment order$")
	 	 public void WhenISelectedNSRefurbishedinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSRefurbished();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Who Handles International Freight two in new shipment order$")
	 	 public void WhenISelectedNSWhoHandlesInternationalFreighttwoinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSWhoHandlesInternationalFreighttwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS client Handles International Freight in new shipment order$")
	 	 public void WhenISelectedNSclientHandlesInternationalFreightinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSclientHandlesInternationalFreight();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Type of Product two in new shipment order$")
	 	 public void WhenISelectedNSTypeofProducttwoinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTypeofProducttwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Type of Product Investigational in new shipment order$")
	 	 public void WhenISelectedNSTypeofProductInvestigationalinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTypeofProductInvestigational();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Temperature Control Requirements two in new shipment order$")
	 	 public void WhenISelectedNSTemperatureControlRequirementstwoinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTemperatureControlRequirementstwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Temperature Control Transit two in new shipment order$")
	 	 public void WhenISelectedNSTemperatureControlTransittwoinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTemperatureControlTransittwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Shipment Value two in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextShipmentValuetwoinshipmentasShipmentValuetwo8(String shipmentValuetwo)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForShipmentValuetwo(shipmentValuetwo);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Estimated Chargeable weight two in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextEstimatedChargeableweighttwoinshipmentasEstimatedChargeableweighttwo9(String estimatedChargeableweighttwo)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForEstimatedChargeableweighttwo(estimatedChargeableweighttwo);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Client reference two in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextClientreferencetwoinshipmentasClientreferencetwo10(String clientreferencetwo)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForClientreferencetwo(clientreferencetwo);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered NS Ship from country Algeria in new shipment order as '(.*)'$")
	 	 public void WhenIEnteredNSShipfromcountryAlgeriainnewshipmentorderasNSShipfromcountryAlgeria(String nSShipfromcountryAlgeria)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterNSShipfromcountryAlgeria(nSShipfromcountryAlgeria);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Ship from country Algeria value in new shipment order$")
	 	 public void WhenISelectedNSShipfromcountryAlgeriavalueinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSShipfromcountryAlgeriavalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Service type three in new shipment order$")
	 	 public void WhenISelectedNSServicetypethreeinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSServicetypethree();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Service type Value three in new shipment order$")
	 	 public void WhenISelectedNSServicetypeValuethreeinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSServicetypeValuethree();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered NS Ship TO country Brazil in new shipment order as '(.*)'$")
	 	 public void WhenIEnteredNSShipTOcountryBrazilinnewshipmentorderasNSShipTOcountryBrazil(String nSShipTOcountryBrazil)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterNSShipTOcountryBrazil(nSShipTOcountryBrazil);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Ship TO country Brazil value in new shipment order$")
	 	 public void WhenISelectedNSShipTOcountryBrazilvalueinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSShipTOcountryBrazilvalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Do you ship second hand or refurbished goods three in new shipment order$")
	 	 public void WhenISelectedNSDoyoushipsecondhandorrefurbishedgoodsthreeinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSDoyoushipsecondhandorrefurbishedgoodsthree();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Neither of them in new shipment order$")
	 	 public void WhenISelectedNSNeitheroftheminnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSNeitherofthem();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Who Handles International Freight three in new shipment order$")
	 	 public void WhenISelectedNSWhoHandlesInternationalFreightthreeinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSWhoHandlesInternationalFreightthree();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Type of Product three in new shipment order$")
	 	 public void WhenISelectedNSTypeofProductthreeinnewshipmentorder()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedNSTypeofProductthree();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I wait in seconds Wait in shipment as '(.*)'$")
	 	 public void WhenIwaitinsecondsWaitinshipmentasWait14(String time)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.WaitTextBoxWaitinSeconds(time);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I copied text Shipment orders one in shipment$")
	 	 public void WhenIcopiedtextShipmentordersoneinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.copiedtextShipmentordersone();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I copied text Shipment orders two in shipment$")
	 	 public void WhenIcopiedtextShipmentorderstwoinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.copiedtextShipmentorderstwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I copied text Shipment orders three in shipment$")
	 	 public void WhenIcopiedtextShipmentordersthreeinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.copiedtextShipmentordersthree();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Yes new project in shipment$")
	 	 public void WhenISelectedYesnewprojectinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedYesnewproject();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I entered Project Name in shipment as '(.*)'$")
	 	 public void WhenIenteredProjectNameinshipmentasProjectName(String projectName)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.enterProjectName(projectName);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected This a Clinical Trial in shipment$")
	 	 public void WhenIselectedThisaClinicalTrialinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedThisaClinicalTrial();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected Create New Project in shipment$")
	 	 public void WhenIselectedCreateNewProjectinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedCreateNewProject();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected Add pickup address in shipment$")
	 	 public void WhenIselectedAddpickupaddressinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedAddpickupaddress();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected Radio button Juli test in shipment$")
	 	 public void WhenIselectedRadiobuttonJulitestinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedRadiobuttonJulitest();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected select pickup address ok in shipment$")
	 	 public void WhenIselectedselectpickupaddressokinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedselectpickupaddressok();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Units Of Measurement in shipment$")
	 	 public void WhenISelectedUnitsOfMeasurementinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedUnitsOfMeasurement();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected Imperial UM in shipment$")
	 	 public void WhenISelectedImperialUMinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedImperialUM();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I entered SOT Ship to country Canada in shipment order two as '(.*)'$")
	 	 public void WhenIenteredSOTShiptocountryCanadainshipmentordertwoasSOTShiptocountryCanada(String sOTShiptocountryCanada)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.enterSOTShiptocountryCanada(sOTShiptocountryCanada);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Ship to country Canada value in shipment order two$")
	 	 public void WhenIselectedSOTShiptocountryCanadavalueinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTShiptocountryCanadavalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Do you ship second hand or refurbished goods in shipment order two$")
	 	 public void WhenIselectedSOTDoyoushipsecondhandorrefurbishedgoodsinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTDoyoushipsecondhandorrefurbishedgoods();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Refurbished goods in shipment order two$")
	 	 public void WhenIselectedSOTRefurbishedgoodsinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTRefurbishedgoods();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Type of Product in shipment order two$")
	 	 public void WhenIselectedSOTTypeofProductinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTTypeofProduct();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT client Type of Product in shipment order two$")
	 	 public void WhenIselectedSOTclientTypeofProductinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTclientTypeofProduct();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Who Handles International Freight in shipment order two$")
	 	 public void WhenIselectedSOTWhoHandlesInternationalFreightinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTWhoHandlesInternationalFreight();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Investigational Products in shipment order two$")
	 	 public void WhenIselectedSOTInvestigationalProductsinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTInvestigationalProducts();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Temperature Control Requirements in shipment order two$")
	 	 public void WhenIselectedSOTTemperatureControlRequirementsinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTTemperatureControlRequirements();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Temperature Control Transit in shipment order two$")
	 	 public void WhenIselectedSOTTemperatureControlTransitinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTTemperatureControlTransit();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Estimated Chargeable weight in shipment as '(.*)'$")
	 	 public void WhenIEnteredEstimatedChargeableweightinshipmentasEstimatedChargeableweight3(String estimatedChargeableweight)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.EnterEstimatedChargeableweight(estimatedChargeableweight);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Vendor Reference in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextVendorReferenceinshipmentasVendorReference5(String vendorReference)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForVendorReference(vendorReference);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I entered SOT Ship to country United Arab Emirates in shipment order two as '(.*)'$")
	 	 public void WhenIenteredSOTShiptocountryUnitedArabEmiratesinshipmentordertwoasSOTShiptocountryUnitedArabEmirates(String sOTShiptocountryUnitedArabEmirates)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.enterSOTShiptocountryUnitedArabEmirates(sOTShiptocountryUnitedArabEmirates);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Ship to country United Arab Emirates value in shipment order two$")
	 	 public void WhenIselectedSOTShiptocountryUnitedArabEmiratesvalueinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTShiptocountryUnitedArabEmiratesvalue();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Type of Product two in shipment order two$")
	 	 public void WhenIselectedSOTTypeofProducttwoinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTTypeofProducttwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT client Type of Product two in shipment order two$")
	 	 public void WhenIselectedSOTclientTypeofProducttwoinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTclientTypeofProducttwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Who Handles International Freight two in shipment order two$")
	 	 public void WhenIselectedSOTWhoHandlesInternationalFreighttwoinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTWhoHandlesInternationalFreighttwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I selected SOT Tech Equipment in shipment order two$")
	 	 public void WhenIselectedSOTTechEquipmentinshipmentordertwo()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.selectedSOTTechEquipment();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Vendor Reference two in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextVendorReferencetwoinshipmentasVendorReferencetwo13(String vendorReferencetwo)
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.ClearAndEnterTextForVendorReferencetwo(vendorReferencetwo);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I copied text project name copy in shipment$")
	 	 public void WhenIcopiedtextprojectnamecopyinshipment()
	 	 {
			Page1WorkFlow page1WorkFlow = new Page1WorkFlow();
			page1WorkFlow.copiedtextprojectnamecopy();
		 WebBrowserUtil.takescrenshot();
		 }
 
	}
