package easyr.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import easyr.qa.base.TestBase;

public class EasyRDonationPage extends TestBase{

	Actions act;
	@FindBy(xpath = "(//a[@aria-expanded='true'])[8]")
	WebElement Donation;
	@FindBy(xpath = "//span[text()='donations']")
	WebElement donationTextOnPage;
	@FindBy(xpath = "//button[text()='Create Donation']")
	WebElement createDonationBtn;
	@FindBy(xpath = "//input[@placeholder='Search organization by Name...']")
	WebElement enterOrgName;
	@FindBy(xpath = "//span[contains(@class,'text-easyRPrimary/70')]")
	WebElement clickOnViewOrg;
	@FindBy(xpath = "(//span[contains(@class,'font-semibold text-sla')])[1]")
	WebElement verifyOrgName;
	@FindBy(xpath = "(//span[contains(@class,'font-semibold text-sla')])[2]")
	WebElement verifyOrgEmail;
	@FindBy(xpath = "//button[text()='Add Donation Details']")
	WebElement clickOnAddDonationDetailsBtn;		
	@FindBy(xpath = "//input[@placeholder='Title in English']")
	WebElement titleInEng;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in English']")
	WebElement shortDescInEng;
	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
	WebElement whoAreWrInEng;
	@FindBy(xpath = "//div[@data-placeholder='\"What we need\" content in English']")
	WebElement whatWeNeedInEng;
	@FindBy(xpath = "//button[text()='Next For Danish']")
	WebElement nxtForDanish;
	@FindBy(xpath = "//input[@placeholder='Title in Danish']")
	WebElement titleInDan;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in Danish']")
	WebElement shortDescInDan;
	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
	WebElement whoAreWrInDan;
	@FindBy(xpath = "//div[@data-placeholder='\"What we need\" content in Danish']")
	WebElement whatWeNeedInDan;
	@FindBy(xpath = "//button[text()='Next For Arabic']")
	WebElement nxtForArabic;
	@FindBy(xpath = "//input[@placeholder='Title in Arabic']")
	WebElement titleInArab;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in Arabic']")
	WebElement shortDescInArab;
	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[1]")
	WebElement whoAreWrInArab;
	@FindBy(xpath = "//div[@data-placeholder='\"What we need\" content in Arabic']")
	WebElement whatWeNeedInArab;
	@FindBy(xpath = "//button[text()='Next Step ']")
	WebElement nxtStep;
	@FindBy(xpath = "//input[@id='image']")
	WebElement chooseDonationImgFile;
	@FindBy(xpath = "//div[text()='Donate Category']")
	WebElement donateCate;
	@FindBy(xpath = "//input[@placeholder='Minimum Donation (Kr.)']")
	WebElement minDonation;
	@FindBy(xpath = "//input[@placeholder='Maximum Donation (Kr.)']")
	WebElement maxDonation;
	@FindBy(xpath = "//input[@placeholder='Targeted Donation (Kr.)']")
	WebElement donationTarget;
	@FindBy(xpath = "//button[text()='Create Donation']")
	WebElement CreateDonationBtn;
	@FindBy(xpath = "(//a[contains(@rel,'noreferrer')])[1]")
	WebElement verifyCreatedDonationName;
	@FindBy(xpath = "(//div[contains(@Class,'py-1 px-2 text-xs rounded-1.8 whit')])[1]")
	WebElement verifyCreatedDonationOrg;
	@FindBy(xpath = "(//div[contains(@Class,'break-words whitespace-normal flex just')])[1]")
	WebElement verifyCreatedDonationCat;


	//constructor
	public EasyRDonationPage() {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	//Actions
	public String verifyDonationTextOnMenuBar() {
		return Donation.getText();
	}

	public String verifyDonationTextOnPage() {
		return donationTextOnPage.getText();
	}

	public void clickOncreateDonationBtn() {
		createDonationBtn.click();
	}

	public void enterOrgName(String orgName) {
		enterOrgName.sendKeys(orgName);
	}
	
	public void clickOnViewOrg() {
		clickOnViewOrg.click();
	}
	
	public String verifyOrgName() {
		return verifyOrgName.getText();
	}
	
	public String verifyOrgEmail() {
		return verifyOrgEmail.getText();
	}
	
	public void clickOnAddDonationDetails() {
		clickOnAddDonationDetailsBtn.click();
	}
	
	public void enterDatainEnglish(String orgTitleEng, String orgShortDescEng, String orgWhoAreWeEng, String orgWhatWeNeedEng) {
		titleInEng.sendKeys(orgTitleEng);
		shortDescInEng.sendKeys(orgShortDescEng);
		whoAreWrInEng.sendKeys(orgWhoAreWeEng);
		whatWeNeedInEng.sendKeys(orgWhatWeNeedEng);
	}
	
	public void clickOnNxtForDanishBtn() {
		nxtForDanish.click();
	}
	
	public void enterDanishData(String orgTitleDan, String orgShortDescDan, String orgWhoAreWeDan, String orgWhatWeNeedDan) {
		titleInDan.sendKeys(orgTitleDan);
		shortDescInDan.sendKeys(orgShortDescDan);
		whoAreWrInDan.sendKeys(orgWhoAreWeDan);
		whatWeNeedInDan.sendKeys(orgWhatWeNeedDan);
	}
	
	public void clickOnNxtForArabicBtn() {
		nxtForArabic.click();
	}
	
	public void enterDataInArabic(String orgTitleArab, String orgShortDescArab, String orgWhoAreWeArab, String orgWhatWeNeedArab) {
		titleInArab.sendKeys(orgTitleArab);
		shortDescInArab.sendKeys(orgShortDescArab);
		whoAreWrInArab.sendKeys(orgWhoAreWeArab);
		whatWeNeedInArab.sendKeys(orgWhatWeNeedArab);
	}

	public void clickOnNextstep() {
		nxtStep.click();
	}

	public void enterDonationImage(String DonationImg) {
		chooseDonationImgFile.sendKeys(DonationImg);
	}
	
	public void selectDonateCate(String DonateCat) throws InterruptedException {
		act.sendKeys(donateCate, DonateCat).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	}
	
	public void enterMinDonation(String minDonate) {
		minDonation.sendKeys(minDonate);
	}
	
	public void enterMaxDonation(String maxDonate) {
		maxDonation.sendKeys(maxDonate);
	}
	
	public void enterDonationTarget(String targetDonate) {
		donationTarget.sendKeys(targetDonate);
	}
	
	public void clickOnCreateDonationBtn() throws InterruptedException {
		createDonationBtn.click();
		Thread.sleep(5000);
	}
	
	public String verifyDonationTitle() {
		return verifyCreatedDonationName.getText();
	}
	
	public String verifyDonationOrganization() {
		return verifyCreatedDonationOrg.getText();
	}
	
	public String verifyDonationCategory() {
		return verifyCreatedDonationCat.getText();
	}
}
