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
	
	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
		ArrayList<Song> songs = new ArrayList<>();
	}
	
	public void addSong(String name) {
		// so you can add songs to the album
		Song song = new Song(name, artist);
		songs.add(song);
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
