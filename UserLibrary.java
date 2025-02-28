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
public class UserLibrary {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	private ArrayList<PlayList> playlists;

	public UserLibrary() {
		songs = new ArrayList<Song>();
		albums = new ArrayList<Album>();
		playlists = new ArrayList<PlayList>();
	}

	public void makePlaylist(String name) {
		PlayList playlist = new PlayList(name);
		playlists.add(playlist);
	}

	public void addSong(Song song) {
		songs.add(song);
	}

	public void addAlbum(Album album) {
		albums.add(album);
		// if a song in the album is not already in songs it adds it
		ArrayList<Song> a= album.getSongs();
		for (Song s : a) {
			if (!songs.contains(s)) {
				songs.add(s);
			}
		}
	}

	public String addSongPlaylist(String name, String artist, String playlist) {
		// if the song is already in songs then the song can be added to a playList
		for (Song s : songs) {
			if (s.getName().equals(name) && s.getArtist().equals(artist)) {
				for (PlayList p : playlists) {
					if (p.getName().equals(playlist)) {
						p.addSong(s);
						return "Song Added";
					}
				}
				return "Playlist not found";
			}
		}
		return "Song not found";
	}

	// search by song title
		public String getSongTitle(String title) {
			String str = "";
			for (Song s : songs) {
				// if name equals song add it to str
				if (s.getName().equals(title)) {
					str += s.toString() + "\n";
				}
			}
			// if it doesn't find any song called title then return error message
			if (str.length() == 0) return "Song Not Found";
			return str;
		}

		// search by song's artist
		public String getSongArtist(String artist) {
			String str = "";
			for (Song s : songs) {
				// if artist equals song's artist add it to str
				if (s.getArtist().equals(artist)) {
					str += s.toString() + "\n";
				}
			}
			// if it doesn't find any song by artist then return error message
			if (str.length() == 0) return "Song Not Found";
			return str;
		}

		// search by album title
		public String getAlbumTitle(String title) {
			String str = "";
			for (Album a : albums) {
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
			for (Album a : albums) {
				// if album's artist equals artist add album to str
				if (a.getArtist().equals(artist)) str += a.toString();
			}
			// if it doesn't find any album by artist then return error message
			if (str.length() == 0) return "Album Not Found";
			return str;
		}
		
		// creates a list of artists in the User Library 
		public String getAllArtists() {
			String message = "Artists:\n";
			
			for (Song s: songs) {
				message = s.getArtist() + "\n";
			}
			
			for (Album album : albums) {
				message += album.getArtist() + "\n";
			}
			
			return message;
		}
		
		// creates a list of album names
		public String getAllAlbums() {
			String message = "Albums:\n";
			
			for (Album a: albums) {
				message += a.getTitle() + "\n";
			}
		
			return message;
		}
		
		public String getAllPlayists() {
			String message = "Playlists:\n";
			
			for (PlayList p: playlists) {
				message += p.getName() + "\n";
			}
			
			
			return message;
		}
		
		public String getAllSongs() {
			String str = "Songs:\n";
			for (Song s : songs) {
				str += s.getName() + "\n";
			}
			return str;
		}
		
		public ArrayList<Song> getSongs() {
			return new ArrayList<Song>();
		}
		
		public String getFavorites() {
			String message = "Favorites:\n";
			for (Song s: songs) {
				if (s.isFavorite()) {
					message += s.getName() + "\n";
				}
			}
			return message;
		}
		
		// find a playlist in a string of playlists
		public String getPlayList(String name) {
			String playListContents = "";
			for (PlayList p: playlists) {
				if (p.getName().equals(name)) {
					playListContents = p.toString();
				}
			}
			return playListContents;
		}
	
}
