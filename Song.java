/*
 * Song class to store a songs name and artist
 * as well as if its a favorite song and its rating
 * is an immutable type since all instance variables
 * are private and no setters
 */

package Model;

public class Song {
	private String name;
	private String artist;
	private boolean isFavorite;
	private int rating;
	private String album;
	private int numPlays;
	private String genre;
	
	/*
	  * @pre name != null && artist != null && album != null
	 */
	public Song(String name, String artist, String album, String genre) {
		assert name != null && artist != null && album != null;
		this.name = name;
		this.artist = artist;
		this.isFavorite = false;
		this.album = album;
		this.numPlays = 0;
		this.genre = genre;
	}
	
	public void favorite() {
		// puts the book as a favorite
		isFavorite = true;
	}
	
	public void play() {
		numPlays++;
	}
	
	public int getPlays() {
		return numPlays;
	}
	
	public String getGenre() {
		return this.genre.toLowerCase();
	}
	
	/*
	 * @pre r > 0 && r < 6
	 */
	public void rate(int r) {
		// makes sure r is between 1 to 5
		assert r > 0 && r < 6;
		rating = r;
		// if the rating is 5 the book is automatically a favorite
		if (rating == 5) isFavorite = true;
	}
	
	public String getAlbum() {
		return album.toLowerCase();
	}
	
	public String getName() {
		return name.toLowerCase();
	}
	
	public String getArtist() {
		return artist.toLowerCase();
	}
	
	public boolean isFavorite() {
		return isFavorite;
	}
	
	public int getRating() {
		return rating;
	}
	
	@Override
	public String toString() {
		// prints name of the song and who its by
		String str = name + ", by: " + artist + ", " + album + ", " + genre + "\n";
		return str;
	}
}