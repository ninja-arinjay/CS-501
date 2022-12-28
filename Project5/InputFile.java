// Name - Arinjay (Jay) Panwar

//Class - CS501-WS3

//Project description - The program will analyze the words in the input file and will display the output containing unique words
//						having frequency and palindrome status.
import java.io.File;
import java.io.IOException;
import java.util.*;
	
public class InputFile{
	
	// List variable to store all the words present in the input file.
	ArrayList<String> list = new ArrayList<String>();
	
	//default constructor
	public InputFile() {
		int len = list.size();
		for(int i =0; i<len;i++) {
			this.list.set(i,"");
		}
	}
	
	public void driver() throws IOException{
		
		// Calling readInput function
		readInput();
		
		// instantiate an object of class Analysis
		Analysis an = new Analysis(list);
		
		//Call the driver method in class Analysis
		an.driver();
	}
	
	private void readInput() throws IOException{
		
		String input_fileName = "inPoem.txt";
		File inp_file = new File(input_fileName);
		// Opening the text file
		Scanner inFile = new Scanner(inp_file);
		
		System.out.println("Opening Input File....\n");
		
		while(inFile.hasNext()) {
			String sentence = inFile.nextLine();
			sentence = sentence.trim();
			int len = sentence.length();
			String temp ="";
			for(int i = 0; i<len;i++) {
				if((int)sentence.charAt(i) == 32) {
					list.add(temp);
					temp="";
				}
				else {
					int check = (int)sentence.charAt(i);
					if((check >=65 && check <=90) || (check>=97 && check <=122)) {
						temp = temp+sentence.charAt(i);
					}
				}
			}
			list.add(temp);
		}
		// calling the closeFile function
		closeFile(inFile);
	}
	
	private void closeFile(Scanner inFile) {
		// close the input file
		inFile.close();
	}
	
}// end of class InputFile
