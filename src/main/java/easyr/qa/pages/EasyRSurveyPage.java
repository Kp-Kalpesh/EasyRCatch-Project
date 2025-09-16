package easyr.qa.pages;

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
	@FindBy(xpath = "//div[contains(@id,'react-select-24-placeholder')]")
	WebElement selectAge;
	@FindBy(xpath = "//div[contains(@id,'react-select-25-placeholder')]")
	WebElement selectGender;
	@FindBy(xpath = "//div[contains(@id,'react-select-26-placeholder')]")
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
	@FindBy(xpath = "//button[text()='Create Survey']")
	WebElement CreateSurveyButton;
	@FindBy(xpath = "//input[@placeholder='Search Survey by Title, Vendor...']")
	WebElement searchField;
	@FindBy(xpath = "//h6[contains(@class,'mb-0 capitalize font-semibold lea')]")
	WebElement surveyTitle;
	@FindBy(xpath = "//span[@class='text-sm font-medium break-words text-justify']")
	WebElement vendorName;



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

	public void enterTitleInEng() {
		act.sendKeys(titleInEng, "Test").perform();
	}

	public void enterTitleInDan() {
		act.sendKeys(titleInDan, "test").perform();
	}

	public void enterTitleInArab() {
		act.sendKeys(titleInArab, "test").perform();
	}

	public void selectVendor() throws InterruptedException {
		act.sendKeys(selectVendor, "Joss Sterlin").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void enterRewardKroners() {
		act.sendKeys(rewardKroner, "10").perform();
	}

	public void enterUserLimit() {
		act.sendKeys(userLimit, "5").perform();
	}

	//	public void selectStartDate() {
	//		startDate.click();
	//	}
	//	
	//	public void selectEndDate() {
	//		endDate.click();
	//	}

	public void clickOnUploadImgBtn() {
		uplaodImgBtn.click();
	}

	public void chooseimgFile() {
		chooseFile.sendKeys("path of img file");
	}

	public void clickOnSaveimgBtn() {
		saveImgBtn.click();
	}

	public void selectAge() throws InterruptedException {
		act.sendKeys(selectAge, "26-35 Years").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void selectGender() throws InterruptedException {
		act.sendKeys(selectGender, "Male").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void selectLanguage() throws InterruptedException {
		act.sendKeys(selectLang, "English").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
	}

	public void selectLocation() {
		act.sendKeys(enterlocation, "sakri").perform();
	}

	public void selectQuestionType() {
		act.sendKeys(selectQuestionType, "true or false").perform();
	}

	public void enterQuestionInEng() {
		act.sendKeys(queInEng, "Test").perform();
	}

	public void enterQuestionInDan() {
		act.sendKeys(queInDan, "Test").perform();
	}

	public void enterQuestionInArab() {
		act.sendKeys(queInArab, "Test").perform();
	}

	public void clickOnSaveAndContinue() {
		saveAndContinue.click();
	}

	public void clickOnCreatSurveyButton() {
		CreateSurveyButton.click();
	}

	public void sendDataInSearchField() {
		act.sendKeys(searchField, "created survey text").perform();
	}

	public String verifyCreatedSurveyTitle() {
		return surveyTitle.getText();
	}

	public String verifySelectedVendor() {
		return vendorName.getText();
	}


}
