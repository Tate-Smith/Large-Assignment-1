package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MusicStoreTest {
	private MusicStore store = new MusicStore();

	@Test
	void testMusicStoreConstructor() {
		Assertions.assertEquals(store.getAllAlbums().size(), 15);
	}
	
	@Test 
	void testGetSong() {
		Song s = store.getSong("Jesus", "Amos Lee");
		Assertions.assertEquals(s.toString(), "Mission Bell, by: The Heavy");
	}
	
	@Test
	void testGetAlbum() {
		Album a = store.getAlbum("Mission Bell", "Amos Lee");
		Assertions.assertEquals(a.getArtist(), "Amos Lee");
	}
	
	@Test
	void testGetSongTitle() {
		
	}
	
	@Test
	void testGetSongArtist() {
		
	}
	
	@Test
	void testGetAlbumTitle() {
		
	}
	
	@Test
	void testGetAlbumArtist() {
		
	}

}
