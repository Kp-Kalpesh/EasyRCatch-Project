package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("Email"), prop.getProperty("Password"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
		shoppg = offerpg.clickOnProductStore();
	}


	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
