package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPage;
import PageObjects.TransferFund;
import Utility.BrowserActions;
import Utility.DriverManager;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepTransferFund {
 
	public  WebDriver driver=DriverManager.getDriver();
	
	TransferFund transferfund=new TransferFund(driver);
	
	@Given("User click on Transfer Funds")
	public void user_click_on_transfer_funds() 
	{
	
		transferfund.clickOnTransferFundLink();
	}
	
	@When("User enter the Amount as {string}")
	public void user_enter_the_amount_as(String tAmount) {
		transferfund.typeAmount(tAmount);
	}
	
	@And("User enters From Account as {string} and To Account as {string}")
	public void user_enters_from_account_as_and_to_account_as(String fromId, String toId) throws InterruptedException
	{
		transferfund.selectFromAccount(fromId);
		transferfund.selectToAccount(toId);
	}
	
	@Then("Click on Transfer Button")
	public void click_on_transfer_button() {
		transferfund.clickOnTransferFundButton();
	}
	
	@When("Page Title should be contains {string}")
	public void page_title_should_be_contains(String expectedPageTitle) 
	{
		transferfund.validatePageTitle(expectedPageTitle);
	}

	
	@And("Verify Amount should be {string}")
	public void verify_amount_should_be(String expAmt)
	{
		transferfund.verifyTransferedAmt(expAmt);
	}
	
	@And("Verify From account should be {string} and To account should be {string}")
	public void verify_from_account_should_be_and_to_account_should_be(String expectedfromAccountId, String expectedToAccountId)
	{
		transferfund.verifyTransferFromAccountId(expectedfromAccountId);
		transferfund.verifyTransferToAccountId(expectedToAccountId);
		
	}


}
