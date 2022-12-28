// Name - Arinjay (Jay) Panwar

// Class - CS 501-WS3

// Project Description - The project will read an input file and encrypt the contents of the file. After completion of encryption, It will 
//                       save the content to an output file.

//Importing util and io packages
import java.util.*;
import java.io.*;

public class Project3 {

	public static void main(String[] args) throws IOException{
		
		System.out.println("Encryption Level 1\n");
		
		//input and output file names
		String input_fileName = "Oct1.txt";
		String output_fileName = "EncryptedOct1.txt";
		
		// creating instance of File
		File inp_file = new File(input_fileName);
		
		System.out.println("Opening input file....\n");
		
		// Creating instance of scanner class to read inputs from the file
		Scanner iF = new Scanner(inp_file);
		
		// To store the result in output file
		FileOutputStream out = new FileOutputStream(output_fileName);
		PrintWriter oF = new PrintWriter(out);
		
		
		//create object 
		Encrypt en = new Encrypt(iF, oF);
		
		
		System.out.println("Encrypting....\n");
		
		//begin the process
		en.start();
		
		
		//Displaying the user that Encryption is completed
		System.out.println("Encryption complete.\n");
		
		//to close all the files
		closeFiles(iF, oF);
		
		//Displaying to user that Program has been completed
		System.out.println("End of program.\n");
	}
	
	private static void closeFiles(Scanner iF, PrintWriter oF) throws IOException{
		//Closing the instances 
		oF.close();
		iF.close();
	}

}
