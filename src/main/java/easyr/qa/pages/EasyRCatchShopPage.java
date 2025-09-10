package easyr.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import easyr.qa.base.TestBase;

public class EasyRCatchShopPage extends TestBase{

	Actions act;

	@FindBy(xpath = "//span[text()='inventory products']")
	WebElement shopTextOnPage;
	@FindBy(xpath = "//button[text()='Create Product']")
	WebElement createProductBtn;
	@FindBy(xpath = "//input[contains(@placeholder,'Search vendor')]")
	WebElement enterVendorName;
	@FindBy(xpath = "//span[contains(@class,'text-easyRPrimary/')]")
	WebElement clickOnDisplayedVendorName;
	@FindBy(xpath = "(//span[contains(@class,'font-semibold text-sla')])[1]")
	WebElement verifyVendorName;
	@FindBy(xpath = "(//span[contains(@class,'font-semibold text-sla')])[2]")
	WebElement verifyVendorCompany;
	@FindBy(xpath = "//button[text()='Add Product Details']")
	WebElement addProductDetailsBtn;
	@FindBy(xpath = "//input[contains(@placeholder,'Inventory Title in English')]")
	WebElement titleInEng;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in English']")
	WebElement shortDescInEng;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Description in English')]")
	WebElement descInEng;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Terms in English')]")
	WebElement termsInEnglish;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Instruction in English')]")
	WebElement instructionInEng;
	@FindBy(xpath = "//button[text()='Next For Danish']")
	WebElement nxtForDanish;
	@FindBy(xpath = "//input[contains(@placeholder,'Inventory Title in Danish')]")
	WebElement titleInDan;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in Danish']")
	WebElement shortDescInDan;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Description in Danish')]")
	WebElement descInDan;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Terms in Danish')]")
	WebElement termsInDan;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Instruction in Danish')]")
	WebElement instructionInDan;
	@FindBy(xpath = "//button[text()='Next For Arabic']")
	WebElement nxtForArab;
	@FindBy(xpath = "//input[contains(@placeholder,'Inventory Title in Arabic')]")
	WebElement titleInArab;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in Arabic']")
	WebElement shortDescInArab;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Description in Arabic')]")
	WebElement descInArab;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Terms in Arabic')]")
	WebElement termsInArab;
	@FindBy(xpath = "//div[contains(@data-placeholder,'Instruction in Arabic')]")
	WebElement instructionInArab;
	@FindBy(xpath = "//button[text()='Next Step ']")
	WebElement nxtStepBtn;
	@FindBy(xpath = "//button[text()='Select File']")
	WebElement productImg;
	@FindBy(xpath = "//input[@id='product_image']")
	WebElement chooseImgFile;
	@FindBy(xpath = "//button[text()='Save Image']")
	WebElement saveImgbtn;
	@FindBy(xpath = "//img[@alt='product_image_square_image']")
	WebElement uploadedImgIsDisplayed;
	@FindBy(xpath = "//div[text()='Category']")
	WebElement selectCategory;
	@FindBy(xpath = "//input[@placeholder='Enter quantity']")
	WebElement quantityOfProduct;
	@FindBy(xpath = "//input[@placeholder='Enter per unit purchase cost']")
	WebElement perUnitPurchaseCost;
	@FindBy(xpath = "//input[@placeholder='Enter per sell unit cost']")
	WebElement perUnitSellCost;
	@FindBy(xpath = "//input[@id='user_limit_type']")
	WebElement redemptionLimitToggle;
	@FindBy(xpath = "//input[@placeholder='eg. 5']")
	WebElement enterRedemptionLimit;
	@FindBy(xpath = "//input[@id='allowed_multiple_redeem']")
	WebElement allowMultipleRedemption;
	@FindBy(xpath = "//input[@placeholder='eg. 5 days']")
	WebElement validatiyOfProductInDays;
	@FindBy(xpath = "//button[text()='Create Product']")
	WebElement createProduct;
	//verify data
	@FindBy(xpath = "(//a[@rel='noreferrer'])[1]")
	WebElement createdProduct;
	@FindBy(xpath = "(//div[contains(@class,'py-1 px-2 text-xs rounded-1.8 whitespace-normal text-center border-0.4 border-bl')])[1]")
	WebElement createdProductVName;
	@FindBy(xpath = "(//div[contains(@class,'break-words whitespace-normal flex justify-center false text-center')])[1]")
	WebElement createdProductCat;
	//Organization
	@FindBy(xpath = "(//a[@aria-expanded='true'])[7]")
	WebElement Organizations;



	//constructor
	public EasyRCatchShopPage() {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	//Actions
	public String verifyProductsTextOnPage() throws InterruptedException {
		Thread.sleep(2000);
		return shopTextOnPage.getText();
	}

	public void clickOnCreateProductBtn() {
		createProductBtn.click();
	}

	public void enterVendorNameInField(String vName) {
		enterVendorName.sendKeys(vName);
	}

	public boolean verifyDisplayedVendorInDrpDwn() {
		return  clickOnDisplayedVendorName.isDisplayed();
	}

	public void clickOnDisplayedVendorName() {
		clickOnDisplayedVendorName.click();
	}

	public String verifySelectedVName() {
		return verifyVendorName.getText();
	}

	public String verifySelectedVCompany() {
		return verifyVendorCompany.getText();
	}

	public void clickOnAddProductDetailsBtn() {
		addProductDetailsBtn.click();
	}

	public void enterValidDataInEnglish(String ProdTitleEng, String ProdShortDescEng, String ProdDescEng, String ProdTermsEng, String ProdInstructEng) {
		titleInEng.sendKeys(ProdTitleEng);
		shortDescInEng.sendKeys(ProdShortDescEng);
		descInEng.sendKeys(ProdDescEng);
		termsInEnglish.sendKeys(ProdTermsEng);
		instructionInEng.sendKeys(ProdInstructEng);
	}

	public void clickOnNxtForDanishBtn() {
		nxtForDanish.click();
	}

	public void enterValidDataInDanish(String ProdTitleDan, String ProdShortDescDan, String ProdDescDan, String ProdTermsDan, String ProdInstructDan) {
		titleInDan.sendKeys(ProdTitleDan);
		shortDescInDan.sendKeys(ProdShortDescDan);
		descInDan.sendKeys(ProdDescDan);
		termsInDan.sendKeys(ProdTermsDan);
		instructionInDan.sendKeys(ProdInstructDan);
	}

	public void clickOnNextForArabicBtn() {
		nxtForArab.click();
	}

	public void enterValidDataInArabic(String ProdTitleAra, String ProdShortDescAra, String ProdDescAra, String ProdTermsAra, String ProdInstructAra) {
		titleInArab.sendKeys(ProdTitleAra);
		shortDescInArab.sendKeys(ProdShortDescAra);
		descInArab.sendKeys(ProdDescAra);
		termsInArab.sendKeys(ProdTermsAra);
		instructionInArab.sendKeys(ProdInstructAra);
	}

	public void clickOnNextStepBtn() {
		nxtStepBtn.click();
	}

	public void clickOnProductImgField() {
		productImg.click();
	}

	public void enterImgInField(String prodImgLink) {
		chooseImgFile.sendKeys(prodImgLink);

	}

	public void clickOnSaveImgBtn() {
		saveImgbtn.click();
	}

	public String verifyDisplayedUploadedImg(String oldSrc) throws InterruptedException {
		Thread.sleep(2000);
		String src = uploadedImgIsDisplayed.getAttribute("src");
		String oldsrc = oldSrc;

		System.out.println("src: " + src);
		System.out.println("oldsrc: " + oldsrc);

		if(!src.equals(oldsrc))
		{
			System.out.println("The image is successfully uploaded");
		}else
		{
			System.out.println("The image is not uploaded");
		}	
		return src;
	}

	public void selectCategory(String prodCategory) {
		act.sendKeys(selectCategory, prodCategory, Keys.ENTER).build().perform();
	}

	public void enterQuantityOfProduct(String quant) {
		quantityOfProduct.sendKeys(quant);
	}

	public void enterPerUnitPurchaseCost(String purchaseCost) {
		perUnitPurchaseCost.sendKeys(purchaseCost);
	}

	public void enterPerUnitSellCost(String sellCost) {
		perUnitSellCost.sendKeys(sellCost);
	}

	public void enableRedemptionLimitToggle() {
		redemptionLimitToggle.click();
	}

	public void enterRedemptionLimit(String redemptionLimit) {
		enterRedemptionLimit.sendKeys(redemptionLimit);
	}

	public void enableAllowRedemptionLimit() {
		allowMultipleRedemption.click();
	}

	public void enterValidityOfProductAfterPurchased(String validityDays) {
		validatiyOfProductInDays.sendKeys(validityDays);
	}

	public void clickOnCreateProduct() throws InterruptedException {
		createProduct.click();
		Thread.sleep(4000);
	}

	public String verifyCreatedOfferTitle() {
		return createdProduct.getText();
	}

	public String verifyCreatedOfferVName() {
		return createdProductVName.getText();
	}

	public String verifyCreatedOfferCategory() {
		return createdProductCat.getText();
	}

	public EasyROrganizationPage clickOnOrganization() {
		Organizations.click();
		return new EasyROrganizationPage();
	}
}
