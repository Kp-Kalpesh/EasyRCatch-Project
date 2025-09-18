package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRDashboardPage;
import easyr.qa.pages.EasyRLoginPage;
import easyr.qa.pages.EasyROffersAndDealsPage;
import easyr.qa.pages.EasyRVendorPage;
import junit.framework.Assert;

public class EasyROffersAndDealsPageTest extends TestBase{
	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;
	EasyRVendorPage vendrpg;
	EasyROffersAndDealsPage offerpg;

	public EasyROffersAndDealsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpg = new EasyRLoginPage();
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("EmailQA"), prop.getProperty("PasswordQA"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
	}

	@Test(priority = 1)
	public void verifyOffersAndDealsFlow() {
		try {
			Assert.assertEquals(offerpg.verifyOffersAndDealsText(), "OFFERS AND DEALS");
			offerpg.clickOnCreateOffer();
			offerpg.enterVendorName(prop.getProperty("Vendor_Name"));
			offerpg.clickOnDisplayedVendor();
			Assert.assertEquals(offerpg.verifySelectedVendorName(), prop.getProperty("Vendor_Name"));
			Assert.assertEquals(offerpg.verifySelectVendorCompanyName(), prop.getProperty("Vendor_company"));			
			offerpg.clickOnAddOfferDetailsBtn();
			offerpg.selectOfferType(prop.getProperty("offer_Type"));
			offerpg.selectOfferDepartment(prop.getProperty("Offer_Dept"));
			offerpg.selectOfferCategory(prop.getProperty("offer_category"));
			offerpg.selectSubCategory(prop.getProperty("offer_subCategory"));
			offerpg.selectStartDate();
			offerpg.selectExpiryDate();
			offerpg.enterDonationPerRedemption(prop.getProperty("donationPer_redemption"));
			offerpg.enterCommissionPerRedemption(prop.getProperty("commissionPer_redemption"));
			offerpg.enterRewardCoins(prop.getProperty("Reward_coins"));
			offerpg.enterRedemptionLimit(prop.getProperty("redemption_limit"));
			offerpg.selectDiscountType(prop.getProperty("discount_Type"));
			offerpg.enterDiscount(prop.getProperty("discount_Price"));
			offerpg.enterClickCommission(prop.getProperty("click_commission"));
			offerpg.enterWebLink(prop.getProperty("offer_Link"));
			offerpg.clickOnOfferimagebtn();
			offerpg.selectImageFile(prop.getProperty("offer_Img"));
			offerpg.clickOnsaveImageBtn();
			offerpg.clickOnNextBtn();
			offerpg.enterSubDetailsInEnglish(prop.getProperty("OfftitleInEnglish"), prop.getProperty("OffshortDescInEnglish"), prop.getProperty("OfftermsInEnglish"), prop.getProperty("OffdescInEnglish"));
			offerpg.enterSubDetailsInDanish(prop.getProperty("OfftitleInDanish"), prop.getProperty("OffshortDescInDanish"), prop.getProperty("OfftermsInDanish"), prop.getProperty("OffdescInDanish"));
			offerpg.enterSubDetailsInArabic(prop.getProperty("OfftitleInArabic"), prop.getProperty("OffshortDescInArabic"), prop.getProperty("OfftermsInArabic"), prop.getProperty("OffdescInArabic"));
			offerpg.clickOnCreateOfferbtn();
			offerpg.logout();
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyDataAfterOfferCreation() {
		try {
			String actOffTitle = offerpg.verifyOfferTitle();
			System.out.println("actOffTitle = " + offerpg.verifyOfferTitle());
			Assert.assertEquals(actOffTitle, prop.getProperty("OfftitleInEnglish"));

			String actOffType = offerpg.verifyOfferType();
			System.out.println("actOffType = " + offerpg.verifyOfferType());
			Assert.assertEquals(actOffType, prop.getProperty("offer_Type"));

			String actOffVendorName = offerpg.verifyOfferVendorName();
			System.out.println("actOffVendorName = " + offerpg.verifyOfferVendorName());
			Assert.assertEquals(actOffVendorName, prop.getProperty("vendorNameAssertion"));	
			offerpg.logout();

		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
