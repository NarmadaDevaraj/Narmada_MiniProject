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

public class TransferFund {
	
   public WebDriver driver;
   
   Logger log=(Logger) LogManager.getLogger("TransferFund.java");
   BrowserActions browseractions=new BrowserActions();
   SoftAssert softassert = new SoftAssert();
   
	public TransferFund(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[text()='Transfer Funds']")
	WebElement transferFundLink;
	
	@FindBy(xpath="//input[@id='amount']")
	WebElement amount;
	
	@FindBy(xpath="//select[@id='fromAccountId']")
	WebElement fAccountBox;
	
	@FindBy(xpath="//select[@id='fromAccountId']")
	WebElement fromAccountBox;
	
	@FindBy(xpath="//select[@id='toAccountId']")
	WebElement toAccountBox;
	
	@FindBy(xpath="//input[@class='button']")
	WebElement transferButton;
	
	@FindBy(xpath="//h1[@class='title']")
	WebElement transferSuccessTitle;
	
	@FindBy(xpath="//span[@id='amount']")
	WebElement verifyAmount;
	
	@FindBy(xpath="//span[@id='fromAccountId']")
	WebElement verifyFromAccountId;
	
	@FindBy(xpath="//span[@id='toAccountId']")
	WebElement verifyToAccountId;
	
	public void clickOnTransferFundLink()
	{
		browseractions.click(transferFundLink);
	}
	public void typeAmount(String tAmount)
	{
		try {
			Thread.sleep(6000);
			amount.clear();
			amount.sendKeys(tAmount);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	
	public void selectFromAccount(String text) throws InterruptedException
	{
		
		browseractions.selectByOptionText(fromAccountBox, text);
	}
	
	public void selectToAccount(String text)
	{
		browseractions.selectByOptionText(toAccountBox, text);
	}
	
	public void clickOnTransferFundButton()
	{
		browseractions.click(transferButton);
		
	}
	
	public void verifyTransferedAmt(String expAmt)
	{
		String actualAmt=verifyAmount.getText();
		log.info(actualAmt);
		Assert.assertEquals(actualAmt, expAmt);
	}
	
	public void verifyTransferFromAccountId(String expectedAccountId)
	{
		String actualAccountId=verifyFromAccountId.getText();
		log.info(actualAccountId);
		Assert.assertEquals(actualAccountId, expectedAccountId);
	}
	
	public void verifyTransferToAccountId(String expectedAccountId)
	{
		String actualAccountId=verifyToAccountId.getText();
		log.info(actualAccountId);
		Assert.assertEquals(actualAccountId, expectedAccountId);
	}
	
	public void validatePageTitle(String expectedPageTitle)
	{
		try {
			Thread.sleep(5000);
			String actPageTitle=transferSuccessTitle.getText();
			softassert.assertEquals(actPageTitle, expectedPageTitle);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
