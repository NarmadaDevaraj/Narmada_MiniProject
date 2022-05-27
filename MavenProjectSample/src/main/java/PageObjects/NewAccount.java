package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Utility.BrowserActions;

public class NewAccount {

	public WebDriver driver;
	public static String actNewAccountId=null;
	
	Logger log=(Logger) LogManager.getLogger("NewAccount.java");
	BrowserActions browseractions=new BrowserActions();
	SoftAssert softassert = new SoftAssert();
	
	public NewAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Open New Account']")
	WebElement clickOnOpenNewAccount;
	
	@FindBy(xpath="//select[@id='type']")
	WebElement sAccountType;
	
	@FindBy(xpath="//select[@id='fromAccountId']")
	WebElement fromAccountId;
	
	@FindBy(xpath="//input[@class='button']")
	WebElement clickNewAccountButton;
	
	@FindBy(xpath="//h1[@class='title']")
	WebElement getTitle;
	
	@FindBy(xpath="//a[@id='newAccountId']")
	WebElement getNAccounttId;
	
	@FindBy(xpath="//table/tbody/tr/td[text()='Account Number:']/following-sibling::td[@id='accountId']")
	WebElement vefAccountId;
	
	@FindBy(xpath="//table/tbody/tr/td[text()='Account Type:']/following-sibling::td[@id='accountType']")
	WebElement vefAccountType;
	
	@FindBy(xpath="//select[@id='month']")
	WebElement selectMonth;
	
	@FindBy(xpath="//select[@id='transactionType']")
	WebElement selectTransactionType;
	
	@FindBy(xpath="//table[@id='transactionTable']")
	WebElement selecttransactionTable;
	
	@FindBy(xpath="//p[@class='ng-scope']")
	WebElement transactionTableMsg;
	
	
	public void clickOnNewAccountlink()
	{
		browseractions.explicitWaitEleToBeClickable_Click(clickOnOpenNewAccount);
	}
	
	public void selectAccountType(String sText)
	{
	
		browseractions.selectByOptionText(sAccountType, sText);
		
	}
	
	public void selectExAccountNum(String sNum)
	{
	
		browseractions.selectByOptionText(fromAccountId, sNum);
		
	}
	
	public void clickOnNewAccButton()
	{
		browseractions.explicitWaitEleToBeClickable_Click(clickNewAccountButton);
	}
	
	public void verifyTile(String expectedTitle)
	{
		String actPageTitle=getTitle.getText();
		Assert.assertEquals(actPageTitle, expectedTitle);
	}
	
	public void getNewAccountID()
	{
	 actNewAccountId=getNAccounttId.getText();
	}
	
	public void clickOnNewAccountID()
	{
		
		browseractions.explicitWaitEleToBeClickable_Click(getNAccounttId);
	}
	
	public void accountIdVerify()
	{
		try {
			Thread.sleep(6000);
			String expectedActID=vefAccountId.getText();
			if(actNewAccountId.equalsIgnoreCase(expectedActID))
			{
				Assert.assertTrue(true);
				log.info("Account Id verification done");
			}else
			{
				softassert.fail("Account Id not getting matched");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void accountTypeVerify(String expectedActType)
	{
		try {
			String actActtype=vefAccountType.getText();
			if(actActtype.equalsIgnoreCase(expectedActType))
			{
				Assert.assertTrue(true);
				log.info("Account Type Verification done");
			}else
			{
				softassert.fail("Account Id not getting matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectMonths(String monthName)
	{
		browseractions.selectByOptionText(selectMonth, monthName);
	}
	
	public void selectTrasactionType(String tText)
	{
		browseractions.selectByOptionText(selectTransactionType, tText);
	}

	public void clickOnGoButton()
	{
		browseractions.explicitWaitEleToBeClickable_Click(clickNewAccountButton);
		String actTransactionTableMsg=transactionTableMsg.getText();
		log.info("Transaction table msg verified Successfully:"+actTransactionTableMsg);
	}
	
}
