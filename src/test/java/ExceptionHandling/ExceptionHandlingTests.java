package ExceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class ExceptionHandlingTests { 
	// Exceptions:
	
		// 1. Un Checked Exceptions : Run time exceptions
		// 2. Checked Exceptions : Compile time exceptions
		
		// ERRORS:
		//  Errors : We can not control the Errors 
		
		// Exception can be thrown or catch.
		
		// Try
		// Catch
		// Throws:  some times instead of try/catch we can use throws
		// Finally
		// throw : to throw custom exceptions, we use throw excepction, our own exceptions
	
	@Test
	public void checkedExceptionExample() 
	{
		
		try {
			
				FileInputStream in =  new FileInputStream("test.txt");
				System.out.println("File is present");
				 
		} catch (FileNotFoundException e){
			System.out.println("File is not present");    // if you know sure about exception type
		} catch (Exception e){
			System.out.println("File is not present");    // if you are not sure about the exception type
			e.printStackTrace();
			
		} finally {
			System.out.println("final block"); // something you want to execute common
		}
		
		System.out.println("here");
	}
	
	
	
	   public void checkedExceptionsExample1() throws FileNotFoundException {
			
			FileInputStream in = new FileInputStream("MyFirstcel.xlsx");
			System.out.println("Next statment");
			

	  }
	   	      
	   
	   public void callCheckedExceptionsExample1() throws FileNotFoundException
	   {
		   checkedExceptionsExample1();
		   //checkedExceptionExample(); 
		   
	   }
	   
	      
	   @Test
	   public void validate(){  
		   int age = 20;
		     if(age<18)  
		      throw new ArithmeticException("not valid");  
		     else  
		      System.out.println("welcome to vote"); 
		     
		   System.out.println("Next Statement");  
		}  
	   
	   
		
		@Test
		public void unCheckedException() {  //compile time exceptions
			
			try {
				int[] arrayValues = new int[3];
				arrayValues[4] = 1100;
			} catch(Exception e) {
				
				System.out.println("Exception Found"+e.getMessage());
			}
			
		}
	
}


