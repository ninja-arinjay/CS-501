public class Circle {
	
	private double radius;
	private final double PI = 3.14159;
	private double area;
	
	//default constructor
	public Circle() {
		radius = 0;
	}
	
	//overloaded constructor
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//get for radius 
	
	public double getRadius() {
		return radius;
	}
	
	//set for radius 
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//To calculate area
	public void calcArea() {
		area = PI * Math.pow(radius, 2);
	}
	
	//to get area
	public double getArea() {
		return area;
	}
}
