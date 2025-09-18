package easyr.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import easyr.qa.base.TestBase;
import easyr.qa.pages.EasyRCatchShopPage;
import easyr.qa.pages.EasyRDashboardPage;
import easyr.qa.pages.EasyRDonationPage;
import easyr.qa.pages.EasyRLoginPage;
import easyr.qa.pages.EasyROffersAndDealsPage;
import easyr.qa.pages.EasyROrganizationPage;
import easyr.qa.pages.EasyRSurveyPage;
import easyr.qa.pages.EasyRVendorPage;
import junit.framework.Assert;

public class EasyRSurveyPageTest extends TestBase{

	EasyRLoginPage loginpg;
	EasyRDashboardPage dashpg;
	EasyRVendorPage vendrpg;
	EasyROffersAndDealsPage offerpg;
	EasyRCatchShopPage shoppg;
	EasyROrganizationPage orgpg;
	EasyRDonationPage donpg;
	EasyRSurveyPage survpg;

	public EasyRSurveyPageTest() {
		super();
	}


	@BeforeMethod
	public void setup() {
		initialization();
		loginpg = new EasyRLoginPage();
		dashpg = loginpg.clickOnLoginbtn(prop.getProperty("EmailQA"), prop.getProperty("PasswordQA"));
		vendrpg = dashpg.clickOnVendors();
		offerpg = vendrpg.clickOnOffersAndDeals();
		shoppg = offerpg.clickOnProductStore();
		orgpg = shoppg.clickOnOrganization();
		donpg = orgpg.clickOnDonationTab();
		survpg = donpg.clickOnSurveyTab();
	}

	@Test(priority = 1)
	public void verifySurvey() {
		try {
			Assert.assertEquals(survpg.verifySurveyTxtOnPage(), "SURVEY");
			survpg.clickOnCreateSurveyBtn();
			survpg.verifyCreateSurveyTxt();
			survpg.enterTitleInEng(prop.getProperty("SurveyTitle_English"));
			survpg.enterTitleInDan(prop.getProperty("SurveyTitle_Danish"));
			survpg.enterTitleInArab(prop.getProperty("SurveyTitle_Arabic"));
			survpg.selectVendor(prop.getProperty("SurveyVendorName"));
			survpg.enterRewardKroners(prop.getProperty("RewardsInKrones"));
			survpg.enterUserLimit(prop.getProperty("UserLimit"));
			survpg.selectStartDate();
			survpg.selectEndDate();
			survpg.clickOnUploadImgBtn();
			survpg.chooseimgFile(prop.getProperty("SurveyImgFile"));
			survpg.clickOnSaveimgBtn();
			//						survpg.selectAge(prop.getProperty("UsersAge"));
			//						survpg.selectGender(prop.getProperty("UsersGender"));
			//						survpg.selectLanguage(prop.getProperty("UserLanguage"));
			survpg.selectLocation(prop.getProperty("userLocation"));
			//Question 1
			survpg.selectQuestionTypeTrueorFalse(prop.getProperty("QuestionType_1"));
			survpg.enterQuestionInEng(prop.getProperty("Question_1InEnglish"));
			survpg.enterQuestionInDan(prop.getProperty("Question_1InDansh"));
			survpg.enterQuestionInArab(prop.getProperty("Question_1InArabic"));
			survpg.clickOnSaveAndContinueForQue1();
			//Question 2
			survpg.selectQuestionTypeRating(prop.getProperty("QuestionType_2"));
			survpg.selectQuestionTypeRatingInEng(prop.getProperty("Question_2InEnglish"));
			survpg.selectQuestionTypeRatingInDan(prop.getProperty("Question_2InDansh"));
			survpg.selectQuestionTypeRatingInArab(prop.getProperty("Question_2InArabic"));
			survpg.clickOnSaveAndContinueForQue2();
			//Question 3
			survpg.selectQuestionTypeComment(prop.getProperty("QuestionType_3"));
			survpg.selectQuestionTypeCommentInEng(prop.getProperty("Question_3InEnglish"));
			survpg.selectQuestionTypeCommentInDan(prop.getProperty("Question_3InDansh"));
			survpg.selectQuestionTypeCommentInArab(prop.getProperty("Question_3InArabic"));
			survpg.clickOnSaveAndContinueForQue3();
			//Question 3
			survpg.selectQuestionTypeChooseAmong(prop.getProperty("QuestionType_4"));
			survpg.selectQuestionTypeChooseAmongInEng(prop.getProperty("Question_4InEnglish"), prop.getProperty("option_1InEng"), prop.getProperty("option_2InEng"), prop.getProperty("option_3InEng"));
			survpg.selectQuestionTypeChooseAmongInDan(prop.getProperty("Question_4InDansh"), prop.getProperty("option_1InDan"), prop.getProperty("option_2InDan"), prop.getProperty("option_3InDan"));
			survpg.selectQuestionTypeChooseAmongInArab(prop.getProperty("Question_4InArabic"), prop.getProperty("option_1InArab"), prop.getProperty("option_2InArab"), prop.getProperty("option_3InArab"));
			survpg.clickOnSaveAndContinueForQue4();
			survpg.clickOnCreatSurveyButton();
			System.out.println("Message on modal: " + survpg.verifyMessageOnModalBeforeCreatingSurvey());
			Assert.assertEquals(survpg.verifyMessageOnModalBeforeCreatingSurvey(), "Today's date selected. Start date cannot be modified after survey creation.");
			survpg.clickOnCreateItBtn();

		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}


	@Test(priority = 2)
	public void verifyCreatedSurveyOnListingPage() {
		try {
			SoftAssert sa = new SoftAssert();
			survpg.sendDataInSearchField(prop.getProperty("SurveyTitle_English"));
			System.out.println("verifyCreatedSurveyTitle(): " + survpg.verifyCreatedSurveyTitle());
			sa.assertEquals(survpg.verifyCreatedSurveyTitle(), "Vehicle buying survey\r\n"
					+ "4");
			System.out.println("survpg.verifySelectedVendor(): " + survpg.verifySelectedVendor());
			Assert.assertEquals(survpg.verifySelectedVendor(), "Joss Sterlin (Sterlin Industries)");

		}catch (Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@Test(priority = 3)
	public void verifyUserOfSendSurvey() {
		try {
			survpg.sendDataInSearchField(prop.getProperty("SurveyTitle_English"));
			survpg.clickOnSideBtn();
			survpg.clickOnEditBtn();
			survpg.clickOnTargetedUserBox();
			survpg.enterDataInSearchField();
			System.out.println("survpg.verifyUserName(): "+ survpg.verifyUserName());
			Assert.assertEquals(survpg.verifyUserName(), "Kalpesh Patil");
			System.out.println("survpg.verifyUserEmail(): " + survpg.verifyUserEmail());
			Assert.assertEquals(survpg.verifyUserEmail(), "kalpesh.p@easyr.ae");
			System.out.println("survpg.verifyUserGender(): " + survpg.verifyUserGender());
			Assert.assertEquals(survpg.verifyUserGender(), "Male");

		}catch(Exception e) {
			System.out.println("Element not found within timeout: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
