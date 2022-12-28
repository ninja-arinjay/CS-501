// Name - Arinjay (Jay) Panwar

//Class - CS501-WS3

//Project description - The program will analyze the words in the input file and will display the output containing unique words
//						having frequency and palindrome status.
import java.util.ArrayList;

public class Analysis {
	
	//variables 
	ArrayList<String> list = new ArrayList<String>();
	//List storing the unique words in the file
	ArrayList<String> result = new ArrayList<String>();
	//List storing the frequency of each word in the file
	ArrayList<Integer> freq = new ArrayList<Integer>();
	//List storing if the word is Palindrome or not
	ArrayList<Boolean> palindrome = new ArrayList<Boolean>();
	
	
	//default constructor
	public Analysis() {
		int len = list.size();
		for(int i =0; i<len;i++) {
			this.list.set(i,"");
		}
	}
		
		
	//Constructor to initialize the list variable
	public Analysis(ArrayList<String> list) {
		int len = list.size();
		for(int i =0; i<len;i++) {
			this.list.add(list.get(i));
		}
	}
	
	//driver function
	public void driver() {
		
		//calling sortList function to sort the words in the list.
		list = sortList(list);
		
		//Calling to store the frequency of each words in the list.
		calcFrequency(list);
		
		//Calling to store whether the word is a palindrome or not 
		calcPalindrome();
		
		// Calling to print the result to the user
		printResult();
	}
	
	//Returns a sorted list
	private ArrayList<String> sortList(ArrayList<String> l) {
		l.sort(null);
		return l;
	}
	
	//Calculating frequency of each word
	private void calcFrequency(ArrayList<String> l) {
		int count =0;
		for(int j =0; j<l.size(); j++) {
			count = 0; 
			for(int k =j; k<l.size();k++) {
				if(l.get(j).equals(l.get(k))) {
					count++;
				}
			}
			if(check(result, l.get(j))) {
				result.add(l.get(j));
				freq.add(count);
			}
		}
	}// end of calcFreequency Method
	
	//calculating if the word is palindrome or not
	private void calcPalindrome() {
		for(String st : result) {
			if(palindromeCheck(st)) {
				palindrome.add(true);
			}
			else {
				palindrome.add(false);
			}
		}
	}//end of calcPalindrome
	
	private boolean check(ArrayList<String> l, String s) {
		for(String ls : l) {
			if(ls.equals(s)) {
				return false;
			}
		}
		return true;
	}
	
	//Check a word is a plaindrome or not
	private boolean palindromeCheck(String s) {
		String temp = "";
		for(int i = s.length()-1; i>=0;i--) {
			temp = temp+s.charAt(i);
		}
		if(temp.equals(s)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Displaying the result to the user
	private void printResult() {
		System.out.println("Word \t\t Frequency \t Palindrome");
		System.out.println();
		for(int i =0; i<result.size();i++) {
			System.out.println(result.get(i)+"\t\t  "+freq.get(i)+"\t\t  "+palindrome.get(i));
		}
		System.out.println();
		System.out.println("End of results.");
	}
	
} // End of Analysis File
