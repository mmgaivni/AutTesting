package SeleniumAutomation.Demo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matcher.*;

public class RestAssuredTestClass {
	
	@Test
	public void getResponseStatus(){
	  int statusCode = given().queryParam("CUSTOMER_ID","68195")
	          .queryParam("PASSWORD","1234!")
	          .queryParam("Account_No","1")
	          .when().get("http://demo.guru99.com/V4/sinkministatement.php")
	         
	          .getStatusCode();
	 
	  System.out.println("The response status is "+statusCode);

	}

}


