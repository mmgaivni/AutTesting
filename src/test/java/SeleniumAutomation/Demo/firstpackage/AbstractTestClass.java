package SeleniumAutomation.Demo.firstpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import SeleniumAutomation.Demo.BrowserUtils;

public class AbstractTestClass {

	BrowserUtils utils = new BrowserUtils();
	public static WebDriver driver ;
	
	@BeforeSuite
	public void beforeSuite() {
	
		driver = utils.loginBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	public void commonUtilityMethod() {
		
		System.out.println("Commonly used this method by all test methods in the package");
	}
	

	@AfterSuite
	public void afterSuite() {
		
		driver.close();
	}
	
		
}
