package TestRunner;

import org.testng.annotations.Listeners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports/report.html","json:target/cucumber-reports/report.json"},
//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome=true,
//features = "src/test/resources/Feature",
//features = {"src/test/resources/Feature/Login.feature","src/test/resources/Feature/TransferFund.feature"},
features = "src/test/resources/Feature/Login.feature",
glue ={"StepDefinitions"},
dryRun=false
)

@Listeners({ExtentITestListenerClassAdapter.class})
public class Runner extends AbstractTestNGCucumberTests {
	
		
}
