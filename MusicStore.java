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
	private String[] files = {"19_Adele.txt", "21_Adele.txt", 
			"A Rush of Blood to the Head_Coldplay.txt", "Begin Again_Norah Jones.txt", "Boys & Girls_Alabama Shakes.txt",
			"Coat of Many Colors_Dolly Parton.txt", "Cuando Los Angeles Lloran_Mana.txt", "Don't Mess With the Dragon_Ozomatli.txt",
			"Fight for Your Mind_Ben Harper.txt","Mission Bell_Amos Lee.txt", "Old Ideas_Leonard Cohen.txt",
			"Sigh No More_Mumford & Sons.txt", "Sons_The Heavy.txt", "Tapestry_Carol King.txt",
			"Waking Up_OneRepublic.txt"};
	private ArrayList<Album> musicStore;
	
	public MusicStore() {
	// use the files to initialize the musicStore
	this.musicStore = new ArrayList<>();
	for (String f: files) {
		Album a = new Album(f);
		musicStore.add(a);
	}

	}
	
	// creates a copy of the list of all albums in the music store
	public ArrayList<Album> getAllAlbums(){
		ArrayList<Album> copy = new ArrayList<>(musicStore);
		return copy;
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
	
	public static void main(String[] args) {
		MusicStore store = new MusicStore();
		ArrayList<Album> list = store.getAllAlbums();
		for (Album a: list) {
			System.out.println(a.toString());
		}
	}
}