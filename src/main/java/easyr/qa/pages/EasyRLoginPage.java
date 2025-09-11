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
	
	public EasyRDashboardPage clickOnLoginbtn(String email, String pwd) {
		enterEmail.sendKeys(email);
		EasyrPwd.sendKeys(pwd);
		LoginBtn.click();
		return new EasyRDashboardPage();
	}
}
