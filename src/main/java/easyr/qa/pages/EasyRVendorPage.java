package easyr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
//	@FindBy(xpath = "(//button[text()='Select File'])[1]")
//	WebElement VendorLogoSelectFile;
	
	
	
	
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
}
