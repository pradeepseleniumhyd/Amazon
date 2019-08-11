package in.amazon.selenium.testcases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import in.amazon.selenium.commons.OpenBrowser;
import in.amazon.selenium.commons.RegressionCommons;

public class TC002 extends RegressionCommons
{
	
	OpenBrowser ob = new OpenBrowser();
	
	@BeforeSuite
	public void Report() throws Exception
	{
		try
		{
		report = new ExtentHtmlReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(report);
		report.setAppendExisting(false);

		}catch(Exception e)
		{
			System.out.println("Report method issue : " + e.getMessage() );
		}
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void config(String browser) throws Exception
	{
		test = extent.createTest("TC002 - Amazon");
		test.assignAuthor("Indu");
		test.assignCategory(browser);
		prop=configLoad(configPath);
		System.out.println(configPath);
		System.out.println(prop.getProperty("URL"));
		driver = ob.browserOpen(driver, browser);
		navigateURL(driver,test, prop.getProperty("URL"));
	}
	
	
	
	@Test
	public void TC002() throws Exception
	{
		try
		{
			validateAttribute(driver, test, "(//a[contains(@class,'logo')])[1]", "aria-label", "Amazon");
				
				
				
				
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@AfterMethod
	public void configend() throws Exception
	{
		try
		{
			driver.close();
			extent.flush();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
			
		
	}

}
