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
	private ArrayList<Album> playlists;
	
	public UserLibrary() {
		
	}
	
	public void addSong(Song song) {
		songs.add(song);
	}
	
	public void addAlbum(Album album) {
		albums.add(album);
	}
	
	public void createPlaylist(String title, String name) {
			Album playlist = new Album(title, name);
			playlists.add(playlist);
	}
}
