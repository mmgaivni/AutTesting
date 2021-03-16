package SeleniumAutomation.Demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayDataCollectionExample {
	
	public void arrayExample1() {
		
		String[] values = new String[4];
	
		
		values[0] = "1";
		values[1] = "2";
		values[2] = "3";
		values[3] = "4";
		//values[4] = "5";
		
		for(int i=0;i<values.length;i++) {
			
			System.out.println("VAL : "+values[i]);
		}
		
		
		List<String> values1 = new ArrayList<String>();
		
		values1.add("1");
		values1.add("2");
		
		
		for(String val : values1) {
			
			System.out.println("VAL : "+val);
		}
		
		
	}
	
	public static void main(String args[]) {
		
		
		ArrayDataCollectionExample arrayDataCollectionExample = new ArrayDataCollectionExample();
		arrayDataCollectionExample.arrayExample1();
		
		//1. How to create array
		//2. How to assign the values to array
		//3. How to Iterate the values of array usinng for loop
		//4. Display the array elements using for loop
		
		//1. How to create array list
		//2. How to assign elements in the array list using add method
		//3. How to Iterate the array elelments using for loop
		//4. Display the arraylis elements using for loop.
	}

}
