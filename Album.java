/*
 * album class that has a name and an artist
 * its made by, as well as a list of songs
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
	
	
	public Album(String fileName) {
		try {
			loadAlbum(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();	
		}
		
	}
	
	
	/* @pre fileName != null 
	 *
	 */
	// use this method to scrape the files and make albums and add songs
	private void loadAlbum(String fileName) throws FileNotFoundException {
		assert fileName != null;
		File info = new File(fileName);
		Scanner myReader = new Scanner(info);
		String[] firstLine = myReader.nextLine().split(",");
		this.title = firstLine[0];
		this.artist = firstLine[1];
		while (myReader.hasNextLine()) {
			String[] albumContent = myReader.nextLine().split(",");
			Song song = new Song(albumContent[0], albumContent[1]);
			this.songs.add(song);
		}
		myReader.close();
		// open file
		// populate album with songs form file
		// make sure for every song in file make it into a song object
		// add album to musicStore
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