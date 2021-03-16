package SeleniumAutomation.Demo.firstpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTestClass extends AbstractTestClass {
	
	
	@Test
	public void testMethod1() {
		
		        //System.setProperty("webdriver.chrome.driver","C:\\Users\\hi\\Downloads\\chromedriver_win32\\chromedriver.exe");
				
		        //driver = new ChromeDriver();
		    	
		        String baseUrl = "http://demo.guru99.com/test/newtours/";
		       
		        String expectedTitle = "Welcome: Mercury Tours";
		        
		        String actualTitle = "";

		        // launch Chrome driver and direct it to the Base URL
		        driver.get(baseUrl);

		        // get the actual value of the title
		        actualTitle = driver.getTitle();
		        
		        System.out.println("Actual Title : "+actualTitle);
		        System.out.println("Expected Title : "+expectedTitle);
		        
		        Assert.assertEquals(actualTitle, expectedTitle, "Title is not found");
		        		        
		      

	}
	
	
}
