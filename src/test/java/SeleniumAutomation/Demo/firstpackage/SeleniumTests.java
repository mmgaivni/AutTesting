package SeleniumAutomation.Demo.firstpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumTests extends AbstractTestClass {
	
	
	//@Test
	public void idExample() {
			        
		String baseUrl = "http://www.facebook.com";
        String tagName = "";
        
        driver.get(baseUrl);
        
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
	}
	
	//@Test
	public void frameAndLinkTextExample () {
		
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
        driver.switchTo().frame("classFrame");
        
        driver.findElement(By.linkText("Deprecated")).click();
        
	}
	
	
	@Test
	public void gmailLoginExample() throws InterruptedException {
		
		// Login to facebook page
		// Enter User name
		// Enter password
		// Click on the Login
		
		driver.get("https://www.facebook.com/");
		
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//input[@id='email']"))).sendKeys("addepalliamareswar");
        
        
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//input[@id='pass']"))).sendKeys("password");
        
        Thread.sleep(1000);
       
        driver.findElement(By.xpath("//button[@name='login']")).click();
        
	}

}
