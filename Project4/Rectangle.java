
public class Rectangle {
	
	private double length;
	private double width;
	private double area;
	
	//default constructor
	public Rectangle() {
		length = 0;
		width = 0;
	}
	
	//overloaded constructor
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	//get for length 
	public double getLength() {
		return length;
	}
	
	//set for length
	public void setLength(double length) {
		this.length = length;
	}
	
	//get for width  
	public double getWidth() {
		return width;
	}
	
	//set for width
	public void setWidth(double width) {
		this.width = width;
	}
	
	//to calculate area
	public void calcArea() {
		area = length * width;
	}
	
	//to get area
	public double getArea() {
		return area;
	}
}
