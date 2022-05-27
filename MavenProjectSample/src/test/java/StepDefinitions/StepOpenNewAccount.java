package StepDefinitions;

import org.openqa.selenium.WebDriver;

import PageObjects.NewAccount;
import Utility.DriverManager;
import io.cucumber.java.en.*;

public class StepOpenNewAccount {
	
	WebDriver driver=DriverManager.getDriver();
	NewAccount newaccount=new NewAccount(driver);
	
	@Given("User click on New Account")
	public void user_click_on_new_account() {
		newaccount.clickOnNewAccountlink();
	}
	
	@When("User select the Account Type as {string}")
	public void user_select_the_account_type_as(String sText) {
	   
		newaccount.selectAccountType(sText);
	}
	
	@And("User select Exsisting Account number as {string}")
	public void user_select_exsisting_account_number_as(String sNum) {
	  
		newaccount.selectExAccountNum(sNum);
	}
	
	@And("Click on OPEN NEW ACCOUNT button")
	public void click_on_open_new_account_button() {
	   
		newaccount.clickOnNewAccButton();
	}
	
	@And("click on Account Number")
	public void click_on_account_number() {
		newaccount.getNewAccountID();
		newaccount.clickOnNewAccountID();
	}
	
	@And("Verify Account Type as {string}")
	public void verify_account_type_as(String expectedActType) {
		
		newaccount.accountTypeVerify(expectedActType);
	   
	}
	
	@And("Verify New Account ID")
	public void verify_new_account_id() {
		
		newaccount.accountIdVerify();
	}

	@Then("User select Activity period as {string} and Type as {string}")
	public void user_select_activity_period_as_and_type_as(String monthName, String tText) {
	   
		newaccount.selectMonths(monthName);
		newaccount.selectTrasactionType(tText);
	}
	
	@Then("User click on GO")
	public void user_click_on_go() {
	  
		newaccount.clickOnGoButton();
	}


}
