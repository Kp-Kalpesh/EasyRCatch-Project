package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
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
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
	}

	@Test(priority = 1)
	public void verifyOffersAndDealsPage() throws InterruptedException {

		AssertJUnit.assertEquals(offerpg.verifyOffersAndDealsText(), "OFFERS AND DEALS");

	}


	@Test(priority = 2)
	public void verifyCreateOfferPage(){
		offerpg.clickOnCreateOffer();
	}


	@Test(priority = 3)
	public void verifyEnterVendorNameAndVerifyDetails() throws InterruptedException{
		offerpg.clickOnCreateOffer();
		offerpg.enterVendorName(prop.getProperty("Vendor_Name"));
		offerpg.clickOnDisplayedVendor();
		AssertJUnit.assertEquals(offerpg.verifySelectedVendorName(), prop.getProperty("Vendor_Name"));
		AssertJUnit.assertEquals(offerpg.verifySelectVendorCompanyName(), prop.getProperty("Vendor_company"));			

	}


	@Test(priority = 4)
	public void verifyNavigateToSubDetailsOfOffer() throws InterruptedException{
		offerpg.clickOnCreateOffer();
		offerpg.enterVendorName(prop.getProperty("Vendor_Name"));
		offerpg.clickOnDisplayedVendor();
		offerpg.clickOnAddOfferDetailsBtn();
	}


	@Test(priority = 5)
	public void verifyAllFieldValidationInsubDetails() throws InterruptedException{
		AssertJUnit.assertEquals(offerpg.verifyOffersAndDealsText(), "OFFERS AND DEALS");
		offerpg.clickOnCreateOffer();
		Assert.assertEquals(offerpg.clickOnAddOfferDetailBtn(), "Please select vendor for offer");
		offerpg.enterVendorName(prop.getProperty("Vendor_Name"));
		offerpg.clickOnDisplayedVendor();			
		offerpg.clickOnAddOfferDetailsBtn();
		Assert.assertEquals(offerpg.verifyOfferTypeValidation(), "Select offer type");
		Assert.assertEquals(offerpg.verifyOfferDepartment(), "Select offer department");
		Assert.assertEquals(offerpg.verifyOfferCategoryVal(), "Offer Category is required");
		Assert.assertEquals(offerpg.verifyOfferStartDateVal(), "Start date is required");
		Assert.assertEquals(offerpg.verifyOfferEndDateVal(), "End date is required");
		offerpg.selectOfferType(prop.getProperty("offer_Type"));
		offerpg.clickOnOfferSubDetails();
		Assert.assertEquals(offerpg.verifyDonationPerRedemptionVal(), "Donation per redemption is required");
		Assert.assertEquals(offerpg.verifyEasyRCommissionPerRedeemVal(), "EasyR commission per redeem in flat is required");
		Assert.assertEquals(offerpg.verifyEarningRewardCoinVal(), "Earning Reward Coins is required");
		Assert.assertEquals(offerpg.verifyOfferRedemptionLimitVal(), "At least one offer redemption limit is required");		
		Assert.assertEquals(offerpg.verifyOfferDiscountVal(), "Please select the type of discount");
		Assert.assertEquals(offerpg.verifyOfferCommissionPerClickVal(), "EasyR commission per click is required");
		Assert.assertEquals(offerpg.verifyOfferImageVal(), "Please upload image for offer!");
	}











	//			offerpg.clickOnOfferSubDetails();
	//			offerpg.selectOfferDepartment();

	//			offerpg.selectOfferDepartment(prop.getProperty("Offer_Dept"));
	//			offerpg.selectOfferCategory(prop.getProperty("offer_category"));
	//			offerpg.selectSubCategory(prop.getProperty("offer_subCategory"));
	//			offerpg.selectStartDate();
	//			offerpg.selectExpiryDate();
	//			offerpg.enterDonationPerRedemption(prop.getProperty("donationPer_redemption"));
	//			offerpg.enterCommissionPerRedemption(prop.getProperty("commissionPer_redemption"));
	//			offerpg.enterRewardCoins(prop.getProperty("Reward_coins"));
	//			offerpg.enterRedemptionLimit(prop.getProperty("redemption_limit"));
	//			offerpg.selectDiscountType(prop.getProperty("discount_Type"));
	//			offerpg.enterDiscount(prop.getProperty("discount_Price"));
	//			offerpg.enterClickCommission(prop.getProperty("click_commission"));
	//			offerpg.enterWebLink(prop.getProperty("offer_Link"));
	//			offerpg.clickOnOfferimagebtn();
	//			offerpg.selectImageFile(prop.getProperty("offer_Img"));
	//			offerpg.clickOnsaveImageBtn();
	//			offerpg.clickOnNextBtn();
	//			offerpg.enterSubDetailsInEnglish(prop.getProperty("OfftitleInEnglish"), prop.getProperty("OffshortDescInEnglish"), prop.getProperty("OfftermsInEnglish"), prop.getProperty("OffdescInEnglish"));
	//			offerpg.enterSubDetailsInDanish(prop.getProperty("OfftitleInDanish"), prop.getProperty("OffshortDescInDanish"), prop.getProperty("OfftermsInDanish"), prop.getProperty("OffdescInDanish"));
	//			offerpg.enterSubDetailsInArabic(prop.getProperty("OfftitleInArabic"), prop.getProperty("OffshortDescInArabic"), prop.getProperty("OfftermsInArabic"), prop.getProperty("OffdescInArabic"));
	//			offerpg.clickOnCreateOfferbtn();
	//			offerpg.logout();

	//	}

	//	@Test(priority = 2)
	//	public void verifyDataAfterOfferCreation() {
	//		try {
	//			String actOffTitle = offerpg.verifyOfferTitle();
	//			System.out.println("actOffTitle = " + offerpg.verifyOfferTitle());
	//			AssertJUnit.assertEquals(actOffTitle, prop.getProperty("OfftitleInEnglish"));
	//
	//			String actOffType = offerpg.verifyOfferType();
	//			System.out.println("actOffType = " + offerpg.verifyOfferType());
	//			AssertJUnit.assertEquals(actOffType, prop.getProperty("offer_Type"));
	//
	//			String actOffVendorName = offerpg.verifyOfferVendorName();
	//			System.out.println("actOffVendorName = " + offerpg.verifyOfferVendorName());
	//			AssertJUnit.assertEquals(actOffVendorName, prop.getProperty("vendorNameAssertion"));	
	//			offerpg.logout();
	//
	//		}catch (Exception e) {
	//			System.out.println("Element not found within timeout: " + e.getMessage());
	//		}
	//	}

	@AfterMethod
	public void tearDown() {
		//		driver.quit();
	}
}
