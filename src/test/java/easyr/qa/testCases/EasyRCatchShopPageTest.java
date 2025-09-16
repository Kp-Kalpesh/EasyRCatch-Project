package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRCatchShopPage;
import easyr.qa.pages.EasyRDashboardPage;
import easyr.qa.pages.EasyRLoginPage;
import easyr.qa.pages.EasyROffersAndDealsPage;
import easyr.qa.pages.EasyRVendorPage;
import junit.framework.Assert;
public class EasyRCatchShopPageTest extends TestBase{

	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;
	EasyRVendorPage vendrpg;
	EasyROffersAndDealsPage offerpg;
	EasyRCatchShopPage shoppg;

	public EasyRCatchShopPageTest() {
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
	}

	@Test(priority = 1)
	public void verifyInventoryStoreProduct() {
		try {			
			Assert.assertEquals(shoppg.verifyProductsTextOnPage(), "INVENTORY PRODUCTS");
			shoppg.clickOnCreateProductBtn();
			shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
			Assert.assertTrue(shoppg.verifyDisplayedVendorInDrpDwn());
			shoppg.clickOnDisplayedVendorName();
			Assert.assertEquals(shoppg.verifySelectedVName(), prop.getProperty("Vendor_Name"));
			Assert.assertEquals(shoppg.verifySelectedVCompany(), prop.getProperty("Vendor_company"));
			shoppg.clickOnAddProductDetailsBtn();
			shoppg.enterValidDataInEnglish(prop.getProperty("ProdTitleEnglish"), prop.getProperty("ProdShortDescEnglish"), prop.getProperty("ProdDescEnglish"), prop.getProperty("ProdTermsEnglish"), prop.getProperty("prodInstructionEnglish"));
			shoppg.clickOnNxtForDanishBtn();
			shoppg.enterValidDataInDanish(prop.getProperty("ProdTitleDanish"), prop.getProperty("ProdShortDescDanish"), prop.getProperty("ProdDescDanish"), prop.getProperty("ProdTermsDanish"), prop.getProperty("prodInstructionDanish"));
			shoppg.clickOnNextForArabicBtn();
			shoppg.enterValidDataInArabic(prop.getProperty("ProdTitleArabic"), prop.getProperty("ProdShortDescArabic"), prop.getProperty("ProdDescArabic"), prop.getProperty("ProdTermsArabic"), prop.getProperty("prodInstructionArabic"));
			shoppg.clickOnNextStepBtn();
			shoppg.clickOnProductImgField();
			shoppg.enterImgInField(prop.getProperty("ProductImg_Url"));		
			shoppg.clickOnSaveImgBtn();
			shoppg.verifyDisplayedUploadedImg(prop.getProperty("OldSrcFile"));			
			shoppg.selectCategory(prop.getProperty("productCategory"));
			shoppg.enterQuantityOfProduct(prop.getProperty("ProductQuantity"));
			shoppg.enterPerUnitPurchaseCost(prop.getProperty("purchsedCost"));
			shoppg.enterPerUnitSellCost(prop.getProperty("sellCost"));
			shoppg.enableRedemptionLimitToggle();
			shoppg.enterRedemptionLimit(prop.getProperty("Redemption_Limit"));
			shoppg.enableAllowRedemptionLimit();
			shoppg.enterValidityOfProductAfterPurchased(prop.getProperty("ProductValidityInDays"));
			shoppg.clickOnCreateProduct();
			shoppg.logout();
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyCreatedProduct() {
		try {
			Assert.assertEquals(shoppg.verifyCreatedOfferTitle(), prop.getProperty("ProdTitleEnglish"));
			Assert.assertEquals(shoppg.verifyCreatedOfferVName(), prop.getProperty("vendorNameAssertion"));
			Assert.assertEquals(shoppg.verifyCreatedOfferCategory(), prop.getProperty("productCategory"));
			shoppg.logout();
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown()	{
		driver.quit();
	}
}
