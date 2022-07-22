package Utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportConfiguration {
	public static ExtentReportConfiguration exReport;
	public static ExtentReports report;
	public static ExtentTest extentLog;
	

	public  ExtentReportConfiguration()
	{
		report = new ExtentReports();
		//ExtentSparkReporter	spark = new ExtentSparkReporter("target/Spark.html");
		ExtentSparkReporter	spark = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/target/Reports/narmada.html"));
		report.attachReporter(spark);
		//extentLog=report.createTest(Hooks.Sc);	
//		extentLog.info("starting browser");
		
	}
	@BeforeSuite
	public static void reportConfig()
	{
		System.out.println("Before suite code");
		report = new ExtentReports();
		//ExtentSparkReporter	spark = new ExtentSparkReporter("target/Spark.html");
		ExtentSparkReporter	spark = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/target/Reports/narmada.html"));
		report.attachReporter(spark);
		
	}
	public static void afterConfig()
	{
		report.flush();
	}
	
	public static ExtentReports  getReport()
	{
		return report;
	}
	public static void setupReport()
	{
		if(exReport == null)
		{
			exReport=new ExtentReportConfiguration();
			
		}
	}
	
	

}
