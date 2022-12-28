// Name - Arinjay (Jay) Panwar

//Class - CS501-WS3

//Project description - The program will analyze the words in the input file and will display the output containing unique words
//						having frequency and palindrome status.
import java.io.IOException;

public class Launcher {

	public static void main(String[] args)throws IOException{
		
		System.out.println("Poem Word Analysis\n");
		
		// instantiate an object of class InputFile
		InputFile inf = new InputFile();
		
		//Call the driver method in class InputFile
		inf.driver();
	}

}
