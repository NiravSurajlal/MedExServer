package stepdefinitions;
import common.WebBrowser;
import common.WebBrowserUtil;
import common.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import workflows.TecExMedicalWorkFlow;
import org.junit.Assert;
	 public class TecExMedicalStepDefinition
	{
		  

 		 @Given("^I have access to TecEx Medical application$")
	 	 public void GivenIhaveaccesstoTecExMedicalapplication()
	 	 {
			TecExMedicalWorkFlow tecExMedicalWorkFlow = new TecExMedicalWorkFlow();
			tecExMedicalWorkFlow.accessToPage();
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Username in salesforce login as '(.*)'$")
	 	 public void WhenIEnteredUsernameinsalesforceloginasUsername(String username)
	 	 {
			TecExMedicalWorkFlow tecExMedicalWorkFlow = new TecExMedicalWorkFlow();
			tecExMedicalWorkFlow.EnterUsername(username);
		 WebBrowserUtil.takescrenshot();
		 }
 

 		 @When("^I Entered Password in salesforce login as '(.*)'$")
	 	 public void WhenIEnteredPasswordinsalesforceloginasPassword(String password)
	 	 {
			TecExMedicalWorkFlow tecExMedicalWorkFlow = new TecExMedicalWorkFlow();
			tecExMedicalWorkFlow.EnterPassword(password);
		 WebBrowserUtil.takescrenshot();
		 }
 
	}
