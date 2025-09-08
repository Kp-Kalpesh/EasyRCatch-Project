package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRLoginPage;
import junit.framework.Assert;

public class EasyRLoginTest extends TestBase{
	EasyRLoginPage LoginPg;

	public EasyRLoginTest () {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPg = new EasyRLoginPage();
	}

	
	@Test
	public void verifySignInText() {
		Assert.assertEquals(LoginPg.verifySignInText(), "Sign In");
		boolean flag = LoginPg.verifyEasyRLogo();
		Assert.assertTrue(flag);
		
		LoginPg.enterEmail(prop.getProperty("Email"));
		LoginPg.enterPass(prop.getProperty("Password"));
		LoginPg.clickOnRemembeeMe();
		LoginPg.clickOnLoginbtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
