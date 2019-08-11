package in.amazon.selenium.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class RegressionCommons 
{

	public static String chromepath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
	public static String iepath = "D:\\INDU\\Basics\\driver\\IEDriverServer.exe";
	public static String firefoxpath = "D:\\INDU\\Basics\\driver\\geckodriver.exe";
	
	public static String configPath = System.getProperty("user.dir")+ "\\Resources\\config.properties";
	
	
	public static String reportPath = System.getProperty("user.dir") + "\\Reports\\AmazonReport.html";
	
	public FileInputStream fis;
	public Properties prop;
	public WebDriver driver;
	public ExtentHtmlReporter report;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void navigateURL(WebDriver driver,ExtentTest test,String url)
	{
		try
		{
			driver.get(url);
			System.out.println("URL is entered : " + url);
			test.log(Status.PASS, "URL is entered : " + url);
		}catch(Exception e)
		{
			System.out.println("Navigate URL method is not working : " + e.getMessage());
			test.log(Status.FAIL, "Navigate URL method is not working : " + e.getMessage());

		}
		
	}
	
	
	public Properties configLoad(String config_path) throws Exception
	{
		fis = new FileInputStream(config_path);
		prop = new Properties();
		prop.load(fis);
		return prop;
	
	}

	public void validateTitle(WebDriver driver,ExtentTest test,String ExpectedTitle)
	{
		try
		{
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase(ExpectedTitle))
			{
				System.out.println(title + " is matched");
				Reporter.log(title + " is matched");
				test.log(Status.PASS, title + " is matched");
			}else
			{
				System.out.println(title + " is not matched");
				Reporter.log(title + " is not matched");
				test.log(Status.FAIL, title + " is not matched");

			}
			
		}catch(Exception e)
		{
			System.out.println("ValidateTitle method is not working : " + e.getMessage());
			test.log(Status.FAIL, "ValidateTitle method is not working : " + e.getMessage());
		}
		
	}
	
	public void validateAttribute(WebDriver driver,ExtentTest test,String xpathvalue,String attributename, String expectedattributevalue)
	{
		try
		{
			String value = driver.findElement(By.xpath(xpathvalue)).getAttribute(attributename);

			System.out.println(value);
			if(value.equalsIgnoreCase(expectedattributevalue))
			{
				System.out.println(value + " is matched");
				Reporter.log(value + " is matched");
				test.log(Status.PASS, value + " is matched");
			}else
			{
				System.out.println(value + " is not matched");
				Reporter.log(value + " is not matched");
				test.log(Status.FAIL, value + " is not matched");

			}
			
		}catch(Exception e)
		{
			System.out.println("Validate Attribute method is not working : " + e.getMessage());
			test.log(Status.FAIL, "Validate Attribute method is not working : " + e.getMessage());
		}
		
	}
	
}
