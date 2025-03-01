package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserLibraryTest {

	@Test
	void testBasicFunctionality() {
		UserLibrary myLibrary = new UserLibrary();
		Album newAlbum = new Album("19_Adele");
		Song rollingDeep = new Song("Rolling Deep", "Adele");
		myLibrary.makePlaylist("Fye");
		myLibrary.addSong(rollingDeep);
		myLibrary.addAlbum(newAlbum);
		
		
		assertEquals(myLibrary.getAllAlbums(), "Albums:\n19\n");
		assertEquals(myLibrary.getAllPlaylists(), "Playlists:\nFye\n");
		assertEquals(myLibrary.getAllSongs(), "Songs:\n" + "Rolling Deep" + "\n"
		+"Daydreamer\nBest for Last\n");
		
	}

	@Test
	void testAddSongsToPlayList() {
		UserLibrary myLibrary = new UserLibrary();
		Album newAlbum = new Album("19_Adele");
		Song rollingDeep = new Song("Rolling Deep", "Adele");
		myLibrary.makePlaylist("Fye");
		myLibrary.addSong(rollingDeep);
		myLibrary.addAlbum(newAlbum);
		
		assertEquals(myLibrary.addSongPlaylist("Rolling Deep", "Adele", "Fye"), "Song Added");
		assertEquals(myLibrary.addSongPlaylist("Jump!", "Adele", "Fye"), "Song not found");
		assertEquals(myLibrary.addSongPlaylist("Rolling Deep", "Adele", "Rod's Playlist"), "Playlist not found");
	}
	
	@Test
	void testgetByTitle() {
		UserLibrary myLibrary = new UserLibrary();
		Album newAlbum = new Album("19_Adele");
		Song rollingDeep = new Song("Rolling Deep", "Adele");
		myLibrary.makePlaylist("Fye");
		myLibrary.addSong(rollingDeep);
		myLibrary.addAlbum(newAlbum);
		
		assertEquals(myLibrary.getSongTitle("Rolling Deep"), "Rolling Deep ,by Adele");
		
		
	}
}
