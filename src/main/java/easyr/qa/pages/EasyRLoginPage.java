package easyr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import easyr.qa.base.TestBase;

public class EasyRLoginPage extends TestBase{

	@FindBy(xpath = "//h4[text()='Sign In']")
	WebElement signInText;
	@FindBy(xpath = "//img[@alt='easyr-logo']")
	WebElement EasyrLogo;
	@FindBy(xpath = "//input[contains(@placeholder,'Email')]")
	WebElement enterEmail;
	@FindBy(xpath = "//input[contains(@placeholder,'Password')]")
	WebElement EasyrPwd;
	@FindBy(xpath = "//label[text()='Remember me']")
	WebElement rememberMeToggle;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement LoginBtn;
	@FindBy(xpath = "//div[text()='Invalid email/password combination provided, please try again']")
	WebElement loginErrorMessage;
	@FindBy(xpath = "//div[text()='Invalid email address']")
	WebElement invalidEmail;
	@FindBy(xpath = "//div[text()='Password is required!']")
	WebElement invalidPwd;
	@FindBy(xpath = "//div[text()='Email is required!']")
	WebElement requiredEmail;
	//Logout
	@FindBy(xpath = "//p[text()='Super Admin']")
	WebElement clickOnSuperAdmintxt;
	@FindBy(xpath = "//button[text()='Log Out']")
	WebElement logouttxt;


	//Constructor
	public EasyRLoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions	
	public String verifySignInText() {
		return signInText.getText();
	}

	public boolean verifyEasyRLogo() {
		return EasyrLogo.isDisplayed();
	}

	public void enterEmail(String email) {
		enterEmail.sendKeys(email);
	}

	public void enterPass(String pwd) {
		EasyrPwd.sendKeys(pwd);
	}

	public void clickOnRemembeeMe() {
		rememberMeToggle.click();
	}

	public void clickOnLoginButton() {
		LoginBtn.click();
	}

	public EasyRDashboardPage clickOnLoginbtn(String email, String pwd) {
		enterEmail.sendKeys(email);
		EasyrPwd.sendKeys(pwd);
		LoginBtn.click();
		return new EasyRDashboardPage();
	}

	public boolean errorMessageIsDisplayed() {
		return loginErrorMessage.isDisplayed();
	}

	public String verifyErrorMessage() {
		return loginErrorMessage.getText();
	}

	public boolean invalidEmailIsDisplayed() {
		return invalidEmail.isDisplayed();
	}

	public String verifyInvalidEmail() {
		return invalidEmail.getText();
	}

	public boolean invalidPwdIsDisplayed() {
		return invalidPwd.isDisplayed();
	}

	public String verifyPwdErrorMessage() {
		return invalidPwd.getText();
	}

	public boolean displayedEmailValidation() {
		return requiredEmail.isDisplayed();
	}

	public String verifyEmailValidation() {
		return requiredEmail.getText();
	}

	public boolean superAdminTextIsDisplayed() throws InterruptedException {
		Thread.sleep(1000);
		return clickOnSuperAdmintxt.isDisplayed();
	}

	public void clickOnSuperAdminTxt() {
		clickOnSuperAdmintxt.click();
	}

	public boolean LogoutTextisDisplayed() throws InterruptedException {
		Thread.sleep(1000);
		return logouttxt.isDisplayed();
	}

	public void logout() throws InterruptedException {
		logouttxt.click();
		Thread.sleep(1000);

	}
}


