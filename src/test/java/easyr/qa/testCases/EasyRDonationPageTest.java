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
import easyr.qa.pages.EasyRDonationPage;
import easyr.qa.pages.EasyRLoginPage;
import easyr.qa.pages.EasyROffersAndDealsPage;
import easyr.qa.pages.EasyROrganizationPage;
import easyr.qa.pages.EasyRVendorPage;

public class EasyRDonationPageTest extends TestBase{

	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;
	EasyRVendorPage vendrpg;
	EasyROffersAndDealsPage offerpg;
	EasyRCatchShopPage shoppg;
	EasyROrganizationPage orgpg;
	EasyRDonationPage donpg;

	public EasyRDonationPageTest(){
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpg = new EasyRLoginPage();
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
//		shoppg = offerpg.clicskOnProductStore();
		orgpg = shoppg.clickOnOrganization();
		donpg = orgpg.clickOnDonationTab();
	}

	@Test(priority = 1)
	public void createDonation() {
		try {
			AssertJUnit.assertEquals(donpg.verifyDonationTextOnMenuBar(), "Donations");
			AssertJUnit.assertEquals(donpg.verifyDonationTextOnPage(), "DONATIONS");
			donpg.clickOncreateDonationBtn();
			donpg.enterOrgName(prop.getProperty("Organization_Name"));
			donpg.clickOnViewOrg();
			donpg.verifyOrgName();
			donpg.verifyOrgEmail();
			donpg.clickOnAddDonationDetails();
			donpg.enterDatainEnglish(prop.getProperty("orgTitleEnglish"),prop.getProperty("orgShortDescEnglish"), prop.getProperty("orgWhoAreWeEnglish"), prop.getProperty("orgWhatWeNeedEnglish"));
			donpg.clickOnNxtForDanishBtn();
			donpg.enterDanishData(prop.getProperty("orgTitleDanish"),prop.getProperty("orgShortDescDanish"), prop.getProperty("orgWhoAreWeDanish"), prop.getProperty("orgWhatWeNeedDanish"));
			donpg.clickOnNxtForArabicBtn();
			donpg.enterDataInArabic(prop.getProperty("orgTitleArabic"),prop.getProperty("orgShortDescArabic"), prop.getProperty("orgWhoAreWeArabic"), prop.getProperty("orgWhatWeNeedArabic"));
			donpg.clickOnNextstep();
			donpg.enterDonationImage(prop.getProperty("donation_Image"));
			donpg.selectDonateCate(prop.getProperty("DonationCategory"));
			donpg.enterMinDonation(prop.getProperty("MinimumDonation"));
			donpg.enterMaxDonation(prop.getProperty("MaximumDonation"));
			donpg.enterDonationTarget(prop.getProperty("DonationTargetedAmount"));
			donpg.clickOncreateDonationBtn();
			donpg.logout();
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyCreatedDonationData() {
		try {
			AssertJUnit.assertEquals(donpg.verifyDonationTitle(), prop.getProperty("orgTitleEnglish"));
			AssertJUnit.assertEquals(donpg.verifyDonationOrganization(), prop.getProperty("CreatedDonationOrg"));
			AssertJUnit.assertEquals(donpg.verifyDonationCategory(), prop.getProperty("DonationCategory"));
			donpg.logout();
		} catch (Exception e){
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}


	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
}
