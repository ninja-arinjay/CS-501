// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "NamedFloridaHurricane.txt" and computes different result 
//						based on the user's input.

import java.util.*;
import javax.swing.*;
import java.io.*;
public class Project6 {
	public static void main(String[] args) throws IOException
	{
		Driver();
		
	}//end of main
	
	public static void Driver() throws IOException {
		ArrayList<HurricaneEntry> hurricanelist = buildHurricaneEntryList();
		String option;
		option =JOptionPane.showInputDialog("Florida Names Hurricanes 1950 - 2022 \n\n "
											 + "Press 1 to Sort by Storm Name\n"
											 + "Press 2 to Sort by Storm Category\n"
											 + "Press 3 to Sort by Storm Year\n"
											 + "Press 4 to Sort by Storm Month\n"
											 + "Press 5 to Display the Average Storm Category\n"
											 + "Press 6 to Display the Most Active Hurricane Year\n"
											 + "Press 7 to Display the Total Number of Storms by Category\n"
											 + "Press 8 to Display the Total Number of Storms by Year\n"
											 + "Press 9 to Exit\n");
		switch(option){
		case "1":
			OptionOne a1 = new OptionOne();
			a1.optionOne(hurricanelist);
			break;
		case "2":
			OptionTwo a2 = new OptionTwo();
			a2.optionTwo(hurricanelist);
			break;
		case "3":
			OptionThree a3 = new OptionThree();
			a3.optionThree(hurricanelist);
			break;
		case "4":
			OptionFour a4 = new OptionFour();
			a4.optionFour(hurricanelist);
			break;
		case "5":
			OptionFive a5 = new OptionFive();
			a5.optionFive(hurricanelist);
			break;
		case "6":
			OptionSix a6 = new OptionSix();
			a6.optionSix(hurricanelist);
			break;
		case "7":
			OptionSeven a7 = new OptionSeven();
			a7.optionSeven(hurricanelist);
			break;
		case "8":
			OptionEight a8 = new OptionEight();
			a8.optionEight(hurricanelist);
			break;
		case "9" :
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Wrong Choice!");
			Driver();
		}
		
	}//End of Driver
	
	public static ArrayList<HurricaneEntry> buildHurricaneEntryList() throws IOException
	{
		ArrayList<HurricaneEntry> hurricanelist = new ArrayList<>();
		
		//Open the file
		String input_fileName = "NamedFloridaHurricanes.txt";
		File inp_file = new File(input_fileName);
		Scanner infile = new Scanner(inp_file);
		 
		 //Read the file's contents into the ArrayList
		 
		 while(infile.hasNext()) {
			 
			 //Read a Line
			 String line = infile.nextLine();
			 
			 //Split the line into tokens to get the name, category and date
			 
			 String[] majorTokens = line.split(":");
			 
			 String[] nameTokens = majorTokens[0].split(",");
			 
			 //Split the date into tokens for month, day , year 
			 
			 String[] dateTokens = majorTokens[1].split("/");
			 
			 //Build a HurricaneEntry object and add it to the arrayList
			 hurricanelist.add(new HurricaneEntry(nameTokens[0],
					 							  Integer.parseInt(nameTokens[1]),
					 							  Integer.parseInt(dateTokens[0]),
					 							  Integer.parseInt(dateTokens[1]),
					 							  Integer.parseInt(dateTokens[2])));
			 
		 }
		 
		 //close the file
		 infile.close();
		 
		 return hurricanelist;
	}//End of buildHurricaneList	
}
