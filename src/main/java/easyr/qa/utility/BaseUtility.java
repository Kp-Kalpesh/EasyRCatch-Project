package easyr.qa.utility;

import java.util.Set;

import org.openqa.selenium.support.ui.WebDriverWait;

import easyr.qa.base.TestBase;

public class BaseUtility extends TestBase{

	WebDriverWait wt;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public String mainWindow;


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
	
}
