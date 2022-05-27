package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BrowserActions;

public class ParaBankAccountOverview {
	
	public WebDriver driver;
	
	BrowserActions browseractions=new BrowserActions();
	Logger log=(Logger) LogManager.getLogger("ParaBankAccountOverview.java");
	
	public ParaBankAccountOverview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Log Out']")
	WebElement logOut;
	
	@FindBy(xpath="//a[text()='Bill Pay']")
	WebElement billPay;
	
	@FindBy(xpath="//a[text()='Update Contact Info']")
	WebElement updateContactInfo;
	
	public void clickLogOut()
	{
		System.out.println("Sample :"+logOut);
		if(logOut.isEnabled())
		{
			log.info("button is enabled");
		}
		browseractions.click(logOut);
		log.info("Successfully clicked on logout button");
	}
	
	public void clickOnBillPayLink()
	{
		browseractions.click(billPay);
	}
	
	public void clickOnUpdateContactInfoLink()
	{
		browseractions.click(updateContactInfo);
	}

}
