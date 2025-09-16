package easyr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import easyr.qa.base.TestBase;

public class EasyRSurveyPage extends TestBase{
	
	@FindBy(xpath = "(//a[@aria-expanded='true'])[11]")
	WebElement surveyAndQuestions;

	
	
	
	//constructor	
	public EasyRSurveyPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
}
