package in.amazon.selenium.testcases;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import in.amazon.selenium.commons.OpenBrowser;
import in.amazon.selenium.commons.RegressionCommons;

public class TC001 extends RegressionCommons
{
	
	OpenBrowser ob = new OpenBrowser();
	
	@Test
	public void TC001() throws Exception
	{
		
		prop=configLoad(configPath);
		System.out.println(configPath);
		System.out.println(prop.getProperty("URL"));
		
		driver = ob.browserOpen(driver, "Chrome");
		navigateURL(driver, prop.getProperty("URL"));
		validateTitle(driver, prop.getProperty("HomePageTitle"));
	}

}
