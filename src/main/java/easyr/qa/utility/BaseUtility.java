package easyr.qa.utility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import easyr.qa.base.TestBase;

public class BaseUtility extends TestBase{

	WebDriverWait wt;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public String mainWindow;
	public Actions act;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okBtn;
	@FindBy(xpath = "(//span[@aria-current='step'])[3]")
	WebElement upperTab;

	public void switchToFrame() {
		driver.switchTo().frame(0);
	}

	public void waits() {
		wt = new WebDriverWait(driver, 10); 

	}

	public void windowHandleCode() {
		Set<String> windowHandles = driver.getWindowHandles();
		mainWindow = driver.getWindowHandle();
		// Iterate through the window handles
		for(String windowHandle : windowHandles)
		{
			// Switch to each window
			if(!windowHandle.equals(mainWindow))
			{
				driver.switchTo().window(windowHandle);
				break;
			} 
		}		
	}

	public void switchToMainwindow() {
		driver.switchTo().window(mainWindow);
	}

	public void clickOnNextBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, (10));
		act.sendKeys(upperTab, Keys.ARROW_UP).perform();

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

}
