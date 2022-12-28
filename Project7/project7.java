// Arinjay (Jay) Panwar

// CS 501-WS3

//Project description - The Project will extract movies data from the output file and will sort the data based on the genre of the movies.
import java.util.*;
import java.io.*;
public class project7 {
	
	public static void main(String[] args) throws IOException{
		driver();
	}
	public static void driver() throws IOException{
		String input_fileName = "MovieListing.txt";
		//Open the File
		File inp_file = new File(input_fileName);
		Scanner infile = new Scanner(inp_file);
		
		//Read the file's contents into the ArrayList
		int count = 0;
		String d ="";
		String c ="";
		ArrayList<Details> warList = new ArrayList<>();
		ArrayList<Details> thrillerList = new ArrayList<>();
		ArrayList<Details> scifiList = new ArrayList<>();
		ArrayList<Details> adventureList = new ArrayList<>();
		ArrayList<Details> dramaList = new ArrayList<>();
		ArrayList<Details> romanceList = new ArrayList<>();
		ArrayList<Details> fantasyList = new ArrayList<>();
		while(infile.hasNext()) {
			
			//Read a Line
			String line = infile.nextLine();
			if(count==0) {
				d = line.trim();
			}
			else if(count == 1) {
				c =line.trim();
			}
			else {
				String[] majorTokens = line.split(",");
				String g = majorTokens[2].trim();
				if(g.equals("War")) {
					warList.add(new Details(d,c, majorTokens[0].trim(), majorTokens[1].trim(), g, majorTokens[3].trim()));
				}
				else if(g.equals("Thriller"))
				{
					thrillerList.add(new Details(d,c, majorTokens[0].trim(), majorTokens[1].trim(), g, majorTokens[3].trim()));
				}
				else if(g.equals("Sci Fi"))
				{
					scifiList.add(new Details(d,c, majorTokens[0].trim(), majorTokens[1].trim(), g, majorTokens[3].trim()));
				}
				else if(g.equals("Adventure")) 
				{
					adventureList.add(new Details(d,c, majorTokens[0].trim(), majorTokens[1].trim(), g, majorTokens[3].trim()));
				}
				else if(g.equals("Drama")) 
				{
					dramaList.add(new Details(d,c, majorTokens[0].trim(), majorTokens[1].trim(), g, majorTokens[3].trim()));
				}
				else if(g.equals("Romance"))
				{
					romanceList.add(new Details(d,c, majorTokens[0].trim(), majorTokens[1].trim(), g, majorTokens[3].trim()));
				}
				else if(g.equals("Fantasy"))
				{
					fantasyList.add(new Details(d,c, majorTokens[0].trim(), majorTokens[1].trim(), g, majorTokens[3].trim()));
				}
				else
				{
					System.out.println("Error : Unknown Genre");
				}
			}
			count++;
		}
		//Sorting the arrayList(s)
		Collections.sort(warList, project7.getCompByYear() );
		Collections.sort(thrillerList, project7.getCompByYear() );
		Collections.sort(scifiList, project7.getCompByYear() );
		Collections.sort(adventureList, project7.getCompByYear() );
		Collections.sort(dramaList, project7.getCompByYear() );
		Collections.sort(romanceList, project7.getCompByYear() );
		Collections.sort(fantasyList, project7.getCompByYear() );
		//Close the file
		infile.close();
		
		
		optionDisplay(d,c,adventureList,dramaList,fantasyList,romanceList,scifiList,thrillerList,warList);
	}
	//To display the available options to the user 
	public static void optionDisplay(String d, String c, ArrayList<Details> adventureList, ArrayList<Details> dramaList,ArrayList<Details> fantasyList,ArrayList<Details> romanceList, ArrayList<Details> scifiList, ArrayList<Details> thrillerList, ArrayList<Details> warList) {
		System.out.println("Director/Composer Movies");
		System.out.println("\nDirector: "+ d);
		System.out.println("Composer: "+ c);
		System.out.println("\nWhich genre would you like:");
		System.out.println("\n1. Adventure");
		System.out.println("2. Drama");
		System.out.println("3. Fantasy");
		System.out.println("4. Romance");
		System.out.println("5. Sci Fi");
		System.out.println("6. Thriller");
		System.out.println("7. War");
		System.out.println("\nYour Choice:");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch(choice) {
		case "1":
			printResult(d,c,adventureList, "Adventure");
			break;
		case "2":
			printResult(d,c,dramaList,"Drama");
			break;
		case "3":
			printResult(d,c,fantasyList,"Fantasy");
			break;
		case "4":
			printResult(d,c,romanceList,"Romance");
			break;
		case "5":
			printResult(d,c,scifiList,"Sci Fi");
			break;
		case "6":
			printResult(d,c,thrillerList,"Thriller");
			break;
		case "7":
			printResult(d,c,warList,"War");
			break;
		default:
			System.out.println("Wrong Input");
		}
		//Closing Scanner class
		sc.close();
	}
	//To Print the final list 
	public static void printResult(String d, String c, ArrayList<Details> list, String g) {
		System.out.println("Director : "+ d);
		System.out.println("Composer : " +c);
		System.out.println("\nGenre : "+g);
		System.out.println("\nMovie Title \t\t\t Year Released \t Rating");
		for(int i =0; i<list.size();i++) {
			System.out.print(list.get(i).getTitle());
			for(int j =0;j<=40-list.get(i).getTitle().length();j++) {
				System.out.print(" ");
			}
			System.out.print(list.get(i).getYearReleased());
			System.out.print("\t  ");
			System.out.print(list.get(i).getRating());
			System.out.println();
		}
	}
	//To Sort the ArrayLists
	public static Comparator<Details> getCompByYear() {
		Comparator<Details> comp = new Comparator<Details>() {
			@Override
			public int compare(Details d1, Details d2) {
				if(d1.getYearReleased().equals(d2.getYearReleased())) {
					return d1.getTitle().compareTo(d2.getTitle());
				}else {
					return d1.getYearReleased().compareTo(d2.getYearReleased());
				}
			}
		};
		return comp;
	}
}
