package easyr.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import easyr.qa.base.TestBase;

public class EasyROrganizationPage extends TestBase{

	Actions act;

	@FindBy(xpath = "(//a[@aria-expanded='true'])[7]")
	WebElement Organizations;
	@FindBy(xpath = "//span[text()='organizations']")
	WebElement textOnPage;
	@FindBy(xpath = "//button[text()='Create Organization']")
	WebElement clickOnCreateOrganizationBtn;
	@FindBy(xpath = "//button[text()='Select File']")
	WebElement clickOnSelectFile;
	@FindBy(xpath = "//input[@title='Select Organization']")
	WebElement ChooseFile;
	@FindBy(xpath = "//button[text()='Save Image']")
	WebElement clickOnSaveImgBtn;
	@FindBy(xpath = "//input[@placeholder='Organization Name']")
	WebElement orgName;
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement orgEmail;
	@FindBy(xpath = "//input[@placeholder='Phone']")
	WebElement orgPhone;
	@FindBy(xpath = "//input[@placeholder='Select Address']")
	WebElement orgAddress;
	@FindBy(xpath = "//div[@data-placeholder='Description in English']")
	WebElement descInEng;
	@FindBy(xpath = "//button[text()='Danish']")
	WebElement clickOnDan;
	@FindBy(xpath = "//div[@data-placeholder='Description in Danish']")
	WebElement descInDan;
	@FindBy(xpath = "//button[text()='Arabic']")
	WebElement clickOnArabic;
	@FindBy(xpath = "//div[@data-placeholder='Description in Arabic']")
	WebElement descInAra;
	@FindBy(xpath = "//input[@placeholder='Organization Website']")
	WebElement orgWebsite;
	@FindBy(xpath = "//button[text()='Add Organization']")
	WebElement clickOnAddOrgBtn;

	@FindBy(xpath = "(//a[contains(@class,'whitespace-normal')])[1]")
	WebElement createdOrgName;
	@FindBy(xpath = "(//div[contains(@class,'whitespace-normal')])[1]")
	WebElement createdOrgEmail;

	@FindBy(xpath = "(//a[@aria-expanded='true'])[8]")
	WebElement Donation;




	public EasyROrganizationPage() {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}


	//Actions
	public String verifyTextOnMenuBar() {
		return Organizations.getText();
	}

	public String verifyTextOnPage() {
		return textOnPage.getText();
	}

	public void clickOnCreateOrganizationBtn() {
		clickOnCreateOrganizationBtn.click();
	}

	public void clickOnSelectOrgImgFileBtn() {
		clickOnSelectFile.click();
	}

	public void enterImgFilePath(String orgImg) {
		ChooseFile.sendKeys(orgImg);
	}

	public void clickOnSaveImageBtn() {
		clickOnSaveImgBtn.click();
	}

	public void enterOrgName(String orgsName) {
		orgName.sendKeys(orgsName);
	}

	public void enterOrgEmail(String orgsEmail) {
		orgEmail.sendKeys(orgsEmail);
	}

	public void enterOrgPhone(String orgsPhone) {
		orgPhone.sendKeys(orgsPhone);
	}

	public void enterOrgAddress(String Address) throws InterruptedException {
		act.sendKeys(orgAddress, Address).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();	
	}

	public void enterDescInEng(String orgDescInEng) {
		descInEng.sendKeys(orgDescInEng);
	}

	public void clickOnDanishBtn() {
		clickOnDan.click();
	}

	public void enterDescInDan(String orgDescInDan) {
		descInDan.sendKeys(orgDescInDan);
	}

	public void clickOnArabicBtn() {
		clickOnArabic.click();
	}

	public void enterDescInArab(String orgDescInAra) {
		descInAra.sendKeys(orgDescInAra);
	}

	public void enterOrgWebsite(String orgsWebsite) {
		orgWebsite.sendKeys(orgsWebsite);	
	}

	public void clickOnAddOrganizationBtn() throws InterruptedException {
		clickOnAddOrgBtn.click();
		Thread.sleep(3000);
	}

	public String verifyCreatedOrgName() {
		return createdOrgName.getText();
	}

	public String verifyCreatedOrgEmail() {
		return createdOrgEmail.getText();
	}
	
	public EasyRDonationPage clickOnDonationTab() {
		Donation.click();
		return new EasyRDonationPage();
	}
	
}
