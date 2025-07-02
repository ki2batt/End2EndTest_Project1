package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	public static WebDriverWait wait;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException
	{
		
		prop = new Properties();
		FileInputStream fils = new FileInputStream("C:\\Users\\Kiki\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fils);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome"))
		{
			//Execute in ChromeDriver
			System.setProperty("webdriver.chrome.driver", "C:/Users/Kiki/Documents/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/Kiki/Documents/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.edge.driver", "C:/Users/Kiki/Documents/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		return driver;
	}
	
}
