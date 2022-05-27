package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Utility.BrowserActions;

public class UpdateContactInfo {

    public WebDriver driver;
    
    BrowserActions browseractions=new BrowserActions();
	SoftAssert softassert = new SoftAssert();
	Logger log=(Logger) LogManager.getLogger("UpdateContactInfo.java");
	
	public UpdateContactInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//input[@id='customer.firstName']")
	WebElement cFirstName;
	
	@FindBy(xpath="//input[@id='customer.lastName']")
	WebElement cLastName;
	
	@FindBy(xpath="//input[@id='customer.address.street']")
	WebElement cAddressStreet;
	
	@FindBy(xpath="//input[@id='customer.address.city']")
	WebElement cAddressCity;
	
	@FindBy(xpath="//input[@id='customer.address.state']")
	WebElement cAddressState;
	
	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	WebElement cAddressZipCode;
	
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	WebElement cPhoneNumber;
	
	@FindBy(xpath="//input[@class='button']")
	WebElement cSubmitButtn;
	
	@FindBy(xpath="//table[@class='form2']/tbody/tr/td/span[contains(@ng-if,'customer.firstName')]")
	WebElement err_CFname;
	
	@FindBy(xpath="//table[@class='form2']/tbody/tr/td/span[contains(@ng-if,'customer.lastName')]")
	WebElement err_CLname;
	
	@FindBy(xpath="//table[@class='form2']/tbody/tr/td/span[contains(@ng-if,'customer.address.street')]")
	WebElement err_CAddStreet;
	
	@FindBy(xpath="//table[@class='form2']/tbody/tr/td/span[contains(@ng-if,'customer.address.city')]")
	WebElement err_CAddCity;
	
	@FindBy(xpath="//table[@class='form2']/tbody/tr/td/span[contains(@ng-if,'customer.address.state')]")
	WebElement err_CState;
	
	@FindBy(xpath="//table[@class='form2']/tbody/tr/td/span[contains(@ng-if,'customer.address.zipCode')]")
	WebElement err_CzipCode;
	
	public void typeCustomerName(String expName)
	{
		browseractions.type(cFirstName, expName);
		log.info("User typed customer name successfully");
	}
	
	public void typeCustomerLName(String expLName)
	{
		browseractions.type(cLastName, expLName);
		log.info("User typed customer last name successfully");
	}
	
	public void typeCustomerAddress(String expAddress)
	{
		browseractions.type(cAddressStreet, expAddress);
		log.info("User typed customer Address successfully");
	}
	
	public void typeCustomerCity(String expCity)
	{
		browseractions.type(cAddressCity, expCity);
		log.info("User typed customer City successfully");
	}
	
	public void typeCustomerState(String expState)
	{
		browseractions.type(cAddressState, expState);
		log.info("User typed customer state successfully");
	}
	
	public void typeCustomerZipCode(String expZipCode)
	{
		browseractions.type(cAddressZipCode, expZipCode);
		log.info("User typed customer Zip code successfully");
	}
	
	public void typeCustomerPhoneNum(String expPhNum)
	{
		browseractions.type(cPhoneNumber, expPhNum);
		log.info("User typed customer Zip code successfully");
	}
	
	public void clickOnUpdateProfile()
	{
		browseractions.click(cSubmitButtn);
		log.info("User successfully clicked on UpdateProfile button");
	}
//Scenario 2
	
	public void errorMsgValidationForEmptyCName(String expCname_err)
	{
		try {
			Thread.sleep(5000);
			browseractions.clearTextBox(cFirstName);
			browseractions.explicitWaitTextTobePresent(err_CFname,expCname_err);
			String actCname_err=err_CFname.getText();
			softassert.assertEquals(actCname_err, expCname_err);
			log.info("Error msg validated successfully for empty customer name");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void errorMsgValidationForEmptyCLName(String expCLname_err)
	{
	    browseractions.clearTextBox(cLastName);
		browseractions.explicitWaitTextTobePresent(err_CLname,expCLname_err);
		String actCLname_err=err_CLname.getText();
		softassert.assertEquals(actCLname_err, expCLname_err);
		log.info("Error msg validated successfully for empty customer last name");
	}
	
	public void errorMsgValidationForEmptyCAddress(String expCAdd_err)
	{
		browseractions.clearTextBox(cAddressStreet);
		browseractions.explicitWaitTextTobePresent(err_CAddStreet,expCAdd_err);
		String actCAddress_err=err_CAddStreet.getText();
		softassert.assertEquals(actCAddress_err, expCAdd_err);
		log.info("Error msg validated successfully for empty customer Address");
	}
	
	public void errorMsgValidationForEmptyCAddCity(String expCAddCity_err)
	{
		browseractions.clearTextBox(cAddressCity);
		browseractions.explicitWaitTextTobePresent(err_CAddCity,expCAddCity_err);
		String actCAddCity_err=err_CAddCity.getText();
		softassert.assertEquals(actCAddCity_err, expCAddCity_err);
		log.info("Error msg validated successfully for empty customer Address city");
	}
	
	public void errorMsgValidationForEmptyCAddState(String expCAddState_err)
	{
		browseractions.clearTextBox(cAddressState);
		browseractions.explicitWaitTextTobePresent(err_CState,expCAddState_err);
		String actCAddState_err=err_CState.getText();
		softassert.assertEquals(actCAddState_err, expCAddState_err);
		log.info("Error msg validated successfully for empty customer Address State");
	}
	
	public void errorMsgValidationForEmptyCZipCode(String expCAddzipCode_err)
	{
		browseractions.clearTextBox(cAddressZipCode);
		browseractions.explicitWaitTextTobePresent(err_CzipCode,expCAddzipCode_err);
		String actCAddZipCode_err=err_CzipCode.getText();
		softassert.assertEquals(actCAddZipCode_err, expCAddzipCode_err);
		log.info("Error msg validated successfully for empty customer Address zip code");
	}

}
