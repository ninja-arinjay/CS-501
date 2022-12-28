// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "studentInfo.txt" and computes grade of students
//						based on the user's input.
import java.util.*;
import java.io.*;
public class project9 {

	public static void main(String[] args) throws IOException {
		//File Not Found Exception
		// Input Mismatch Exception
		launch();
		

	}
	public static void launch() throws IOException {
		System.out.println("Student by Letter Grade\n");
		
		//variables      				
		int studentId;
	    double avgGrade;
	    double projectTotal;
		  
		GradeNode headNode;                                              
	    GradeNode currNode;
	    GradeNode lastNode;
	    
	    // Front of nodes list                                                                         
	    headNode = new GradeNode();
	    lastNode = headNode;
	      
	      
		//Open the file
		String input_fileName = "studentInfo.txt";
		try {
			File inp_file = new File(input_fileName);
			Scanner infile = new Scanner(inp_file);
			System.out.println("Opening file.....");
			System.out.println("Processing File.....\n");
			while(infile.hasNext()) {
				String line = infile.nextLine();
				line=line.trim();
				String[] tokens = line.split(" ");
				studentId = Integer.parseInt(tokens[0]);
				
				projectTotal = (Double.parseDouble(tokens[1])+Double.parseDouble(tokens[2]) + Double.parseDouble(tokens[4]) + Double.parseDouble(tokens[5]))/4;
				avgGrade = (projectTotal*50)/100 + (Double.parseDouble(tokens[3])*20)/100 + (Double.parseDouble(tokens[6])*30)/100;
				currNode = new GradeNode(studentId,avgGrade);
		        lastNode.insertAfter(currNode);
		        lastNode = currNode;
				
			}
			//close the file
			infile.close();
			userChoice(headNode);
			System.out.println("\nEnd of results");
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		
		
	}
	public static void userChoice(GradeNode headNode) {
		System.out.println("Enter the letter grade earned by students to display :\n");
		Scanner sc = new Scanner(System.in);
		String g = sc.nextLine();
		
	    
		switch(g) {
			case "A":
				printGradelist(headNode, "A",94, 100);
				break;
			case "A-":
				printGradelist(headNode, "A-",90, 93.9);
				break;
			case "B+":
				printGradelist(headNode, "B+",87, 89.9);
				break;
			case "B":
				printGradelist(headNode, "B",83, 86.9);
				break;
			case "B-":
				printGradelist(headNode, "B-",80, 82.9);
				break;
			case "C+":
				printGradelist(headNode, "C+",77, 79.9);
				break;
			case "C":
				printGradelist(headNode, "C",73, 76.9);
				break;
			case "C-":
				printGradelist(headNode, "C-",70, 72.9);
				break;
			case "D+":
				printGradelist(headNode, "D+",67, 69.9);
				break;
			case "D":
				printGradelist(headNode, "D",63, 66.9);
				break;
			case "D-":
				printGradelist(headNode, "D-",60, 62.9);
				break;
			case "F":
				printGradelist(headNode, "F",0, 59.9);
				break;
			default :
				System.out.println("Incorrect letter grade entered, try again.");
				userChoice(headNode);
				
		}
		sc.close();
	}
	public static void printGradelist(GradeNode headNode, String g,double min, double max) {
		// Print linked list
	    System.out.println("List Of Students with a "+g+" average ("+min+" - "+max+"%):");
	    System.out.println("-------------");
		GradeNode currNode;
		boolean flag = true;
		currNode = headNode.getNext();
		while(currNode != null) {
			double temp = currNode.getAvgGrade();
			if(temp>=min && temp<=max) {
				flag = false;
				currNode.printGradeInfo();
				System.out.println();
			}
			currNode = currNode.getNext();
		}
		if(flag) {
			System.out.println("No Student in the record with the given input Grade.");
		}
	}

}
