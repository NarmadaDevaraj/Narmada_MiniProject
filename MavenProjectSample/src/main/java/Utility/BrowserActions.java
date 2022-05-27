package Utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;

public class BrowserActions {
	
	WebDriver driver=DriverManager.getDriver();
	Logger log=(Logger) LogManager.getLogger("BrowserActions.java");
	
	public void selectByOptionText(WebElement element,String text)
	{
		try {
			Select select=new Select(element);
			 select.selectByVisibleText(text);
			 log.info("Selected the option "+text+" by using selectByOptionTextMethod");
		} catch (Exception e) {
			
			log.error("The error Msg :"+e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void getCurrentTime()
	{
		LocalDateTime date = LocalDateTime.now();
	      System.out.println("Current Date and Time: "+date);
	}
	
	public void fluentWait_Click(final WebElement element)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
	WebElement fElement=wait.until(new Function<WebDriver , WebElement>(){

		public WebElement apply(WebDriver driver) {
			
			return element;
		}
	});
			
	fElement.click();			
	}
	
	public void explicitWaitEleToBeClickable_Click(WebElement element)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,20);
			WebElement wElement=wait.until(ExpectedConditions.elementToBeClickable(element));
			wElement.click();
			log.info("Element clicked successfully");
		} catch (Exception e) {
			log.error("The error Msg is:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void explicitWaitEleToBeVisible(WebElement element)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log.error("The error Msg is:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void explicitWaitTextTobePresent(WebElement element,String text)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		} catch (Exception e) {
			log.error("The error Msg is:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void captureScreenshot(String scenarioName)
	{
		LocalDateTime date = LocalDateTime.now();
	      System.out.println("Current Date and Time: "+date);
	      ScreenshotManager.takeScreenshot(driver,"abc.png");
	}
	
	public void type(WebElement element,String text)
	{
		try {
			explicitWaitEleToBeVisible(element);
			element.clear();
			explicitWaitEleToBeClickable_Click(element);
			element.sendKeys(text);
			log.info("The text "+text+" typed successfully");
		} catch (Exception e) {
			log.error("The error Msg is:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void click(WebElement element)
	{
		try {
			explicitWaitEleToBeVisible(element);
			explicitWaitEleToBeClickable_Click(element);
			
		} catch (Exception e) {
			log.error("The error Msg is:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void clearTextBox(WebElement element)
	{
		try {
			explicitWaitEleToBeVisible(element);
			element.clear();
			log.info("Text box cleared successfully");
		} catch (Exception e) {
			log.error("The error Msg is:"+e.getMessage());
			e.printStackTrace();
		}
	}
}
