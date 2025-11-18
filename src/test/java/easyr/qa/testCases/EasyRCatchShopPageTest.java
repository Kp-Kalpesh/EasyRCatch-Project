package easyr.qa.testCases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRCatchShopPage;
import easyr.qa.pages.EasyRDashboardPage;
import easyr.qa.pages.EasyRLoginPage;
import easyr.qa.pages.EasyROffersAndDealsPage;
import easyr.qa.pages.EasyRVendorPage;
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
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
		shoppg = offerpg.clickOnProductStore();
	}

	@Test(priority = 1)
	public void verifyProductPage() throws InterruptedException {
		AssertJUnit.assertEquals(shoppg.verifyProductsTextOnPage(), "INVENTORY PRODUCTS");
		shoppg.logout();
	}

	@Test(priority = 2)
	public void verifyCreateProductPage() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.logout();
	}

	@Test(priority = 3)
	public void verifyVendorSelectionValidation() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.clickOnAddProductDetailsBtn();
		Assert.assertEquals(shoppg.verifySelectVendorValidation(), "Please select vendor for product");
		System.out.println("Vendor selection validation: " + shoppg.verifySelectVendorValidation());
		shoppg.logout();
	}

	@Test(priority = 4)
	public void verifyCreateProductPageEnterVendorName() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		Assert.assertTrue(shoppg.verifyDisplayedVendorInDrpDwn());
		shoppg.logout();
	}

	@Test(priority = 5)
	public void verifyCreateProductPageSelectVendor() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		Assert.assertEquals(shoppg.verifySelectedVName(), prop.getProperty("Vendor_Name"));
		Assert.assertEquals(shoppg.verifySelectedVCompany(), prop.getProperty("Vendor_company"));
		shoppg.logout();
	}

	@Test(priority = 6)
	public void verifySubmitFirstPhase() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.logout();
	}

	@Test(priority = 7)
	public void verifySecondPageValidationsInEnglish() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.clickOnNxtForDanishBtn();
		Assert.assertEquals(shoppg.checkInventoryTitleValInEngl(), "Title is required.");
		Assert.assertEquals(shoppg.checkshortDescValInEngl(), "Short description is required.");
		Assert.assertEquals(shoppg.checkDescValInEngl(), "Description is required.");
		Assert.assertEquals(shoppg.checkTermsAndCondValInEngl(), "Terms is required.");
		Assert.assertEquals(shoppg.checkInstructionInEngl(), "Instruction is required.");
		shoppg.logout();
	}

	@Test(priority = 8)
	public void verifySecondPageValidationsInDanish() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.clickOnDanishTabBar();
		shoppg.clickOnNextForArabicBtn();
		Assert.assertEquals(shoppg.checkInventoryTitleValInDani(), "Title is required.");
		Assert.assertEquals(shoppg.checkshortDescValInDani(), "Short description is required.");
		Assert.assertEquals(shoppg.checkDescValInDani(), "Description is required.");
		Assert.assertEquals(shoppg.checkTermsAndCondValInDani(), "Terms is required.");
		Assert.assertEquals(shoppg.checkInstructionInDani(), "Instruction is required.");
		shoppg.logout();
	}

	@Test(priority = 9)
	public void verifySecondPageValidationsInArabic() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.clickOnArabicTabBar();
		shoppg.clickOnNextStepBtn();
		Assert.assertEquals(shoppg.checkInventoryTitleValInArabi(), "Title is required.");
		Assert.assertEquals(shoppg.checkshortDescValInArabi(), "Short description is required.");
		Assert.assertEquals(shoppg.checkDescValInArabi(), "Description is required.");
		Assert.assertEquals(shoppg.checkTermsAndCondValInArabi(), "Terms is required.");
		Assert.assertEquals(shoppg.checkInstructionInArabi(), "Instruction is required.");
		shoppg.logout();
	}

	@Test(priority = 10)
	public void verifySecondPageWithEnterData() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.enterValidDataInEnglish(prop.getProperty("ProdTitleEnglish"), prop.getProperty("ProdShortDescEnglish"), prop.getProperty("ProdDescEnglish"), prop.getProperty("ProdTermsEnglish"), prop.getProperty("prodInstructionEnglish"));
		shoppg.clickOnNxtForDanishBtn();
		shoppg.enterValidDataInDanish(prop.getProperty("ProdTitleDanish"), prop.getProperty("ProdShortDescDanish"), prop.getProperty("ProdDescDanish"), prop.getProperty("ProdTermsDanish"), prop.getProperty("prodInstructionDanish"));
		shoppg.clickOnNextForArabicBtn();
		shoppg.enterValidDataInArabic(prop.getProperty("ProdTitleArabic"), prop.getProperty("ProdShortDescArabic"), prop.getProperty("ProdDescArabic"), prop.getProperty("ProdTermsArabic"), prop.getProperty("prodInstructionArabic"));
		shoppg.clickOnNextStepBtn();
		shoppg.logout();
	}

	@Test(priority = 11)
	public void verifyThirdPageValidation() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.enterValidDataInEnglish(prop.getProperty("ProdTitleEnglish"), prop.getProperty("ProdShortDescEnglish"), prop.getProperty("ProdDescEnglish"), prop.getProperty("ProdTermsEnglish"), prop.getProperty("prodInstructionEnglish"));
		shoppg.clickOnNxtForDanishBtn();
		shoppg.enterValidDataInDanish(prop.getProperty("ProdTitleDanish"), prop.getProperty("ProdShortDescDanish"), prop.getProperty("ProdDescDanish"), prop.getProperty("ProdTermsDanish"), prop.getProperty("prodInstructionDanish"));
		shoppg.clickOnNextForArabicBtn();
		shoppg.enterValidDataInArabic(prop.getProperty("ProdTitleArabic"), prop.getProperty("ProdShortDescArabic"), prop.getProperty("ProdDescArabic"), prop.getProperty("ProdTermsArabic"), prop.getProperty("prodInstructionArabic"));
		shoppg.clickOnNextStepBtn();
		shoppg.clickOnCreateProduct();
		shoppg.logout();
	}

	@Test(priority = 12)
	public void verifyThirdPageCheckUploadImageValidation() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.enterValidDataInEnglish(prop.getProperty("ProdTitleEnglish"), prop.getProperty("ProdShortDescEnglish"), prop.getProperty("ProdDescEnglish"), prop.getProperty("ProdTermsEnglish"), prop.getProperty("prodInstructionEnglish"));
		shoppg.clickOnNxtForDanishBtn();
		shoppg.enterValidDataInDanish(prop.getProperty("ProdTitleDanish"), prop.getProperty("ProdShortDescDanish"), prop.getProperty("ProdDescDanish"), prop.getProperty("ProdTermsDanish"), prop.getProperty("prodInstructionDanish"));
		shoppg.clickOnNextForArabicBtn();
		shoppg.enterValidDataInArabic(prop.getProperty("ProdTitleArabic"), prop.getProperty("ProdShortDescArabic"), prop.getProperty("ProdDescArabic"), prop.getProperty("ProdTermsArabic"), prop.getProperty("prodInstructionArabic"));
		shoppg.clickOnNextStepBtn();
		shoppg.clickOnCreateProduct();
		Assert.assertEquals(shoppg.checkUploadImageVal(), "Please upload a product image!");
		shoppg.logout();
	}

	@Test(priority = 13)
	public void verifyThirdPageCheckCateAndQuantityValidation() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.enterValidDataInEnglish(prop.getProperty("ProdTitleEnglish"), prop.getProperty("ProdShortDescEnglish"), prop.getProperty("ProdDescEnglish"), prop.getProperty("ProdTermsEnglish"), prop.getProperty("prodInstructionEnglish"));
		shoppg.clickOnNxtForDanishBtn();
		shoppg.enterValidDataInDanish(prop.getProperty("ProdTitleDanish"), prop.getProperty("ProdShortDescDanish"), prop.getProperty("ProdDescDanish"), prop.getProperty("ProdTermsDanish"), prop.getProperty("prodInstructionDanish"));
		shoppg.clickOnNextForArabicBtn();
		shoppg.enterValidDataInArabic(prop.getProperty("ProdTitleArabic"), prop.getProperty("ProdShortDescArabic"), prop.getProperty("ProdDescArabic"), prop.getProperty("ProdTermsArabic"), prop.getProperty("prodInstructionArabic"));
		shoppg.clickOnNextStepBtn();
		shoppg.clickOnCreateProduct();
		Assert.assertEquals(shoppg.checkCategoryVal(), "Please select category");
		Assert.assertEquals(shoppg.checkQuantityVal(), "Quantity is must be required.");
		shoppg.logout();
	}

	@Test(priority = 14)
	public void verifyThirdPageCheckPurchaseAndSellCostValidation() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.enterValidDataInEnglish(prop.getProperty("ProdTitleEnglish"), prop.getProperty("ProdShortDescEnglish"), prop.getProperty("ProdDescEnglish"), prop.getProperty("ProdTermsEnglish"), prop.getProperty("prodInstructionEnglish"));
		shoppg.clickOnNxtForDanishBtn();
		shoppg.enterValidDataInDanish(prop.getProperty("ProdTitleDanish"), prop.getProperty("ProdShortDescDanish"), prop.getProperty("ProdDescDanish"), prop.getProperty("ProdTermsDanish"), prop.getProperty("prodInstructionDanish"));
		shoppg.clickOnNextForArabicBtn();
		shoppg.enterValidDataInArabic(prop.getProperty("ProdTitleArabic"), prop.getProperty("ProdShortDescArabic"), prop.getProperty("ProdDescArabic"), prop.getProperty("ProdTermsArabic"), prop.getProperty("prodInstructionArabic"));
		shoppg.clickOnNextStepBtn();
		shoppg.clickOnCreateProduct();
		Assert.assertEquals(shoppg.checkPurchaseCostVal(), "Per unit purchase cost is must be required");
		Assert.assertEquals(shoppg.checkSellCostVal(), "Per unit sell cost is must be required");
		shoppg.logout();
	}

	@Test(priority = 15)
	public void verifyThirdPageUploadedImageIsDisplayed() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
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
		shoppg.logout();
	}

	@Test(priority = 16)
	public void verifyThirdPageUserRedemptionLimitValidation() throws InterruptedException {
		shoppg.clickOnCreateProductBtn();
		shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
		shoppg.clickOnDisplayedVendorName();
		shoppg.clickOnAddProductDetailsBtn();
		shoppg.enterValidDataInEnglish(prop.getProperty("ProdTitleEnglish"), prop.getProperty("ProdShortDescEnglish"), prop.getProperty("ProdDescEnglish"), prop.getProperty("ProdTermsEnglish"), prop.getProperty("prodInstructionEnglish"));
		shoppg.clickOnNxtForDanishBtn();
		shoppg.enterValidDataInDanish(prop.getProperty("ProdTitleDanish"), prop.getProperty("ProdShortDescDanish"), prop.getProperty("ProdDescDanish"), prop.getProperty("ProdTermsDanish"), prop.getProperty("prodInstructionDanish"));
		shoppg.clickOnNextForArabicBtn();
		shoppg.enterValidDataInArabic(prop.getProperty("ProdTitleArabic"), prop.getProperty("ProdShortDescArabic"), prop.getProperty("ProdDescArabic"), prop.getProperty("ProdTermsArabic"), prop.getProperty("prodInstructionArabic"));
		shoppg.clickOnNextStepBtn();
		shoppg.enableRedemptionLimitToggle();
		shoppg.clickOnCreateProduct();
		Assert.assertEquals(shoppg.checkUserRedemptionLimitVal(), "User limit is required for limited redemption type");
		shoppg.logout();
	}

	//Create Product
	@Test(priority = 17)
	public void createInventoryStoreProduct() {
		try {			
			shoppg.clickOnCreateProductBtn();
			shoppg.enterVendorNameInField(prop.getProperty("Vendor_Name"));
			shoppg.clickOnDisplayedVendorName();
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

	@Test(priority = 18)
	public void verifyCreatedProductTitle() {
		try {
			Assert.assertEquals(shoppg.verifyCreatedOfferTitle(), prop.getProperty("ProdTitleEnglish"));

			shoppg.logout();
		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@Test(priority = 19)
	public void verifyCreatedProductVendorname() throws InterruptedException {
		Assert.assertEquals(shoppg.verifyCreatedOfferVName(), prop.getProperty("vendorNameAssertion"));
		shoppg.logout();
	}

	@Test(priority = 20)
	public void verifyCreatedProductCategory() throws InterruptedException {
		Assert.assertEquals(shoppg.verifyCreatedOfferCategory(), prop.getProperty("productCategory"));
		shoppg.logout();
	}

	@AfterMethod
	public void tearDown()	{
		driver.quit();
	}
}
