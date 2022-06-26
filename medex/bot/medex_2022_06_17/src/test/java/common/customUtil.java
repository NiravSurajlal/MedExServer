package common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.io.FileOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import com.cucumber.listener.Reporter;
import com.google.inject.Key;
import java.util.Base64;
import java.io.OutputStream;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import common.YMLUtil;
import pages.Page1Page;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class customUtil {
	static WebDriver driver;

	public boolean verifyValuePresentInOneOfTheRowValues(String param) {
		boolean isVerified = true;
		driver = WebBrowser.getBrowser();
		param = CommonUtil.GetData(param);
		List<WebElement> rows = driver.findElements(By.xpath(YMLUtil.getYMLObjectRepositoryData("RowsXpath")));
		for (int i = 1; i <= rows.size(); i++) {
			boolean valueIsPresent = false;
			List<WebElement> rowEle = driver.findElements(By.xpath(YMLUtil.getYMLObjectRepositoryData("RowsEleXpath")));
			for (int k = 0; k < rowEle.size(); k++) {
				String text = WebBrowserUtil.GetText(rowEle.get(k));
				if (text.contains(param)) {
					valueIsPresent = true;
					Reporter.addStepLog(text + " contains : " + param);
					break;
				}
			}
			if (valueIsPresent == false) {
				Reporter.addStepLog("Row index : " + i + " does not contains : " + param);
				isVerified = false;
				break;
			}
		}
		return isVerified;
	}

	public void Login() {
		try {
			WebBrowser.setCurrentBrowser(0);
			WebDriver browser = WebBrowser.getBrowser();
			
			WebElement usernameElemnt = WebBrowserUtil
					.findElement(YMLUtil.getYMLObjectRepositoryData("UsernameTextBoxXpath"), "Xpath");
			String username ="";
			if (CommonUtil.getApplicationType().toUpperCase().contains("STAGING")) {
			// Enter Username			
			username = CommonUtil.GetData("TecExUsername");			
			}
			else
			{
				username = CommonUtil.GetData("TecExProductionUsername");	
			}
			WebBrowserUtil.EnterText(usernameElemnt, username);

			// Enter password
			WebElement passwordElemnt = WebBrowserUtil
					.findElement(YMLUtil.getYMLObjectRepositoryData("PasswordTextBoxXpath"), "Xpath");
			String password = CommonUtil.GetData("TecExPassword");
			WebBrowserUtil.EnterText(passwordElemnt, password);

			// Click on Login button
			WebElement loginElemnt = WebBrowserUtil
					.findElement(YMLUtil.getYMLObjectRepositoryData("LoginButtonXpath"), "Xpath");
			WebBrowserUtil.ScrollAndClickUsingJS(loginElemnt);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}
	
	
	
	public static void addLineItems(String lineItems) {
		WebBrowser.setCurrentBrowser(0);
		WebDriver browser = WebBrowser.getBrowser();
		String XPath = YMLUtil.getYMLObjectRepositoryData("LineItemsTableTDXPath");
		try {
			Thread.sleep(16000);			
			String lineItemsData="";
			lineItems =CommonUtil.GetData(lineItems);
			String[] data=lineItems.split(",");
			
			if (lineItems != null && !lineItems.trim().isEmpty()) {
				//WebBrowserUtil.Click(browser.findElement(By.xpath(XPath)));
				Thread.sleep(5000);
				WebElement cellxpath = WebBrowserUtil.getSingleElementByXpath(XPath);
				cellxpath.click();
				Thread.sleep(1000);	
				
				Actions actions = new Actions(driver);
				for(int i=1;i<=data.length;i++)
				{				
					 actions.sendKeys(data[i-1]);
					 actions.sendKeys("	");
					 actions.build().perform();
					 Reporter.addStepLog(data[i-1]);
				}
				actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
				actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
				WebBrowserUtil.Click(browser.findElement(By.xpath(XPath)));
				actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				Thread.sleep(2000);				
				
			} else {
				Thread.sleep(2000);				
			}

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}
	
	public static void addHeaders(String lineItems) {
		WebBrowser.setCurrentBrowser(0);
		driver = WebBrowser.getBrowser();
		Actions actions = new Actions(driver);
		//String XPath = YMLUtil.getYMLObjectRepositoryData("LineItemsTableTDXPath");
		try {
			//	Thread.sleep(16000);			
			String lineItemsData="";
			lineItems =CommonUtil.GetData(lineItems);
			String[] data=lineItems.split(",");			
			if (lineItems != null && !lineItems.trim().isEmpty()) {
				//WebBrowserUtil.Click(driver.findElement(By.xpath(XPath)));
				//WebDriverWait wait = new WebDriverWait(driver, 5);
				//WebElement ele= wait.until(ExpectedConditions.elementToBeClickable
				//(By.xpath("//table[@class='slds-m-top_small slds-table slds-table_cell-buffer catTableData']//tr//td")));
				//ele.click();
				//lineItemsData ="Product Code	Description	Quantity	Unit Price\r\n" + 
				//	"PowerEdge R720xd	PowerEdgeR720xd	10	50";
				//StringSelection stringSelection = new StringSelection(lineItemsData);
				//Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				//clipboard.setContents(stringSelection, null);
				//Thread.sleep(1000);
				// WebElement element = driver.findElement(By.xpath(XPath));
				//element.sendKeys(Keys.CONTROL + "v");
				//actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

				WebElement fromElementPr = driver.findElement(By.xpath("//div[contains(@class,'available')]//div[contains(text(),'Product Code')]"));
				WebElement toElementPr = driver.findElement(By.xpath("//table[@class='slds-m-top_small slds-table slds-table_cell-buffer catTableData']//tr//td[1]//div[contains(@class,'dropabbleDiv')]"));

				WebElement a = fromElementPr;
				WebElement b = toElementPr;

				int x = b.getLocation().x;
				int y = b.getLocation().y;

				//Actions actions = new Actions(driver);
				actions.moveToElement(a)
				.pause(Duration.ofSeconds(1))
				.clickAndHold(a)
				.pause(Duration.ofSeconds(1))
				.moveByOffset(x, y)
				.moveToElement(b)
				.moveByOffset(x,y)
				.pause(Duration.ofSeconds(1))
				.release().build().perform();
				Thread.sleep(2000);


				WebBrowserUtil.DragAndDropHorizontally(fromElementPr,toElementPr);
				Thread.sleep(1000);	
				//if(Xpathtwo.isDisplayed())
				//{
				//Actions actions = new Actions(driver);
				//for(int i=1;i<=data.length;i++)
				//{				
				//actions.sendKeys(data[i-1]);
				//actions.sendKeys("	");
				// actions.build().perform();
				//Reporter.addStepLog(data[i-1]);
				//}

				//actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
				//actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
				//WebBrowserUtil.Click(driver.findElement(By.xpath(XPath)));
				//actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				//Thread.sleep(2000);
				//}
				//} else {
				//	Thread.sleep(2000);				
				//}
			}
		}
		catch (Exception e) {
				throw new CustomException(e.getMessage(), e);
			}
		}
	
	public static void CopyExcelData(String data) {
		WebBrowser.setCurrentBrowser(0);
		driver = WebBrowser.getBrowser();
		 data = "";
		Object value = "";
		try {
			String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\attachments\\MedEx line items.xlsx";//filename
			//String filePath = "C:\\TechEx\\Line Items for Testing.xlsx"; // filepath
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1"); // sheet name
			FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
			for (Row row : sheet)
			// iteration over row using for each loop
			{
				for (Cell cell : row) // iteration over cell using for each loop
				{
					value = cell.getStringCellValue();
						data = data + value + ",";
						System.out.print(value + "\t\t\t");
				        System.out.print(" | ");
				}
				System.out.println();
			}
			if (data.endsWith(",")) {
				  data = data.substring(0, data.length() - 1);
				}
			System.out.println("data:" + data);
			addLineItems(data);
		}
		catch (Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}
	
    public static void addMultipleLineItems(String lineItems) {
		WebBrowser.setCurrentBrowser(0);
		driver  = WebBrowser.getBrowser();
		String XPath = YMLUtil.getYMLObjectRepositoryData("LineItemsTableTDXPath");
		try {
			Thread.sleep(16000);			
			String lineItemsData="";
			lineItems =CommonUtil.GetData(lineItems);
			String[] data=lineItems.split(",");
			
			if (lineItems != null && !lineItems.trim().isEmpty()) {
				WebBrowserUtil.Click(driver.findElement(By.xpath(XPath)));				
				Thread.sleep(1000);	
				
				Actions actions = new Actions(driver);
				for(int i=1;i<=data.length;i++)
				{				
					 actions.sendKeys(data[i-1]);
					 actions.sendKeys("	");
					 actions.build().perform();
					 Reporter.addStepLog(data[i-1]);
				}
				
				actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
				actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
				WebBrowserUtil.Click(driver.findElement(By.xpath(XPath)));
				actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				Thread.sleep(2000);				
			
			} else {
				Thread.sleep(2000);				
			}

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}
		
	public boolean verifyfiledownloaded(String filePath)
	 	 {
 	 		try {
 		 	   filePath = CommonUtil.GetData(filePath);
 		 	   CommonUtil commonUtil = new CommonUtil();
 		 	   System.out.println("\n");
 		 	   System.out.println("Inside verify download #####");
 		 	 String text=  ((JavascriptExecutor) driver).executeScript("lambda-file-list=Cost Estimate No").toString();
 		 	 System.out.println("text: "+text);
 		 	 if(text.equals(null) || text.equals("")) {
 		 		 return false;
 		 	 }
 		 	 else {
 		 		 Reporter.addStepLog("Downloaded filename is: "+text);
 		 		 return true;
 		 	 }
 	 	 		 }
 	 	 		 catch(Exception e) {
 	 	 			 System.out.println(e.getMessage());
 	 	 			 return false;
 	 	 		 }
		 }

	
	
}