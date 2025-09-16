package easyr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import easyr.qa.base.TestBase;

public class EasyRDashboardPage extends TestBase{

	@FindBy(xpath = "//span[text()='dashboard']")
	WebElement DashboardPageText;
	@FindBy(xpath = "//div[text()='Welcome Super Admin to EasyR Admin']")
	WebElement verifyLoginSuccessfullyMessage;
	@FindBy(xpath = "(//a[@aria-expanded='true'])[2]")
	WebElement VendorsText;

	//Logout
	@FindBy(xpath = "//p[text()='Super Admin']")
	WebElement clickOnSuperAdmintxt;
	@FindBy(xpath = "//button[text()='Log Out']")
	WebElement logouttxt;


	public EasyRDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String verifySuccessfulLoginToastMessage() throws InterruptedException {
		Thread.sleep(2000);
		return verifyLoginSuccessfullyMessage.getText();
	}

	public String verifyDashboardTextOnPage() {
		return DashboardPageText.getText();
	}

	public EasyRVendorPage clickOnVendors() {
		VendorsText.click();
		return new EasyRVendorPage();
	}

	public void logout() throws InterruptedException {
		clickOnSuperAdmintxt.click();
		Thread.sleep(1000);
		logouttxt.click();
	}
}
