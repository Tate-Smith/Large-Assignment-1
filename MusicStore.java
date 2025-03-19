/*
 * This is the Music Store class that has an arrayList
 * of albums full of songs, which it makes from all
 * the files and their information. It also implements
 * search functions for the user to search a song by 
 * title or artist and search an album by title or artist
 */

package Model;

import java.util.HashMap;
import java.util.HashSet;

public class MusicStore {
	private String[] files = {"19_Adele.txt", "21_Adele.txt", 
			"A Rush of Blood to the Head_Coldplay.txt", "Begin Again_Norah Jones.txt", "Boys & Girls_Alabama Shakes.txt",
			"Coat of Many Colors_Dolly Parton.txt", "Cuando Los Angeles Lloran_Mana.txt", "Don't Mess With the Dragon_Ozomatli.txt",
			"Fight for Your Mind_Ben Harper.txt","Mission Bell_Amos Lee.txt", "Old Ideas_Leonard Cohen.txt",
			"Sigh No More_Mumford & Sons.txt", "Sons_The Heavy.txt", "Tapestry_Carol King.txt",
			"Waking Up_OneRepublic.txt"};
	private HashMap<String, Album> musicStore;
	
	public MusicStore() {
		// use the files to initialize the musicStore
		this.musicStore = new HashMap<String, Album>();
		for (String f: files) {
			Album a = new Album(f);
			musicStore.put(a.getTitle(), a);
		}
	}
	
	// creates a copy of the list of all albums in the music store
	public HashSet<Album> getAllAlbums(){
		return new HashSet<Album>(musicStore.values());
	}
	
	public Song getSong(String name, String artist) {
		for (Album a : musicStore.values()) {
			for (Song s : a.getSongs()) {
				if (s.getName().toLowerCase().equals(name) && s.getArtist().toLowerCase().equals(artist)) {
					return s;
				}
			}
		}
		return null;
	}
	
	public Album getAlbum(String name, String artist) {
		for (Album a : musicStore.values()) {
			if (a.getTitle().toLowerCase().equals(name) && a.getArtist().toLowerCase().equals(artist)) {
				return a;
			}
		}
		return null;
	}
	
	// search by song title
	public String getSongTitle(String title) {
		String str = "";
		for (Album a : musicStore.values()) {
			// sets every album to an arrayList of all its songs
			for (Song s : a.getSongs()) {
				// if name equals song add it to str
				if (s.getName().toLowerCase().equals(title)) str += s.toString() + "\n";
			}
		}
		// if it doesn't find any song called title then return error message
		if (str.length() == 0) return "Song Not Found";
		return str;
	}
	
	// search by song's artist
	public String getSongArtist(String artist) {
		String str = "";
		for (Album a : musicStore.values()) {
			// sets every album to an arrayList of all its songs
			for (Song s : a.getSongs()) {
				// if artist equals song's artist add it to str
				if (s.getArtist().toLowerCase().equals(artist)) str += s.toString() + "\n";
			}
		}
		// if it doesn't find any song by artist then return error message
		if (str.length() == 0) return "Song Not Found";
		return str;
	}
	
	// search by album title
	public String getAlbumTitle(String title) {
		if (!musicStore.containsKey(title)) return "Album Not Found";
		String str = "";
		for (Album a : musicStore.values()) {
			// if album title equals title add album to str
			if (a.getTitle().toLowerCase().equals(title)) str += a.toString();
		}
		// if it doesn't find any album called title then return error message
		return str;
	}
	
	// search by album's artist
	public String getAlbumArtist(String artist) {
		String str = "";
		for (Album a : musicStore.values()) {
			// if album's artist equals artist add album to str
			if (a.getArtist().toLowerCase().equals(artist)) str += a.toString();
		}
		// if it doesn't find any album by artist then return error message
		if (str.length() == 0) return "Album Not Found";
		return str;
	}
}