package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.WebBrowserUtil;
import common.YMLUtil;
	public class Page1Page
	{
	 	 WebDriver driver;
	 	 public Page1Page (WebDriver _driver){ driver=_driver; } 

 	 	 public WebElement AccountTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AccountTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddDeliveryAddressCheckboxCheckBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddDeliveryAddressCheckboxCheckBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddDeliveryAddressOKButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddDeliveryAddressOKButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddDeliveryAddressOptionalButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddDeliveryAddressOptionalButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddheadersTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddheadersTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddLineitemsTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddLineitemsTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddLineitemsSaveButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddLineitemsSaveButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddLineitemsTecexTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddLineitemsTecexTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddPartsButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddPartsButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddpickupaddressButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddpickupaddressButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddrowinTableButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddrowinTableButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement AddtotableButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.AddtotableButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ClientreferenceTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ClientreferenceTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ClientreferencetwoTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ClientreferencetwoTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ClinicaltrialButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ClinicaltrialButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ContactTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ContactTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement CreateNewProjectButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.CreateNewProjectButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement CreateQuoteButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.CreateQuoteButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement EstimatedChargeableweightTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.EstimatedChargeableweightTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement EstimatedChargeableweighttwoTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.EstimatedChargeableweighttwoTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ImperialUMButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ImperialUMButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement InternationalFreightButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.InternationalFreightButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement LogIntoSandboxButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.LogIntoSandboxButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement MedicalBotSOButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.MedicalBotSOButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement messageLabel()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.messageLabeltext"),"text"); 
	 	 }

 	 	 public WebElement NSclientHandlesInternationalFreightButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSclientHandlesInternationalFreightButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSDoyoushipsecondhandorrefurbishedgoodsButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSDoyoushipsecondhandorrefurbishedgoodsButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSDoyoushipsecondhandorrefurbishedgoodsthreeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSDoyoushipsecondhandorrefurbishedgoodsthreeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSDoyoushipsecondhandorrefurbishedgoodstwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSDoyoushipsecondhandorrefurbishedgoodstwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSNeitherofthemButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSNeitherofthemButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSRefurbishedButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSRefurbishedButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSServicetypeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSServicetypeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSServicetypethreeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSServicetypethreeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSServicetypetwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSServicetypetwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSServicetypeValueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSServicetypeValueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSServicetypeValuethreeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSServicetypeValuethreeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSServicetypeValuetwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSServicetypeValuetwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipfromcountryAlgeriaTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipfromcountryAlgeriaTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipfromcountryAlgeriavalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipfromcountryAlgeriavalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipfromcountryBermudaTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipfromcountryBermudaTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipfromcountryBermudavalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipfromcountryBermudavalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipfromcountryUSTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipfromcountryUSTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipfromcountryUSvalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipfromcountryUSvalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSshipsecondhandButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSshipsecondhandButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipTOcountryBrazilTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipTOcountryBrazilTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipTOcountryBrazilvalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipTOcountryBrazilvalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipTOcountryCanadaTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipTOcountryCanadaTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipTOcountryCanadavalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipTOcountryCanadavalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipTOcountrySouthAfricaTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipTOcountrySouthAfricaTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSShipTOcountrySouthAfricavalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSShipTOcountrySouthAfricavalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTecexHandlesInternationalFreightButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTecexHandlesInternationalFreightButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTemperatureControlRequirementstwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTemperatureControlRequirementstwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTemperatureControlTransittwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTemperatureControlTransittwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTypeofProductButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTypeofProductButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTypeofProductInvestigationalButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTypeofProductInvestigationalButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTypeofProductMedicalEquipmentButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTypeofProductMedicalEquipmentButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTypeofProductthreeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTypeofProductthreeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTypeofProducttwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSTypeofProducttwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSWhoHandlesInternationalFreightButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSWhoHandlesInternationalFreightButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSWhoHandlesInternationalFreightthreeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSWhoHandlesInternationalFreightthreeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSWhoHandlesInternationalFreighttwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.NSWhoHandlesInternationalFreighttwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDActualWeightTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDActualWeightTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDAddFirstPackageButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDAddFirstPackageButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDAddRowButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDAddRowButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDAddSecondPackageButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDAddSecondPackageButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDBreadthTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDBreadthTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDContainsBatteriesButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDContainsBatteriesButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDDimensionUnitButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDDimensionUnitButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDDimensionUnitvalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDDimensionUnitvalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDHeigthTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDHeigthTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDHowmanypackagesTBTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDHowmanypackagesTBTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDLengthTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDLengthTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDSaveButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDSaveButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDWeightUnitButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDWeightUnitButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDWeightUnitvalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.PDWeightUnitvalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ProceedButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ProceedButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ProjectButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ProjectButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ProjectNameTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ProjectNameTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement projectnamecopyLabel()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.projectnamecopyLabelXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement QuoteButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.QuoteButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement RadiobuttonJulitestButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.RadiobuttonJulitestButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SearchProjectTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SearchProjectTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SearchProjectselectButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SearchProjectselectButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SelectAccountButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SelectAccountButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SelectClinicaltrialButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SelectClinicaltrialButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SelectContactButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SelectContactButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SelectInternationalFreightButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SelectInternationalFreightButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement selectpickupaddressokButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.selectpickupaddressokButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SelectProjectButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SelectProjectButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SelectServicetypeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SelectServicetypeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ServicetypeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ServicetypeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipfromcountryTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipfromcountryTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipfromcountryselectButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipfromcountryselectButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShiptocountryButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShiptocountryButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShiptocountryTBTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShiptocountryTBTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentOrdersdropdownButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentOrdersdropdownButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentordersoneLabel()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentordersoneLabelXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentordersrefreshButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentordersrefreshButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentOrdersSearchTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentOrdersSearchTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentordersthreeLabel()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentordersthreeLabelXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentorderstwoLabel()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentorderstwoLabelXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentValueTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentValueTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentValuetwoTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ShipmentValuetwoTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOIDCopyLabel()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOIDCopyLabelXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SONewButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SONewButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTclientTypeofProductButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTclientTypeofProductButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTclientTypeofProducttwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTclientTypeofProducttwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTDoyoushipsecondhandorrefurbishedgoodsButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTDoyoushipsecondhandorrefurbishedgoodsButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTInvestigationalProductsButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTInvestigationalProductsButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTRefurbishedgoodsButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTRefurbishedgoodsButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTShiptocountryCanadaTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTShiptocountryCanadaTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTShiptocountryCanadavalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTShiptocountryCanadavalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTShiptocountryUnitedArabEmiratesTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTShiptocountryUnitedArabEmiratesTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTShiptocountryUnitedArabEmiratesvalueButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTShiptocountryUnitedArabEmiratesvalueButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTTechEquipmentButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTTechEquipmentButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTTemperatureControlRequirementsButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTTemperatureControlRequirementsButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTTemperatureControlTransitButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTTemperatureControlTransitButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTTypeofProductButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTTypeofProductButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTTypeofProducttwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTTypeofProducttwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTWhoHandlesInternationalFreightButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTWhoHandlesInternationalFreightButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement SOTWhoHandlesInternationalFreighttwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.SOTWhoHandlesInternationalFreighttwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement TechequipmentButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.TechequipmentButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ThisaClinicalTrialButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.ThisaClinicalTrialButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement TogglebuttonshipmentinInternationalfreightButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.TogglebuttonshipmentinInternationalfreightButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement TogglebuttonshipmentinServicetypeButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.TogglebuttonshipmentinServicetypeButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement TogglebuttonshipmentinShipfromcountryButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.TogglebuttonshipmentinShipfromcountryButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement TypeofProductButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.TypeofProductButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement UnitsOfMeasurementButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.UnitsOfMeasurementButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement VendorReferenceTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.VendorReferenceTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement VendorReferencetwoTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.VendorReferencetwoTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement WaitTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.WaitTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement YesAddtoexistingprojectButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.YesAddtoexistingprojectButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement YesnewprojectButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page1.YesnewprojectButtonXpath"),"Xpath"); 
	 	 }
	}
