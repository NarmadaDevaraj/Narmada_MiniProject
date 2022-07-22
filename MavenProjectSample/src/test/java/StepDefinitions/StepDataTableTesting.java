package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.LoginPage;
import PageObjects.ParaBankAccountOverview;
import Utility.DriverManager;
import Utility.ExtentReportConfiguration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class StepDataTableTesting extends ExtentReportConfiguration {

		WebDriver driver=DriverManager.getDriver(); 
		public ParaBankAccountOverview accountoverview;
		LoginPage loginpage=new LoginPage(driver);
		ExtentReports report=ExtentReportConfiguration.getReport();
		
		//public ExtentTest extentLog=Hooks.getLog();
		
		
		@When("User enters UserName and Password")
		public void user_enters_user_name_and_password(DataTable dataTable)
		{
			
			List<Map<String, String>> loginDetails = dataTable.asMaps(String.class, String.class);
			for (Map<String, String> row : loginDetails) {

				String name = row.get("Username");
				String passcode = row.get("Password");
				System.out.println("name:"+name);
				System.out.println("Password:"+passcode);
				loginpage.setUserName(name);
				loginpage.setPassword(passcode);
				
				extentLog=report.createTest(Hooks.scenarioName);	
				
				extentLog.info("working on data table info");
			}

		}
		
		@When("Click on Login button")
		public void click_on_login_button() {
		    
			loginpage.clickLoginButton();
			extentLog.pass("successfully done datatable");
		}



}
