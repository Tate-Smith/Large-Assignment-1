/*
 * album class that takes a file name that holds
 * all the album information and then populates the 
 * songs list with all its songs. It is also an
 * immutable type
 */

package Model;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Album {
	private String title;
	private String artist;
	private ArrayList<Song> songs;
	private String genre;
	
	public Album(String fileName) {
		try {
			loadAlbum(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();	
		}
	}
	
	public Album(Album album) {
		// copy album
		this.title = album.title;
		this.artist = album.artist;
		this.genre = album.genre;
		this.songs = new ArrayList<Song>();
	}
	
	// use this method to scrape the files and make albums and add songs
	private void loadAlbum(String fileName) throws FileNotFoundException {
		File info = new File(fileName);
		Scanner myReader = new Scanner(info);
		// set the album title and artist from the first line
		String[] firstLine = myReader.nextLine().split(",");
		this.title = firstLine[0];
		this.artist = firstLine[1];
		this.genre = firstLine[2];
		this.songs = new ArrayList<>();
		// get all the songs from the album file
		while (myReader.hasNextLine()) {
			// create all the songs then add them to songs
			Song song = new Song(myReader.nextLine(), artist, title, genre);
			this.songs.add(song);
		}
		myReader.close();
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
	
	public void addSong(Song s) {
		songs.add(s);
	}
	
	@Override
	public String toString() {
		// prints out the song title and artist followed by all it's songs
		String str = title + ", by: " + artist + "\n";
		for (Song s : songs) {
			str += s.getName() + "\n";
		}
		return str;
	}
}