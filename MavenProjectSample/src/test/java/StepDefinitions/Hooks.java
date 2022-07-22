package StepDefinitions;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.DriverManager;
import Utility.ExtentReportConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends ExtentReportConfiguration {
	
	public static String scenarioName=null;
	
	@Before
	public void setUp(Scenario scenario)
	{
		scenarioName=scenario.getName();
		System.out.println("scenarioName="+scenarioName);
		
		//ExtentReportConfiguration.setupReport();
		//reportConfig();
		DriverManager.setupDriver();
		
	
	}
	
	@After
	public void quitBrowser()
	{
		DriverManager.tearDown();
		//report.flush();
		ExtentReportConfiguration.afterConfig();
		System.out.println("After method is executing");
		
	}
	
	public static String getScenarioName()
	{
		return scenarioName;
	}

}
