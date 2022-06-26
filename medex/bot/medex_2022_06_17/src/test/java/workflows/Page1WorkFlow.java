package workflows;
import common.WebBrowser;
import common.CommonUtil;
import common.WebBrowserUtil;
import common.DbHelper;
import common.Hooks;
import common.CustomException;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.Comparator;
import common.YMLUtil;
import com.cucumber.listener.Reporter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Calendar;
import java.io.BufferedWriter;
import java.text.DateFormat;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import java.util.Arrays;
import java.io.File;
import org.openqa.selenium.interactions.Actions;
import java.nio.file.Path;
import org.openqa.selenium.Keys;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import java.util.Optional;
import java.util.List;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.HashMap;
import common.PostgreSQLUtil;
import common.SqlServerUtil;
import common.MongoDBUtil;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import java.io.IOException;
import java.util.TimeZone;
import java.awt.Color;
import pages.Page1Page;
import common. customUtil;
public class Page1WorkFlow
{
	public static WebDriver browser;
	final static Logger log = Logger.getLogger(Page1WorkFlow.class);

 	 	 public void EnterAccount(String account)
	 	 {
	 	 	 log.info("Method EnterAccount completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 account=CommonUtil.GetData(account);
	 	 	 account = DbHelper.textRandomCopiedNumber(account);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.AccountTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, account);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,account); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterAccount not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void checkAddDeliveryAddressCheckbox()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element=page1Page.AddDeliveryAddressCheckboxCheckBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.Check(element);
	 	 	 log.info("Method checkAddDeliveryAddressCheckbox completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndCheck(element);
	 	 	 log.info("Method checkAddDeliveryAddressCheckbox completed.");
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method checkAddDeliveryAddressCheckbox not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedAddDeliveryAddressOK()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedAddDeliveryAddressOK    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement AddDeliveryAddressOKlink = page1Page.AddDeliveryAddressOKButton();
	 	 	     try
	 	 	 //selectedAddDeliveryAddressOK    
	 	 	     {
	 	 	        WebBrowserUtil.Click(AddDeliveryAddressOKlink);
	 	 	 log.info("Method selectedAddDeliveryAddressOK completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(AddDeliveryAddressOKlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedAddDeliveryAddressOK not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedAddDeliveryAddressOptional()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedAddDeliveryAddressOptional    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement AddDeliveryAddressOptionallink = page1Page.AddDeliveryAddressOptionalButton();
	 	 	     try
	 	 	 //selectedAddDeliveryAddressOptional    
	 	 	     {
	 	 	        WebBrowserUtil.Click(AddDeliveryAddressOptionallink);
	 	 	 log.info("Method selectedAddDeliveryAddressOptional completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(AddDeliveryAddressOptionallink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedAddDeliveryAddressOptional not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void TextBoxAddheadersaddHeaders(String lineItems)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 customUtil customObject= new customUtil();
	 	 	customObject.addHeaders(lineItems);

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void TextBoxAddLineitemsaddmultiplelineitems(String lineItems)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 customUtil customObject= new customUtil();
	 	 	customObject.addMultipleLineItems(lineItems);

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedAddLineitemsSave()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedAddLineitemsSave    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement AddLineitemsSavelink = page1Page.AddLineitemsSaveButton();
	 	 	     try
	 	 	 //selectedAddLineitemsSave    
	 	 	     {
	 	 	        WebBrowserUtil.Click(AddLineitemsSavelink);
	 	 	 log.info("Method selectedAddLineitemsSave completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(AddLineitemsSavelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedAddLineitemsSave not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void TextBoxAddLineitemsTecexaddlineitems(String lineItems)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 customUtil customObject= new customUtil();
	 	 	customObject.addLineItems(lineItems);

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedAddParts()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedAddParts    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement AddPartslink = page1Page.AddPartsButton();
	 	 	     try
	 	 	 //selectedAddParts    
	 	 	     {
	 	 	        WebBrowserUtil.Click(AddPartslink);
	 	 	 log.info("Method selectedAddParts completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(AddPartslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedAddParts not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedAddpickupaddress()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedAddpickupaddress    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Addpickupaddresslink = page1Page.AddpickupaddressButton();
	 	 	     try
	 	 	 //selectedAddpickupaddress    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Addpickupaddresslink);
	 	 	 log.info("Method selectedAddpickupaddress completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Addpickupaddresslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedAddpickupaddress not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedAddrowinTable()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedAddrowinTable    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement AddrowinTablelink = page1Page.AddrowinTableButton();
	 	 	     try
	 	 	 //selectedAddrowinTable    
	 	 	     {
	 	 	        WebBrowserUtil.Click(AddrowinTablelink);
	 	 	 log.info("Method selectedAddrowinTable completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(AddrowinTablelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedAddrowinTable not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedAddtotable()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedAddtotable    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Addtotablelink = page1Page.AddtotableButton();
	 	 	     try
	 	 	 //selectedAddtotable    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Addtotablelink);
	 	 	 log.info("Method selectedAddtotable completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Addtotablelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedAddtotable not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterClientreference(String clientreference)
	 	 {
	 	 	 log.info("Method EnterClientreference completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 clientreference=CommonUtil.GetData(clientreference);
	 	 	 clientreference = DbHelper.textRandomCopiedNumber(clientreference);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.ClientreferenceTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, clientreference);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,clientreference); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterClientreference not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void ClearAndEnterTextForClientreferencetwo(String clientreferencetwo)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 clientreferencetwo = CommonUtil.GetData(clientreferencetwo);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForClientreferencetwo completed.");
	 	 	 clientreferencetwo=clientreferencetwo.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.ClientreferencetwoTextBox(),clientreferencetwo); 
	 	 	 log.info("Method ClearAndEnterTextForClientreferencetwo completed.");
		 }

 	 	 public void selectedClinicaltrial()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedClinicaltrial    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Clinicaltriallink = page1Page.ClinicaltrialButton();
	 	 	     try
	 	 	 //selectedClinicaltrial    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Clinicaltriallink);
	 	 	 log.info("Method selectedClinicaltrial completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Clinicaltriallink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedClinicaltrial not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterContact(String contact)
	 	 {
	 	 	 log.info("Method EnterContact completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 contact=CommonUtil.GetData(contact);
	 	 	 contact = DbHelper.textRandomCopiedNumber(contact);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.ContactTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, contact);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,contact); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterContact not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedCreateNewProject()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedCreateNewProject    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement CreateNewProjectlink = page1Page.CreateNewProjectButton();
	 	 	     try
	 	 	 //selectedCreateNewProject    
	 	 	     {
	 	 	        WebBrowserUtil.Click(CreateNewProjectlink);
	 	 	 log.info("Method selectedCreateNewProject completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(CreateNewProjectlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedCreateNewProject not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedCreateQuote()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedCreateQuote    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement CreateQuotelink = page1Page.CreateQuoteButton();
	 	 	     try
	 	 	 //selectedCreateQuote    
	 	 	     {
	 	 	        WebBrowserUtil.Click(CreateQuotelink);
	 	 	 log.info("Method selectedCreateQuote completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(CreateQuotelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedCreateQuote not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public boolean  VerifyDefaultpageIsdisplayed(String defaultpage)
	 	 {
	 	 	 boolean isVerified = false;
	 	 	 for (int i = 0; i <= 2; i++)
	 	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 //WebBrowserUtil.SwitchToBrowserWindow(WebBrowser.getParentWindowHandle());
	 	 	 try{
	 	 	 	 browser = WebBrowserUtil.AttachPage(defaultpage);
	 	 	 }
	 	 	 catch(Exception ex){ 
	 	 	 
	 	 	 }
	 	 	 if (defaultpage != null && !defaultpage.isEmpty()  && !defaultpage.toUpperCase().equals("NA".toUpperCase()) && !defaultpage.toUpperCase().equals("Page1".toUpperCase()) && !defaultpage.toUpperCase().equals("Page2".toUpperCase()) && !defaultpage.toUpperCase().equals("Page3".toUpperCase())&& !defaultpage.toUpperCase().equals("Page4".toUpperCase()))
	 	 	 {
	 	 	 isVerified = browser.getTitle().toUpperCase().contains(defaultpage.toUpperCase());
	 	 	 }
	 	 	 else
	 	 	 {
	 	 	 isVerified = true;
	 	 	 }
	 	 	 if (isVerified)
	 	 	  {
	 	 	    break;
	 	 	  }
	 	}
	 	 try
	 	 {
	 	 Reporter.addStepLog("Actual Page Name: "+browser.getTitle()+", Expected Page Name: "+defaultpage);
	 	 	 log.info("Method  VerifyDefaultpageIsdisplayed completed.");
	 	 }
	 	 catch(Exception e)
	 	 {}
	 	 	 return isVerified;
		 }

 	 	 public void EnterEstimatedChargeableweight(String estimatedChargeableweight)
	 	 {
	 	 	 log.info("Method EnterEstimatedChargeableweight completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 estimatedChargeableweight=CommonUtil.GetData(estimatedChargeableweight);
	 	 	 estimatedChargeableweight = DbHelper.textRandomCopiedNumber(estimatedChargeableweight);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.EstimatedChargeableweightTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, estimatedChargeableweight);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,estimatedChargeableweight); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterEstimatedChargeableweight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void ClearAndEnterTextForEstimatedChargeableweighttwo(String estimatedChargeableweighttwo)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 estimatedChargeableweighttwo = CommonUtil.GetData(estimatedChargeableweighttwo);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForEstimatedChargeableweighttwo completed.");
	 	 	 estimatedChargeableweighttwo=estimatedChargeableweighttwo.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.EstimatedChargeableweighttwoTextBox(),estimatedChargeableweighttwo); 
	 	 	 log.info("Method ClearAndEnterTextForEstimatedChargeableweighttwo completed.");
		 }

 	 	 public void selectedImperialUM()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedImperialUM    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement ImperialUMlink = page1Page.ImperialUMButton();
	 	 	     try
	 	 	 //selectedImperialUM    
	 	 	     {
	 	 	        WebBrowserUtil.Click(ImperialUMlink);
	 	 	 log.info("Method selectedImperialUM completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(ImperialUMlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedImperialUM not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedInternationalFreight()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedInternationalFreight    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement InternationalFreightlink = page1Page.InternationalFreightButton();
	 	 	     try
	 	 	 //selectedInternationalFreight    
	 	 	     {
	 	 	        WebBrowserUtil.Click(InternationalFreightlink);
	 	 	 log.info("Method selectedInternationalFreight completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(InternationalFreightlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedInternationalFreight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedLogIntoSandbox()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedLogIntoSandbox    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement LogIntoSandboxlink = page1Page.LogIntoSandboxButton();
	 	 	     try
	 	 	 //selectedLogIntoSandbox    
	 	 	     {
	 	 	        WebBrowserUtil.Click(LogIntoSandboxlink);
	 	 	 log.info("Method selectedLogIntoSandbox completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(LogIntoSandboxlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedLogIntoSandbox not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedMedicalBotSO()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedMedicalBotSO    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement MedicalBotSOlink = page1Page.MedicalBotSOButton();
	 	 	     try
	 	 	 //selectedMedicalBotSO    
	 	 	     {
	 	 	        WebBrowserUtil.Click(MedicalBotSOlink);
	 	 	 log.info("Method selectedMedicalBotSO completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(MedicalBotSOlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedMedicalBotSO not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public boolean  VerifymessageIsDisplayed(String message)
	 	 {
	 	 	 boolean isVerified = false;
	 	 	String[] messages;
	 	 	String[] messages1;
	 	 	List<String> boolvalues = null;
	 	 	if(message.contains("verifyalert_"))
	 	 	{
	 	 	 	 String[] msgs=message.split("_");
	 	 	 	 return WebBrowserUtil.verifyAlertText(msgs[1]);
	 	 	}
	 	 	if ((message.contains("frameid_")) && (message.contains("&or&")))
	 	 	{
	 	 	String[] msgs = message.split("_");
	 	 	String frameID = "";
	 	 	for (int i = 0; i < msgs.length - 1; i++)
	 	 	{
	 	 	if (i != 0)
	 	 	{
	 	 	frameID = frameID + msgs[i] + "_";
	 	 	}
	 	 	}
	 	 	frameID = frameID.replaceAll("_$", "");
	 	 	WebBrowserUtil.GetFrame(frameID);
	 	 	String[] multiplemessages = msgs[msgs.length - 1].toString().split("&or&");
	 	 	for (int i = 0; i < multiplemessages.length; i++)
	 	 	{
	 	 	 boolean isVerified1 = WebBrowserUtil.IsElementPresent(multiplemessages[i]);
	 	 	if (isVerified1)
	 	 	{
	 	 	isVerified = true;
	 	 	}
	 	 	}
	 	 	 return isVerified;
	 	 	}
	 	 	else if(message.contains("frameid_"))
	 	 	{
	 	 	 	String[] msgs=message.split("_");
	 	 	 	String frameID="";
	 	 	 	for(int i=0;i<msgs.length-1;i++)
	 	 	 	{
	 	 	 	 	 if(i!=0)
	 	 	 	 	{
	 	 	 	 	 	frameID = frameID+msgs[i]+"_";
	 	 	 	 	}
	 	 	 	}
	 	 	 	frameID= frameID.replaceAll("_$", "");
	 	 	 	WebBrowserUtil.GetFrame(frameID);
	 	 	 	isVerified = WebBrowserUtil.IsElementPresent(msgs[msgs.length-1]);
	 	 	 	return isVerified;
	 	 	}
	 	 	if (message.contains(")_or_("))
	 	 	{
	 	 	 	 messages = message.split(")_or_(");
	 	 	 	for(String msg : messages)
	 	 	 	  {
	 	 	 	 	  if (msg.toUpperCase().equals("NA"))
	 	 	 	 	  {
	 	 	 	 	      return true;
	 	 	 	 	  }
	 	 	 	 	 messages1 = msg.split("_and_");
	 	 	 boolvalues.clear();
	 	 	 	  for(String msg1 : messages1)
	 	 	 	 {
	 	 	 	 	String messagetocheck = msg1;
	 	 	 	 	 messagetocheck = msg1.replace("(", "").replace(")", "");
	 	 	 	 browser = WebBrowser.getBrowser();
	 	 	 	 	 isVerified = WebBrowserUtil.IsElementPresent(messagetocheck);
	 	 	 	 	if (isVerified)
	 	 	 	 	{
	 	 	 	 	boolvalues.add(Boolean.toString(isVerified));
	 	 	 	 }
	 	 	 	 }
	 	 	 	 	if (messages1.length == boolvalues.size())
	 	 	 	{
	 	 	 	 	 Assert.assertTrue(isVerified);
	 	 	 	 	 System.out.println("message Labelwith value : message is verified");
	 	 	 	 	 return isVerified;
	 	 	 	 	}
	 	 	 	 	}
	 	 	 	 	 return isVerified;
	 	 	 	}
	 	 	else if (message.contains("_and_"))
	 	 	{
	 	 	 	messages = message.split("_and_");
	 	 	 	for(String msg : messages)
	 	 	 	{
	 	 	 	 browser = WebBrowser.getBrowser();
	 	 	 	isVerified = WebBrowserUtil.IsElementPresent(msg);
	 	 	 	if (isVerified == false)
	 	 	 	{
	 	 	 	 return isVerified;
	 	 	 	}
	 	 	}
	 	 	return isVerified;
	 	 	}
	 	 	else if (message.contains("_or_"))
	 	 	 	{
	 	 	 	messages = message.split("_or_");
	 	 	 	for(String msg : messages)
	 	 	 	{
	 	 	 	 	 browser = WebBrowser.getBrowser();
	 	 	 	 	  if(msg=="NA")
	 	 	 	 	{
	 	 	 	 	 Assert.assertTrue(isVerified);
	 	 	 	 	 System.out.println("message Labelwith value : message is verified");
	 	 	 	 	return isVerified;
	 	 	 	 	}
	 	 	 	 	isVerified = WebBrowserUtil.IsElementPresent(msg);
	 	 	 	 	 if (isVerified)
	 	 	 	 	{
	 	 	 	 	 	 Assert.assertTrue(isVerified);
	 	 	 	 	 	 System.out.println("message Labelwith value : message is verified");
	 	 	 	 	 	 return isVerified;
	 	 	 	 	}
	 	 	 	}
	 	 	return isVerified;
	 	 	}
	 	 	 if(!message.equals("NA"))
	 	 	 {
	 	 	   for (int i = 0; i <= 2; i++)
	 	 	   {
	 	 	   String content = "";
	 	 	  	 browser = WebBrowser.getBrowser();
	 	 	 	 isVerified =WebBrowserUtil.IsElementPresent(message);
	 	 	 	 try
	 	 	 	{
	 	 	 	 	content = browser.findElement(By.xpath("")).getText();
	 	 	 	 	if (!isVerified)
	 	 	 	 	{
	 	 	 	 	if (content.contains(message))
	 	 	 	 	{
	 	 	 	 	isVerified = true;
	 	 	 	 	 }
	 	 	 	 	}
	 	 	 	 	}
	 	 	 	 	catch (Exception exc)
	 	 	 	 	{
	 	 	 	 	}
	 	 	 	 content = WebBrowserUtil.GetContent(message);
	 	 	 	 if (isVerified)
	 	 	 	 	 {
	 	 	 	 Assert.assertTrue(isVerified);
	 	 	 	 System.out.println("message Labelwith value : message is verified");
	 	 	 	 if (content != null && !content.isEmpty())
	 	 	 	 {
	 	 	 	 	 Reporter.addStepLog("Actual content: "+content+", Expected content: "+message);
	 	 	 log.info("Method  VerifymessageIsDisplayed completed.");
	 	 	 	 }
	 	 	 	 	 return isVerified;
	 	 	 	 	}
	 	 	   }
	 	 	 	 return isVerified;
	 	 	 }
	 	 	 else
	 	 	 {
	 	 	 	 return true;
	 	 	 }
		 }

 	 	 public void selectedNSclientHandlesInternationalFreight()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSclientHandlesInternationalFreight    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSclientHandlesInternationalFreightlink = page1Page.NSclientHandlesInternationalFreightButton();
	 	 	     try
	 	 	 //selectedNSclientHandlesInternationalFreight    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSclientHandlesInternationalFreightlink);
	 	 	 log.info("Method selectedNSclientHandlesInternationalFreight completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSclientHandlesInternationalFreightlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSclientHandlesInternationalFreight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSDoyoushipsecondhandorrefurbishedgoods()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSDoyoushipsecondhandorrefurbishedgoods    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSDoyoushipsecondhandorrefurbishedgoodslink = page1Page.NSDoyoushipsecondhandorrefurbishedgoodsButton();
	 	 	     try
	 	 	 //selectedNSDoyoushipsecondhandorrefurbishedgoods    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSDoyoushipsecondhandorrefurbishedgoodslink);
	 	 	 log.info("Method selectedNSDoyoushipsecondhandorrefurbishedgoods completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSDoyoushipsecondhandorrefurbishedgoodslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSDoyoushipsecondhandorrefurbishedgoods not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSDoyoushipsecondhandorrefurbishedgoodsthree()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSDoyoushipsecondhandorrefurbishedgoodsthree    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSDoyoushipsecondhandorrefurbishedgoodsthreelink = page1Page.NSDoyoushipsecondhandorrefurbishedgoodsthreeButton();
	 	 	     try
	 	 	 //selectedNSDoyoushipsecondhandorrefurbishedgoodsthree    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSDoyoushipsecondhandorrefurbishedgoodsthreelink);
	 	 	 log.info("Method selectedNSDoyoushipsecondhandorrefurbishedgoodsthree completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSDoyoushipsecondhandorrefurbishedgoodsthreelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSDoyoushipsecondhandorrefurbishedgoodsthree not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSDoyoushipsecondhandorrefurbishedgoodstwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSDoyoushipsecondhandorrefurbishedgoodstwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSDoyoushipsecondhandorrefurbishedgoodstwolink = page1Page.NSDoyoushipsecondhandorrefurbishedgoodstwoButton();
	 	 	     try
	 	 	 //selectedNSDoyoushipsecondhandorrefurbishedgoodstwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSDoyoushipsecondhandorrefurbishedgoodstwolink);
	 	 	 log.info("Method selectedNSDoyoushipsecondhandorrefurbishedgoodstwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSDoyoushipsecondhandorrefurbishedgoodstwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSDoyoushipsecondhandorrefurbishedgoodstwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSNeitherofthem()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSNeitherofthem    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSNeitherofthemlink = page1Page.NSNeitherofthemButton();
	 	 	     try
	 	 	 //selectedNSNeitherofthem    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSNeitherofthemlink);
	 	 	 log.info("Method selectedNSNeitherofthem completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSNeitherofthemlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSNeitherofthem not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSRefurbished()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSRefurbished    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSRefurbishedlink = page1Page.NSRefurbishedButton();
	 	 	     try
	 	 	 //selectedNSRefurbished    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSRefurbishedlink);
	 	 	 log.info("Method selectedNSRefurbished completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSRefurbishedlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSRefurbished not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSServicetype()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSServicetype    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSServicetypelink = page1Page.NSServicetypeButton();
	 	 	     try
	 	 	 //selectedNSServicetype    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSServicetypelink);
	 	 	 log.info("Method selectedNSServicetype completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSServicetypelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSServicetype not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSServicetypethree()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSServicetypethree    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSServicetypethreelink = page1Page.NSServicetypethreeButton();
	 	 	     try
	 	 	 //selectedNSServicetypethree    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSServicetypethreelink);
	 	 	 log.info("Method selectedNSServicetypethree completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSServicetypethreelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSServicetypethree not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSServicetypetwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSServicetypetwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSServicetypetwolink = page1Page.NSServicetypetwoButton();
	 	 	     try
	 	 	 //selectedNSServicetypetwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSServicetypetwolink);
	 	 	 log.info("Method selectedNSServicetypetwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSServicetypetwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSServicetypetwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSServicetypeValue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSServicetypeValue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSServicetypeValuelink = page1Page.NSServicetypeValueButton();
	 	 	     try
	 	 	 //selectedNSServicetypeValue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSServicetypeValuelink);
	 	 	 log.info("Method selectedNSServicetypeValue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSServicetypeValuelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSServicetypeValue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSServicetypeValuethree()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSServicetypeValuethree    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSServicetypeValuethreelink = page1Page.NSServicetypeValuethreeButton();
	 	 	     try
	 	 	 //selectedNSServicetypeValuethree    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSServicetypeValuethreelink);
	 	 	 log.info("Method selectedNSServicetypeValuethree completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSServicetypeValuethreelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSServicetypeValuethree not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSServicetypeValuetwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSServicetypeValuetwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSServicetypeValuetwolink = page1Page.NSServicetypeValuetwoButton();
	 	 	     try
	 	 	 //selectedNSServicetypeValuetwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSServicetypeValuetwolink);
	 	 	 log.info("Method selectedNSServicetypeValuetwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSServicetypeValuetwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSServicetypeValuetwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterNSShipfromcountryAlgeria(String nSShipfromcountryAlgeria)
	 	 {
	 	 	 log.info("Method EnterNSShipfromcountryAlgeria completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 nSShipfromcountryAlgeria=CommonUtil.GetData(nSShipfromcountryAlgeria);
	 	 	 nSShipfromcountryAlgeria = DbHelper.textRandomCopiedNumber(nSShipfromcountryAlgeria);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.NSShipfromcountryAlgeriaTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, nSShipfromcountryAlgeria);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,nSShipfromcountryAlgeria); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterNSShipfromcountryAlgeria not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSShipfromcountryAlgeriavalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSShipfromcountryAlgeriavalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSShipfromcountryAlgeriavaluelink = page1Page.NSShipfromcountryAlgeriavalueButton();
	 	 	     try
	 	 	 //selectedNSShipfromcountryAlgeriavalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSShipfromcountryAlgeriavaluelink);
	 	 	 log.info("Method selectedNSShipfromcountryAlgeriavalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSShipfromcountryAlgeriavaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSShipfromcountryAlgeriavalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterNSShipfromcountryBermuda(String nSShipfromcountryBermuda)
	 	 {
	 	 	 log.info("Method EnterNSShipfromcountryBermuda completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 nSShipfromcountryBermuda=CommonUtil.GetData(nSShipfromcountryBermuda);
	 	 	 nSShipfromcountryBermuda = DbHelper.textRandomCopiedNumber(nSShipfromcountryBermuda);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.NSShipfromcountryBermudaTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, nSShipfromcountryBermuda);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,nSShipfromcountryBermuda); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterNSShipfromcountryBermuda not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSShipfromcountryBermudavalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSShipfromcountryBermudavalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSShipfromcountryBermudavaluelink = page1Page.NSShipfromcountryBermudavalueButton();
	 	 	     try
	 	 	 //selectedNSShipfromcountryBermudavalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSShipfromcountryBermudavaluelink);
	 	 	 log.info("Method selectedNSShipfromcountryBermudavalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSShipfromcountryBermudavaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSShipfromcountryBermudavalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterNSShipfromcountryUS(String nSShipfromcountryUS)
	 	 {
	 	 	 log.info("Method EnterNSShipfromcountryUS completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 nSShipfromcountryUS=CommonUtil.GetData(nSShipfromcountryUS);
	 	 	 nSShipfromcountryUS = DbHelper.textRandomCopiedNumber(nSShipfromcountryUS);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.NSShipfromcountryUSTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, nSShipfromcountryUS);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,nSShipfromcountryUS); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterNSShipfromcountryUS not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSShipfromcountryUSvalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSShipfromcountryUSvalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSShipfromcountryUSvaluelink = page1Page.NSShipfromcountryUSvalueButton();
	 	 	     try
	 	 	 //selectedNSShipfromcountryUSvalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSShipfromcountryUSvaluelink);
	 	 	 log.info("Method selectedNSShipfromcountryUSvalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSShipfromcountryUSvaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSShipfromcountryUSvalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSshipsecondhand()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSshipsecondhand    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSshipsecondhandlink = page1Page.NSshipsecondhandButton();
	 	 	     try
	 	 	 //selectedNSshipsecondhand    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSshipsecondhandlink);
	 	 	 log.info("Method selectedNSshipsecondhand completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSshipsecondhandlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSshipsecondhand not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterNSShipTOcountryBrazil(String nSShipTOcountryBrazil)
	 	 {
	 	 	 log.info("Method EnterNSShipTOcountryBrazil completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 nSShipTOcountryBrazil=CommonUtil.GetData(nSShipTOcountryBrazil);
	 	 	 nSShipTOcountryBrazil = DbHelper.textRandomCopiedNumber(nSShipTOcountryBrazil);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.NSShipTOcountryBrazilTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, nSShipTOcountryBrazil);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,nSShipTOcountryBrazil); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterNSShipTOcountryBrazil not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSShipTOcountryBrazilvalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSShipTOcountryBrazilvalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSShipTOcountryBrazilvaluelink = page1Page.NSShipTOcountryBrazilvalueButton();
	 	 	     try
	 	 	 //selectedNSShipTOcountryBrazilvalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSShipTOcountryBrazilvaluelink);
	 	 	 log.info("Method selectedNSShipTOcountryBrazilvalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSShipTOcountryBrazilvaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSShipTOcountryBrazilvalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterNSShipTOcountryCanada(String nSShipTOcountryCanada)
	 	 {
	 	 	 log.info("Method EnterNSShipTOcountryCanada completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 nSShipTOcountryCanada=CommonUtil.GetData(nSShipTOcountryCanada);
	 	 	 nSShipTOcountryCanada = DbHelper.textRandomCopiedNumber(nSShipTOcountryCanada);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.NSShipTOcountryCanadaTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, nSShipTOcountryCanada);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,nSShipTOcountryCanada); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterNSShipTOcountryCanada not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSShipTOcountryCanadavalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSShipTOcountryCanadavalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSShipTOcountryCanadavaluelink = page1Page.NSShipTOcountryCanadavalueButton();
	 	 	     try
	 	 	 //selectedNSShipTOcountryCanadavalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSShipTOcountryCanadavaluelink);
	 	 	 log.info("Method selectedNSShipTOcountryCanadavalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSShipTOcountryCanadavaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSShipTOcountryCanadavalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterNSShipTOcountrySouthAfrica(String nSShipTOcountrySouthAfrica)
	 	 {
	 	 	 log.info("Method EnterNSShipTOcountrySouthAfrica completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 nSShipTOcountrySouthAfrica=CommonUtil.GetData(nSShipTOcountrySouthAfrica);
	 	 	 nSShipTOcountrySouthAfrica = DbHelper.textRandomCopiedNumber(nSShipTOcountrySouthAfrica);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.NSShipTOcountrySouthAfricaTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, nSShipTOcountrySouthAfrica);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,nSShipTOcountrySouthAfrica); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterNSShipTOcountrySouthAfrica not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSShipTOcountrySouthAfricavalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSShipTOcountrySouthAfricavalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSShipTOcountrySouthAfricavaluelink = page1Page.NSShipTOcountrySouthAfricavalueButton();
	 	 	     try
	 	 	 //selectedNSShipTOcountrySouthAfricavalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSShipTOcountrySouthAfricavaluelink);
	 	 	 log.info("Method selectedNSShipTOcountrySouthAfricavalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSShipTOcountrySouthAfricavaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSShipTOcountrySouthAfricavalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTecexHandlesInternationalFreight()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTecexHandlesInternationalFreight    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTecexHandlesInternationalFreightlink = page1Page.NSTecexHandlesInternationalFreightButton();
	 	 	     try
	 	 	 //selectedNSTecexHandlesInternationalFreight    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTecexHandlesInternationalFreightlink);
	 	 	 log.info("Method selectedNSTecexHandlesInternationalFreight completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTecexHandlesInternationalFreightlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTecexHandlesInternationalFreight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTemperatureControlRequirementstwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTemperatureControlRequirementstwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTemperatureControlRequirementstwolink = page1Page.NSTemperatureControlRequirementstwoButton();
	 	 	     try
	 	 	 //selectedNSTemperatureControlRequirementstwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTemperatureControlRequirementstwolink);
	 	 	 log.info("Method selectedNSTemperatureControlRequirementstwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTemperatureControlRequirementstwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTemperatureControlRequirementstwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTemperatureControlTransittwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTemperatureControlTransittwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTemperatureControlTransittwolink = page1Page.NSTemperatureControlTransittwoButton();
	 	 	     try
	 	 	 //selectedNSTemperatureControlTransittwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTemperatureControlTransittwolink);
	 	 	 log.info("Method selectedNSTemperatureControlTransittwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTemperatureControlTransittwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTemperatureControlTransittwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTypeofProduct()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTypeofProduct    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTypeofProductlink = page1Page.NSTypeofProductButton();
	 	 	     try
	 	 	 //selectedNSTypeofProduct    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTypeofProductlink);
	 	 	 log.info("Method selectedNSTypeofProduct completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTypeofProductlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTypeofProduct not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTypeofProductInvestigational()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTypeofProductInvestigational    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTypeofProductInvestigationallink = page1Page.NSTypeofProductInvestigationalButton();
	 	 	     try
	 	 	 //selectedNSTypeofProductInvestigational    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTypeofProductInvestigationallink);
	 	 	 log.info("Method selectedNSTypeofProductInvestigational completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTypeofProductInvestigationallink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTypeofProductInvestigational not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTypeofProductMedicalEquipment()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTypeofProductMedicalEquipment    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTypeofProductMedicalEquipmentlink = page1Page.NSTypeofProductMedicalEquipmentButton();
	 	 	     try
	 	 	 //selectedNSTypeofProductMedicalEquipment    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTypeofProductMedicalEquipmentlink);
	 	 	 log.info("Method selectedNSTypeofProductMedicalEquipment completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTypeofProductMedicalEquipmentlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTypeofProductMedicalEquipment not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTypeofProductthree()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTypeofProductthree    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTypeofProductthreelink = page1Page.NSTypeofProductthreeButton();
	 	 	     try
	 	 	 //selectedNSTypeofProductthree    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTypeofProductthreelink);
	 	 	 log.info("Method selectedNSTypeofProductthree completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTypeofProductthreelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTypeofProductthree not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSTypeofProducttwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSTypeofProducttwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTypeofProducttwolink = page1Page.NSTypeofProducttwoButton();
	 	 	     try
	 	 	 //selectedNSTypeofProducttwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTypeofProducttwolink);
	 	 	 log.info("Method selectedNSTypeofProducttwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTypeofProducttwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTypeofProducttwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSWhoHandlesInternationalFreight()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSWhoHandlesInternationalFreight    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSWhoHandlesInternationalFreightlink = page1Page.NSWhoHandlesInternationalFreightButton();
	 	 	     try
	 	 	 //selectedNSWhoHandlesInternationalFreight    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSWhoHandlesInternationalFreightlink);
	 	 	 log.info("Method selectedNSWhoHandlesInternationalFreight completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSWhoHandlesInternationalFreightlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSWhoHandlesInternationalFreight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSWhoHandlesInternationalFreightthree()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSWhoHandlesInternationalFreightthree    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSWhoHandlesInternationalFreightthreelink = page1Page.NSWhoHandlesInternationalFreightthreeButton();
	 	 	     try
	 	 	 //selectedNSWhoHandlesInternationalFreightthree    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSWhoHandlesInternationalFreightthreelink);
	 	 	 log.info("Method selectedNSWhoHandlesInternationalFreightthree completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSWhoHandlesInternationalFreightthreelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSWhoHandlesInternationalFreightthree not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedNSWhoHandlesInternationalFreighttwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedNSWhoHandlesInternationalFreighttwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSWhoHandlesInternationalFreighttwolink = page1Page.NSWhoHandlesInternationalFreighttwoButton();
	 	 	     try
	 	 	 //selectedNSWhoHandlesInternationalFreighttwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSWhoHandlesInternationalFreighttwolink);
	 	 	 log.info("Method selectedNSWhoHandlesInternationalFreighttwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSWhoHandlesInternationalFreighttwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSWhoHandlesInternationalFreighttwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void ClearAndEnterTextForPDActualWeight(String pDActualWeight)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 pDActualWeight = CommonUtil.GetData(pDActualWeight);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForPDActualWeight completed.");
	 	 	 pDActualWeight=pDActualWeight.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.PDActualWeightTextBox(),pDActualWeight); 
	 	 	 log.info("Method ClearAndEnterTextForPDActualWeight completed.");
		 }

 	 	 public void selectedPDAddFirstPackage()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDAddFirstPackage    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDAddFirstPackagelink = page1Page.PDAddFirstPackageButton();
	 	 	     try
	 	 	 //selectedPDAddFirstPackage    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDAddFirstPackagelink);
	 	 	 log.info("Method selectedPDAddFirstPackage completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDAddFirstPackagelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDAddFirstPackage not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedPDAddRow()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDAddRow    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDAddRowlink = page1Page.PDAddRowButton();
	 	 	     try
	 	 	 //selectedPDAddRow    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDAddRowlink);
	 	 	 log.info("Method selectedPDAddRow completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDAddRowlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDAddRow not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedPDAddSecondPackage()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDAddSecondPackage    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDAddSecondPackagelink = page1Page.PDAddSecondPackageButton();
	 	 	     try
	 	 	 //selectedPDAddSecondPackage    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDAddSecondPackagelink);
	 	 	 log.info("Method selectedPDAddSecondPackage completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDAddSecondPackagelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDAddSecondPackage not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void ClearAndEnterTextForPDBreadth(String pDBreadth)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 pDBreadth = CommonUtil.GetData(pDBreadth);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForPDBreadth completed.");
	 	 	 pDBreadth=pDBreadth.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.PDBreadthTextBox(),pDBreadth); 
	 	 	 log.info("Method ClearAndEnterTextForPDBreadth completed.");
		 }

 	 	 public void selectedPDContainsBatteries()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDContainsBatteries    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDContainsBatterieslink = page1Page.PDContainsBatteriesButton();
	 	 	     try
	 	 	 //selectedPDContainsBatteries    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDContainsBatterieslink);
	 	 	 log.info("Method selectedPDContainsBatteries completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDContainsBatterieslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDContainsBatteries not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedPDDimensionUnit()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDDimensionUnit    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDDimensionUnitlink = page1Page.PDDimensionUnitButton();
	 	 	     try
	 	 	 //selectedPDDimensionUnit    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDDimensionUnitlink);
	 	 	 log.info("Method selectedPDDimensionUnit completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDDimensionUnitlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDDimensionUnit not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedPDDimensionUnitvalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDDimensionUnitvalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDDimensionUnitvaluelink = page1Page.PDDimensionUnitvalueButton();
	 	 	     try
	 	 	 //selectedPDDimensionUnitvalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDDimensionUnitvaluelink);
	 	 	 log.info("Method selectedPDDimensionUnitvalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDDimensionUnitvaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDDimensionUnitvalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void ClearAndEnterTextForPDHeigth(String pDHeigth)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 pDHeigth = CommonUtil.GetData(pDHeigth);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForPDHeigth completed.");
	 	 	 pDHeigth=pDHeigth.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.PDHeigthTextBox(),pDHeigth); 
	 	 	 log.info("Method ClearAndEnterTextForPDHeigth completed.");
		 }

 	 	 public void ClearAndEnterTextForPDHowmanypackagesTB(String pDHowmanypackagesTB)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 pDHowmanypackagesTB = CommonUtil.GetData(pDHowmanypackagesTB);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForPDHowmanypackagesTB completed.");
	 	 	 pDHowmanypackagesTB=pDHowmanypackagesTB.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.PDHowmanypackagesTBTextBox(),pDHowmanypackagesTB); 
	 	 	 log.info("Method ClearAndEnterTextForPDHowmanypackagesTB completed.");
		 }

 	 	 public void ClearAndEnterTextForPDLength(String pDLength)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 pDLength = CommonUtil.GetData(pDLength);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForPDLength completed.");
	 	 	 pDLength=pDLength.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.PDLengthTextBox(),pDLength); 
	 	 	 log.info("Method ClearAndEnterTextForPDLength completed.");
		 }

 	 	 public void selectedPDSave()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDSave    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDSavelink = page1Page.PDSaveButton();
	 	 	     try
	 	 	 //selectedPDSave    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDSavelink);
	 	 	 log.info("Method selectedPDSave completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDSavelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDSave not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedPDWeightUnit()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDWeightUnit    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDWeightUnitlink = page1Page.PDWeightUnitButton();
	 	 	     try
	 	 	 //selectedPDWeightUnit    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDWeightUnitlink);
	 	 	 log.info("Method selectedPDWeightUnit completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDWeightUnitlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDWeightUnit not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedPDWeightUnitvalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedPDWeightUnitvalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDWeightUnitvaluelink = page1Page.PDWeightUnitvalueButton();
	 	 	     try
	 	 	 //selectedPDWeightUnitvalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDWeightUnitvaluelink);
	 	 	 log.info("Method selectedPDWeightUnitvalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDWeightUnitvaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDWeightUnitvalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedProceed()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedProceed    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Proceedlink = page1Page.ProceedButton();
	 	 	     try
	 	 	 //selectedProceed    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Proceedlink);
	 	 	 log.info("Method selectedProceed completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Proceedlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedProceed not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedProject()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedProject    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Projectlink = page1Page.ProjectButton();
	 	 	     try
	 	 	 //selectedProject    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Projectlink);
	 	 	 log.info("Method selectedProject completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Projectlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedProject not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void enterProjectName(String projectName)
	 	 {
	 	 	 log.info("Method enterProjectName completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 projectName=CommonUtil.GetData(projectName);
	 	 	 projectName = DbHelper.textRandomCopiedNumber(projectName);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.ProjectNameTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, projectName);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,projectName); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method enterProjectName not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void copiedtextprojectnamecopy()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 String copiedValue=WebBrowserUtil.GetText(page1Page.projectnamecopyLabel());
	 	 	if (copiedValue.contains("C:\\fakepath\\"))
	 	 	{
	 	 	Path p = Paths.get(copiedValue);
	 	 	copiedValue = p.getFileName().toString();
	 	 	}
	 	 	 CommonUtil.setCopiedText(copiedValue);
	 	 	 System.out.println(WebBrowserUtil.GetText(page1Page.projectnamecopyLabel()));
			  Reporter.addStepLog("Copied value: "+copiedValue);
	 	 	 log.info("Method copiedtextprojectnamecopy completed.");
		 }

 	 	 public void selectedQuote()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedQuote    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Quotelink = page1Page.QuoteButton();
	 	 	     try
	 	 	 //selectedQuote    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Quotelink);
	 	 	 log.info("Method selectedQuote completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Quotelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedQuote not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedRadiobuttonJulitest()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedRadiobuttonJulitest    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement RadiobuttonJulitestlink = page1Page.RadiobuttonJulitestButton();
	 	 	     try
	 	 	 //selectedRadiobuttonJulitest    
	 	 	     {
	 	 	        WebBrowserUtil.Click(RadiobuttonJulitestlink);
	 	 	 log.info("Method selectedRadiobuttonJulitest completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(RadiobuttonJulitestlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedRadiobuttonJulitest not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void enterSearchProject(String searchProject)
	 	 {
	 	 	 log.info("Method enterSearchProject completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 searchProject=CommonUtil.GetData(searchProject);
	 	 	 searchProject = DbHelper.textRandomCopiedNumber(searchProject);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.SearchProjectTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, searchProject);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,searchProject); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method enterSearchProject not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSearchProjectselect()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSearchProjectselect    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SearchProjectselectlink = page1Page.SearchProjectselectButton();
	 	 	     try
	 	 	 //selectedSearchProjectselect    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SearchProjectselectlink);
	 	 	 log.info("Method selectedSearchProjectselect completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SearchProjectselectlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSearchProjectselect not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSelectAccount()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSelectAccount    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SelectAccountlink = page1Page.SelectAccountButton();
	 	 	     try
	 	 	 //selectedSelectAccount    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SelectAccountlink);
	 	 	 log.info("Method selectedSelectAccount completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SelectAccountlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSelectAccount not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSelectClinicaltrial()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSelectClinicaltrial    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SelectClinicaltriallink = page1Page.SelectClinicaltrialButton();
	 	 	     try
	 	 	 //selectedSelectClinicaltrial    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SelectClinicaltriallink);
	 	 	 log.info("Method selectedSelectClinicaltrial completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SelectClinicaltriallink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSelectClinicaltrial not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSelectContact()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSelectContact    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SelectContactlink = page1Page.SelectContactButton();
	 	 	     try
	 	 	 //selectedSelectContact    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SelectContactlink);
	 	 	 log.info("Method selectedSelectContact completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SelectContactlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSelectContact not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSelectInternationalFreight()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSelectInternationalFreight    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SelectInternationalFreightlink = page1Page.SelectInternationalFreightButton();
	 	 	     try
	 	 	 //selectedSelectInternationalFreight    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SelectInternationalFreightlink);
	 	 	 log.info("Method selectedSelectInternationalFreight completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SelectInternationalFreightlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSelectInternationalFreight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedselectpickupaddressok()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedselectpickupaddressok    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement selectpickupaddressoklink = page1Page.selectpickupaddressokButton();
	 	 	     try
	 	 	 //selectedselectpickupaddressok    
	 	 	     {
	 	 	        WebBrowserUtil.Click(selectpickupaddressoklink);
	 	 	 log.info("Method selectedselectpickupaddressok completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(selectpickupaddressoklink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedselectpickupaddressok not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSelectProject()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSelectProject    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SelectProjectlink = page1Page.SelectProjectButton();
	 	 	     try
	 	 	 //selectedSelectProject    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SelectProjectlink);
	 	 	 log.info("Method selectedSelectProject completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SelectProjectlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSelectProject not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSelectServicetype()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSelectServicetype    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SelectServicetypelink = page1Page.SelectServicetypeButton();
	 	 	     try
	 	 	 //selectedSelectServicetype    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SelectServicetypelink);
	 	 	 log.info("Method selectedSelectServicetype completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SelectServicetypelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSelectServicetype not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedServicetype()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedServicetype    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Servicetypelink = page1Page.ServicetypeButton();
	 	 	     try
	 	 	 //selectedServicetype    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Servicetypelink);
	 	 	 log.info("Method selectedServicetype completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Servicetypelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedServicetype not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterShipfromcountry(String shipfromcountry)
	 	 {
	 	 	 log.info("Method EnterShipfromcountry completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 shipfromcountry=CommonUtil.GetData(shipfromcountry);
	 	 	 shipfromcountry = DbHelper.textRandomCopiedNumber(shipfromcountry);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.ShipfromcountryTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, shipfromcountry);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,shipfromcountry); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterShipfromcountry not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedShipfromcountryselect()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedShipfromcountryselect    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Shipfromcountryselectlink = page1Page.ShipfromcountryselectButton();
	 	 	     try
	 	 	 //selectedShipfromcountryselect    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Shipfromcountryselectlink);
	 	 	 log.info("Method selectedShipfromcountryselect completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Shipfromcountryselectlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedShipfromcountryselect not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedShipmentOrdersdropdown()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedShipmentOrdersdropdown    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement ShipmentOrdersdropdownlink = page1Page.ShipmentOrdersdropdownButton();
	 	 	     try
	 	 	 //selectedShipmentOrdersdropdown    
	 	 	     {
	 	 	        WebBrowserUtil.Click(ShipmentOrdersdropdownlink);
	 	 	 log.info("Method selectedShipmentOrdersdropdown completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(ShipmentOrdersdropdownlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedShipmentOrdersdropdown not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void copiedtextShipmentordersone()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 String copiedValue=WebBrowserUtil.GetText(page1Page.ShipmentordersoneLabel());
	 	 	if (copiedValue.contains("C:\\fakepath\\"))
	 	 	{
	 	 	Path p = Paths.get(copiedValue);
	 	 	copiedValue = p.getFileName().toString();
	 	 	}
	 	 	 CommonUtil.setCopiedText(copiedValue);
	 	 	 System.out.println(WebBrowserUtil.GetText(page1Page.ShipmentordersoneLabel()));
			  Reporter.addStepLog("Copied value: "+copiedValue);
	 	 	 log.info("Method copiedtextShipmentordersone completed.");
		 }

 	 	 public void selectedShipmentordersrefresh()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedShipmentordersrefresh    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Shipmentordersrefreshlink = page1Page.ShipmentordersrefreshButton();
	 	 	     try
	 	 	 //selectedShipmentordersrefresh    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Shipmentordersrefreshlink);
	 	 	 log.info("Method selectedShipmentordersrefresh completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Shipmentordersrefreshlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedShipmentordersrefresh not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterShipmentOrdersSearch(String shipmentOrdersSearch)
	 	 {
	 	 	 log.info("Method EnterShipmentOrdersSearch completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 shipmentOrdersSearch=CommonUtil.GetData(shipmentOrdersSearch);
	 	 	 shipmentOrdersSearch = DbHelper.textRandomCopiedNumber(shipmentOrdersSearch);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.ShipmentOrdersSearchTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, shipmentOrdersSearch);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,shipmentOrdersSearch); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterShipmentOrdersSearch not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void copiedtextShipmentordersthree()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 String copiedValue=WebBrowserUtil.GetText(page1Page.ShipmentordersthreeLabel());
	 	 	if (copiedValue.contains("C:\\fakepath\\"))
	 	 	{
	 	 	Path p = Paths.get(copiedValue);
	 	 	copiedValue = p.getFileName().toString();
	 	 	}
	 	 	 CommonUtil.setCopiedText(copiedValue);
	 	 	 System.out.println(WebBrowserUtil.GetText(page1Page.ShipmentordersthreeLabel()));
			  Reporter.addStepLog("Copied value: "+copiedValue);
	 	 	 log.info("Method copiedtextShipmentordersthree completed.");
		 }

 	 	 public void copiedtextShipmentorderstwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 String copiedValue=WebBrowserUtil.GetText(page1Page.ShipmentorderstwoLabel());
	 	 	if (copiedValue.contains("C:\\fakepath\\"))
	 	 	{
	 	 	Path p = Paths.get(copiedValue);
	 	 	copiedValue = p.getFileName().toString();
	 	 	}
	 	 	 CommonUtil.setCopiedText(copiedValue);
	 	 	 System.out.println(WebBrowserUtil.GetText(page1Page.ShipmentorderstwoLabel()));
			  Reporter.addStepLog("Copied value: "+copiedValue);
	 	 	 log.info("Method copiedtextShipmentorderstwo completed.");
		 }

 	 	 public void EnterShipmentValue(String shipmentValue)
	 	 {
	 	 	 log.info("Method EnterShipmentValue completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 shipmentValue=CommonUtil.GetData(shipmentValue);
	 	 	 shipmentValue = DbHelper.textRandomCopiedNumber(shipmentValue);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.ShipmentValueTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, shipmentValue);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,shipmentValue); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterShipmentValue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void ClearAndEnterTextForShipmentValuetwo(String shipmentValuetwo)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 shipmentValuetwo = CommonUtil.GetData(shipmentValuetwo);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForShipmentValuetwo completed.");
	 	 	 shipmentValuetwo=shipmentValuetwo.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.ShipmentValuetwoTextBox(),shipmentValuetwo); 
	 	 	 log.info("Method ClearAndEnterTextForShipmentValuetwo completed.");
		 }

 	 	 public void selectedShiptocountry()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedShiptocountry    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Shiptocountrylink = page1Page.ShiptocountryButton();
	 	 	     try
	 	 	 //selectedShiptocountry    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Shiptocountrylink);
	 	 	 log.info("Method selectedShiptocountry completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Shiptocountrylink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedShiptocountry not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void EnterShiptocountryTB(String shiptocountryTB)
	 	 {
	 	 	 log.info("Method EnterShiptocountryTB completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 shiptocountryTB=CommonUtil.GetData(shiptocountryTB);
	 	 	 shiptocountryTB = DbHelper.textRandomCopiedNumber(shiptocountryTB);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.ShiptocountryTBTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, shiptocountryTB);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,shiptocountryTB); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterShiptocountryTB not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public boolean VerifytextSOIDCopy()
	 	 {
	 	 	 boolean isVerified = false;
				 WebBrowser.setCurrentBrowser(0);
	 	 	 	 browser=WebBrowser.getBrowser();
	 	 	 	 int i = 0;
	 	 	 	 while (i < 5)
	 	 	 	 {
	 	 	 	 try
	 	 	 	  {
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 //	o get xpath of SOIDCopyLabelXpath";
	 	 	  	 String ID=YMLUtil.getYMLObjectRepositoryData("Page1.SOIDCopyLabelXpath"); 
	 	 	 	 	  WebElement SOIDCopyXpath  = WebBrowserUtil.getSingleElementByXpath(ID); 
	 	 	 	   // to check if SOIDCopyXpath is Displayed ; 
	 	 	 	     if(SOIDCopyXpath.isDisplayed())
	 	 	 	      {
	 	 	 	 	 isVerified=true;
	 	 	 	      }
	 	 	 	      if (isVerified)
	 	 	 	      {
	 	 	 	        break;
	 	 	 	      }
	 	 	 	      i++;
	 	 	 	  }
	 	 	 	  catch(Exception ex)
	 	 	 	  {
	 	 	 	 	 isVerified = false;
	 	 	 	 	 i++;
	 	 	 	  }
	 	 	 	}
	 	 	 //"Method VerifytextSOIDCopy is completed.";
	 	 	 log.info("Method VerifytextSOIDCopy completed.");
	 	 	 	 return isVerified;
		 }

 	 	 public void selectedSONew()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSONew    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SONewlink = page1Page.SONewButton();
	 	 	     try
	 	 	 //selectedSONew    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SONewlink);
	 	 	 log.info("Method selectedSONew completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SONewlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSONew not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTclientTypeofProduct()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTclientTypeofProduct    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTclientTypeofProductlink = page1Page.SOTclientTypeofProductButton();
	 	 	     try
	 	 	 //selectedSOTclientTypeofProduct    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTclientTypeofProductlink);
	 	 	 log.info("Method selectedSOTclientTypeofProduct completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTclientTypeofProductlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTclientTypeofProduct not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTclientTypeofProducttwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTclientTypeofProducttwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTclientTypeofProducttwolink = page1Page.SOTclientTypeofProducttwoButton();
	 	 	     try
	 	 	 //selectedSOTclientTypeofProducttwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTclientTypeofProducttwolink);
	 	 	 log.info("Method selectedSOTclientTypeofProducttwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTclientTypeofProducttwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTclientTypeofProducttwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTDoyoushipsecondhandorrefurbishedgoods()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTDoyoushipsecondhandorrefurbishedgoods    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTDoyoushipsecondhandorrefurbishedgoodslink = page1Page.SOTDoyoushipsecondhandorrefurbishedgoodsButton();
	 	 	     try
	 	 	 //selectedSOTDoyoushipsecondhandorrefurbishedgoods    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTDoyoushipsecondhandorrefurbishedgoodslink);
	 	 	 log.info("Method selectedSOTDoyoushipsecondhandorrefurbishedgoods completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTDoyoushipsecondhandorrefurbishedgoodslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTDoyoushipsecondhandorrefurbishedgoods not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTInvestigationalProducts()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTInvestigationalProducts    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTInvestigationalProductslink = page1Page.SOTInvestigationalProductsButton();
	 	 	     try
	 	 	 //selectedSOTInvestigationalProducts    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTInvestigationalProductslink);
	 	 	 log.info("Method selectedSOTInvestigationalProducts completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTInvestigationalProductslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTInvestigationalProducts not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTRefurbishedgoods()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTRefurbishedgoods    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTRefurbishedgoodslink = page1Page.SOTRefurbishedgoodsButton();
	 	 	     try
	 	 	 //selectedSOTRefurbishedgoods    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTRefurbishedgoodslink);
	 	 	 log.info("Method selectedSOTRefurbishedgoods completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTRefurbishedgoodslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTRefurbishedgoods not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void enterSOTShiptocountryCanada(String sOTShiptocountryCanada)
	 	 {
	 	 	 log.info("Method enterSOTShiptocountryCanada completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 sOTShiptocountryCanada=CommonUtil.GetData(sOTShiptocountryCanada);
	 	 	 sOTShiptocountryCanada = DbHelper.textRandomCopiedNumber(sOTShiptocountryCanada);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.SOTShiptocountryCanadaTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, sOTShiptocountryCanada);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,sOTShiptocountryCanada); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method enterSOTShiptocountryCanada not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTShiptocountryCanadavalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTShiptocountryCanadavalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTShiptocountryCanadavaluelink = page1Page.SOTShiptocountryCanadavalueButton();
	 	 	     try
	 	 	 //selectedSOTShiptocountryCanadavalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTShiptocountryCanadavaluelink);
	 	 	 log.info("Method selectedSOTShiptocountryCanadavalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTShiptocountryCanadavaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTShiptocountryCanadavalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void enterSOTShiptocountryUnitedArabEmirates(String sOTShiptocountryUnitedArabEmirates)
	 	 {
	 	 	 log.info("Method enterSOTShiptocountryUnitedArabEmirates completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 sOTShiptocountryUnitedArabEmirates=CommonUtil.GetData(sOTShiptocountryUnitedArabEmirates);
	 	 	 sOTShiptocountryUnitedArabEmirates = DbHelper.textRandomCopiedNumber(sOTShiptocountryUnitedArabEmirates);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = page1Page.SOTShiptocountryUnitedArabEmiratesTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, sOTShiptocountryUnitedArabEmirates);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,sOTShiptocountryUnitedArabEmirates); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method enterSOTShiptocountryUnitedArabEmirates not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTShiptocountryUnitedArabEmiratesvalue()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTShiptocountryUnitedArabEmiratesvalue    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTShiptocountryUnitedArabEmiratesvaluelink = page1Page.SOTShiptocountryUnitedArabEmiratesvalueButton();
	 	 	     try
	 	 	 //selectedSOTShiptocountryUnitedArabEmiratesvalue    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTShiptocountryUnitedArabEmiratesvaluelink);
	 	 	 log.info("Method selectedSOTShiptocountryUnitedArabEmiratesvalue completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTShiptocountryUnitedArabEmiratesvaluelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTShiptocountryUnitedArabEmiratesvalue not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTTechEquipment()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTTechEquipment    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTTechEquipmentlink = page1Page.SOTTechEquipmentButton();
	 	 	     try
	 	 	 //selectedSOTTechEquipment    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTTechEquipmentlink);
	 	 	 log.info("Method selectedSOTTechEquipment completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTTechEquipmentlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTTechEquipment not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTTemperatureControlRequirements()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTTemperatureControlRequirements    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTTemperatureControlRequirementslink = page1Page.SOTTemperatureControlRequirementsButton();
	 	 	     try
	 	 	 //selectedSOTTemperatureControlRequirements    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTTemperatureControlRequirementslink);
	 	 	 log.info("Method selectedSOTTemperatureControlRequirements completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTTemperatureControlRequirementslink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTTemperatureControlRequirements not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTTemperatureControlTransit()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTTemperatureControlTransit    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTTemperatureControlTransitlink = page1Page.SOTTemperatureControlTransitButton();
	 	 	     try
	 	 	 //selectedSOTTemperatureControlTransit    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTTemperatureControlTransitlink);
	 	 	 log.info("Method selectedSOTTemperatureControlTransit completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTTemperatureControlTransitlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTTemperatureControlTransit not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTTypeofProduct()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTTypeofProduct    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTTypeofProductlink = page1Page.SOTTypeofProductButton();
	 	 	     try
	 	 	 //selectedSOTTypeofProduct    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTTypeofProductlink);
	 	 	 log.info("Method selectedSOTTypeofProduct completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTTypeofProductlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTTypeofProduct not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTTypeofProducttwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTTypeofProducttwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTTypeofProducttwolink = page1Page.SOTTypeofProducttwoButton();
	 	 	     try
	 	 	 //selectedSOTTypeofProducttwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTTypeofProducttwolink);
	 	 	 log.info("Method selectedSOTTypeofProducttwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTTypeofProducttwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTTypeofProducttwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTWhoHandlesInternationalFreight()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTWhoHandlesInternationalFreight    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTWhoHandlesInternationalFreightlink = page1Page.SOTWhoHandlesInternationalFreightButton();
	 	 	     try
	 	 	 //selectedSOTWhoHandlesInternationalFreight    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTWhoHandlesInternationalFreightlink);
	 	 	 log.info("Method selectedSOTWhoHandlesInternationalFreight completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTWhoHandlesInternationalFreightlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTWhoHandlesInternationalFreight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedSOTWhoHandlesInternationalFreighttwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedSOTWhoHandlesInternationalFreighttwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement SOTWhoHandlesInternationalFreighttwolink = page1Page.SOTWhoHandlesInternationalFreighttwoButton();
	 	 	     try
	 	 	 //selectedSOTWhoHandlesInternationalFreighttwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(SOTWhoHandlesInternationalFreighttwolink);
	 	 	 log.info("Method selectedSOTWhoHandlesInternationalFreighttwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(SOTWhoHandlesInternationalFreighttwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedSOTWhoHandlesInternationalFreighttwo not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedTechequipment()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedTechequipment    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Techequipmentlink = page1Page.TechequipmentButton();
	 	 	     try
	 	 	 //selectedTechequipment    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Techequipmentlink);
	 	 	 log.info("Method selectedTechequipment completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Techequipmentlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedTechequipment not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedThisaClinicalTrial()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedThisaClinicalTrial    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement ThisaClinicalTriallink = page1Page.ThisaClinicalTrialButton();
	 	 	     try
	 	 	 //selectedThisaClinicalTrial    
	 	 	     {
	 	 	        WebBrowserUtil.Click(ThisaClinicalTriallink);
	 	 	 log.info("Method selectedThisaClinicalTrial completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(ThisaClinicalTriallink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedThisaClinicalTrial not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedTogglebuttonshipmentinInternationalfreight()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedTogglebuttonshipmentinInternationalfreight    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement TogglebuttonshipmentinInternationalfreightlink = page1Page.TogglebuttonshipmentinInternationalfreightButton();
	 	 	     try
	 	 	 //selectedTogglebuttonshipmentinInternationalfreight    
	 	 	     {
	 	 	        WebBrowserUtil.Click(TogglebuttonshipmentinInternationalfreightlink);
	 	 	 log.info("Method selectedTogglebuttonshipmentinInternationalfreight completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(TogglebuttonshipmentinInternationalfreightlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedTogglebuttonshipmentinInternationalfreight not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedTogglebuttonshipmentinServicetype()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedTogglebuttonshipmentinServicetype    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement TogglebuttonshipmentinServicetypelink = page1Page.TogglebuttonshipmentinServicetypeButton();
	 	 	     try
	 	 	 //selectedTogglebuttonshipmentinServicetype    
	 	 	     {
	 	 	        WebBrowserUtil.Click(TogglebuttonshipmentinServicetypelink);
	 	 	 log.info("Method selectedTogglebuttonshipmentinServicetype completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(TogglebuttonshipmentinServicetypelink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedTogglebuttonshipmentinServicetype not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedTogglebuttonshipmentinShipfromcountry()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedTogglebuttonshipmentinShipfromcountry    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement TogglebuttonshipmentinShipfromcountrylink = page1Page.TogglebuttonshipmentinShipfromcountryButton();
	 	 	     try
	 	 	 //selectedTogglebuttonshipmentinShipfromcountry    
	 	 	     {
	 	 	        WebBrowserUtil.Click(TogglebuttonshipmentinShipfromcountrylink);
	 	 	 log.info("Method selectedTogglebuttonshipmentinShipfromcountry completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(TogglebuttonshipmentinShipfromcountrylink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedTogglebuttonshipmentinShipfromcountry not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedTypeofProduct()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedTypeofProduct    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement TypeofProductlink = page1Page.TypeofProductButton();
	 	 	     try
	 	 	 //selectedTypeofProduct    
	 	 	     {
	 	 	        WebBrowserUtil.Click(TypeofProductlink);
	 	 	 log.info("Method selectedTypeofProduct completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(TypeofProductlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedTypeofProduct not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedUnitsOfMeasurement()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedUnitsOfMeasurement    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement UnitsOfMeasurementlink = page1Page.UnitsOfMeasurementButton();
	 	 	     try
	 	 	 //selectedUnitsOfMeasurement    
	 	 	     {
	 	 	        WebBrowserUtil.Click(UnitsOfMeasurementlink);
	 	 	 log.info("Method selectedUnitsOfMeasurement completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(UnitsOfMeasurementlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedUnitsOfMeasurement not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void ClearAndEnterTextForVendorReference(String vendorReference)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 vendorReference = CommonUtil.GetData(vendorReference);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForVendorReference completed.");
	 	 	 vendorReference=vendorReference.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.VendorReferenceTextBox(),vendorReference); 
	 	 	 log.info("Method ClearAndEnterTextForVendorReference completed.");
		 }

 	 	 public void ClearAndEnterTextForVendorReferencetwo(String vendorReferencetwo)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 vendorReferencetwo = CommonUtil.GetData(vendorReferencetwo);
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
	 	 	 log.info("Method ClearAndEnterTextForVendorReferencetwo completed.");
	 	 	 vendorReferencetwo=vendorReferencetwo.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(page1Page.VendorReferencetwoTextBox(),vendorReferencetwo); 
	 	 	 log.info("Method ClearAndEnterTextForVendorReferencetwo completed.");
		 }

 	 	 public void WaitTextBoxWaitinSeconds(String time)
	 	 {
	 	  try{
	 	  time = CommonUtil.GetData(time);
	 	 	 int waitTime=Integer.parseInt(time);
	 	 	 Thread.sleep((1000)*waitTime);
	 	 	 }
	 	 	 catch(Exception ex)
	 	 	  {
	 	 	  }
	 	 	 log.info("Method WaitTextBoxWaitinSeconds completed.");
		 }

 	 	 public void selectedYesAddtoexistingproject()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedYesAddtoexistingproject    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement YesAddtoexistingprojectlink = page1Page.YesAddtoexistingprojectButton();
	 	 	     try
	 	 	 //selectedYesAddtoexistingproject    
	 	 	     {
	 	 	        WebBrowserUtil.Click(YesAddtoexistingprojectlink);
	 	 	 log.info("Method selectedYesAddtoexistingproject completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(YesAddtoexistingprojectlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedYesAddtoexistingproject not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }

 	 	 public void selectedYesnewproject()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 Page1Page page1Page=new Page1Page(WebBrowserUtil.AttachPage("Page1"));
try
{
	 	 	 //selectedYesnewproject    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement Yesnewprojectlink = page1Page.YesnewprojectButton();
	 	 	     try
	 	 	 //selectedYesnewproject    
	 	 	     {
	 	 	        WebBrowserUtil.Click(Yesnewprojectlink);
	 	 	 log.info("Method selectedYesnewproject completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(Yesnewprojectlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedYesnewproject not completed."+ex);
	 	 	             throw new CustomException(ex.getMessage(),ex);
	 	 	         }
	 	 	     }
	 	 	 }

}
catch(Exception e)
{
throw new CustomException(e.getMessage(), e);
}
		 }
	}
