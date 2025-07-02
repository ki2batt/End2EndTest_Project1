package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class HomePage extends base{
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize() throws IOException 
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
	
		//Inheritance
		//Creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		l.getLogin().click(); //driver.findElement(By.css()
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		Log.info(text);
		
		lp.getLogin().click();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//Column stands for how many values per each test
		
		//Array size is 5 (0, 1, 2, 3, 4)
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		//1st row	
		  data[1][0] = "restricteduser@qw.com"; 
		  data[1][1] = "456788"; 
		  data[1][2] = "Non Restricted User";
		 
		
		return data;
		
	}
	
	
}
