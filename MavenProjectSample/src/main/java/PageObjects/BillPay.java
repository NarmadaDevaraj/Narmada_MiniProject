package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Utility.BrowserActions;

public class BillPay {
	
   public WebDriver driver;
	
   Logger log = (Logger) LogManager.getLogger("BillPay.java");
   BrowserActions browseractions = new BrowserActions();
   SoftAssert softassert = new SoftAssert();

	public BillPay(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='payee.name']")
	WebElement payeeName;
	
	@FindBy(xpath="//input[@name='payee.address.street']")
	WebElement payeeAddress;
	
	@FindBy(xpath="//input[@name='payee.address.city']")
	WebElement payeeAddCity;
	
	@FindBy(xpath="//input[@name='payee.address.state']")
	WebElement payeeAddState;
	
	@FindBy(xpath="//input[@name='payee.address.zipCode']")
	WebElement payeeZipCode;
	
	@FindBy(xpath="//input[@name='payee.phoneNumber']")
	WebElement payeePhNumber;
	
	@FindBy(xpath="//input[@name='payee.accountNumber']")
	WebElement payeeANumber;
	
	@FindBy(xpath="//input[@name='verifyAccount']")
	WebElement verifyANumber;
	
	@FindBy(xpath="//input[@name='amount']")
	WebElement amount;
	
	@FindBy(xpath="//select[@name='fromAccountId']")
	WebElement fromAccountId;
	
	@FindBy(xpath="//input[@class='button']")
	WebElement submitButton;
	
	//Scenario 2
	
	@FindBy(xpath="//span[@ng-show='!validationModel.name']")
	WebElement err_PayeeName;
	
	@FindBy(xpath="//span[@ng-show='!validationModel.address']")
	WebElement err_address;
	
	@FindBy(xpath="//span[@ng-show='!validationModel.city']")
	WebElement err_Payeecity;
	
	@FindBy(xpath="//span[@ng-show='!validationModel.state']")
	WebElement err_Payeestate;
	
	@FindBy(xpath="//span[@ng-show='!validationModel.zipCode']")
	WebElement err_PayeezipCode;
	
	@FindBy(xpath="//span[@ng-show='!validationModel.phoneNumber']")
	WebElement err_PayeephoneNumber;
	
	@FindBy(xpath="(//table[@class='form2']/tbody/tr/td/span[contains(@ng-show,'empty')])[1]")
	WebElement err_Account;
	
	@FindBy(xpath="(//table[@class='form2']/tbody/tr/td/span[contains(@ng-show,'empty')])[2]")
	WebElement err_VefAccount;
	
	@FindBy(xpath="(//table[@class='form2']/tbody/tr/td/span[contains(@ng-show,'empty')])[3]")
	WebElement err_emptyAmt;
	
	@FindBy(xpath="(//table[@class='form2']/tbody/tr/td/span[contains(@ng-show,'invalid')])[1]")
	WebElement errInvalid_Account;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[9]/td[3]/span[3]")
	WebElement errMismatch_VefAccount;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[9]/td[3]/span[2]")
	WebElement errInvalid_VefAccount;
	
	public void enterPayeeName(String pNtext)
	{
		browseractions.type(payeeName, pNtext);
	}
	
	public void enterPayeeAddress(String pAtext)
	{
		browseractions.type(payeeAddress, pAtext);
	}
	
	public void enterPayeeAddCity(String pACtext)
	{
		browseractions.type(payeeAddCity, pACtext);
	}
	
	public void enterPayeeAddState(String pAStext)
	{
		browseractions.type(payeeAddState, pAStext);
	}
	
	public void enterPayeeZipCode(String pZipTxt)
	{
		browseractions.type(payeeZipCode, pZipTxt);
	}
	
	public void enterPayeePhNumber(String pPhNtext)
	{
		browseractions.type(payeePhNumber, pPhNtext);
	}
	
	public void enterPayeeAccountNumber(String pAccNumberTxt)
	{
		browseractions.type(payeeANumber, pAccNumberTxt);
	}
	
	public void enterPayeeVefANumber(String pvefAccNumTxt)
	{
		browseractions.type(verifyANumber, pvefAccNumTxt);
	}
	
	public void enterPayeeAmt(String pAmtTxt)
	{
		browseractions.type(amount, pAmtTxt);
	}
	
	public void selectfromAccountId(String fromAccountTxt)
	{
		browseractions.selectByOptionText(fromAccountId, fromAccountTxt);
	}
	
	public void clickOnSendPayment()
	{
		browseractions.click(submitButton);
	}
	
//Scenario 2 method implementation
	
	public void verifyErrorMsg_PayeeName(String expectedPNErrorMsg)
	{
		String actPNErrorMsg=err_PayeeName.getText();
		softassert.assertEquals(actPNErrorMsg, expectedPNErrorMsg);
		log.info("Error msg verified successfully for empty payee Name");
	}
	
	public void verifyErrorMsg_PayeeAddress(String expectedPAErrorMsg)
	{
		String actPAErrorMsg=err_address.getText();
		softassert.assertEquals(actPAErrorMsg, expectedPAErrorMsg);
		log.info("Error msg verified successfully for empty payee Address");
	}
	
	public void verifyErrorMsg_PayeeCity(String expectedPCErrorMsg)
	{
		String actPCErrorMsg=err_Payeecity.getText();
		softassert.assertEquals(actPCErrorMsg, expectedPCErrorMsg);
		log.info("Error msg verified successfully for empty payee City");
	}
	
	public void verifyErrorMsg_PayeeState(String expectedPSErrorMsg)
	{
		String actPSErrorMsg=err_Payeestate.getText();
		softassert.assertEquals(actPSErrorMsg, expectedPSErrorMsg);
		log.info("Error msg verified successfully for empty payee State");
	}
	
	public void verifyErrorMsg_PayeeZipCode(String expectedPZipCodeErrorMsg)
	{
		String actPZCErrorMsg=err_PayeezipCode.getText();
		softassert.assertEquals(actPZCErrorMsg, expectedPZipCodeErrorMsg);
		log.info("Error msg verified successfully for empty payee zip code");
	}
	
	public void verifyErrorMsg_PayeePhoneNumber(String expectedPhErrorMsg)
	{
		String actPhNumberErrorMsg=err_PayeephoneNumber.getText();
		softassert.assertEquals(actPhNumberErrorMsg, expectedPhErrorMsg);
		log.info("Error msg verified successfully for empty payee Phone number");
	}
	
	public void verifyErrorMsg_PayeeAccountId(String expectedPAIdErrorMsg)
	{
		String actPAIDErrorMsg=err_PayeeName.getText();
		softassert.assertEquals(actPAIDErrorMsg, expectedPAIdErrorMsg);
		log.info("Error msg verified successfully for empty payee Account ID");
	}
	
	public void verifyErrorMsg_PayeeVerifyAccountID(String expectedPVAIdErrorMsg)
	{
		String actPVAIdErrorMsg=err_PayeeName.getText();
		softassert.assertEquals(actPVAIdErrorMsg, expectedPVAIdErrorMsg);
		log.info("Error msg verified successfully for empty payee Verify account Id");
	}
	
	public void verifyErrorMsg_PayeeAmount(String expectedPAmtErrorMsg)
	{
		String actPAmtErrorMsg=err_PayeeName.getText();
		softassert.assertEquals(actPAmtErrorMsg, expectedPAmtErrorMsg);
		log.info("Error msg verified successfully for empty payee amount");
	}
	
	public void verifyInvalidAccountErrorMsg(String expectedPAcInvErrorMsg)
	{
		String actPInvalidErrorMsg=errInvalid_Account.getText();
		softassert.assertEquals(actPInvalidErrorMsg, expectedPAcInvErrorMsg);
		log.info("Error msg verified successfully for invalid payee account number");
		
	}
	
	public void verifyMismatchVerifyAccountErrorMsg(String expectedMismatchErrorMsg)
	{
		String actPMismatchErrorMsg=errMismatch_VefAccount.getText();
		softassert.assertEquals(actPMismatchErrorMsg, expectedMismatchErrorMsg);
		log.info("Error msg verified successfully for invalid payee account and wrong verify account number");
		
	}
	
	public void verifyInvalidVerifyAccountErrorMsg(String expectedVeifyInvAccErrorMsg)
	{
		String actInvalidVefAccErrorMsg=errInvalid_VefAccount.getText();
		softassert.assertEquals(actInvalidVefAccErrorMsg, expectedVeifyInvAccErrorMsg);
		log.info("Error msg verified successfully for invalid payee account and wrong verify account number");
		
	}
}
