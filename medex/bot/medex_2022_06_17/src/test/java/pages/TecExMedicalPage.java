package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.WebBrowserUtil;
import common.YMLUtil;
	public class TecExMedicalPage
	{
	 	 WebDriver driver;
	 	 public TecExMedicalPage (WebDriver _driver){ driver=_driver; } 

 	 	 public WebElement PasswordTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("TecEx Medical.PasswordTextBoxXpath"),"Xpath"); 
	 	 }

 	 	 public WebElement UsernameTextBox()
	 	 {
	 	  return WebBrowserUtil.findElement(YMLUtil.getYMLObjectRepositoryData("TecEx Medical.UsernameTextBoxXpath"),"Xpath"); 
	 	 }
	}
