package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRLoginPage;
import junit.framework.Assert;

public class EasyRLoginTest extends TestBase{

	EasyRLoginPage loginpg;
	public EasyRLoginTest () {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpg = new EasyRLoginPage();
	}

	@Test
	public void verifySignInText() {
		try {
			Assert.assertEquals(loginpg.verifySignInText(), "Sign In");
			boolean flag = loginpg.verifyEasyRLogo();
			Assert.assertTrue(flag);
			loginpg.enterEmail(prop.getProperty("Email"));
			loginpg.enterPass(prop.getProperty("Password"));
			loginpg.clickOnRemembeeMe();
			loginpg.clickOnLoginbtn(prop.getProperty("Email"), prop.getProperty("Password"));
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
