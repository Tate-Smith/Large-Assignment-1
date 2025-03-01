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
	void testGetByTitle() {
		UserLibrary myLibrary = new UserLibrary();
		Album newAlbum = new Album("19_Adele");
		Song rollingDeep = new Song("Rolling Deep", "Adele");
		myLibrary.makePlaylist("Fye");
		myLibrary.addSong(rollingDeep);
		myLibrary.addAlbum(newAlbum);
		
		assertEquals(myLibrary.getSongTitle("Rolling Deep"), "Rolling Deep, by: Adele\n");
		assertEquals(myLibrary.getSongTitle("Deep"), "Song Not Found");
		assertEquals(myLibrary.getAlbumTitle("19"), "19,by: Adele\nDaydreamer\nBest for Last\n");
		assertEquals(myLibrary.getAlbumTitle("9"), "Album Not Found");
	}
	
	@Test 
	void testGetByArtist() {
		UserLibrary myLibrary = new UserLibrary();
		Album newAlbum = new Album("19_Adele");
		Song rollingDeep = new Song("Rolling Deep", "Adele");
		Song nokia = new Song("NOKIA", "Adele");
		
		myLibrary.makePlaylist("Fye");
		myLibrary.addSong(rollingDeep);
		myLibrary.addAlbum(newAlbum);
		myLibrary.addSong(nokia);
		
		assertEquals(myLibrary.getSongArtist("Adele"), "Rolling Deep, by: Adele\nDaydreamer, by: Adele\nBest for Last, by: Adele\n"
				+ "NOKIA, by: Adele\n");
		assertEquals(myLibrary.getSongArtist("Drake"), "Song Not Found");
		assertEquals(myLibrary.getAlbumArtist("Adele"), "19,by: Adele\nDaydreamer\nBest for Last\n");
		assertEquals(myLibrary.getAlbumArtist("9"), "Album Not Found");
		
	}
	
	@Test
	void testGetAll() {
		UserLibrary myLibrary = new UserLibrary();
		Album newAlbum = new Album("19_Adele");
		Song rollingDeep = new Song("Rolling Deep", "Adele");
		Song nokia = new Song("NOKIA", "Adele");
		Song pilot = new Song("Pilot", "Drake");
		
		
		
		myLibrary.addAlbum(newAlbum);
		myLibrary.addSong(pilot);
		myLibrary.addSong(nokia);
		assertEquals(myLibrary.getAllArtists(), "Artists:\nAdele\nDrake\n");
		
	}
}
