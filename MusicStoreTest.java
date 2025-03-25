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
		assertEquals(store.getSongTitle("Cat".toLowerCase()), "Cat, by: Xavier, 100, Pop\n");
		assertEquals(store.getAlbumTitle("100"), "100, by: Xavier\ncat\ndog\n");
	}
	
	@Test 
	void testGetByArtist() {
		MusicStore store = new MusicStore();
		assertEquals(store.getSongArtist("Xavier".toLowerCase()), "Cat, by: Xavier, 100, Pop\nDog, by: Xavier, 100, Pop\n");
		assertEquals(store.getAlbumArtist("100"), "Album Not Found");
	}
	
	@Test
	void testGet() {
		MusicStore store = new MusicStore();
		Song coldShoulder = new Song("Cold Shoulder", "Adele", "19", "Pop");
		assertTrue(store.getSong("cold shoulder", "adele").toString().equals(coldShoulder.toString()) );
		
		Album newAlbum = new Album("19_Adele.txt");
		assertTrue(store.getAlbum("19", "adele").toString().equals(newAlbum.toString()));
	}
	
	@Test
	void testGetSongAlbum() {
		MusicStore store = new MusicStore();
		assertEquals(store.getSongAlbum("dog", "xavier").toString(), "100, by: Xavier\ncat\ndog\n");	
	}
}