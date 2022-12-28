// Name : Arinjay (Jay) Panwar
// Class : CS 501-WS3
//Project Description : A Calculator is developed that performs all the basic arithmetic calculations,
//                      taking input from the user and then return the result after performing the calculations.



//Importing util package
import java.util.*;
public class Calculator {
	
	//Private member for calculator current's value
	private double value;
	
	//default constructor method to set the member field to 0.0
	public Calculator(){
		this.value = 0.0;
	}
	
	//add the parameter to the member field
	public void add(double val) {
		value = value + val;
	}
	
	//subtract the parameter from the member field
	public void subtract(double val) {
		value = value - val;
	}
	
	//multiply the member field by the parameter
	public void multiply (double val) {
		value = value * val;
	}
	
	//divide the member field by the parameter
	public void divide(double val) {
		value = value / val;
	}
	
	//set the member field to 0.0
	public void clear() {
		value = 0.0;
	}
	
	//return the member field
	public double getValue() {
		return value;
	}
	
	//Main method
	public static void main(String[] args) {
		//Title of the program
		System.out.println("The Calculator Program\n");
		
		//Creating Scanner class object
		Scanner myObj = new Scanner(System.in);
		
		
		//Prompting user to enter num1
		System.out.print("Enter the first number: ");
		double num1 = myObj.nextDouble();
		
		//Prompting user to enter num2
		System.out.print("\nEnter the second number : ");
		double num2 = myObj.nextDouble();
		
		//Printing out the output after calling methods
		System.out.println("\n\nOutput :\n\n");
		
		//Creating calculator class object c1
		Calculator c1 = new Calculator();
		
		
		//Calling getValue method and printing it
		System.out.println(c1.getValue());
		
		//Calling add method
		c1.add(num1);
		
		//Calling getValue method and printing it
		System.out.println(c1.getValue());
		
		//Calling multiply method
		c1.multiply(3);
		
		//Calling getValue method and printing it
		System.out.println(c1.getValue());
		
		//Calling subtract method
		c1.subtract(num2);
		
		//Calling getValue method and printing it
		System.out.println(c1.getValue());
		
		//Calling divide function
		c1.divide(2.0);
		
		//Calling getValue method and printing it
		System.out.println(c1.getValue());
		
		//Calling clear method, to get the value to 0.0
		c1.clear();
		
		//Calling getValue method and printing it
		System.out.println(c1.getValue());
		
		//End Statement 
		System.out.println("\nEnd of results");
		
		myObj.close();
	}

}
