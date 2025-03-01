package Model;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryModelTest {
	private LibraryModel myLibrary = new LibraryModel();
	
	@Test 
	void testAddSongPlaylist() {
		myLibrary.makePlaylist("My Playlist");
		Song s = new Song("SIRENS", "Travis Scott", "UTOPIA");
		myLibrary.addSong(s);
		String str = myLibrary.addSongPlaylist("SIRENS", "Travis Scott", "My Playlist");
		Assertions.assertEquals(str, "Song Added");
	}
	
	@Test
	void testRemoveSongPlaylist() {
		myLibrary.makePlaylist("My Playlist");
		Song s = new Song("SIRENS", "Travis Scott", "UTOPIA");
		myLibrary.addSong(s);
		String str = myLibrary.addSongPlaylist("SIRENS", "Travis Scott", "My Playlist");
		String string = myLibrary.removeSongPlaylist("SIRENS", "Travis Scott", "My Playlist");
		Assertions.assertEquals(string, "Song Removed");
	}
	
	@Test
	void testGetSongTitle() {
		Song s = new Song("SIRENS", "Travis Scott", "UTOPIA");
		myLibrary.addSong(s);
		String str = s.toString();
		Assertions.assertEquals(myLibrary.getSongTitle("SIRENS"), str + "\n");
	}
	
	@Test
	void testGetSongArtist() {
		Song s = new Song("SIRENS", "Travis Scott", "UTOPIA");
		myLibrary.addSong(s);
		Assertions.assertEquals(myLibrary.getSongArtist("Travis Scott"), "SIRENS, by: Travis Scott, UTOPIA\n");
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
		Album a = new Album("21_Adele.txt");
		myLibrary.addAlbum(a);
		Song s = new Song("SIRENS", "Travis Scott", "UTOPIA");
		myLibrary.addSong(s);
		Assertions.assertEquals(myLibrary.getAllArtists(), "Artists:\nAdele\nTravis Scott\n");
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
		Assertions.assertEquals(myLibrary.getAllPlaylists(), "Playlists:\nMy Playlist:\n");
	}
	
	@Test 
	void testGetAllSongs() {
		Song s = new Song("SIRENS", "Travis Scott", "UTOPIA");
		myLibrary.addSong(s);
		String str = s.toString();
		Assertions.assertEquals(myLibrary.getAllSongs(), "Songs:\n" + str);
	}
	
	@Test
	void testGetSongs() {
		ArrayList<Song> songs = myLibrary.getSongs();
		Assertions.assertEquals(songs.size(), 0);
	}
	
	@Test
	void testGetFavorites() {
		Song s = new Song("SIRENS", "Travis Scott", "UTOPIA");
		myLibrary.addSong(s);
		s.favorite();
		String str = s.toString();
		Assertions.assertEquals(myLibrary.getFavorites(), "Favorites:\n" + str);
	}
	
	@Test
	void testGetPlayList() {
		myLibrary.makePlaylist("My Playlist");
		Assertions.assertEquals(myLibrary.getPlayList("My Playlist"), "My Playlist:\n");
	}
}
