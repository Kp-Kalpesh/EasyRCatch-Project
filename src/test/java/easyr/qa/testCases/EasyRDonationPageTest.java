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
import easyr.qa.pages.EasyRVendorPage;
import junit.framework.Assert;

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
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("Email"), prop.getProperty("Password"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
		shoppg = offerpg.clickOnProductStore();
		orgpg = shoppg.clickOnOrganization();
		donpg = orgpg.clickOnDonationTab();
	}

	@Test(priority = 1)
	public void createDonation() {
		try {
			Assert.assertEquals(donpg.verifyDonationTextOnMenuBar(), "Donations");
			Assert.assertEquals(donpg.verifyDonationTextOnPage(), "DONATIONS");

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

		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());

		}
	}

	@Test(priority = 2)
	public void verifyCreatedDonationData() {
		try {
			Assert.assertEquals(donpg.verifyDonationTitle(), prop.getProperty("orgTitleEnglish"));
			Assert.assertEquals(donpg.verifyDonationOrganization(), prop.getProperty("CreatedDonationOrg"));
			Assert.assertEquals(donpg.verifyDonationCategory(), prop.getProperty("DonationCategory"));
		} catch (Exception e){
			System.out.println("Element not found within timeout: " + e.getMessage());

		}
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
