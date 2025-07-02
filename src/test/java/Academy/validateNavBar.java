package Academy;

import java.io.IOException;
//Adding logs
//Generating html reports
//Screenshots on failure
//Jenkins integration

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateNavBar extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());

@BeforeMethod
	public void initialize() throws IOException 
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException {
		
		// Inheritance
		// Creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		// Compare the text from the browser with actual text.-Error..
		Assert.assertTrue(l.getNavBar().isDisplayed());
		Log.info("Navigation Bar Is Displayed");

	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
