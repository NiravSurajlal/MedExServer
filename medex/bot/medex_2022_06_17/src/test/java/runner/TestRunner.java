package runner;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import common.WebBrowser;
import org.junit.BeforeClass;
import com.cucumber.listener.ExtentProperties;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.RetryAcceptance;




@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        //jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        //jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target/cucumber-reports/extended-report")
@CucumberOptions(
		features = "src/test/java/features",
		glue= {"stepdefinitions","common"},
		//plugin = {"pretty", "html:out"}
		plugin = {"ru.yandex.qatools.allure.cucumberjvm.AllureReporter","com.cucumber.listener.ExtentCucumberFormatter:"}
        //features={"."}
		)
public class TestRunner {
	public static int retries = 0;
	@AfterClass
    public static void tearDown(){
		if (WebBrowser.isBrowserOpened())
        {           
            WebBrowser.closeBrowserInstance();
        }
    }
	
	
	
}
