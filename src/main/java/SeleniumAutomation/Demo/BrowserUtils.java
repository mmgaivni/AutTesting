package SeleniumAutomation.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Utility class for browsers
 * @author Eswar
 *
 */
public class BrowserUtils {
	
	WebDriver driver;
	
	public WebDriver loginBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Srujana Gavini\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
		    driver = new ChromeDriver();
		    	
		}
		
		return driver;
			
	}
	

}
