// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "NamedFloridaHurricane.txt" and computes different result 
//						based on the user's input.
import java.util.*;
import javax.swing.*;
import java.io.*;
public class OptionFive {
	public void optionFive(ArrayList<HurricaneEntry> hurricanelist) throws IOException{
		int sum = 0;
		double avg;
		for(int i =0; i<hurricanelist.size(); i++) {
			sum = sum+ hurricanelist.get(i).getCategory();
		}
		avg = sum/hurricanelist.size();
		displayAvgOutput(avg);
	}// End of Option Five
	
	public static void displayAvgOutput(double avg ) throws IOException{
		JOptionPane.showMessageDialog(null, String.format("Florida Named Hurricanes 1950 - 2022 \n\n Average Storm "
				+ "Category by Saffir-Simpson Scale\n\n Average Storm Category is %.1f",avg));
	}// End of displayAvgOutput
}
