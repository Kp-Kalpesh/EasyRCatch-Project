package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRCatchShopPage;
import easyr.qa.pages.EasyRDashboardPage;
import easyr.qa.pages.EasyRLoginPage;
import easyr.qa.pages.EasyROffersAndDealsPage;
import easyr.qa.pages.EasyROrganizationPage;
import easyr.qa.pages.EasyRVendorPage;

public class EasyROrganizationPageTest extends TestBase{

	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;
	EasyRVendorPage vendrpg;
	EasyROffersAndDealsPage offerpg;
	EasyRCatchShopPage shoppg;
	EasyROrganizationPage orgpg;

	public EasyROrganizationPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpg = new EasyRLoginPage();
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
//		shoppg = offerpg.clickOnProductStore();
		orgpg = shoppg.clickOnOrganization();
	}

	@Test(priority = 1)
	public void createOrganization() {
		try {
			AssertJUnit.assertEquals(orgpg.verifyTextOnMenuBar(), "Organizations");
			AssertJUnit.assertEquals(orgpg.verifyTextOnPage(), "ORGANIZATIONS");

			orgpg.clickOnCreateOrganizationBtn();
			orgpg.clickOnSelectOrgImgFileBtn();
			orgpg.enterImgFilePath(prop.getProperty("orgImage_File"));
			orgpg.clickOnSaveImageBtn();
			orgpg.enterOrgName(prop.getProperty("OrganizationName"));
			orgpg.enterOrgEmail(prop.getProperty("OrganizationEmail"));
			orgpg.enterOrgPhone(prop.getProperty("OrganizationPhone"));
			orgpg.enterOrgAddress(prop.getProperty("OrgAddress"));
			orgpg.enterDescInEng(prop.getProperty("OrgDescInEnglish"));
			orgpg.clickOnDanishBtn();
			orgpg.enterDescInDan(prop.getProperty("OrgDescInDanish"));
			orgpg.clickOnArabicBtn();
			orgpg.enterDescInArab(prop.getProperty("OrgDescInArabic"));
			orgpg.enterOrgWebsite(prop.getProperty("OrganizationWebsite"));
			orgpg.clickOnAddOrganizationBtn();
			orgpg.logout();
		}catch(Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyCreatedOrganization() {
		try {
			AssertJUnit.assertEquals(orgpg.verifyCreatedOrgName(), "People For Animals");
			AssertJUnit.assertEquals(orgpg.verifyCreatedOrgEmail(), "peopleforanimals@easyr.ae");
			orgpg.logout();
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
