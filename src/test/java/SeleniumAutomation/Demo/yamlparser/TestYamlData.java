package SeleniumAutomation.Demo.yamlparser;

import java.io.InputStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import SeleniumAutomation.Demo.Customer;



public class TestYamlData {
	
	//@BeforeClass
	@Test
	public void yamlToJavaObject()
	{
		// convert testdata.yaml to customer.java file
		// convert the below code as method put in the util library, call it using the 
		//parameters such as class name and yaml file parameters.
		
		Yaml yaml = new Yaml(new Constructor(Customer.class));
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("testdata.yaml");
		Customer customer = yaml.load(inputStream);
		
		
		
		System.out.println("testing yaml"+customer.getFirstName());
		System.out.println("testing yaml"+customer.getLastName());
		System.out.println("testing yaml"+customer.getAge());
		System.out.println("testing yaml"+customer.isEmployee());
		System.out.println("testing yaml"+customer.getContactDetails().get(0).getType());
		System.out.println("testing yaml"+customer.getContactDetails().get(0).getNumber());
		System.out.println("testing yaml"+customer.getContactDetails().get(1).getType());
		System.out.println("testing yaml"+customer.getContactDetails().get(1).getNumber());
				
				
	}

}

// why yaml
//yaml files are used to configure test data or configuration required to run our application/test

// Key : value
// key : {} new java class
// key : [] new arrayList

		
