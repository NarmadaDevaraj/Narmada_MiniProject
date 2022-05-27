package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports/report.html","json:target/cucumber-reports/report.json"},
monochrome=true,
features = "src/test/resources/Feature",
glue ={"StepDefinitions"},
dryRun=false
)
public class Runner extends AbstractTestNGCucumberTests{
	
		
}
