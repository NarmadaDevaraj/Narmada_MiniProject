package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import PageObjects.LoginPage;
import PageObjects.ParaBankAccountOverview;
import Utility.BrowserActions;
import Utility.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class StepLoginPage  {

	WebDriver driver=DriverManager.getDriver();
	
	public LoginPage loginpage; 
	public ParaBankAccountOverview accountoverview;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginpage=new LoginPage(driver);
		accountoverview=new ParaBankAccountOverview(driver);
		
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		 driver.get(url);
	}
	
	@When("User enters UserName as {string} and Password as {string}")
	public void user_enters_user_name_as_and_password_as(String name, String passcode) {
	   
		loginpage.setUserName(name);
		loginpage.setPassword(passcode);
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
	}

	@And("Close the browser")
	public void close_the_browser() {
	   
		driver.close();
	}

}
