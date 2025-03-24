/*
 * This class allows the user to add songs or albums from the
 * musicStore to their own library, create their own playlist,
 * rate or mark songs as favorite, search their library for
 * songs by title or artist, and albums by title or artist,
 * and finally list all items in the library. Very similar
 * to musicStore but no files to scrape and its the users
 * own library.
 */
package Model;

import java.util.*;
import java.lang.reflect.Array;



public class LibraryModel {
	private HashMap<String, Song> songs;
	private HashMap<String, Album> albums;
	private HashMap<String, PlayList> playlists;
	private ArrayList<Song> recentSongs;
	private LinkedList<Song> recents;
	private ArrayList<Song> frequents;

	public LibraryModel() {
		songs = new HashMap<String, Song>();
		albums = new HashMap<String, Album>();
		playlists = new HashMap<String, PlayList>();
		recentSongs = new ArrayList<Song>();
		recents = new LinkedList<Song>();
		frequents = new ArrayList<Song>();
	
		
		this.makePlaylist("Favorites");
		this.makePlaylist("Recents");
		this.makePlaylist("Frequents");
	}
	
	
	/* This method uses the sortedSet interface, more specifically tree sets to sort all of the songs
	 * by number of plays in descending order*/
	
	private void updateFrequents() {
	
		// convert treeSet to arrayList to be able to index the treeSet
		List <Song> allFreqSongs = new ArrayList<Song>(songs.values());
		Collections.sort(allFreqSongs, (s1,s2) -> Integer.compare(s1.getPlays(), s2.getPlays()));
		// removes all songs with 0 plays
		allFreqSongs.removeIf(song -> song.getPlays() == 0);
		// size of list is greater than 10 then only set frequents to the 10 most frequently played songs
		if (allFreqSongs.size() > 10) {
			frequents = (ArrayList<Song>) allFreqSongs.subList((allFreqSongs.size() - 10), allFreqSongs.size());
		} else {
			frequents = (ArrayList<Song>) allFreqSongs; // otherwise just set frequents to the songs that have been played
		}
	}

	public void makePlaylist(String name) {
		PlayList playlist = new PlayList(name);
		playlists.put(name, playlist);
	}

	public void addSong(Song song) {
		songs.put(song.getName().toLowerCase(), song);
	}

	public void addAlbum(Album album) {
		albums.put(album.getTitle().toLowerCase(), album);
		// if a song in the album is not already in songs it adds it
		ArrayList<Song> a = album.getSongs();
		for (Song s : a) {
			String name = s.getName();
			if (!songs.containsKey(name.toLowerCase())) {
				songs.put(name.toLowerCase(), s);
			}
		}
	}

	public String addSongPlaylist(String name, String artist, String playlist) {
		// if playlist doesnt exist return immediately 
		if (!playlists.containsKey(playlist)) return "Playlist Not Found";
		PlayList p = playlists.get(playlist);
		for (Song s : songs.values()) {
			if (s.getName().toLowerCase().equals(name.toLowerCase()) && 
					s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				p.addSong(s);
				return "Song Added";
			}
		}
		return "Song Not Found";
	}
	
	public String removeSongPlaylist(String name, String artist, String playlist) {
		// if playlist doesnt exsist return immeadately
		if (!playlists.containsKey(playlist)) return "Playlist not found";
		PlayList p = playlists.get(playlist);
		for (Song s : p.getSongs()) {
			if (s.getName().equalsIgnoreCase(name) && s.getArtist().equalsIgnoreCase(artist)) {
				p.removeSong(s);
				return "Song Removed";
			}
		}
		return "Song not found";
	}

	// get a specific song by title and artist
	public String getSong(String title, String artist) {
		if (!songs.containsKey(title)) return "Song Not Found";
		for (String key : songs.keySet()) {
			Song s = songs.get(key);
			if (key.equals(title) && s.getArtist().equals(artist)) return s.toString();
		}
		return "Song Not Found";
	}

	// search by song title
	public String getSongTitle(String title) {
		// if it doesn't find any song called title then return error message
		if (!songs.containsKey(title.toLowerCase())) return "Song Not Found";
		String str = "";
		for (Song s : songs.values()) {
			// if name equals song add it to str
			if (s.getName().toLowerCase().equals(title.toLowerCase())) {
				str += s.toString() + "\n";
			}
		}
		return str;
	}

	// search by song's artist
	public String getSongArtist(String artist) {
		String str = "";
		for (Song s : songs.values()) {
			// if artist equals song's artist add it to str
			if (s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				str += s.toString() + "\n";
			}
		}
		// if it doesn't find any song by artist then return error message
		if (str.length() == 0) return "Song Not Found";
		return str;
	}

	// search for song by genre
	public String getSongGenre(String genre) {
		String str = "";
		for (Song s : songs.values()) {
			// if artist equals song's genre add it to str
			if (s.getGenre().toLowerCase().equals(genre)) {
				str += s.toString() + "\n";
			}
		}
		// if it doesn't find any song by artist then return error message
		if (str.length() == 0) return "Song Not Found";
		return str;
	}

	// search by album title
	public String getAlbumTitle(String title) {
		// if it doesn't find any album called title then return error message
		if (!albums.containsKey(title.toLowerCase())) return "Album Not Found";
		String str = "";
		for (Album a : albums.values()) {
			// if album title equals title add album to str
			if (a.getTitle().toLowerCase().equals(title.toLowerCase())) str += a.toString();
		}
		return str;
	}

	// search by album's artist
	public String getAlbumArtist(String artist) {
		String str = "";
		for (Album a : albums.values()) {
		// if album's artist equals artist add album to str
			if (a.getArtist().toLowerCase().equals(artist.toLowerCase())) str += a.toString();
		}
		// if it doesn't find any album by artist then return error message
		if (str.length() == 0) return "Album Not Found";
		return str;
	}
		
	// creates a list of artists in the User Library 
	public String getAllArtists() {
		String message = "Artists:\n";
		HashSet<String> artists = new HashSet<String>();
		for (Song s : songs.values()) {
			// makes sure there are no duplicate artists
			String artist = s.getArtist();
			if (!artists.contains(artist)) {
				message += artist + "\n";
				artists.add(artist);
			}
		}	
		return message;
	}
		
	// creates a list of album names
	public String getAllAlbums() {
		String message = "Albums:\n";	
		for (Album a : albums.values()) {
			message += a.toString();
		}
		return message;
	}
		
	public String getAllPlaylists() {
		String message = "Playlists:\n";	
		for (PlayList p : playlists.values()) {
			message += p.toString();
		}	
		return message;
	}
		
	public String getAllSongs() {
		String str = "Songs:\n";
		for (Song s : songs.values()) {
			str += s.toString();
		}
		return str;
	}
		
	public ArrayList<Song> getSongs() {
		return new ArrayList<Song>();
	}
	
	public void play(String name, String artist) {
		// when a song is played it increments the numPlay count, and adds it to the top 10 most recent plays
		for (Song s : songs.values()) {
			if (s.getName().toLowerCase().equals(name) && s.getAlbum().equals(artist) ) {
				s.play();
				// if a song has already been played recently, remove it from the list
				if (recents.contains(s)) {
					recents.remove(s);
				}
				// add song to the first in the list
				recents.addFirst(s);
				// if recent songs is already at 10 songs remove the last song
				if (recents.size() > 10) recents.removeLast();
			}
		}
		
	}
	
	public void favoriteSong(String name, String artist) {
		for (Song s : songs.values()) {
			if (s.getName().equals(name.toLowerCase()) && s.getArtist().equals(artist.toLowerCase())) {
				s.favorite();
				// add song to favorites playList immediately
				PlayList p = playlists.get("Favorites");
				p.addSong(s);
			}
		}
	}
	
	public String getFavorites() {
		String message = "Favorites:\n";
		for (Song s : songs.values()) {
			if (s.isFavorite()) {
				message += s.toString();
			}
		}
		return message;
	}
	
	public String getRecents() {
		// gets the 10 most recently played songs
		String message = "Recent Songs:\n";
		PlayList p = playlists.get("Recents");
		for (Song s : p.getSongs()) {
			message += s.toString();
		}
		return message;
	}
	
	
	public String getFrequents() {
		updateFrequents();
		// gets the 10 most frequently played songs from most played to least played
		String message = "Frequent Songs:\n";
		for (Song s : frequents.reversed()) {
			message += s.toString();
		}
		return message;
	}
		
	// find a playlist in a string of playlists
	public String getPlayList(String name) {
		if (!playlists.containsKey(name)) return "No Playlist found";
		String playListContents = "";
		for (PlayList p : playlists.values()) {
			if (p.getName().equals(name)) {
				playListContents = p.toString();
			}
		}
		return playListContents;
	}	
	
	
	public String getSortedBySongTitle() {
		StringBuilder message = new StringBuilder();
		List<Song> allSongs = new ArrayList<>(songs.values());
		// sort by Song name using lambda expressions
		Collections.sort(allSongs, (s1, s2) -> s1.getName().compareTo(s2.getName()));
		for (Song s: allSongs) {
			message.append(s.toString() + "\n");
		}
		
		return message.toString();	
	}
	
	public String getSortedBySongArtist() {
		StringBuilder message = new StringBuilder();
		List<Song> allSongs = new ArrayList<>(songs.values());
		Collections.sort(allSongs, (s1, s2) -> s1.getArtist().compareTo(s2.getArtist()));
		for (Song s: allSongs) {
			message.append(s.toString() + "\n");
		}
		
		return message.toString();	
	}
	
	public String getSortedbyRating() {
		StringBuilder message = new StringBuilder();
		List<Song> allSongs = new ArrayList<>(songs.values());
		Collections.sort(allSongs, (s1, s2) -> Integer.compare(s1.getRating(), s2.getRating()));
		for (Song s: allSongs) {
			message.append(s.toString() + "\n");
		}
		
		return message.toString();	
	}
	
	public void removeFromLibrary(Song song) {
		if (songs.containsKey(song.getName())){
			songs.remove(song.getName());
			System.out.println(song.getName() + " removed.");
		} else {
			System.out.println("Song not found.");
		}
	}
	
	
	public void removeFromLibrary(Album album) {
		if (albums.containsKey(album.getTitle())) {
			albums.remove(album.getTitle());
			System.out.println(album.getTitle() + " removed.");
		} else {
			System.out.println("Album not found.");
		}
	}
	
	public void shuffleSongs(ArrayList<Song> playList) {
		Collections.shuffle(playList);
	}
	
	public ArrayList<Song> shuffleSongs(HashMap<String, Song> songs) {
		ArrayList<Song> allSongs = new ArrayList<>();
		for (Song s: songs.values()) {
			allSongs.add(s);
		}
		Collections.shuffle(allSongs);
		return allSongs;
	}	
}
