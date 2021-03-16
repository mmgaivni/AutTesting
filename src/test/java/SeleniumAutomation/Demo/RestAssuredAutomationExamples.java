package SeleniumAutomation.Demo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredAutomationExamples {
	
	@BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
	
	
	@Test
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        System.out.println("RESPONSE"+response.getBody().asString()); 
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("qui est esse", response.jsonPath().getString("title"));
    }
	
	@Test
    public void getRequestWithQueryParam() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("id", "7")
                .when()
                .get("/comments")
                .then()
                .extract().response();

        System.out.println("RESPONSE"+response.getBody().asString()); 
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Dallas@ole.me", response.jsonPath().getString("email[0]"));
    }
	
	
	@Test
    public void postRequest() {
		 String requestBody = "{\n" +
		            "  \"title\": \"foo\",\n" +
		            "  \"body\": \"bar\",\n" +
		            "  \"userId\": \"1\" \n}";
		 
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("foo", response.jsonPath().getString("title"));
        Assert.assertEquals("bar", response.jsonPath().getString("body"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("101", response.jsonPath().getString("id"));
    }

	@Test
	public void putRequest() {
		String requestBody = "{\n" +
	            "  \"title\": \"foo\",\n" +
	            "  \"body\": \"baz\",\n" +
	            "  \"userId\": \"1\",\n" +
	            "  \"id\": \"1\" \n}";
		
	        Response response = given()
	                .header("Content-type", "application/json")
	                .and()
	                .body(requestBody)
	                .when()
	                .put("/posts/1")
	                .then()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	        Assert.assertEquals("foo", response.jsonPath().getString("title"));
	        Assert.assertEquals("baz", response.jsonPath().getString("body"));
	        Assert.assertEquals("1", response.jsonPath().getString("userId"));
	        Assert.assertEquals("1", response.jsonPath().getString("id"));
  }
	
	@Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }	
	 
}

