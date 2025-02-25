/*
 * album class that has a name and an artist
 * its made by, as well as a list of songs
 */

package Model;

import java.util.ArrayList;

public class Album {
	private String title;
	private String artist;
	private ArrayList<Song> songs;
	
	/*
	 * @pre title != null && artist != null
	 */
	public Album(String title, String artist) {
		assert title != null && artist != null;
		this.title = title;
		this.artist = artist;
		this.songs = new ArrayList<>();
	}
	
	/*
	 * @pre name != null
	 */
	public void addSong(String name) {
		// so you can add songs to the album
		assert name != null;
		Song s = new Song(name, artist);
		this.songs.add(s);
	}
	
	/*
	 * @pre name != null
	 */
	public void removeSong(String name, String artist) {
		// removes a song with the name and artist from the album
		assert name != null;
		for (Song s : songs) {
			if (s.getName().equals(name) && s.getArtist().equals(artist)) songs.remove(s);
		}
	}
	
	public ArrayList<Song> getSongs() {
		// gets a list of all songs in the album with no escaping references
		return new ArrayList<>(songs);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	@Override
	public String toString() {
		// prints out the song title and artist followed by all it's songs
		String str = title + ", by: " + artist + "\n";
		for (Song s : songs) {
			str += s.getName();
			str += "\n";
		}
		return str;
	}
}
