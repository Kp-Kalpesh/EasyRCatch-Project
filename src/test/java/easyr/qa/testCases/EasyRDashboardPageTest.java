package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRDashboardPage;
import easyr.qa.pages.EasyRLoginPage;
import junit.framework.Assert;

public class EasyRDashboardPageTest extends TestBase{

	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;

	public EasyRDashboardPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpg = new EasyRLoginPage();
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("EmailQA"), prop.getProperty("PasswordQA"));
	}

	@Test
	public void verifyDahsboardPage() {
		try {
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(dashpg.verifySuccessfulLoginToastMessage(), "Welcome Super Admin to EasyR Admin");
			System.out.println("dashpg.verifySuccessfulLoginToastMessage(): " + dashpg.verifySuccessfulLoginToastMessage());
			Assert.assertEquals(dashpg.verifyDashboardTextOnPage(), "DASHBOARD");
			dashpg.clickOnVendors();
			dashpg.logout();
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


