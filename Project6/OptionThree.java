// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "NamedFloridaHurricane.txt" and computes different result 
//						based on the user's input.
import java.util.*;
import javax.swing.*;
import java.io.*;
public class OptionThree {
	public void optionThree(ArrayList<HurricaneEntry> hurricanelist) throws IOException{
		String option;
		option = JOptionPane.showInputDialog("Florida Names Hurricanes 1950 - 2022 \n\n "
				 + "Sort By Hurricane Year\n\n"
				 + "Press 1 for Ascending Order\n"
				 + "Press 2 for Descending Order\n");
		ArrayList<HurricaneEntry> res;
		switch(option) {
		case "1":
			res = sortByYearAscending(hurricanelist);
			displayOutput(res,1, "Year");
			writeOutput(res,1,"Year");
			break;
		case "2":
			res = sortByYearDescending(hurricanelist);
			displayOutput(res,2, "Year");
			writeOutput(res,2,"Year");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Wrong Choice!");
			optionThree(hurricanelist);
		}
	}//End of Option Three
	
	public static ArrayList<HurricaneEntry> sortByYearAscending(ArrayList<HurricaneEntry> hurricanelist) {
		ArrayList<HurricaneEntry> result  = new ArrayList<>();
		for(int j =1950;j<=2022;j++) {
			for(int k =0; k<hurricanelist.size();k++) {
				if(j == hurricanelist.get(k).getYear()) {
					result.add(new HurricaneEntry(hurricanelist.get(k).getName(),
							hurricanelist.get(k).getCategory(),
							hurricanelist.get(k).getMonth(),
							hurricanelist.get(k).getDay(),
							hurricanelist.get(k).getYear()));
				}
			}
		}
		return result;
	}// End of sortByYearAescending
	
	public static ArrayList<HurricaneEntry> sortByYearDescending(ArrayList<HurricaneEntry> hurricanelist) {
		ArrayList<HurricaneEntry> result  = new ArrayList<>();
		for(int j =2022;j>=1950;j--) {
			for(int k =0; k<hurricanelist.size();k++) {
				if(j == hurricanelist.get(k).getYear()) {
					result.add(new HurricaneEntry(hurricanelist.get(k).getName(),
							hurricanelist.get(k).getCategory(),
							hurricanelist.get(k).getMonth(),
							hurricanelist.get(k).getDay(),
							hurricanelist.get(k).getYear()));
				}
			}
		}
		return result;
	}// End of sortByYearDescending
	
	public static void displayOutput(ArrayList<HurricaneEntry> res, int option, String s) throws IOException {
		JFrame f= new JFrame();  
        JTextArea area=new JTextArea("Florida Named Hurricanes 1950 - 2022\n\n");
        String t = option == 1 ? "Ascending" : "Descending";
        area.append(String.format("Sort By %s in %s Order\n\n\n",s,t));
        area.append("Name          Category     Date\n");
        area.setBounds(10,30, 400,800);  
        f.add(area);  
        f.setSize(500,900);  
        f.setLayout(null);  
        f.setVisible(true); 
        for(int i =0; i<res.size();i++) {
        	area.append(res.get(i).getName());
        	for(int j =1; j<18-res.get(i).getName().length();j++) {
        		area.append(" ");
        	}
        	area.append(String.format("%d", res.get(i).getCategory()));
        	area.append("               ");
        	area.append(String.format("%d-%d-%d", res.get(i).getMonth(),res.get(i).getDay(),res.get(i).getYear()));
        	area.append("\n");
		}
	}// End of displayOutput
	
	public static void writeOutput(ArrayList<HurricaneEntry> res, int option, String s) throws IOException {
		String output_fileName = String.format("SortBy%sPanwar.txt",s);
		// To store the result in output file
		FileOutputStream out = new FileOutputStream(output_fileName);
		PrintWriter oF = new PrintWriter(out);
		String t = option == 1 ? "Ascending" : "Descending";
		oF.println("Florida Named Hurricanes 1950 - 2022");
		oF.println();
		oF.println();
		oF.println(String.format("Sort By %s in %s order.",s,t));
		oF.println();
		oF.println("Name   Category    Date");
		oF.println();
		for(int i =0; i<res.size();i++) {
			oF.println(res.get(i).toString());
		}
		oF.close();
	}// End of writeOutput
}
