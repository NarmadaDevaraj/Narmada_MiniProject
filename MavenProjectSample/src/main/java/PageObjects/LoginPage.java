package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.BrowserActions;

public class LoginPage {

	public WebDriver driver;
	
	Logger log=(Logger) LogManager.getLogger("LoginPage.java");
	BrowserActions browseractions=new BrowserActions();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id='rightPanel']/p")
	WebElement errorMsg;
	
	public void setUserName(String name)
	{
		browseractions.click(username);
		browseractions.type(username, name);
		log.info("Successfully entered username");
	}

	public void setPassword(String passcode)
	{
		browseractions.click(password);
		browseractions.type(password, passcode);
		log.info("Successfully entered password");
	}
	
	public void clickLoginButton()
	{
		browseractions.click(loginButton);
		log.info("Successfully clicked on login button");
	}
}
