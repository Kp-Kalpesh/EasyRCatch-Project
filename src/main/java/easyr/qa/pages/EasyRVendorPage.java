package easyr.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import easyr.qa.base.TestBase;

public class EasyRVendorPage extends TestBase{

	@FindBy(xpath = "//span[@class='uppercase tracking-wider hover:scale-102 cursor-pointer']")
	WebElement vendorPageText;
	@FindBy(xpath="//button[contains(text(),'Create Vendor')]")
	WebElement createVendor;
	@FindBy(xpath = "(//button[text()='Select File'])[1]")
	WebElement VendorLogoSelectFile;
	@FindBy(xpath = "//input[@id='vendor_logo']")
	WebElement uploadVendorLogo;	
	@FindBy(xpath = "//button[text()='Save Image']")
	WebElement saveImageBtn;	
	@FindBy(xpath = "(//button[text()='Select File'])[2]")
	WebElement VendorProfileSelectFile;
	@FindBy(xpath = "//input[@id='vendor_image']")
	WebElement uploadVendorProfile;
	@FindBy(xpath = "//button[text()='Save Image']")
	WebElement SaveVendorProfile;

	@FindBy(xpath = "//input[contains(@placeholder,'Vendor Name')]")
	WebElement VendorName;
	@FindBy(xpath = "//input[contains(@placeholder,'Company Name')]")
	WebElement CompanyName;
	@FindBy(xpath = "//input[contains(@placeholder,'Email')]")
	WebElement Email;
	@FindBy(xpath = "//input[contains(@placeholder,'Phone')]")
	WebElement Phone;
	@FindBy(xpath = "//input[@placeholder='Select Address']")
	WebElement selectAddress;
	@FindBy(xpath = "//input[@id='vendor_category_id']")
	WebElement selectCategory;
	@FindBy(xpath = "//input[@placeholder='Company Website']")
	WebElement companyWebsite;
	@FindBy(xpath = "//input[@placeholder='Display Link']")
	WebElement displayLink;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank']//p")
	WebElement DescInEnglish;
	@FindBy(xpath = "//button[@id='headlessui-tabs-tab-:r2:']")
	WebElement danishBtn;
	@FindBy(xpath = "//div[@class='ql-editor ql-blank']//p")
	WebElement DescInDanish;
	@FindBy(xpath = "//button[@id='headlessui-tabs-tab-:r3:']")
	WebElement arabicBtn;
	@FindBy(xpath = "//div[@class='ql-editor ql-blank']//p")
	WebElement DescInArabic;
	@FindBy(xpath = "//input[@id='vendor_tag']")
	WebElement enterTags;
	@FindBy(xpath = "//button[contains(text(),'Add Vendor')]")
	WebElement addVendorBtn;

	@FindBy(xpath = "(//div[@class='css-j1q5rd'])[1]")
	WebElement vendorDrpDwn;
	@FindBy(xpath = "//input[@id='status']")
	WebElement invisible;
	//	@FindBy(xpath = "(//div[@class='css-180fuia-control'])[1]")
	//	WebElement vendorDrpDwn;
	//	@FindBy(xpath = "(//div[@class='css-180fuia-control'])[1]")
	//	WebElement vendorDrpDwn;
	//	@FindBy(xpath = "(//div[@class='css-180fuia-control'])[1]")
	//	WebElement vendorDrpDwn;


	public EasyRVendorPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public String verifyVendorText() {
		return vendorPageText.getText();
	}

	public void clickOnCreateVendorBtn() {
		createVendor.click();
	}

	public void clickOnVendorLogoSelectFile() {
		VendorLogoSelectFile.click();
	}

	public void sendFileToVendorLogoField(String vendor_logo) {
		uploadVendorLogo.sendKeys(vendor_logo);
	}

	public void clickOnSaveImageBtn() {
		saveImageBtn.click();
	}

	public void clickOnProfileSelectFile() {
		VendorProfileSelectFile.click();
	}

	public void sendVendorProfileField(String vendor_profile) {
		uploadVendorProfile.sendKeys(vendor_profile);
	}

	public void clickOnSaveImageVendorProfile() {
		SaveVendorProfile.click();
	}

	public void enterVendorName(String vName) throws InterruptedException {
		Thread.sleep(1000);
		VendorName.sendKeys(vName);	
	}

	public void enterCName(String cName) throws InterruptedException {
		Thread.sleep(1000);
		CompanyName.sendKeys(cName);
	}

	public void enterEmail(String email) throws InterruptedException{
		Thread.sleep(1000);
		Email.sendKeys(email);
	}

	public void enterPhone(String phone) throws InterruptedException{
		Thread.sleep(1000);
		Phone.sendKeys(phone);
	}

	public void selectAddress() throws InterruptedException {
		selectAddress.sendKeys("Dallas");
		Thread.sleep(2000);
		selectAddress.sendKeys(Keys.ARROW_DOWN);
		selectAddress.sendKeys(Keys.ENTER);
	}

	public void selectCategory() throws InterruptedException {
		selectCategory.sendKeys("Sports");
		Thread.sleep(2000);
		selectCategory.sendKeys(Keys.ARROW_DOWN);
		selectCategory.sendKeys(Keys.ENTER);
	}

	public void enterCompanyWebsite() {
		companyWebsite.sendKeys("https://lenskart.com");
	}

	public void enterDisplayLink() {
		displayLink.sendKeys("https://google.com");
	}

	public void enterDescription() throws InterruptedException {
		DescInEnglish.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		DescInEnglish.sendKeys("Test Data");
		danishBtn.click();
		Thread.sleep(1000);

		DescInDanish.sendKeys("Test Data");
		arabicBtn.click();
		Thread.sleep(1000);

		DescInArabic.sendKeys("Test data");
	}

	public void enterTags() {
		enterTags.sendKeys("Test Data");
		enterTags.sendKeys(Keys.ENTER);
	}

	public void clickOnAddVendor() {
		addVendorBtn.click();
	}

	public void clickOnVisibleVendorDrpDwn() throws InterruptedException {
		vendorDrpDwn.click();
		Thread.sleep(1000);		
		Actions act = new Actions(driver);
		act.sendKeys("invisible", Keys.ENTER).perform();
	}
}
