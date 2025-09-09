package easyr.qa.pages;

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
	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextBtn;
	@FindBy(xpath = "//span[text()='Offer Sub Details']")
	WebElement upperTab;
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






	//intialization
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

	public void enterVendorName(String vendrName) {
		enterVendorName.sendKeys(vendrName);
	}

	public void clickOnDisplayedVendor() {
		movedAndClickOnVendorName.click();
	}

	public String verifySelectedVendorName() {
		return verifyVendorName.getText();
	}

	public String verifySelectVendorCompanyName() {
		return verifyCompanyName.getText();
	}

	public void clickOnAddOfferDetailsBtn() {
		addOfferDetailsBtn.click();
	}

	public void selectOfferType(String offerType) {
		act.sendKeys(selectOfferType, offerType, Keys.ENTER).perform();

	}

	public void selectOfferDepartment(String offerDept) {
		act.sendKeys(selectOfferDepartment, offerDept, Keys.ENTER).perform();
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
		selectStartDate.click();

		WebElement todayDate = driver.findElement(By.xpath("(//span[text()='" + currentDay + "'])[1]"));
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

		WebElement todayDate = driver.findElement(By.xpath("(//span[@aria-label='September 9, 2025' and text()='" + currentDay + "'])[2]"));															
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

	public void clickOnNextBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, (10));
		act.sendKeys(upperTab, Keys.ARROW_UP).perform();

		try {
			WebElement element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Offer Sub Details']")));
			act.click(element).perform();
		} catch (TimeoutException e) {
			System.out.println("Element was not found within the timeout period.");
			// Optional: Take screenshot or log error
		}

		Thread.sleep(2000);
		act.click(okBtn).perform();
	}

	public void enterSubDetailsInEnglish(String titleEng, String shortDescEng, String termsEng, String descEng) {
		TitleInEnglish.sendKeys(titleEng);
		shortDescinEnglish.sendKeys(shortDescEng);
		termsInEnglish.sendKeys(termsEng);
		DescInEnglish.sendKeys(descEng);
		nextForDanish.click();
	}

	public void enterSubDetailsInDanish(String titleDan, String shortDescDan, String termsDan, String descDan) {
		TitleInDanish.sendKeys(titleDan);
		shortDescInDanish.sendKeys(shortDescDan);
		termsInDanish.sendKeys(termsDan);
		descInDanish.sendKeys(descDan);
		nextForArabic.click();
	}

	public void enterSubDetailsInArabic(String titleAra, String shortDescAra, String termsAra, String descAra) {
		TitleInArabic.sendKeys(titleAra);
		shortDescInArabic.sendKeys(shortDescAra);
		termsInArabic.sendKeys(termsAra);
		descInArabic.sendKeys(descAra);
	}

	public void clickOnCreateOfferbtn() {
		createOffer.click();
	}
}
