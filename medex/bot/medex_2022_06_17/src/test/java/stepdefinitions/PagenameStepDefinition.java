package stepdefinitions;
import common.WebBrowser;
import common.WebBrowserUtil;
import common.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import workflows.PagenameWorkFlow;
import org.junit.Assert;
	 public class PagenameStepDefinition
	{
		  

 		 @When("^I Selected NS Tecex Handles two in new shipment order$")
	 	 public void WhenISelectedNSTecexHandlestwoinnewshipmentorder()
	 	 {
			PagenameWorkFlow pagenameWorkFlow = new PagenameWorkFlow();
			pagenameWorkFlow.selectedNSTecexHandlestwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected NS Type of Product Tech Equipment two in new shipment order$")
	 	 public void WhenISelectedNSTypeofProductTechEquipmenttwoinnewshipmentorder()
	 	 {
			PagenameWorkFlow pagenameWorkFlow = new PagenameWorkFlow();
			pagenameWorkFlow.selectedNSTypeofProductTechEquipmenttwo();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Shipment Value three in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextShipmentValuethreeinshipmentasShipmentValuethree11(String shipmentValuethree)
	 	 {
			PagenameWorkFlow pagenameWorkFlow = new PagenameWorkFlow();
			pagenameWorkFlow.ClearAndEnterTextForShipmentValuethree(shipmentValuethree);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Estimated Chargeable weight three in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextEstimatedChargeableweightthreeinshipmentasEstimatedChargeableweightthree12(String estimatedChargeableweightthree)
	 	 {
			PagenameWorkFlow pagenameWorkFlow = new PagenameWorkFlow();
			pagenameWorkFlow.ClearAndEnterTextForEstimatedChargeableweightthree(estimatedChargeableweightthree);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I ClearAndEnterText Client reference three in shipment as '(.*)'$")
	 	 public void WhenIClearAndEnterTextClientreferencethreeinshipmentasClientreferencethree13(String clientreferencethree)
	 	 {
			PagenameWorkFlow pagenameWorkFlow = new PagenameWorkFlow();
			pagenameWorkFlow.ClearAndEnterTextForClientreferencethree(clientreferencethree);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Selected PD Add Package in second Row in package details$")
	 	 public void WhenISelectedPDAddPackageinsecondRowinpackagedetails()
	 	 {
			PagenameWorkFlow pagenameWorkFlow = new PagenameWorkFlow();
			pagenameWorkFlow.selectedPDAddPackageinsecondRow();
		 WebBrowserUtil.takescrenshot();
		 }
 
	}
