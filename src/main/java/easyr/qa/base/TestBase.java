package easyr.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import easyr.qa.utility.BaseUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/wcg112/eclipse-workspace/EasyRCatch/src/main" + 
					"/java/easyr/qa/config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}   




	public static void initialization()
	{
		String browserName = prop.getProperty("Browser");

		if(browserName.equals("Chrome")){
			//			System.setProperty("webdriver.chrome.driver", "C:/Users/wcg112/eclipse-workspace/EasyRCatch/Drivers/chromedriver (2).exe");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} 
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:/Users/wcg112/eclipse-workspace/EasyRCatch/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(BaseUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BaseUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));

	}

}
