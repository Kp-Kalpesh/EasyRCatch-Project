package easyr.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRLoginPage;

public class EasyRLoginTest extends TestBase{

	EasyRLoginPage loginpg;

//		Logger log;
//		public static ExtentReports extent = new ExtentReports();
//		public static ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
//		public static ExtentTest test;



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

	@Test(priority = 1)
	public void verifyFieldAndLogoOnLoginPage() {
		Assert.assertEquals(loginpg.verifySignInText(), "Sign In");
		boolean flag = loginpg.verifyEasyRLogo();
		Assert.assertTrue(flag);
	}

	//Test login with valid credentials
	@Test(priority = 2)
	public void verifyLoginFunctionality() throws InterruptedException {
		loginpg.enterEmail(prop.getProperty("ValidEmail"));
		loginpg.enterPass(prop.getProperty("ValidPassword"));
		loginpg.clickOnRemembeeMe();
		loginpg.clickOnLoginButton();
		Assert.assertTrue(loginpg.superAdminTextIsDisplayed(), "The SuperAdmin text is not displayed");
		loginpg.clickOnSuperAdminTxt();
		Assert.assertTrue(loginpg.LogoutTextisDisplayed(), "Login Failed");
		loginpg.logout();
	}

	// Test invalid login (incorrect username)
	@Test(priority = 3)
	public void testInvalidUsernameValidPwd() {
		loginpg.enterEmail(prop.getProperty("InvalidEmail"));
		loginpg.enterPass(prop.getProperty("ValidPassword"));
		loginpg.clickOnLoginButton();

		// Validate error message for invalid credentials
		Assert.assertTrue(loginpg.errorMessageIsDisplayed(), "Error message not displayed!");
		Assert.assertEquals(loginpg.verifyErrorMessage(), "Invalid email/password combination provided, please try again");
	}

	// Test invalid login (incorrect password)
	@Test(priority = 4)
	public void testInvalidPasswordValidUName() {
		loginpg.enterEmail(prop.getProperty("ValidEmail"));
		loginpg.enterPass(prop.getProperty("InvalidPwd"));
		loginpg.clickOnLoginButton();

		// Validate error message for invalid credentials
		Assert.assertTrue(loginpg.errorMessageIsDisplayed(), "Error message not displayed!");
		Assert.assertEquals(loginpg.verifyErrorMessage(), "Invalid email/password combination provided, please try again");
	}

	// Test empty username field
	@Test(priority = 5)
	public void testEmptyUsernameValidPwd() {
		loginpg.enterEmail(prop.getProperty("BlankEmail"));
		loginpg.enterPass(prop.getProperty("ValidPassword"));
		loginpg.clickOnLoginButton();

		// Validate that an error message is shown
		Assert.assertTrue(loginpg.displayedEmailValidation(), "The validation is not displayed");
		Assert.assertEquals(loginpg.verifyEmailValidation(), "Email is required!");
	}

	// Test empty password field
	@Test(priority = 6)
	public void testEmptyPasswordValidUName() throws InterruptedException {
		loginpg.enterEmail(prop.getProperty("ValidEmail"));
		loginpg.enterPass(prop.getProperty("BlankPwd"));
		loginpg.clickOnLoginButton();

		// Validate that an error message is shown
		Assert.assertTrue(loginpg.invalidPwdIsDisplayed(), "The pwd validation is not displayed");
		Assert.assertEquals(loginpg.verifyPwdErrorMessage(), "Password is required!");
	}


	//Invalid id and Invalid pwd
	@Test(priority = 7)
	public void invalidUNameInvalidPwd() {
		loginpg.enterEmail(prop.getProperty("InvalidEmail"));
		loginpg.enterPass(prop.getProperty("InvalidPwd"));
		loginpg.clickOnLoginButton();

		// Validate that an error message is shown
		Assert.assertTrue(loginpg.errorMessageIsDisplayed(), "The validation message is not displayed");
		Assert.assertEquals(loginpg.verifyErrorMessage(), "Invalid email/password combination provided, please try again");
	}

	//click On Login without enter data
	@Test(priority = 8)
	public void clickOnLoginWithoutEnterCreds() {
		loginpg.enterEmail(prop.getProperty("BlankEmail"));
		loginpg.enterPass(prop.getProperty("BlankPwd"));
		loginpg.clickOnLoginButton();

		// Validate that an error message is shown
		//Email
		Assert.assertTrue(loginpg.displayedEmailValidation(), "The Email Validation is not displayed");
		Assert.assertEquals(loginpg.verifyEmailValidation(), "Email is required!");
		//password
		Assert.assertTrue(loginpg.invalidPwdIsDisplayed(), "The pwd validation is not displayed");
		Assert.assertEquals(loginpg.verifyPwdErrorMessage(), "Password is required!");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}






































/*
 * @Test(priority = 2)
	public void verifySignInText() {
		try {
			//			ExtentTest test = extent.createTest("Verify the enter valid login creds and click on the login button").assignAuthor("Kalpesh").assignCategory("Functional Test Case").assignDevice("Windows Machine");
			//			test.info("Successful enter the creds and click on the Login Button");


			loginpg.enterEmail(prop.getProperty("EmailQA"));
			loginpg.enterPass(prop.getProperty("PasswordQA"));
			loginpg.clickOnRemembeeMe();
			loginpg.clickOnLoginButton();
			//			test.info("successfully navigate to the Dashboard page");
			//			test.pass("User Login app and navigate to the Dashboard Page");
			Assert.assertTrue(loginpg.LogoutTextisDisplayed(), "The logout text is not displayed");
			loginpg.logout();
			//			log.info("click on Logout button and successfully logout."); 

		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}
 * 
 * 
 */
