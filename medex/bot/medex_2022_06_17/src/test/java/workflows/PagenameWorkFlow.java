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
import pages.PagenamePage;
import common. customUtil;
public class PagenameWorkFlow
{
	public static WebDriver browser;
	final static Logger log = Logger.getLogger(PagenameWorkFlow.class);

 	 	 public void ClearAndEnterTextForClientreferencethree(String clientreferencethree)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 clientreferencethree = CommonUtil.GetData(clientreferencethree);
	 	 	 PagenamePage pagenamePage=new PagenamePage(WebBrowserUtil.AttachPage("Page name"));
	 	 	 log.info("Method ClearAndEnterTextForClientreferencethree completed.");
	 	 	 clientreferencethree=clientreferencethree.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(pagenamePage.ClientreferencethreeTextBox(),clientreferencethree); 
	 	 	 log.info("Method ClearAndEnterTextForClientreferencethree completed.");
		 }

 	 	 public void ClearAndEnterTextForEstimatedChargeableweightthree(String estimatedChargeableweightthree)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 estimatedChargeableweightthree = CommonUtil.GetData(estimatedChargeableweightthree);
	 	 	 PagenamePage pagenamePage=new PagenamePage(WebBrowserUtil.AttachPage("Page name"));
	 	 	 log.info("Method ClearAndEnterTextForEstimatedChargeableweightthree completed.");
	 	 	 estimatedChargeableweightthree=estimatedChargeableweightthree.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(pagenamePage.EstimatedChargeableweightthreeTextBox(),estimatedChargeableweightthree); 
	 	 	 log.info("Method ClearAndEnterTextForEstimatedChargeableweightthree completed.");
		 }

 	 	 public void selectedNSTecexHandlestwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 PagenamePage pagenamePage=new PagenamePage(WebBrowserUtil.AttachPage("Page name"));
try
{
	 	 	 //selectedNSTecexHandlestwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTecexHandlestwolink = pagenamePage.NSTecexHandlestwoButton();
	 	 	     try
	 	 	 //selectedNSTecexHandlestwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTecexHandlestwolink);
	 	 	 log.info("Method selectedNSTecexHandlestwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTecexHandlestwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTecexHandlestwo not completed."+ex);
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

 	 	 public void selectedNSTypeofProductTechEquipmenttwo()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 PagenamePage pagenamePage=new PagenamePage(WebBrowserUtil.AttachPage("Page name"));
try
{
	 	 	 //selectedNSTypeofProductTechEquipmenttwo    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement NSTypeofProductTechEquipmenttwolink = pagenamePage.NSTypeofProductTechEquipmenttwoButton();
	 	 	     try
	 	 	 //selectedNSTypeofProductTechEquipmenttwo    
	 	 	     {
	 	 	        WebBrowserUtil.Click(NSTypeofProductTechEquipmenttwolink);
	 	 	 log.info("Method selectedNSTypeofProductTechEquipmenttwo completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(NSTypeofProductTechEquipmenttwolink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedNSTypeofProductTechEquipmenttwo not completed."+ex);
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

 	 	 public void selectedPDAddPackageinsecondRow()
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 PagenamePage pagenamePage=new PagenamePage(WebBrowserUtil.AttachPage("Page name"));
try
{
	 	 	 //selectedPDAddPackageinsecondRow    
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	     WebElement PDAddPackageinsecondRowlink = pagenamePage.PDAddPackageinsecondRowButton();
	 	 	     try
	 	 	 //selectedPDAddPackageinsecondRow    
	 	 	     {
	 	 	        WebBrowserUtil.Click(PDAddPackageinsecondRowlink);
	 	 	 log.info("Method selectedPDAddPackageinsecondRow completed.");
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	          WebBrowserUtil.ScrollAndClickUsingJS(PDAddPackageinsecondRowlink);
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch(Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method selectedPDAddPackageinsecondRow not completed."+ex);
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

 	 	 public void ClearAndEnterTextForShipmentValuethree(String shipmentValuethree)
	 	 {
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 shipmentValuethree = CommonUtil.GetData(shipmentValuethree);
	 	 	 PagenamePage pagenamePage=new PagenamePage(WebBrowserUtil.AttachPage("Page name"));
	 	 	 log.info("Method ClearAndEnterTextForShipmentValuethree completed.");
	 	 	 shipmentValuethree=shipmentValuethree.replace("_space_"," ");
	 	 	 WebBrowserUtil.ClearAndEnterText(pagenamePage.ShipmentValuethreeTextBox(),shipmentValuethree); 
	 	 	 log.info("Method ClearAndEnterTextForShipmentValuethree completed.");
		 }
	}
