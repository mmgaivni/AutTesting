package SeleniumAutomation.Demo;

import java.util.List;

public class Customer {
	
	private String firstName;
	private String lastName;
	private int age;
	private boolean employee;
	private List<ContactDetails> contactDetails;
	
	// Contact Details	
	public List<ContactDetails> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}

	// Employee Details
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean isEmployee() {
		return employee;
	}
		
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}
	
	
}
