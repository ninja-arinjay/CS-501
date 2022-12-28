
public class Triangle {
	
	private double base;
	private double height;
	private double area;
	
	//default constructor
	public Triangle() {
		base = 0;
		height = 0;
	}
	
	//overloaded constructor
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	//get for base 
	public double getBase() {
		return base;
	}
	
	//set for base
	public void setBase(double base) {
		this.base = base;
	}
	
	//get for height  
	public double getHeight() {
		return height;
	}
	
	//set for height
	public void setHeight(double height) {
		this.height = height;
	}
	
	//to calculate area
	public void calcArea() {
		area = (base * height)/2;
	}
	
	//to get area
	public double getArea() {
		return area;
	}
}
