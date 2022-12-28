// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "NamedFloridaHurricane.txt" and computes different result 
//						based on the user's input.
public class HurricaneEntry {
	private String name;
	private int category;
	private int month;
	private int day;
	private int year;
	
	//Constructor
	public HurricaneEntry(String n, int c, int m, int d, int y) {
		name = n;
		category = c;
		month = m;
		day = d;
		year = y;
	}
	
	// Accessors
	public String getName() {
		return name;
	}
	public int getCategory() {
		return category;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public String toString() {
		return name + "    "+ 
				Integer.toString(category) +"     " + 
				Integer.toString(month)+"/"+
				Integer.toString(day)+"/"+
				Integer.toString(year);
	}
}
