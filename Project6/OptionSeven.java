// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "NamedFloridaHurricane.txt" and computes different result 
//						based on the user's input.
import java.util.*;
import javax.swing.*;
import java.io.*;
public class OptionSeven {
	public void optionSeven(ArrayList<HurricaneEntry> hurricanelist) throws IOException{
		int[] res = new int[5];
		int count=0;
		for(int i = 1; i<=5;i++) {
			count =0;
			for(int j=0; j<hurricanelist.size(); j++) {
				if(i==hurricanelist.get(j).getCategory()) {
					count++;
				}
			}
			res[i-1]=count;
		}
		displayAggCategory(res, hurricanelist);
		
	}// End of Option Seven
	
	public static void displayAggCategory(int[] res,ArrayList<HurricaneEntry> hurricanelist) throws IOException{
		JOptionPane.showMessageDialog(null, String.format("Florida Named Hurricanes 1950 - 2022 \n\n "
				+ "Aggregate Totals by Category (Staffir- Simpson scale)\n\n"
				+ "Total Number of Named Hurricanes = %d\n\n"
				+ "Total Category 5 hurricanes : %d\n"
				+ "Total Category 4 hurricanes : %d\n"
				+ "Total Category 3 hurricanes : %d\n"
				+ "Total Category 2 hurricanes : %d\n"
				+ "Total Category 1 hurricanes : %d\n",hurricanelist.size(), res[4],res[3],res[2],res[1],res[0]));
	}// End of displayAggCategory
}
