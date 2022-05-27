package StepDefinitions;

import Utility.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static String scenarioName=null;
	
	@Before
	public void setUp(Scenario scenario)
	{
		DriverManager.setupDriver();
		
		scenarioName=scenario.getName();
		System.out.println("scenarioName="+scenarioName);
	}
	
	@After
	public void quitBrowser()
	{
		DriverManager.tearDown();
	}
	
	public static String getScenarioName()
	{
		return scenarioName;
		
	}
}
