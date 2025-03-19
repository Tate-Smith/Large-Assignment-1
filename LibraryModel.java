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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LibraryModel {
	private HashMap<String, Song> songs;
	private HashMap<String, Album> albums;
	private HashMap<String, PlayList> playlists;
	private ArrayList<Song> recentSongs;

	public LibraryModel() {
		songs = new HashMap<String, Song>();
		albums = new HashMap<String, Album>();
		playlists = new HashMap<String, PlayList>();
		recentSongs = new ArrayList<Song>();
		this.makePlaylist("Favorites");
		this.makePlaylist("Recents");
		this.makePlaylist("Frequents");
	}
	
	public void updateFrequents() {
		
	}

	public void makePlaylist(String name) {
		PlayList playlist = new PlayList(name);
		playlists.put(name, playlist);
	}

	public void addSong(Song song) {
		songs.put(song.getName(), song);
	}

	public void addAlbum(Album album) {
		albums.put(album.getTitle(), album);
		// if a song in the album is not already in songs it adds it
		ArrayList<Song> a = album.getSongs();
		for (Song s : a) {
			String name = s.getName();
			if (!songs.containsKey(name)) {
				songs.put(name, s);
			}
		}
	}

	public String addSongPlaylist(String name, String artist, String playlist) {
		// if playlist doesnt exsist return immeadately
		if (!playlists.containsKey(playlist)) return "Playlist Not Found";
		PlayList p = playlists.get(playlist);
		for (Song s : songs.values()) {
			if (s.getName().toLowerCase().equals(name) && s.getArtist().toLowerCase().equals(artist)) {
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
			if (s.getName().equals(name) && s.getArtist().equals(artist)) {
				p.removeSong(s);
				return "Song Removed";
			}
		}
		return "Song not found";
	}

	// search by song title
	public String getSongTitle(String title) {
		// if it doesn't find any song called title then return error message
		if (!songs.containsKey(title)) return "Song Not Found";
		String str = "";
		for (Song s : songs.values()) {
			// if name equals song add it to str
			if (s.getName().equals(title)) {
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
			if (s.getArtist().toLowerCase().equals(artist)) {
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
		if (!albums.containsKey(title)) return "Album Not Found";
		String str = "";
		for (Album a : albums.values()) {
			// if album title equals title add album to str
			if (a.getTitle().toLowerCase().equals(title)) str += a.toString();
		}
		return str;
	}

	// search by album's artist
	public String getAlbumArtist(String artist) {
		String str = "";
		for (Album a : albums.values()) {
		// if album's artist equals artist add album to str
			if (a.getArtist().toLowerCase().equals(artist)) str += a.toString();
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
				// if recent songs is already 10 songs remove the last song
				if (recentSongs.size() == 10) recentSongs.remove(0);
				// add new song to most recents
				recentSongs.add(s);
			}
		}
		// get the recents playlist
		PlayList p = playlists.get("Recents");
		// empty it
		p.clearPlaylist();
		// repopulate it with all the recnt songs
		for (int i = 0; i < recentSongs.size(); i++) {
			p.addSong(recentSongs.get(i));
		}
	}
	
	public void favoriteSong(String name, String artist) {
		for (Song s : songs.values()) {
			if (s.getName().equals(name) && s.getArtist().equals(artist)) {
				s.favorite();
				// add song to favorites playList imedeatly
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
	
	public String getFavoritesPlaylist() {
		// gets all the songs that are favorites
		String message = "10 Favorite Song:\n";
		PlayList p = playlists.get("Favorites");
		for (Song s : p.getSongs()) {
			message += s.toString();
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
		// gets the 10 most frequently played songs
		String message = "Frequent Songs:\n";
		PlayList p = playlists.get("Frequents");
		for (Song s : p.getSongs()) {
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
}