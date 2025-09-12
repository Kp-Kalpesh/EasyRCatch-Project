package easyr.qa.testCases;

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
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("Email"), prop.getProperty("Password"));
		vendrpg = dashpg.clickOnVendors();
	}

	@Test
	public void verifyCreatVendor() {
		try {
			Assert.assertEquals(vendrpg.verifyPageTitle(), "EasyR Catch");
			System.out.println("vendrpg.verifyPageTitle(): " + vendrpg.verifyPageTitle());
			Assert.assertEquals(vendrpg.verifyVendorText(), "VENDORS");
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

			Assert.assertEquals(vendrpg.CreatedVendorName(), prop.getProperty("Vendor_Name"));
			Assert.assertEquals(vendrpg.CreatedVendorComapnyName(), prop.getProperty("Vendor_company"));
			Assert.assertEquals(vendrpg.CreatedVendorEmail(), prop.getProperty("vEmail"));
		}catch(Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
