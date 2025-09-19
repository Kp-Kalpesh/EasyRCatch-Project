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
import easyr.qa.pages.EasyRVendorPage;
import junit.framework.Assert;

public class EasyRVendorPageTest extends TestBase{
	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;
	EasyRVendorPage vendrpg;

	public EasyRVendorPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpg = new EasyRLoginPage();
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		vendrpg = dashpg.clickOnVendors();
	}

	@Test(priority = 1)
	public void verifyVendorLogoValidation() {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The vendor logo validation is not displayed", vendrpg.displayedVendorLogo());
		Assert.assertEquals(vendrpg.verifyVendorLogoFieldValidation(), "Please upload vendor logo!");
	}

	@Test(priority = 2)
	public void verifyVendorProfileValidation() {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The Vendor Profile validation is not displayed", vendrpg.displayedVendorProfileValidation());
		Assert.assertEquals(vendrpg.verifyVendorProfileFieldValidation(), "Please upload vendor image!");
	}

	@Test(priority = 3)
	public void verifyVendorNameValidation() {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("Vendor Name validation is not displayed", vendrpg.displayedVendorNameFieldValidation());
		Assert.assertEquals(vendrpg.verifyVendorNameFieldValidation(), "Vendor Name is required!");
	}

	@Test(priority = 4)
	public void verifyCompanyNameFieldValidation() {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The company name validation is not displayed", vendrpg.displayedCompanyNameFieldValidation());
		Assert.assertEquals(vendrpg.verifyCompanyNameFieldValidation(), "Company Name is required!");
	}

	@Test(priority = 5)
	public void verifyEmailFieldValidation() {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The Email fiedl validation is not displayed", vendrpg.displayedVendorBlankEmailValidation());
		Assert.assertEquals(vendrpg.verifyVendorEmailBlankFieldValidation(), "Email address is required");
	}

	@Test(priority = 6)
	public void verifyInvalidEmailFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		vendrpg.enterEmail("easyr@123");
		Assert.assertTrue("The Invalid Email data field validation is not displayed", vendrpg.displayedVendorInvalidEmailValidation());
		Assert.assertEquals(vendrpg.verifyVendorInvalidEmailFieldValidation(), "Invalid email address");
	}

	@Test(priority = 7)
	public void verifyMobileFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The Mobile field validation is not displayed", vendrpg.displayedBlankMobileNoValidation());
		Assert.assertEquals(vendrpg.verifyMobileNoBlankFieldValidation(), "Mobile number is required");
	}

	@Test(priority = 8)
	public void verifyMobileNoFieldBlankSpaceValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		vendrpg.enterPhone("     ");
		Assert.assertTrue("The Mobile no field with balnk space validation is not displayed", vendrpg.displayedMobileNoBlankSpaceValidation());
		Assert.assertEquals(vendrpg.verifyMobileNoBlankSpaceFieldValidation(), "Please enter valid phone number");
	}

	@Test(priority = 9)
	public void verifyInvalidMobileNoFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		vendrpg.enterPhone("hscbsdcf");
		Assert.assertTrue("The Invalid mobile no field validation is not displayed", vendrpg.displayedInvalidMobileNoValidation());
		Assert.assertEquals(vendrpg.verifyInvalidMobileNoFieldValidation(), "Mobile number can only contain numbers");
	}

	@Test(priority = 10)
	public void verifySelectAddressFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The Select Address field validation is not displayed", vendrpg.displayedSelectAddressFieldValidation());
		Assert.assertEquals(vendrpg.verifySelectAddressFieldValidation(), "Please select suggested address only!");
	}

	@Test(priority = 11)
	public void verifyVendorCategoryFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The Vendor Category field validation is not displayed", vendrpg.displayedVendorCategoryValidation());
		Assert.assertEquals(vendrpg.verifyVendorCategoryFieldValidation(), "Vendor Category is required");
	}

	@Test(priority = 12)
	public void verifyBlankCompanyWebsiteFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The Company Website field validation is not displayed", vendrpg.displayedCompanyWebsiteBlankFieldValidation());
		Assert.assertEquals(vendrpg.verifyCompanyWebsiteBlankFieldValidation(), "Company website is required");
	}

	@Test(priority = 13)
	public void verifyInvalidCompanyWebsiteFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		vendrpg.enterCompanyWebsite("sdcscsdu");
		Assert.assertTrue("The Invalid Company Website field validation is not displayed", vendrpg.displayedInvalidCompanyWebsiteValidation());
		Assert.assertEquals(vendrpg.verifyInvalidCompanyWebsiteFieldValidation(), "Enter correct url!");
	}

	@Test(priority = 14)
	public void verifyParentVendorFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		vendrpg.clickOnvendortypeAsSubVendorToggle();
		Assert.assertTrue("The Parent Vendor field validation is not displayed", vendrpg.displayedParentVendorValidation());
		Assert.assertEquals(vendrpg.verifyParentVendorFieldValidation(), "Parent Vendor Is Required When Vendor Type Is Sub Vendor");
	}

	@Test(priority = 15)
	public void verifyDescInEnglishFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The English lang Description field validation is not displayed", vendrpg.displayedDescInEnglishValidation());
		Assert.assertEquals(vendrpg.verifyDescInEnglishFieldValidation(), "Description in English is required");
	}

	@Test(priority = 16)
	public void verifyDescInDanishFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		vendrpg.clickOnDanishBt();
		Assert.assertTrue("The Danish lang Description field validation is not displayed", vendrpg.displayedDescInDanishValidation());
		Assert.assertEquals(vendrpg.verifyDescInDanishFieldValidation(), "Description in Danish is required");
	}

	@Test(priority = 17)
	public void verifyDescInArabicFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		vendrpg.clickOnArabicBt();
		Assert.assertTrue("The Arabic lang Description field validation is not displayed", vendrpg.displayedDescInArabicValidation());
		Assert.assertEquals(vendrpg.verifyDescInArabicFieldValidation(), "Description in Arabic is required");
	}

	@Test(priority = 18)
	public void verifySearchTagsFieldValidation() throws InterruptedException {
		vendrpg.clickOnCreateVendorBtn();
		vendrpg.clickOnAddVendor();
		Assert.assertTrue("The Search Tags field validation is not displayed", vendrpg.displayedSearchTagsFieldValidation());
		Assert.assertEquals(vendrpg.verifySearchTagFieldValidation(), "At least one tag must be specified!");
	}

	//Create Vendor
	@Test(priority = 19)
	public void verifyCreatVendor() {
		try {
			AssertJUnit.assertEquals(vendrpg.verifyPageTitle(), "EasyR Catch");
			System.out.println("vendrpg.verifyPageTitle(): " + vendrpg.verifyPageTitle());
			AssertJUnit.assertEquals(vendrpg.verifyVendorText(), "VENDORS");
			System.out.println("vendrpg.verifyVendorText(): " + vendrpg.verifyVendorText());

			vendrpg.clickOnCreateVendorBtn(); vendrpg.clickOnVendorLogoSelectFile();
			vendrpg.sendFileToVendorLogoField(prop.getProperty("Vendor_logo"));
			vendrpg.clickOnSaveImageBtn(); vendrpg.clickOnProfileSelectFile();
			vendrpg.sendVendorProfileField(prop.getProperty("Vendor_profile"));
			vendrpg.clickOnSaveImageVendorProfile();
			vendrpg.enterVendorName(prop.getProperty("Vendor_Name"));
			vendrpg.enterCName(prop.getProperty("Vendor_company"));
			vendrpg.enterEmail(prop.getProperty("vEmail"));
			vendrpg.enterPhone(prop.getProperty("vPhone"));
			vendrpg.selectAddress(prop.getProperty("vAddress"));
			vendrpg.selectCategory(prop.getProperty("Category"));
			vendrpg.selectSubCategory(prop.getProperty("SubCategory"));
			vendrpg.enterCompanyWebsite(prop.getProperty("CompWebsite"));
			vendrpg.enterDisplayLink(prop.getProperty("DisplayLink"));
			vendrpg.enterDescription(prop.getProperty("EnglishDesc"),
					prop.getProperty("DanishDesc"), prop.getProperty("Arabicdesc"));
			vendrpg.enterTags(prop.getProperty("Tags"));
			vendrpg.clickOnAddVendor();
			vendrpg.clickOnVisibleVendorDrpDwn();

			AssertJUnit.assertEquals(vendrpg.CreatedVendorName(), prop.getProperty("Vendor_Name"));
			AssertJUnit.assertEquals(vendrpg.CreatedVendorComapnyName(), prop.getProperty("Vendor_company"));
			AssertJUnit.assertEquals(vendrpg.CreatedVendorEmail(), prop.getProperty("vEmail"));
			vendrpg.logout();
		}catch(Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	//View Vendor
	@Test(priority = 20)
	public void verifyDisplayedVendorActiveStatusToggle() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		Assert.assertTrue("The Vendor Active status toggle is not displayed", vendrpg.displayedActiveStatusToggle());
	}

	@Test(priority = 21)
	public void verifyDisplayedVendorViewIcon() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		Assert.assertTrue("The Vendro View Icon is not displayed", vendrpg.displayedViewActionicon());
	}

	@Test(priority = 22)
	public void verifyDisplayedVendorAnalystIcon() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		Assert.assertTrue("The Vendro Analyst Icon is not displayed", vendrpg.displayedAnalyticsActionIcon());
	}

	@Test(priority = 23)
	public void verifyDisplayedVendorQRCodeIcon() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		Assert.assertTrue("The Vendro QR Code Icon is not displayed", vendrpg.displayedVendorQrActionIcon());
	}

	@Test(priority = 24)
	public void verifyDisplayedVendorEditIcon() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		Assert.assertTrue("The Vendro Edit Icon is not displayed", vendrpg.displayedEditVendorActionIcon());
	}

	@Test(priority = 25)
	public void verifyDisplayedChangePwdIcon() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		Assert.assertTrue("The Vendro Change Password Icon is not displayed", vendrpg.displayedChangePwdActionIcon());
	}

	@Test(priority = 26)
	public void verifyDisplayedDeleteIcon() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		Assert.assertTrue("The Vendro Delete Icon is not displayed", vendrpg.displayedDeleteActionIcon());
	}

	@Test(priority = 27)
	public void clickOnViewVendorIcon() throws InterruptedException {
		vendrpg.clickOnVisibleVendorDrpDwn();
		vendrpg.clickOnViewActionicon();
	}


	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
}
