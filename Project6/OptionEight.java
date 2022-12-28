// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "NamedFloridaHurricane.txt" and computes different result 
//						based on the user's input.
import java.util.*;
import javax.swing.*;
import java.io.*;
public class OptionEight {
	public void optionEight(ArrayList<HurricaneEntry> res) throws IOException{
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i =0; i<res.size(); i++) {
			hm.put(res.get(i).getYear(), hm.getOrDefault(res.get(i).getYear(),0)+1);
		}
		displayAggYear(hm);
	}// End of Option Eight
	
	public static void displayAggYear(HashMap<Integer, Integer> hm ) {
		JFrame f= new JFrame();  
        JTextArea area=new JTextArea("Florida Named Hurricanes 1950 - 2022\n\n");
        area.append("Aggregate Totals by Year\n\n");
        area.append("Year     Number Of Storms\n");
        area.setBounds(10,30, 400,800);  
        f.add(area);  
        f.setSize(300,600);  
        f.setLayout(null);  
        f.setVisible(true); 
        TreeMap<Integer,Integer> tm=new  TreeMap<Integer,Integer> (hm);  
        Iterator<Integer> itr=tm.keySet().iterator();
        while(itr.hasNext())    
        {    
        	int key=(int)itr.next();  
        	area.append(String.format("%d",key));
        	area.append("      ");
        	area.append(String.format("%d\n",hm.get(key)));  
        }    
	}// End of displayAggYear
}
