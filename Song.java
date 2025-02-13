/*
 * Song class to store a songs name and artist
 * as well as if its a favorite song and its rating
 */

package Model;

public class Song {
	private String name;
	private String artist;
	private boolean isFavorite;
	private int rating;
	
	/*
	 * @par name != null && artist != null
	 */
	public Song(String name, String artist) {
		assert name != null && artist != null;
		this.name = name;
		this.artist = artist;
		isFavorite = false;
	}
	
	public void favorite() {
		// puts the book as a favorite
		isFavorite = true;
	}
	
	public void rate(int r) {
		// makes sure r is between 1 to 5
		assert r > 0 && r < 6;
		rating = r;
		// if the rating is 5 the book is automatically a favorite
		if (rating == 5) isFavorite = true;
	}
	
	public String getName() {
		return name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public boolean isFavorite() {
		return isFavorite;
	}
	
	@Override
	public String toString() {
		// prints name of the song and who its by
		String str = name + ", by: " + artist;
		return str;
	}
}
