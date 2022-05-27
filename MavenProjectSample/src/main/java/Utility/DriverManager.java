package Utility;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static DriverManager driverManager;
	public static WebDriver driver;
	static Logger log=(Logger) LogManager.getLogger("DriverManager.java");
	
	public DriverManager()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Chrome driver ="+driver);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        log.info("Driver got launched and maximize successfully");
	}

	public static WebDriver getDriver()
	{
		return DriverManager.driver;
		
	}
	
	public static void setupDriver()
	{
		if(driverManager==null)
		{
			driverManager=new DriverManager();
		}
	}
	
	public static void tearDown()
	{
		driverManager=null;
		driver.quit();
		log.info("Driver instances closed successfully");
	}
}
