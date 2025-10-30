package easyr.qa.pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import easyr.qa.base.TestBase;

public class EasyROffersAndDealsPage extends TestBase{

	Actions act;
	@FindBy(xpath = "//span[text()='offers and deals']")
	WebElement offersAndDealsPageText;
	@FindBy(xpath = "//button[text()='Create Offer']")
	WebElement createOfferBtn;

	//create offer page
	@FindBy(xpath = "//input[contains(@placeholder,'Search vendor')]")
	WebElement enterVendorName;
	@FindBy(xpath = "//div[contains(@class,'flex !z-990 justify-between p-')]")
	WebElement movedAndClickOnVendorName;
	@FindBy(xpath = "(//span[contains(@class,'font-semibold text-slate')])[1]")
	WebElement verifyVendorName;
	@FindBy(xpath = "(//span[contains(@class,'font-semibold text-slate')])[2]")
	WebElement verifyCompanyName;
	@FindBy(xpath = "//button[contains(text(),'Add Offer Details')]")
	WebElement addOfferDetailsBtn;
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement getValidation;
	@FindBy(xpath = "//div[contains(text(),'Select offer type')]")
	WebElement getOfferTypeVal;
	@FindBy(xpath = "//div[contains(text(),'Select offer department')]")
	WebElement getOfferDeptVal;
	@FindBy(xpath = "//div[contains(text(),'Offer Category is required')]")
	WebElement getOfferCatVal;
	@FindBy(xpath = "//div[contains(text(),'Start date is required')]")
	WebElement getOfferStartDateVal;
	@FindBy(xpath = "//div[contains(text(),'End date is required')]")
	WebElement getOfferEndDateVal;
	@FindBy(xpath = "//div[contains(text(),'Please select the type of discount')]")
	WebElement getOfferDiscountTypeVal;
	@FindBy(xpath = "//div[contains(text(),'EasyR commission per click is required')]")
	WebElement getOfferCommissionPerClickVal;
	@FindBy(xpath = "//span[contains(text(),'Please upload image for offer!')]")
	WebElement getOfferImageVal;

	@FindBy(xpath = "//div[contains(text(),'Donation per')]")
	WebElement donationPerRedemptionVali;

	@FindBy(xpath = "//div[contains(text(),'EasyR commission per redeem in')]")
	WebElement commissionPerRedemptionsVali;

	@FindBy(xpath = "//div[contains(text(),'Earning Reward Coins is required')]")
	WebElement rewardCoinVali;

	@FindBy(xpath = "//div[contains(text(),'At least one offer redemption limit is required')]")
	WebElement offerRedemptionLimitVali;



	@FindBy(xpath = "//div[text()='Type']")
	WebElement selectOfferType;
	@FindBy(xpath = "//input[@id='offer_department']")
	WebElement selectOfferDepartment;
	@FindBy(xpath = "//div[text()='Category']")
	WebElement selectCategory;
	@FindBy(xpath = "//div[text()='Subcategory']")
	WebElement selectSubCategory;
	@FindBy(xpath = "(//input[@placeholder='Start Date'])[2]")
	WebElement selectStartDate;
	@FindBy(xpath = "(//input[@placeholder='Expiry Date'])[2]")
	WebElement selectExpiryDate;
	@FindBy(xpath = "//input[@placeholder='Kroner per Redemption']")
	WebElement donationPerRedemption;
	@FindBy(xpath = "//input[@placeholder='Commission per Redemption']")
	WebElement commissionPerRedemption;
	@FindBy(xpath = "//input[@placeholder='eg. 1000']")
	WebElement rewardCoins;
	@FindBy(xpath = "//input[@aria-label='offer_limit']")
	WebElement redemptionLimit;
	@FindBy(xpath = "//div[text()='Discount Type']")
	WebElement selectDiscountType;
	@FindBy(xpath = "//input[@placeholder='eg. 10']")
	WebElement enterDiscount;
	@FindBy(xpath = "//input[@placeholder='eg. 14 Kr.']")
	WebElement enterClickCommission;
	@FindBy(xpath = "//input[@placeholder='Web Link']")
	WebElement enterWebLink;
	@FindBy(xpath = "//button[text()='Select File']")
	WebElement offerImageBtn;
	@FindBy(xpath = "//input[contains(@id,'image')]")
	WebElement chooseFileInputField;
	@FindBy(xpath = "//button[contains(text(),'Save Image')]")
	WebElement saveImageBtn;
	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextBtn;
	@FindBy(xpath = "(//span[@aria-current='step'])[3]")
	WebElement upperTab;
	//span[text()='Offer Sub Details']

	@FindBy(xpath = "//button[text()='OK']")
	WebElement okBtn;
	@FindBy(xpath = "//input[@placeholder='Offer Title in English']")
	WebElement TitleInEnglish;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in English']")
	WebElement shortDescinEnglish;
	@FindBy(xpath = "//div[@data-placeholder='Terms in English']")
	WebElement termsInEnglish;
	@FindBy(xpath = "//div[@data-placeholder='Description in English']")
	WebElement DescInEnglish;
	@FindBy(xpath = "//button[text()='Next For Danish']")
	WebElement nextForDanish;
	@FindBy(xpath = "//input[@placeholder='Offer Title in Danish']")
	WebElement TitleInDanish;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in Danish']")
	WebElement shortDescInDanish;
	@FindBy(xpath = "//div[@data-placeholder='Terms in Danish']")
	WebElement termsInDanish;
	@FindBy(xpath = "//div[@data-placeholder='Description in Danish']")
	WebElement descInDanish;
	@FindBy(xpath = "//button[text()='Next For Arabic']")
	WebElement nextForArabic;
	@FindBy(xpath = "//input[@placeholder='Offer Title in Arabic']")
	WebElement TitleInArabic;
	@FindBy(xpath = "//textarea[@placeholder='Short Description in Arabic']")
	WebElement shortDescInArabic;
	@FindBy(xpath = "//div[@data-placeholder='Terms in Arabic']")
	WebElement termsInArabic;
	@FindBy(xpath = "//div[@data-placeholder='Description in Arabic']")
	WebElement descInArabic;
	@FindBy(xpath = "//button[text()='Create Offer']")
	WebElement createOffer;
	@FindBy(xpath = "(//a[@rel='noreferrer'])[1]")
	WebElement createdOfferTitle;
	@FindBy(xpath = "(//div[contains(@class,'py-1 px-2 text-xs rounded-')])[1]")
	WebElement createdOfferType;
	@FindBy(xpath = "(//div[contains(@class,'dark:bg-none dark:border-none dark:!text-[#EF9C66]')])[1]")
	WebElement createdVendorName;
	@FindBy(xpath = "(//a[@aria-expanded='true'])[5]")
	WebElement EasyRCatchShop;

	//Logout
	@FindBy(xpath = "//p[text()='Super Admin']")
	WebElement clickOnSuperAdmintxt;
	@FindBy(xpath = "//button[text()='Log Out']")
	WebElement logouttxt;

	//intialization constructor
	public EasyROffersAndDealsPage() {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	//Actions
	public String verifyOffersAndDealsText() {
		return offersAndDealsPageText.getText();
	}

	public void clickOnCreateOffer() {
		createOfferBtn.click();
	}

	public String clickOnAddOfferDetailBtn() throws InterruptedException {
		Thread.sleep(3000);
		addOfferDetailsBtn.click();
		Thread.sleep(2000);
		String getVal = getValidation.getText();
		System.out.println("Create Offer Validation: " + getVal);
		return getVal;
	}

	public void enterVendorName(String vendrName) {
		enterVendorName.sendKeys(vendrName);
	}

	public void clickOnDisplayedVendor() throws InterruptedException {
		Thread.sleep(2000);
		movedAndClickOnVendorName.click();
	}

	public String verifySelectedVendorName() {
		return verifyVendorName.getText();
	}

	public String verifySelectVendorCompanyName() {
		return verifyCompanyName.getText();
	}

	public void clickOnAddOfferDetailsBtn() throws InterruptedException {
		Thread.sleep(100);
		addOfferDetailsBtn.click();
	}

	public String verifyOfferTypeValidation() {
		return getOfferTypeVal.getText();
	}

	public String verifyOfferDepartment() {
		return getOfferDeptVal.getText();
	}

	public String verifyOfferCategoryVal() {
		return getOfferCatVal.getText();
	}

	public String verifyOfferStartDateVal() {
		return getOfferStartDateVal.getText();
	}

	public String verifyOfferEndDateVal() {
		return getOfferEndDateVal.getText();
	}

	public String verifyOfferDiscountVal() {
		System.out.println("Message: " + getOfferDiscountTypeVal.getText());
		return getOfferDiscountTypeVal.getText();
	}

	public String verifyOfferCommissionPerClickVal() {
		return getOfferCommissionPerClickVal.getText();
	}

	public String verifyOfferImageVal() {
		return getOfferImageVal.getText();
	}

	public String verifyDonationPerRedemptionVal() {
		return donationPerRedemptionVali.getText();
	}

	public String verifyEasyRCommissionPerRedeemVal() {
		return commissionPerRedemptionsVali.getText();
	}

	public String verifyEarningRewardCoinVal() {
		return rewardCoinVali.getText();
	}

	public String verifyOfferRedemptionLimitVal() {
		return offerRedemptionLimitVali.getText();
	}



	public void selectOfferType(String offerType) throws InterruptedException {
		Thread.sleep(2000);
		act.sendKeys(selectOfferType, offerType, Keys.ENTER).perform();
	}

	public void clickOnOfferSubDetails() throws InterruptedException {
		act.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(3000);
		clickOnNxtBtnForValidation();
	}

	public void selectOfferDepartment(String offDept) throws InterruptedException {
		act.sendKeys(selectOfferDepartment, offDept, Keys.ENTER).build().perform();
	}

	public void selectOfferCategory(String offerCat) {
		act.sendKeys(selectCategory, offerCat, Keys.ENTER).perform();
	}

	public void selectSubCategory(String offerSubCat) {
		act.sendKeys(selectSubCategory, offerSubCat, Keys.ENTER).perform();
	}

	public void selectStartDate() throws InterruptedException {
		Thread.sleep(1000);
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d"); // only day number
		String currentDay = today.format(formatter);

		// Click on date picker input
		Thread.sleep(2000);
		selectStartDate.click();
		WebElement todayDate = driver.findElement(By.xpath("(//span[text()='" + currentDay + "'])[2]"));
		Thread.sleep(2000);
		todayDate.click();

		boolean isPastDateDisabled = driver.findElements(By.xpath("(//span[contains(@class,'flatpickr-day') and text()='" + (today.getDayOfMonth() - 1) + "'])[1]")).size() > 0;

		if (isPastDateDisabled) {
			System.out.println("Past dates are disabled, only current date is selectable.");
		} else {
			System.out.println("Past dates are still selectable!");
		}
	}

	public void selectExpiryDate() throws InterruptedException {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d"); // only day number
		String currentDay = today.format(formatter);

		// Click on Expiry date picker input
		selectExpiryDate.click();
		//		Thread.sleep(4000);
		WebElement todayDate = driver.findElement(By.xpath("(//span[text()='" + currentDay + "'])[4]"));															
		todayDate.click();
	}

	public void enterDonationPerRedemption(String donation) {
		donationPerRedemption.sendKeys(donation);
	}

	public void enterCommissionPerRedemption(String donationCoin) {
		commissionPerRedemption.sendKeys(donationCoin);
	}

	public void enterRewardCoins(String rewardCoin) {
		rewardCoins.sendKeys(rewardCoin);
	}

	public void enterRedemptionLimit(String RedeemedLimit) {
		redemptionLimit.sendKeys(RedeemedLimit);
	}

	public void selectDiscountType(String discountType) throws InterruptedException {
		act.sendKeys(selectDiscountType, discountType, Keys.ENTER).perform();
		Thread.sleep(2000);
	}

	public void enterDiscount(String discountPrice) {
		enterDiscount.sendKeys(discountPrice);
	}

	public void enterClickCommission(String commission) {
		enterClickCommission.sendKeys(commission);
	}

	public void enterWebLink(String webLink) {
		enterWebLink.sendKeys(webLink);
	}

	public void clickOnOfferimagebtn() {
		offerImageBtn.click();
	}

	public void selectImageFile(String img) {
		chooseFileInputField.sendKeys(img);
	}

	public void clickOnsaveImageBtn() {
		saveImageBtn.click();
	}



	public void clickOnNxtBtnForValidation() {
		WebDriverWait wait = new WebDriverWait(driver, (10));
		act.sendKeys(upperTab, Keys.ARROW_UP).perform();
		act.sendKeys(Keys.PAGE_DOWN).perform();

	}


	public void clickOnNextBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, (10));
		act.sendKeys(upperTab, Keys.ARROW_UP).perform();
		act.sendKeys(Keys.PAGE_DOWN).perform();

		Thread.sleep(4000);
		try {
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//span[text()='Offer Sub Details']")));
			//			ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));
			act.click(element).perform();
		} catch (TimeoutException e) {
			System.out.println("Element was not found within the timeout period.");
			// Optional: Take screenshot or log error
		}
		Thread.sleep(2000);
		act.click(okBtn).perform();
	}
	//
	//	public void enterSubDetailsInEnglish(String titleEng, String shortDescEng, String termsEng, String descEng) {
	//		TitleInEnglish.sendKeys(titleEng);
	//		shortDescinEnglish.sendKeys(shortDescEng);
	//		termsInEnglish.sendKeys(termsEng);
	//		DescInEnglish.sendKeys(descEng);
	//		nextForDanish.click();
	//	}
	//
	//	public void enterSubDetailsInDanish(String titleDan, String shortDescDan, String termsDan, String descDan) {
	//		TitleInDanish.sendKeys(titleDan);
	//		shortDescInDanish.sendKeys(shortDescDan);
	//		termsInDanish.sendKeys(termsDan);
	//		descInDanish.sendKeys(descDan);
	//		nextForArabic.click();
	//	}
	//
	//	public void enterSubDetailsInArabic(String titleAra, String shortDescAra, String termsAra, String descAra) {
	//		TitleInArabic.sendKeys(titleAra);
	//		shortDescInArabic.sendKeys(shortDescAra);
	//		termsInArabic.sendKeys(termsAra);
	//		descInArabic.sendKeys(descAra);
	//	}
	//
	//	public void clickOnCreateOfferbtn() throws InterruptedException {
	//		createOffer.click();
	//		Thread.sleep(5000);
	//	}
	//
	//	public String verifyOfferTitle() throws InterruptedException {
	//		Thread.sleep(2000);
	//		return createdOfferTitle.getText();
	//	}
	//
	//	public String verifyOfferType() throws InterruptedException {
	//		Thread.sleep(2000);
	//		return createdOfferType.getText();
	//	}
	//
	//	public String verifyOfferVendorName() throws InterruptedException {
	//		Thread.sleep(2000);
	//		return createdVendorName.getText();
	//	}
	//
	//	public EasyRCatchShopPage clickOnProductStore() {
	//		EasyRCatchShop.click();
	//		return new EasyRCatchShopPage();
	//	}
	//
	//	public void logout() throws InterruptedException {
	//		clickOnSuperAdmintxt.click();
	//		Thread.sleep(1000);
	//		logouttxt.click();
	//	}
}
