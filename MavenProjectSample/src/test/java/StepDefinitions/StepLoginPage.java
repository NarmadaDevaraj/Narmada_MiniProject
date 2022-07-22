package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.LoginPage;
import PageObjects.ParaBankAccountOverview;
import Utility.BrowserActions;
import Utility.DriverManager;
import Utility.ExtentReportConfiguration;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class StepLoginPage extends ExtentReportConfiguration   {

	WebDriver driver=DriverManager.getDriver();
	//ExtentReports report=ExtentReportConfiguration.getReport();
	//public ExtentTest extentLog=Hooks.getLog();
	
	public LoginPage loginpage; 
	public ParaBankAccountOverview accountoverview;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginpage=new LoginPage(driver);
		accountoverview=new ParaBankAccountOverview(driver);
		//
		//extentLog=report.createTest(Hooks.scenarioName);
		extentLog=report.createTest("Login scenario");
		extentLog.info("Narmada starting browser for login page");
		System.out.println("Narmada scenario:"+Hooks.scenarioName);
		
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		 driver.get(url);
		 //extentLog.pass("User opens url successfully");
	}
	
	@When("User enters UserName as {string} and Password as {string}")
	public void user_enters_user_name_as_and_password_as(String name, String passcode) {
	   
		loginpage.setUserName(name);
		loginpage.setPassword(passcode);
		extentLog.info("User enters credentials");
	}
	
	@When("Click on Login")
	public void click_on_login() {
	   
		loginpage.clickLoginButton();
		
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expTitle) {
		try {
			String title=driver.getTitle();
			
			if(title.equalsIgnoreCase(expTitle))
			System.out.println("Testcase passed :"+title);
			else
				Assert.fail("Expected Title not Matching:"+title);
		} catch (Exception e) {
			Assert.fail("There is some issue wid code or verification failed :"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	   
		Thread.sleep(1000);
		accountoverview.clickLogOut();
		extentLog.pass("Login part is successfull");
	}

	@And("Close the browser")
	public void close_the_browser() {
	   
		driver.close();
	}

}
