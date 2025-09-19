package easyr.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import easyr.qa.base.TestBase;

public class EasyRVendorPage extends TestBase{

	Actions act;

	//Create Vendor Validation Text messages
	@FindBy(xpath = "//span[text()='Please upload vendor logo!']")
	WebElement vendorLogoValidation;	
	@FindBy(xpath = "//span[text()='Please upload vendor image!']")
	WebElement vendorProfileValidation;		
	@FindBy(xpath = "//div[text()='Vendor Name is required!']")
	WebElement vendorNameValidation;		
	@FindBy(xpath = "//div[text()='Company Name is required!']")
	WebElement CompanyNameValidation;		
	@FindBy(xpath = "//div[text()='Email address is required']")
	WebElement vendorBlankEmailValidation;		
	@FindBy(xpath = "//div[text()='Invalid email address']")
	WebElement vendorInvalidEmailValidation;		
	@FindBy(xpath = "//div[text()='Mobile number is required']")
	WebElement vendorBlankMobileNoValidation;		
	@FindBy(xpath = "//div[text()='Please enter valid phone number']")
	WebElement MobileBlankSpaceValidation;		
	@FindBy(xpath = "//div[text()='Mobile number can only contain numbers']")
	WebElement InvalidMobileNoValidation;		
	@FindBy(xpath = "//div[text()='Please select suggested address only!']")
	WebElement selectAddressValidation;		
	@FindBy(xpath = "//div[text()='Vendor Category is required']")
	WebElement vendorCategoryValidation;		
	@FindBy(xpath = "//div[text()='Company website is required']")
	WebElement CompanyBlankWebsiteFieldValidation;		
	@FindBy(xpath = "//div[text()='Enter correct url!']")
	WebElement InvalidCompanyWebsiteValidation;		
	@FindBy(xpath = "//label[text()='Sub Vendor']")
	WebElement vendorTypeSubVendor;		
	@FindBy(xpath = "//div[text()='Parent vendor is required when vendor type is sub vendor']")
	WebElement ParentVendorValidation;		
	@FindBy(xpath = "//div[text()='Description in English is required']")
	WebElement DescInEnglishValidation;		
	@FindBy(xpath = "//div[text()='Description in Danish is required']")
	WebElement DescInDanishValidation;		
	@FindBy(xpath = "//div[text()='Description in Arabic is required']")
	WebElement DescInArabicValidation;
	@FindBy(xpath = "//div[text()='At least one tag must be specified!']")
	WebElement searchTagValidation;		



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
	@FindBy(xpath = "//div[text()='Subcategory']")
	WebElement selectSubCategory;
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
	@FindBy(xpath = "(//tbody/tr/td/div/a[contains(@class,'whitespace-normal break-words capitalize')])[1]")
	WebElement vendorNameAfterCreation;
	@FindBy(xpath = "(//tbody/tr/td/div)[2]")
	WebElement vendorCompanyAfterCreation;
	@FindBy(xpath = "(//tbody/tr/td/div)[3]")
	WebElement vendorEmailAfterCreation;
	@FindBy(xpath = "(//a[@aria-expanded='true'])[4]")
	WebElement OffersAndDeals;

	//Logout
	@FindBy(xpath = "//p[text()='Super Admin']")
	WebElement clickOnSuperAdmintxt;
	@FindBy(xpath = "//button[text()='Log Out']")
	WebElement logouttxt;



	//constructor
	public EasyRVendorPage() {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	//Validation Methods
	public boolean displayedVendorLogo() {
		return vendorLogoValidation.isDisplayed();
	}

	public String verifyVendorLogoFieldValidation() {
		return vendorLogoValidation.getText();
	}

	public boolean displayedVendorProfile() {
		return vendorProfileValidation.isDisplayed();
	}

	public String verifyVendorProfileFieldValidation() {
		return vendorProfileValidation.getText();
	}

	public boolean displayedVendorNameFieldValidation() {
		return vendorNameValidation.isDisplayed();
	}

	public String verifyVendorNameFieldValidation() {
		return vendorNameValidation.getText();
	}

	public boolean displayedCompanyNameFieldValidation() {
		return CompanyNameValidation.isDisplayed();
	}

	public String verifyCompanyNameFieldValidation() {
		return CompanyNameValidation.getText();
	}

	public boolean displayedVendorBlankEmailValidation() {
		return vendorBlankEmailValidation.isDisplayed();
	}

	public String verifyVendorEmailBlankFieldValidation() {
		return vendorBlankEmailValidation.getText();
	}

	public boolean displayedVendorInvalidEmailValidation() {
		return vendorInvalidEmailValidation.isDisplayed();
	}

	public String verifyVendorInvalidEmailFieldValidation() {
		return vendorInvalidEmailValidation.getText();
	}

	public boolean displayedBlankMobileNoValidation() {
		return vendorBlankMobileNoValidation.isDisplayed();
	}

	public String verifyMobileNoBlankFieldValidation() {
		return vendorBlankMobileNoValidation.getText();
	}

	public boolean displayedMobileNoBlankSpaceValidation() {
		return MobileBlankSpaceValidation.isDisplayed();
	}

	public String verifyMobileNoBlankSpaceFieldValidation() {
		return MobileBlankSpaceValidation.getText();
	}

	public boolean displayedInvalidMobileNoValidation() {
		return InvalidMobileNoValidation.isDisplayed();
	}

	public String verifyInvalidMobileNoFieldValidation() {
		return InvalidMobileNoValidation.getText();
	}

	public boolean displayedSelectAddressFieldValidation() {
		return selectAddressValidation.isDisplayed();
	}

	public String verifySelectAddressFieldValidation() {
		return selectAddressValidation.getText();
	}

	public boolean displayedVendorCategoryValidation() {
		return vendorCategoryValidation.isDisplayed();
	}

	public String verifyVendorCategoryFieldValidation() {
		return vendorCategoryValidation.getText();
	}

	public boolean displayedCompanyWebsiteBlankFieldValidation() {
		return CompanyBlankWebsiteFieldValidation.isDisplayed();
	}

	public String verifyCompanyWebsiteBlankFieldValidation() {
		return CompanyBlankWebsiteFieldValidation.getText();
	}

	public boolean displayedInvalidCompanyWebsiteValidation() {
		return InvalidCompanyWebsiteValidation.isDisplayed();
	}

	public String verifyInvalidCompanyWebsiteFieldValidation() {
		return InvalidCompanyWebsiteValidation.getText();
	}

	public void clickOnvendortypeAsSubVendorToggle() {
		vendorTypeSubVendor.click();
	}

	public boolean displayedParentVendorValidation() {
		return ParentVendorValidation.isDisplayed();
	}

	public String verifyParentVendorFieldValidation() {
		return ParentVendorValidation.getText();
	}

	public boolean displayedDescInEnglishValidation() {
		return DescInEnglishValidation.isDisplayed();
	}

	public String verifyDescInEnglishFieldValidation() {
		return DescInEnglishValidation.getText();
	}

	public boolean displayedDescInDanishValidation() {
		return DescInDanishValidation.isDisplayed();
	}

	public String verifyDescInDanishFieldValidation() {
		return DescInDanishValidation.getText();
	}

	public boolean displayedDescInArabicValidation() {
		return DescInArabicValidation.isDisplayed();
	}

	public String verifyDescInArabicFieldValidation() {
		return DescInArabicValidation.getText();
	}	

	public boolean displayedSearchTagsFieldValidation() {
		return searchTagValidation.isDisplayed();
	}

	public String verifySearchTagFieldValidation() {
		return searchTagValidation.getText();
	}
	
	

	//Actions
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

	public void selectAddress(String city) throws InterruptedException {
		selectAddress.sendKeys(city);
		Thread.sleep(2000);
		selectAddress.sendKeys(Keys.ARROW_DOWN);
		selectAddress.sendKeys(Keys.ENTER);
	}

	public void selectCategory(String category) throws InterruptedException {
		selectCategory.sendKeys(category);
		Thread.sleep(2000);
		selectCategory.sendKeys(Keys.ARROW_DOWN);
		selectCategory.sendKeys(Keys.ENTER);
	}

	public void selectSubCategory(String subCat) throws InterruptedException {
		Thread.sleep(2000);
		act.sendKeys(selectSubCategory, subCat).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void enterCompanyWebsite(String compWebsite) {
		companyWebsite.sendKeys(compWebsite);
	}

	public void enterDisplayLink(String displayWebsite) {
		displayLink.sendKeys(displayWebsite);
	}

	public void enterDescription(String engDesc, String danDesc, String arabDesc) throws InterruptedException {
		DescInEnglish.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		DescInEnglish.sendKeys(engDesc);
		danishBtn.click();
		Thread.sleep(1000);

		DescInDanish.sendKeys(danDesc);
		arabicBtn.click();
		Thread.sleep(1000);
		DescInArabic.sendKeys(arabDesc);
	}

	public void enterTags(String tags) {
		enterTags.sendKeys(tags);
		enterTags.sendKeys(Keys.ENTER);
	}

	public void clickOnAddVendor() {
		addVendorBtn.click();
	}

	public void clickOnVisibleVendorDrpDwn() throws InterruptedException {
		Thread.sleep(5000);
		act.click(vendorDrpDwn).perform();
		Thread.sleep(2000);		
		act.sendKeys("invisible", Keys.ENTER).perform();
	}

	public String CreatedVendorName() throws InterruptedException {
		Thread.sleep(2000);
		return vendorNameAfterCreation.getText();
	}

	public String CreatedVendorComapnyName() throws InterruptedException {
		Thread.sleep(2000);
		return vendorCompanyAfterCreation.getText();
	}

	public String CreatedVendorEmail() throws InterruptedException {
		Thread.sleep(2000);
		return vendorEmailAfterCreation.getText();
	}

	public EasyROffersAndDealsPage clickOnOffersAndDeals(){
		OffersAndDeals.click();
		return new EasyROffersAndDealsPage();
	}

	public void logout() throws InterruptedException {
		clickOnSuperAdmintxt.click();
		Thread.sleep(1000);
		logouttxt.click();
	}
}
