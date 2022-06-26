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
import pages.TecExMedicalPage;
import common. customUtil;
public class TecExMedicalWorkFlow
{
	public static WebDriver browser;
	final static Logger log = Logger.getLogger(TecExMedicalWorkFlow.class);

 	 	 public void accessToPage()
	 	 {
	 	 	 WebBrowser.LaunchApplication(true);
	 	 	 log.info("Method accessToPage() completed.");
		 }

 	 	 public void EnterPassword(String password)
	 	 {
	 	 	 log.info("Method EnterPassword completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 TecExMedicalPage tecExMedicalPage=new TecExMedicalPage(WebBrowserUtil.AttachPage("TecEx Medical"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 password=CommonUtil.GetData(password);
	 	 	 password = DbHelper.textRandomCopiedNumber(password);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = tecExMedicalPage.PasswordTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, password);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,password); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterPassword not completed."+ex);
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

 	 	 public void EnterUsername(String username)
	 	 {
	 	 	 log.info("Method EnterUsername completed.");
				 WebBrowser.setCurrentBrowser(0);
	 	 	 browser=WebBrowser.getBrowser();
	 	 	 TecExMedicalPage tecExMedicalPage=new TecExMedicalPage(WebBrowserUtil.AttachPage("TecEx Medical"));
try
{
	 	 	 boolean staleElement = true;
	 	 	 int i = 0;
	 	 	 username=CommonUtil.GetData(username);
	 	 	 username = DbHelper.textRandomCopiedNumber(username);
	 	 	 while (staleElement && i < 5)
	 	 	 {
	 	 	 WebElement element = tecExMedicalPage.UsernameTextBox();
	 	 	     try
	 	 	     {
	 	 	 WebBrowserUtil.EnterText(element, username);
	 	 	         staleElement = false;
	 	 	     }
	 	 	     catch (Exception ex)
	 	 	     {
	 	 	        i++;
	 	 	        staleElement = true;
	 	 	        try
	 	 	        {
	 	 	         WebBrowserUtil.ScrollAndEnterText(element,username); 
	 	 	          staleElement = false;
	 	 	        }
	 	 	        catch (Exception exc)
	 	 	        {
	 	 	        }
	 	 	        if (i == 4)
	 	 	        {
	 	 	 log.error("Method EnterUsername not completed."+ex);
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
