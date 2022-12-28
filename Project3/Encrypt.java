import java.util.*;
import java.io.*;

public class Encrypt {

	//variables
	private Scanner inF;
	private PrintWriter outF;
	
	private String input_string;
	private int len;
	private String res;
	private int  temp;
	private int difference;
	private char ch;
	
	//constructor
	public Encrypt(Scanner iF, PrintWriter oF) {
		inF = iF;//input file
		outF = oF;//output file
	}
	
	public void start() {
		while(inF.hasNext()) {
			readValues();
			encryptData();
			write();
		}
	}//end start
	
	
	//this method will read input from the files
	private void readValues() {
		// Taking input from file.
		input_string = inF.nextLine();
	}//end read Values
	
	
	//this method will encrypt the data
	private void encryptData() {
		//Calculating length of the input String
		len = input_string.length();
				
		//To store the encrypted string
		res = "";
		//Loop to encrypt every character of the string 
		for(int i=0; i<len; i++) {
					
			//Converting the character of the string into ASCII value
			temp = (int)input_string.charAt(i);
					
			if(temp >= 65 && temp <= 90) {
				temp = temp + 35;
						
				if(temp>122) {
					difference = temp -122;
					temp = 96 + difference;
					}
				}
					
			else if(temp >= 97 && temp <= 122) {
				temp = temp - 29;
				
				if(temp>90) {
					difference = temp - 90;
					temp = 64 + difference;
					}
				}
					
			// Converting it back to char value 
			ch = (char)temp;
			res = res + ch;
			}
	}//end encryptData
	
	
	//this method will write the data to another file
	private void write() {
		outF.println(res);
	}//end write
}
