package SeleniumAutomation.Demo.firstpackage;

import org.testng.annotations.Test;

public class SecondTestClass extends AbstractTestClass {
	
	@Test
	public void secondTestMethod1() {
		
		System.out.println("Second Test Method1");
	}
	
	@Test
    public void secondTestMethod2() {
		
		System.out.println("Second Test Method2");
		commonUtilityMethod();
	}

}
