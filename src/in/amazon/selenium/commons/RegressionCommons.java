package in.amazon.selenium.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class RegressionCommons 
{

	public static String chromepath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
	public static String iepath = "D:\\INDU\\Basics\\driver\\IEDriverServer.exe";
	public static String firefoxpath = "D:\\INDU\\Basics\\driver\\geckodriver.exe";
	
	public static String configPath = System.getProperty("user.dir")+ "\\Resources\\config.properties";
	
	public FileInputStream fis;
	public Properties prop;
	public WebDriver driver;
	
	public void navigateURL(WebDriver driver,String url)
	{
		try
		{
			driver.get(url);
			System.out.println("URL is entered : " + url);
		}catch(Exception e)
		{
			System.out.println("Navigate URL method is not working : " + e.getMessage());
		}
		
	}
	
	
	public Properties configLoad(String config_path) throws Exception
	{
		fis = new FileInputStream(config_path);
		prop = new Properties();
		prop.load(fis);
		return prop;
	
	}

	public void validateTitle(WebDriver driver,String ExpectedTitle)
	{
		try
		{
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase(ExpectedTitle))
			{
				System.out.println(title + " is matched");
			}else
			{
				System.out.println(title + " is not matched");
			}
			
		}catch(Exception e)
		{
			System.out.println("ValidateTitle method is not working : " + e.getMessage());
		}
		
	}
	
	
}
