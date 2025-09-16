package easyr.qa.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRLoginPage;
import junit.framework.Assert;

public class EasyRLoginTest extends TestBase{

	EasyRLoginPage loginpg;

	//	Logger log;
	//	public static ExtentReports extent = new ExtentReports();
	//	public static ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
	//	public static ExtentTest test;



	public EasyRLoginTest () {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpg = new EasyRLoginPage();

		//		log = LogManager.getLogger(TestBase.class);
		//		spark.config().setTheme(Theme.DARK);
		//		spark.config().setDocumentTitle("MyReport");
		//		extent.attachReporter(spark);
	}

	@Test
	public void verifySignInText() {
		try {
			//			ExtentTest test = extent.createTest("Verify the enter valid login creds and click on the login button").assignAuthor("Kalpesh").assignCategory("Functional Test Case").assignDevice("Windows Machine");
			//			test.info("Successful enter the creds and click on the Login Button");

			Assert.assertEquals(loginpg.verifySignInText(), "Sign In");
			boolean flag = loginpg.verifyEasyRLogo();
			Assert.assertTrue(flag);
			loginpg.enterEmail(prop.getProperty("EmailQA"));
			loginpg.enterPass(prop.getProperty("PasswordQA"));
			loginpg.clickOnRemembeeMe();
			loginpg.clickOnLoginButton();
			//			test.info("successfully navigate to the Dashboard page");
			//			test.pass("User Login app and navigate to the Dashboard Page");
			loginpg.logout();
			//			log.info("click on Logout button and successfully logout."); 

		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
