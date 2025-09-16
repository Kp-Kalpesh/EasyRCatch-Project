package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRCatchShopPage;
import easyr.qa.pages.EasyRDashboardPage;
import easyr.qa.pages.EasyRDonationPage;
import easyr.qa.pages.EasyRLoginPage;
import easyr.qa.pages.EasyROffersAndDealsPage;
import easyr.qa.pages.EasyROrganizationPage;
import easyr.qa.pages.EasyRSurveyPage;
import easyr.qa.pages.EasyRVendorPage;

public class EasyRSurveyPageTest extends TestBase{

	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;
	EasyRVendorPage vendrpg;
	EasyROffersAndDealsPage offerpg;
	EasyRCatchShopPage shoppg;
	EasyROrganizationPage orgpg;
	EasyRDonationPage donpg;
	EasyRSurveyPage survpg;

	public EasyRSurveyPageTest() {
		super();
	}


	@BeforeMethod
	public void setup() {
		initialization();
		loginpg = new EasyRLoginPage();
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("EmailQA"), prop.getProperty("PasswordQA"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
		shoppg = offerpg.clickOnProductStore();
		orgpg = shoppg.clickOnOrganization();
		donpg = orgpg.clickOnDonationTab();
		survpg = donpg.clickOnSurveyTab();
	}

	@Test(priority = 1)
	public void verifySurvey() {
		try {

		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		//		driver.quit();s
	}
}
