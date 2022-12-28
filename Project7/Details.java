// Arinjay (Jay) Panwar

// CS 501-WS3

//Project description - The Project will extract movies data from the output file and will sort the data based on the genre of the movies.
public class Details extends Movies {
	private String title;
	private String yearReleased;
	private String genre;
	private String rating;
	//Constructor 
	public Details(String d, String c, String t, String yr, String g, String r) {
		super(d,c);
		title = t;
		yearReleased = yr;
		genre = g;
		rating = r;
	}
	//Getter and setter methods
	public void setTitle(String t) {
		title = t;
	}
	public void setYearReleased(String yr) {
		yearReleased = yr;
	}
	public void setGenre(String g) {
		genre = g;
	}
	public void setRating(String r) {
		rating = r;
	}
	public String getTitle() { 
		return title;
	}
	public String getYearReleased() {
		return yearReleased;
	}
	public String getGenre() {
		return genre;
	}
	public String getRating() {
		return rating;
	}
	public String toString() {
		return "Director : " + getDirector() + "\nComposer : " + getComposer() + "\nTitle : " + title + "\nYear Released : " + yearReleased + "\nGenre : " + genre + "\nRating : " + rating;
	}
}
