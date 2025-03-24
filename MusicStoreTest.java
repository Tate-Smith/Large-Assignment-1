package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MusicStoreTest {

	@Test
	void testMusicStoreConstructor() {
		MusicStore store = new MusicStore();
		assertEquals(store.getAllAlbums().size(), 16);
	}

	@Test
	void testGetByTitle() {
		MusicStore store = new MusicStore();
		assertEquals(store.getSongTitle("Cat"), "Cat, by: Xavier, 100\n");
		assertEquals(store.getAlbumTitle("100"), "100, by: Xavier\nCat\nDog\n");
	}
	
	@Test 
	void testGetByArtist() {
		MusicStore store = new MusicStore();
		assertEquals(store.getSongArtist("Xavier"), "Cat, by: Xavier, 100\nDog, by: Xavier, 100\n");
		assertEquals(store.getAlbumArtist("100"), "Album Not Found");
	}
	
	@Test
	void testGet() {
		MusicStore store = new MusicStore();
		Song coldShoulder = new Song("Cold Shoulder", "Adele", "19", "Pop");
		assertTrue(store.getSong("Cold Shoulder", "Adele").toString().equals(coldShoulder.toString()) );
		
		Album newAlbum = new Album("19_Adele.txt");
		assertTrue(store.getAlbum("19", "Adele").toString().equals(newAlbum.toString()));
	}
}