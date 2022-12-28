// Arinjay (Jay) Panwar

// CS 501-WS3

//Project description - The Project will extract movies data from the output file and will sort the data based on the genre of the movies.
public class Movies {
	private String director;
	private String composer;
	
	//Constructor method
	public Movies(String d,String c){
		director = d;
		composer = c;
	}
	//Getter and setter methods
	public void setDirector(String d) {
		director = d;
	}
	public void setComposer(String c) {
		composer = c;
	}
	public String getDirector() {
		return director;
	}
	public String getComposer() {
		return composer;
	}
	public String toString() {
		return "Director : " + director + "\n Composer :" + composer;
	}
}
