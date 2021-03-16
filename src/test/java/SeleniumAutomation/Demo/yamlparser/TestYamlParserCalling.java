package SeleniumAutomation.Demo.yamlparser;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SeleniumAutomation.Demo.Customer;
import SeleniumAutomation.Demo.YamlJavaMapper;



public class TestYamlParserCalling {
	Customer customer;
	@BeforeClass
	public void yamlToJavaObject() {
		// Creating 
		YamlJavaMapper yamlLoader = new YamlJavaMapper();
		customer = (Customer) yamlLoader.yamlToJavaObject("testdata.yaml", Customer.class);
	}
	
	@Test
	public void validateFirstName() {
		
		Assert.assertEquals(customer.getFirstName(), "John", "Firstname is not matched");
	}
		
	
	
}


