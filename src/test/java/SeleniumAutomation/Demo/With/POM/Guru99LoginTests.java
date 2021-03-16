package SeleniumAutomation.Demo.With.POM;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import SeleniumAutomation.Demo.ExtentReport.ExtentTestManager;
import SeleniumAutomation.Demo.firstpackage.AbstractTestClass;

public class Guru99LoginTests extends AbstractTestClass {
	
	Guru99LoginPage objLogin;
	Guru99HomePage objHome;
	
	@BeforeTest
	public void setupMethod() {
		
		driver.get("http://demo.guru99.com/V4/");
		
	}
	
	@Test

    public void testHomePageAppearCorrect(){

        //Create Login Page object
        objLogin = new Guru99LoginPage(driver);

        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        //login to application
        objLogin.loginToGuru99("mngr307436", "yjajepE");
        
         // go the next page
        objHome = new Guru99HomePage(driver);

        String expectedUserName = objHome.getHomePageDashboardUserName();
        
        String actualValue = "Manger Id : mngr307436";
        
        //Verify home page
        Assert.assertEquals(expectedUserName, actualValue);
        
        ExtentTestManager.getTest().log(Status.INFO, "End Home page test");

    } 

}
