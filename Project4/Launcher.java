// Name - Arinjay (Jay) Panwar

//Class - WS3

//Project description - A program that will prompt the user using a menu 
//                      that will ask if the user would like to calculate the 
//                      area of a circle, a rectangle, or a triangle. It will then display the calculated area.


import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// Variables
		char option = ' ';
		double radius = 0;
		double length = 0;
		double width = 0;
		double base = 0;
		double height = 0;
		
		System.out.println("Start of Area Calculator of different shapes.\n");
		
		//Display menu and get shape option
		option = displayMenu(scan, option);
		
		//get user input dimensions  and validate
		if(option == 'c') {
			System.out.println();
			System.out.println("Enter input radius of circle in metres :");
			radius = inputDimensions(scan, radius);
		}
		else if(option == 'r') {
			System.out.println();
			System.out.println("Enter input length of rectangle in metres :");
			length = inputDimensions(scan, length);
			System.out.println();
			System.out.println("Enter input width of rectangle in metres :");
			width = inputDimensions(scan, width);
		}
		else if(option == 't') {
			System.out.println();
			System.out.println("Enter input base of triangle in metres :");
			base = inputDimensions(scan, base);
			System.out.println();
			System.out.println("Enter input height of triangle in metres :");
			height = inputDimensions(scan, height);
		}
		
		//Calculating area of the shape 
		areaCalculation(option, radius, length, width, base, height);
		
		//Close the scanner object
		scan.close();
		System.out.println();
		System.out.println("End of Program.");
	}// end main
	
	public static char displayMenu(Scanner scan, char opt) {
		System.out.println();
		System.out.println("Press C for Circle");
		System.out.println("Press R for Rectangle");
		System.out.println("Press T for Triangle");
		
		System.out.println();
		
		System.out.println("Your choice : ");
		opt = scan.next().charAt(0);
		
		//lower case input
		opt = Character.toLowerCase(opt);
		
		//Validate input
		opt = validateOpt(scan, opt);
		
		return opt;
	}//end of display menu
	
	public static char validateOpt(Scanner scan, char op) {
		
		while(op != 'c' && op != 'r' && op != 't') {
			System.out.println("Invalid Entry, Please retry.");
			System.out.print("Your Option : ");
			op = scan.next().charAt(0);
			op = Character.toLowerCase(op);
		}
		 return op;
	}// end of validateOpt
	
	public static double inputDimensions(Scanner scan, double inp) {
		inp = scan.nextDouble();
		
		//validate input
		inp = validateInput(scan, inp);
		
		return inp;
	}// end of input Dimension
	
	public static double validateInput(Scanner scan, double inp) {
		while(inp<=0) {
			System.out.println();
			System.out.println("Invalid value entered. Please enter a positive value.");
			System.out.println("Enter input dimensions in metres :");
			inp = scan.nextDouble();
		}
		
		return inp;
	}//end of validate Input
	
	public static void areaCalculation(char option, double radius, double length, double width, double base, double height) {
		if(option == 'c') {
			Circle circle = new Circle(radius);
			System.out.println();
			circle.calcArea();
			System.out.printf("Area of Circle = %.2f metres square", circle.getArea());
		}
		else if(option == 'r') {
			Rectangle rectangle = new Rectangle(length, width);
			System.out.println();
			rectangle.calcArea();
			System.out.printf("Area of Rectangle = %.2f metres square", rectangle.getArea());
		}
		else if(option == 't') {
			Triangle triangle = new Triangle(base, height);
			System.out.println();
			triangle.calcArea();
			System.out.printf("Area of Triangle = %.2f metres square", triangle.getArea());
		}
	}//end of area calculations
}
