/*
 * This is the Music Store class that has an arrayList
 * of albums full of songs, which it makes from all
 * the files and their information. It also implements
 * search functions for the user to search a song by 
 * title or artist and search an album by title or artist
 */

package Model;


import java.util.ArrayList;

public class MusicStore {
	private ArrayList<Album> musicStore;
	
	public MusicStore() {
		// use the files to initialize the musicStore
		ArrayList<Album> musicStore = new ArrayList<>();
		// pass every file name to loadAlbum to populate musicStore
	}
	
	// add an album to the music store
	public void addAlbum(Album album) {
		musicStore.add(album);
	}
	
	// get a song by name and artist from the music store
	public Song getSong(String name, String artist) {
		for (Album a : musicStore) {
			for (Song s : a.getSongs()) {
				if (s.getName().equals(name) && s.getArtist().equals(artist)) {
					return s;
				}
			}
		}
		return null;
	}
	
	// get a album by name and artist from the music store
		public Album getAlbum(String name, String artist) {
			for (Album a : musicStore) {
				if (a.getTitle().equals(name) && a.getArtist().equals(artist)) {
					return a;
				}
			}
			return null;
		}
	
	// search by song title
	public String getSongTitle(String title) {
		String str = "";
		for (Album a : musicStore) {
			// sets every album to an arrayList of all its songs
			ArrayList<Song> album = a.getSongs();
			for (Song s : album) {
				// if name equals song add it to str
				if (s.getName().equals(title)) {
					str += s.toString() + "," + a.getTitle() + "\n";
				}
			}
		}
		// if it doesn't find any song called title then return error message
		if (str.length() == 0) return "Song Not Found";
		return str;
	}
	
	// search by song's artist
	public String getSongArtist(String artist) {
		String str = "";
		for (Album a : musicStore) {
			// sets every album to an arrayList of all its songs
			ArrayList<Song> album = a.getSongs();
			for (Song s : album) {
				// if artist equals song's artist add it to str
				if (s.getArtist().equals(artist)) {
					str += s.toString() + ", " + a.getTitle() + "\n";
				}
			}
		}
		// if it doesn't find any song by artist then return error message
		if (str.length() == 0) return "Song Not Found";
		return str;
	}
	
	// search by album title
	public String getAlbumTitle(String title) {
		String str = "";
		for (Album a : musicStore) {
			// if album title equals title add album to str
			if (a.getTitle().equals(title)) str += a.toString();
		}
		// if it doesn't find any album called title then return error message
		if (str.length() == 0) return "Album Not Found";
		return str;
	}
	
	// search by album's artist
	public String getAlbumArtist(String artist) {
		String str = "";
		for (Album a : musicStore) {
			// if album's artist equals artist add album to str
			if (a.getArtist().equals(artist)) str += a.toString();
		}
		// if it doesn't find any album by artist then return error message
		if (str.length() == 0) return "Album Not Found";
		return str;
	}
}