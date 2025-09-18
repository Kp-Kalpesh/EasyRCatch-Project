package easyr.qa.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import easyr.qa.base.TestBase;

public class EasyRSurveyPage extends TestBase{
	Actions act;

	@FindBy(xpath = "(//a[@aria-expanded='true'])[11]")
	WebElement surveyAndQuestions;

	@FindBy(xpath = "//span[text()='survey']")
	WebElement surveyTxtOnPage;
	@FindBy(xpath = "//button[contains(text(),'Create Survey')]")
	WebElement CreateSurveyBtn;
	@FindBy(xpath = "//h4[contains(text(),'Create New Survey')]")
	WebElement createNewSurveyTxt;
	@FindBy(xpath = "//input[contains(@placeholder,'Title in English')]")
	WebElement titleInEng;
	@FindBy(xpath = "//input[contains(@placeholder,'Title in Danish')]")
	WebElement titleInDan;
	@FindBy(xpath = "//input[contains(@placeholder,'Title in Arabic')]")
	WebElement titleInArab;
	@FindBy(xpath = "//div[contains(text(),'Search vendor by Name, Company')]")
	WebElement selectVendor;
	@FindBy(xpath = "//input[contains(@placeholder,'Reward Kroner')]")
	WebElement rewardKroner;
	@FindBy(xpath = "//input[contains(@placeholder,'User Limit')]")
	WebElement userLimit;
	@FindBy(xpath = "(//input[contains(@placeholder,'Start Date')])[2]")
	WebElement startDate;
	@FindBy(xpath = "(//input[contains(@placeholder,'End Date')])[2]")
	WebElement endDate;
	@FindBy(xpath = "//button[contains(text(),'Upload Image')]")
	WebElement uplaodImgBtn;
	@FindBy(xpath = "//input[contains(@name,'survey_image')]")
	WebElement chooseFile;
	@FindBy(xpath = "//button[contains(text(),'Save Image')]")
	WebElement saveImgBtn;
	@FindBy(xpath = "(//div[@class='css-17uqnl1'])[1]")
	WebElement selectAge;
	@FindBy(xpath = "//div[text()='Select Gender']")
	WebElement selectGender;
	@FindBy(xpath = "//div[text()='Select Language']")
	WebElement selectLang;
	@FindBy(xpath = "//input[contains(@placeholder,'Enter City or State')]")
	WebElement enterlocation;
	@FindBy(xpath = "//div[text()='Selected Question Type']")
	WebElement selectQuestionType;
	@FindBy(xpath = "//textarea[@placeholder='Type Question in English Here']")
	WebElement queInEng;
	@FindBy(xpath = "//textarea[@placeholder='Type Question in Danish Here']")
	WebElement queInDan;
	@FindBy(xpath = "//textarea[@placeholder='Type Question in Arabic Here']")
	WebElement queInArab;
	@FindBy(xpath = "//span[text()='Save & Continue']")
	WebElement saveAndContinue;
	//Choose Among elements
	@FindBy(xpath = "//input[@placeholder='Enter option 1 in English']")
	WebElement option1InEng;
	@FindBy(xpath = "//input[@placeholder='Enter option 2 in English']")
	WebElement option2InEng;
	@FindBy(xpath = "//input[@placeholder='Enter option 3 in English']")
	WebElement option3InEng;
	@FindBy(xpath = "//input[@placeholder='Enter option 1 in Danish']")
	WebElement option1InDan;
	@FindBy(xpath = "//input[@placeholder='Enter option 2 in Danish']")
	WebElement option2InDan;
	@FindBy(xpath = "//input[@placeholder='Enter option 3 in Danish']")
	WebElement option3InDan;
	@FindBy(xpath = "//input[@placeholder='Enter option 1 in Arabic']")
	WebElement option1InArab;
	@FindBy(xpath = "//input[@placeholder='Enter option 2 in Arabic']")
	WebElement option2InArab;
	@FindBy(xpath = "//input[@placeholder='Enter option 3 in Arabic']")
	WebElement option3InArab;
	@FindBy(xpath = "//button[text()='Create Survey']")
	WebElement CreateSurveyButton;
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	WebElement messageBeforeCreateSurvey;
	@FindBy(xpath = "//button[text()='Create it']")
	WebElement clickOnCreateItBtn;
	@FindBy(xpath = "//button[text()='No, cancel!']")
	WebElement clickOnNoCancelBtn;
	@FindBy(xpath = "//input[@placeholder='Search Survey by Title, Vendor...']")
	WebElement searchField;
	@FindBy(xpath = "//h6[contains(@class,'mb-0 capitalize font-semibold lea')]")
	WebElement surveyTitle;
	@FindBy(xpath = "//span[@class='text-sm font-medium break-words text-justify']")
	WebElement vendorName;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement clickOnBtn;
	@FindBy(xpath = "//span[text()='Edit']")
	WebElement clickOnEditBtn;
	@FindBy(xpath = "//button[text()='Targeted App Users Overview for This Survey - 1 Users Targeted']")
	WebElement clickOnTargetedUser;
	@FindBy(xpath = "//input[@placeholder='Search users by Name, Code or Email...']")
	WebElement enterTargetedUseraName;
	@FindBy(xpath = "//span[@class='capitalize']")
	WebElement userName;
	@FindBy(xpath = "(//td[contains(@class,'p-2 ps-4 font-medium leadin')])[3]")
	WebElement userEmail;
	@FindBy(xpath = "(//td[contains(@class,'p-2 ps-4 font-medium leadin')])[4]")
	WebElement userGender;

	//veridy survey sended user



	//constructor	
	public EasyRSurveyPage() {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	//Actions

	public String verifySurveyTxtOnPage() {
		return surveyTxtOnPage.getText();
	}

	public void clickOnCreateSurveyBtn() {
		CreateSurveyBtn.click();
	}

	public String verifyCreateSurveyTxt() {
		return createNewSurveyTxt.getText();
	}

	public void enterTitleInEng(String surveyTitleinEng) {
		act.sendKeys(titleInEng, surveyTitleinEng).perform();
	}

	public void enterTitleInDan(String surveyTitleinDan) {
		act.sendKeys(titleInDan, surveyTitleinDan).perform();
	}

	public void enterTitleInArab(String surveyTitleinArab) {
		act.sendKeys(titleInArab, surveyTitleinArab).perform();
	}

	public void selectVendor(String vName) throws InterruptedException {
		act.sendKeys(selectVendor, vName).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void enterRewardKroners(String rewardKrones) {
		act.sendKeys(rewardKroner, rewardKrones).perform();
	}

	public void enterUserLimit(String usersLimit) {
		act.sendKeys(userLimit, usersLimit).perform();
	}

	public void selectStartDate() throws InterruptedException {
		Thread.sleep(1000);
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d"); // only day number
		String currentDay = today.format(formatter);

		// Click on date picker input
		startDate.click();
		WebElement todayDate = driver.findElement(By.xpath("(//span[@class='flatpickr-day today'] [text()='" + currentDay + "'])[1]"));
		todayDate.click();													
		boolean isPastDateDisabled = driver.findElements(By.xpath("(//span[contains(@class,'flatpickr-day') and text()='" + (today.getDayOfMonth() - 1) + "'])[1]")).size() > 0;

		if (isPastDateDisabled) {
			System.out.println("Past dates are disabled, only current date is selectable.");
		} else {
			System.out.println("Past dates are still selectable!");
		}
	}

	public void selectEndDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d"); // only day number
		String currentDay = today.format(formatter);

		// Click on Expiry date picker input
		endDate.click();
		WebElement todayDate = driver.findElement(By.xpath("(//span[text()='" + currentDay + "'])[2]"));															
		todayDate.click();
	}

	public void clickOnUploadImgBtn() {
		uplaodImgBtn.click();
	}

	public void chooseimgFile(String surveyImg) {
		chooseFile.sendKeys(surveyImg);
	}

	public void clickOnSaveimgBtn() {
		saveImgBtn.click();
	}

	public void selectAge(String age) throws InterruptedException {
		act.click(selectAge).perform();
		act.sendKeys(selectAge, age).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
		act.sendKeys(Keys.TAB).perform();
	}

	public void selectGender(String gender) throws InterruptedException {
		act.sendKeys(selectGender, gender).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
		act.sendKeys(Keys.TAB).perform();
	}

	public void selectLanguage(String lang) throws InterruptedException {
		act.sendKeys(selectLang, lang).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void selectLocation(String location) throws InterruptedException {
		act.click(enterlocation).perform();
		Thread.sleep(1000);
		act.sendKeys(enterlocation, location).perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	//select question type 1
	public void selectQuestionTypeTrueorFalse(String queType_1) {
		act.sendKeys(selectQuestionType, queType_1).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void enterQuestionInEng(String que_1InEng) {
		act.sendKeys(queInEng, que_1InEng).perform();
	}

	public void enterQuestionInDan(String que_1InDan) {
		act.sendKeys(queInDan, que_1InDan).perform();
	}

	public void enterQuestionInArab(String que_1InArab) {
		act.sendKeys(queInArab, que_1InArab).perform();
	}

	public void clickOnSaveAndContinueForQue1() {
		saveAndContinue.click();
	}

	//select question type 2
	public void selectQuestionTypeRating(String queType_2) {
		act.sendKeys(selectQuestionType, queType_2).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void selectQuestionTypeRatingInEng(String que_2InEng) {
		act.sendKeys(queInEng, que_2InEng).perform();
	}

	public void selectQuestionTypeRatingInDan(String que_2InDan) {
		act.sendKeys(queInDan, que_2InDan).perform();
	}

	public void selectQuestionTypeRatingInArab(String que_2InArab) {
		act.sendKeys(queInArab, que_2InArab).perform();
	}

	public void clickOnSaveAndContinueForQue2() {
		saveAndContinue.click();
	}

	//select question type 3
	public void selectQuestionTypeComment(String queType_3) {
		act.sendKeys(selectQuestionType, queType_3).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void selectQuestionTypeCommentInEng(String que_3InEng) {
		act.sendKeys(queInEng, que_3InEng).perform();
	}

	public void selectQuestionTypeCommentInDan(String que_3InDan) {
		act.sendKeys(queInDan, que_3InDan).perform();
	}

	public void selectQuestionTypeCommentInArab(String que_3InArab) {
		act.sendKeys(queInArab, que_3InArab).perform();
	}

	public void clickOnSaveAndContinueForQue3() {
		saveAndContinue.click();
	}


	//select question type 4
	public void selectQuestionTypeChooseAmong(String queType_4) {
		act.sendKeys(selectQuestionType, queType_4).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void selectQuestionTypeChooseAmongInEng(String que_4InEng, String opt_1InEng, String opt_2InEng, String opt_3InEng) {
		act.sendKeys(queInEng, que_4InEng).perform();
		option1InEng.sendKeys(opt_1InEng);
		option2InEng.sendKeys(opt_2InEng);
		option3InEng.sendKeys(opt_3InEng);
	}

	public void selectQuestionTypeChooseAmongInDan(String que_4InDan, String opt_1InDan, String opt_2InDan, String opt_3InDan) {
		act.sendKeys(queInDan, que_4InDan).perform();
		option1InDan.sendKeys(opt_1InDan);
		option2InDan.sendKeys(opt_2InDan);
		option3InDan.sendKeys(opt_3InDan);
	}

	public void selectQuestionTypeChooseAmongInArab(String que_4InArab, String opt_1InArab, String opt_2InArab, String opt_3InArab) {
		act.sendKeys(queInArab, que_4InArab).perform();
		option1InArab.sendKeys(opt_1InArab);
		option2InArab.sendKeys(opt_2InArab);
		option3InArab.sendKeys(opt_3InArab);
	}

	public void clickOnSaveAndContinueForQue4() {
		saveAndContinue.click();
	}

	public void clickOnCreatSurveyButton() {
		CreateSurveyButton.click();
	}

	public String verifyMessageOnModalBeforeCreatingSurvey() {	
		return messageBeforeCreateSurvey.getText();
	}

	public void clickOnCreateItBtn() throws InterruptedException {
		clickOnCreateItBtn.click();
		Thread.sleep(3000);
	}

	public void sendDataInSearchField(String SurveyTitle) {
		act.sendKeys(searchField, SurveyTitle).perform();
	}

	public String verifyCreatedSurveyTitle() {
		return surveyTitle.getText();
	}

	public String verifySelectedVendor() {
		return vendorName.getText();
	}

	//Verify the user which is send the survey
	public void clickOnSideBtn() {
		clickOnBtn.click();
	}

	public void clickOnEditBtn() {
		clickOnEditBtn.click();
	}

	public void clickOnTargetedUserBox() throws InterruptedException {
		clickOnTargetedUser.click();
		Thread.sleep(2000);
	}

	public void enterDataInSearchField() throws InterruptedException {
		enterTargetedUseraName.sendKeys("Kalpesh");
	}

	public String verifyUserName() throws InterruptedException {
		Thread.sleep(1000);
		return userName.getText();
	}

	public String verifyUserEmail() throws InterruptedException {
		Thread.sleep(1000);
		return userEmail.getText();
	}

	public String verifyUserGender() throws InterruptedException {
		Thread.sleep(1000);
		return userGender.getText();
	}


}
