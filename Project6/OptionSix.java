// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "NamedFloridaHurricane.txt" and computes different result 
//						based on the user's input.
import java.util.*;
import javax.swing.*;
import java.io.*;
public class OptionSix {
	public void optionSix(ArrayList<HurricaneEntry> hurricanelist) throws IOException{
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i =0; i<hurricanelist.size(); i++) {
			hm.put(hurricanelist.get(i).getYear(), hm.getOrDefault(hurricanelist.get(i).getYear(),0)+1);
		}
		int max =0;
		for(Map.Entry<Integer, Integer> set : hm.entrySet()) {
			if(set.getValue()>=max) {
				max=set.getValue();
			}
		}
		for(Map.Entry<Integer, Integer> set : hm.entrySet()) {
			if(set.getValue()==max) {
				res.add(set.getKey());
			}
		}
		displayMostActiveYear(res,max);
	}// End of option Six
	
	public static void displayMostActiveYear(ArrayList<Integer> res, int max) {
		JFrame f= new JFrame();  
        JTextArea area=new JTextArea("Florida Named Hurricanes 1950 - 2022\n\n");
        area.append("Most Active Storm Year\n\n");
        area.setBounds(10,30, 400,800);  
        f.add(area);  
        f.setSize(500,600);  
        f.setLayout(null);  
        f.setVisible(true);
        area.append("Most active storm year is ");
        for(int i =0;i<res.size();i++) {
        	area.append(String.format("%d ", res.get(i)));
        }
        area.append(String.format("with %d named storms.",max));
	}// End of displayMostActiveYear
}
