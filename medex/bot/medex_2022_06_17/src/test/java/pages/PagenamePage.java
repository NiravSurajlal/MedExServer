package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.WebBrowserUtil;
import common.YMLUtil;
	public class PagenamePage
	{
	 	 WebDriver driver;
	 	 public PagenamePage (WebDriver _driver){ driver=_driver; } 

 	 	 public WebElement ClientreferencethreeTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page name.ClientreferencethreeTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement EstimatedChargeableweightthreeTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page name.EstimatedChargeableweightthreeTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTecexHandlestwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page name.NSTecexHandlestwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement NSTypeofProductTechEquipmenttwoButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page name.NSTypeofProductTechEquipmenttwoButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement PDAddPackageinsecondRowButton()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page name.PDAddPackageinsecondRowButtonXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement ShipmentValuethreeTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("Page name.ShipmentValuethreeTextBoxXpath"),"Xpath"); 
	 	 }
	}
