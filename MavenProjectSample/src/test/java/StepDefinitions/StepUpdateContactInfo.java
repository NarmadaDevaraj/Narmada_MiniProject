package StepDefinitions;

import org.openqa.selenium.WebDriver;

import PageObjects.ParaBankAccountOverview;
import PageObjects.UpdateContactInfo;
import Utility.DriverManager;
import io.cucumber.java.en.*;

public class StepUpdateContactInfo {
	
	WebDriver driver=DriverManager.getDriver();
	
	UpdateContactInfo contactinfo=new UpdateContactInfo(driver);
	ParaBankAccountOverview accountoverview=new ParaBankAccountOverview(driver);
	
	@Given("User click on Update Contact")
	public void user_click_on_update_contact() {
	  
		accountoverview.clickOnUpdateContactInfoLink();
	}
	
	@When("User enters the First Name as {string}")
	public void user_enters_the_first_name_as(String expName) {
	
		contactinfo.typeCustomerName(expName);
	}
	
	@When("User enters the Last Name as {string}")
	public void user_enters_the_last_name_as(String expLName) {
	
		contactinfo.typeCustomerLName(expLName);
		
	}
	
	@When("User enters Customer Address as {string} and city as {string}")
	public void user_enters_customer_address_as_and_city_as(String expAddress, String expCity) {
	   
		contactinfo.typeCustomerAddress(expAddress);
		contactinfo.typeCustomerCity(expCity);
	}
	
	@Then("User enters Customer state as {string} and Zip code as {string}")
	public void user_enters_customer_state_as_and_zip_code_as(String expState, String expZipCode) {
	    
		contactinfo.typeCustomerState(expState);
		contactinfo.typeCustomerZipCode(expZipCode);
	}
	
	@Then("User enters the Customer phone number as {string}")
	public void user_enters_the_customer_phone_number_as(String expPhNum) {
	   
		contactinfo.typeCustomerPhoneNum(expPhNum);
	}

	@Then("Click on Update Profile")
	public void click_on_update_profile() {
	    
		contactinfo.clickOnUpdateProfile();
	}
	
	@When("User Clears the First Name Column and verify Error msg as {string}")
	public void user_clears_the_first_name_column_and_verify_error_msg_as(String expCname_err) {
	   
		contactinfo.errorMsgValidationForEmptyCName(expCname_err);
	}
	
	@When("User Clears the Last Name Column and verify Error msg as {string}")
	public void user_clears_the_last_name_column_and_verify_error_msg_as(String expCLname_err) {
	    
		contactinfo.errorMsgValidationForEmptyCLName(expCLname_err);
	}
	
	@When("User Clears the Address  Column and verify Error msg as {string}")
	public void user_clears_the_address_column_and_verify_error_msg_as(String expCAdd_err) {
	    
		contactinfo.errorMsgValidationForEmptyCAddress(expCAdd_err);
	}
	
	@Then("User Clears the city  Column and verify Error msg as {string}")
	public void user_clears_the_city_column_and_verify_error_msg_as(String expCAddCity_err) {
	  
		contactinfo.errorMsgValidationForEmptyCAddCity(expCAddCity_err);
	}
	
	@Then("User Clears the state  Column and verify Error msg as {string}")
	public void user_clears_the_state_column_and_verify_error_msg_as(String expCAddState_err) {
	   
		contactinfo.errorMsgValidationForEmptyCAddState(expCAddState_err);
	}
	
	@Then("User Clears the Zip code Column and verify Error msg as {string}")
	public void user_clears_the_zip_code_column_and_verify_error_msg_as(String expCAddzipCode_err) {
      
		contactinfo.errorMsgValidationForEmptyCZipCode(expCAddzipCode_err);
	}


}
