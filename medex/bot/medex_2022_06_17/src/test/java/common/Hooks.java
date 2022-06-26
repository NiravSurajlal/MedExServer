package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import org.testng.asserts.SoftAssert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import common.CommonUtil;

public class Hooks {
	public WebDriver driver;
final static Logger log = Logger.getLogger(Hooks.class);
	public static boolean closeBrowser=true;
	public static SoftAssert softAssertions=new SoftAssert();
	public static List<String> tagsExecuted=new ArrayList<String>();
	public static int passCount=0;
    public static int failCount=0;
    public static int skipCount=0;

	@Before
	
	public void init() {
		log.info("*********************************Execution started*******************************");
		String node=System.getProperty("Node");
		if(node == null || node.isEmpty())
		{
			node="Node1";
		}
		String url=System.getProperty("Url");
		System.out.println("Url-----------"+url);
		if(url != null && !url.isEmpty())
		{
		CommonUtil.appUrl=url;
		}
		String apiurl=System.getProperty("apiUrl");
		System.out.println("apiurl-----------"+apiurl);
		if(apiurl != null && !apiurl.isEmpty())
		{
		CommonUtil.apiCmdUrl=apiurl;
		}
		String browserName=System.getProperty("browserName");
		System.out.println("browserName-----------"+browserName);
		if(browserName != null && !browserName.isEmpty())
		{
		CommonUtil.browserName=browserName;
		}
		
		String environmentType=System.getProperty("environmentType");		
		String path = System.getProperty("user.dir");
		if(environmentType == null || environmentType.isEmpty())
		{		
		environmentType= CommonUtil.GetXMLData(
				Paths.get(path.toString(), "src", "test", "java", "ApplicationSettings.xml").toString(),
				"EnvironmentType");	
		}
		System.out.println("Environment Type is-----------"+environmentType);
		
		CommonUtil.setApplicationType(environmentType);
		
		
		
		
		
		
		
		//JSONUtil.loadJSON("src/test/java/"+jsonPath);		
		YMLUtil.loadYML("src/test/java/TestData.yml", node);
		YMLUtil.loadObjectRepoYML("src/test/java/ObjectRepository.yml");
		YMLUtil.PayloadYML("src/test/java/Payload.yml", node);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 Reporter.addScenarioLog("Start Time : "+timestamp);
		//extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html", true);
	}
	
	//Method to wait for 2 minutes before executing the test case
	//This method is used to handle LRS execution so that execution will happen without locking the user to Login 
	@Before("@waitinminutes")
	public void beforeScenario()throws Throwable {
		log.info("*********************************Scenario started*******************************");
		
		Thread.sleep(120000);
		CommonUtil.setCopiedCount(0);
	}
	
	@Before(order = 1)
	public void beforeScenario(Scenario scenario) {
		
		for(String tag : scenario.getSourceTagNames())
		{
			closeBrowser=true;
			if (tag.toUpperCase().startsWith("@C"))
			{			
				CommonUtil.setTestRailID(tag.replace("@", ""));
				break;
			}
		}	
		
	}
	
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		log.info("*********************************Scenario ended*******************************");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 Reporter.addScenarioLog("End Time: "+timestamp);
		CommonUtil.setCopiedCount(0);
		CommonUtil.setCopiedCountTextNull();
		softAssertions=new SoftAssert();
		boolean semiAuto=false;
		
		if(scenario.getStatus().equalsIgnoreCase("skipped")) {
			skipCount++;
		}
		
		if (scenario.isFailed()||(scenario.getStatus()=="passed")) {
			
			if(scenario.getStatus().equalsIgnoreCase("passed")) {
				passCount++;
			} else if(scenario.getStatus().equalsIgnoreCase("failed")) {
				failCount++;
			}
						
			String screenshotName = "Image_"+new Date().getTime();
			boolean flag=true;
			try {
				for(String tag : scenario.getSourceTagNames())
				{
					tagsExecuted.add(tag);
					if(tag.contains("api"))
					{
						flag=false;
						break;
					}
				}
				if(flag)
				{
					driver = WebBrowser.getBrowser();
				}
				//This takes a screenshot from the driver at save it to the specified location
				String dest = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				//File destinationPath = new File(System.getProperty("user.dir") + "/output/" + screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				//Files.copy(sourcePath, destinationPath);   

				//This attach the specified screenshot to the test
				//Reporter.addScreenCaptureFromPath(destinationPath.toString());
				Reporter.addScreenCaptureFromPath("data:image/jpg;base64, " + dest);
			} catch (IOException e) {
			} 
		}
		for(String tag : scenario.getSourceTagNames())
		{
			closeBrowser=true;
			if (tag.contains("usesamesession"))
			{
				closeBrowser=false;
				break;
			}
		}
		for(String tag : scenario.getSourceTagNames())
		{
			if (tag.contains("set2") || tag.contains("semiauto") || tag.contains("set3") || tag.contains("set21") || tag.contains("set22") || tag.contains("set23"))
            {
				if(closeBrowser)
				{
				WebBrowser.closeBrowserInstance();
				}
            }
            if (tag.contains("semiauto"))
            {
                semiAuto = true;
            }
            if (scenario.isFailed() && semiAuto)
            {
                semiAuto = false;
                throw new CustomException("Semi Auto test cases may fail due to OTP / Captcha.");
            }			
		}
		
	}

	@After(order = 0)
	public void closeBrowser() {
		log.info("*********************************Execution ended*******************************");
		System.out.println("------------------------------");
		System.out.println(" Status - ");
		System.out.println("------------------------------");
		if (WebBrowser.isBrowserOpened() && closeBrowser)
        {           
            WebBrowser.closeBrowserInstance();
        }	
		String abc=System.getProperty("user.dir");
		 File dir = new File(abc+"//output//");
		    File[] files = dir.listFiles();
		    File lastModified = Arrays.stream(files).filter(File::isDirectory).max(Comparator.comparing(File::lastModified)).orElse(null);
		    System.out.println(lastModified);
		   
		      try {
				   
		    	  int totalCount = passCount+failCount+skipCount;
					String json = "{\"TotalTest\":"+String.valueOf(totalCount)+","+"\"passed\":"+passCount+","+"\"failed\":"+failCount+","+"\"skipped\":"+skipCount+"}";			    	
					String path= lastModified+"//Execution_status.json";
					System.out.println("PATH :"+path);
					BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
					writer.write(json);
					writer.close();		    	  
		    	  FileWriter myWriter = new FileWriter(lastModified+"//ExexutedTagDetails.txt");
		    	  Set<String> uniqueTag = new HashSet<String>(tagsExecuted);
				String test="";
				String set="";
				String otherTags="";
				for (String tag : uniqueTag) {
					if(tag.contains("@test"))
					{
						test+= test=="" ? tag: ","+tag;
						
					}
					else if(tag.contains("@set"))
					{
						set+= set=="" ? tag: ","+tag;
						
					}
					else
					{
						otherTags+= otherTags=="" ? tag: ","+tag;
						
					}
				}
				
				myWriter.write("Test Tags:\n");
				myWriter.write(test+"\n\n");
				myWriter.write("Set Tags:\n");
				myWriter.write(set+"\n\n");
				myWriter.write("Other Tags:\n");
				myWriter.write(otherTags+"\n");
				 myWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
	}
	
}
