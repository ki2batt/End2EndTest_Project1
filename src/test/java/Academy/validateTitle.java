package Academy;

import java.io.IOException;

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

public class validateTitle extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException 
	{
		driver = initializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
	}


	@Test
	public void basePageNavigation() throws IOException {
		
		// Inheritance
		// Creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		// Compare the text from the browser with actual text.-Error..
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		Log.info("Successfully validated text message");
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
