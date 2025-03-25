package Model;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryModelTest {
	private LibraryModel myLibrary = new LibraryModel();
	private MusicStore store = new MusicStore();
	
	@Test 
	void testAddSongPlaylist() {
		myLibrary.makePlaylist("My Playlist");
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s, a);
		String str = myLibrary.addSongPlaylist("Dog", "Xavier", "My Playlist");
		Assertions.assertEquals(str, "Song Added");
	}
	
	@Test
	void testRemoveSongPlaylist() {
		myLibrary.makePlaylist("My Playlist");
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		myLibrary.addSongPlaylist("Dog", "Xavier", "My Playlist");
		String string = myLibrary.removeSongPlaylist("Dog", "Xavier", "My Playlist");
		Assertions.assertEquals(string, "Song Removed");
	}
	
	@Test
	void testGetSongTitle() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		String str = s.toString();
		Assertions.assertEquals(myLibrary.getSongTitle("Dog"), str);
	}
	
	@Test
	void testGetSongArtist() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Assertions.assertEquals(myLibrary.getSongArtist("Xavier"), s.toString());
	}
	
	@Test
	void testGetAlbumTitle() {
		Album a = new Album("21_Adele.txt");
		myLibrary.addAlbum(a);
		String str = myLibrary.getAlbumTitle("Blonde");
		Assertions.assertEquals(str, "Album Not Found");
	}
	
	@Test
	void testGetAlbumArtist() {
		Album a = new Album("21_Adele.txt");
		myLibrary.addAlbum(a);
		String str = myLibrary.getAlbumArtist("21");
		Assertions.assertEquals(str, "Album Not Found");
	}
	
	@Test
	void testGetAllArtists() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		Assertions.assertEquals(myLibrary.getAllArtists(), "Artists:\ncoldplay\nxavier\n");
	}
	
	@Test 
	void testGetAllAlbums() {
		Album a = new Album("21_Adele.txt");
		myLibrary.addAlbum(a);
		String str = a.toString();
		Assertions.assertEquals(myLibrary.getAllAlbums(), "Albums:\n" + str);
	}
	
	@Test 
	void testGetAllPlaylists() {
		myLibrary.makePlaylist("My Playlist");
		Assertions.assertEquals(myLibrary.getAllPlaylists(), "Playlists:\nMy Playlist:\nFavorites:\n");
	}
	
	@Test 
	void testGetAllSongs() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		String str = song2.toString() + s.toString();
		Assertions.assertEquals(myLibrary.getAllSongs(), "Songs:\n" + str);
	}
	
	@Test
	void testGetSongs() {
		ArrayList<Song> songs = myLibrary.getSongs();
		Assertions.assertEquals(songs.size(), 0);
	}
	
	@Test
	void testGetFavorites() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		s.favorite();
		String str = s.toString();
		Assertions.assertEquals(myLibrary.getFavorites(), "Favorites:\n" + str);
	}
	
	@Test
	void testGetPlayList() {
		myLibrary.makePlaylist("My Playlist");
		Assertions.assertEquals(myLibrary.getPlayList("My Playlist"), "My Playlist:\n");
	}
	
	@Test
	void test
	
}
