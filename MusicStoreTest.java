package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MusicStoreTest {

	@Test
	void testMusicStoreConstructor() {
		MusicStore store = new MusicStore();
		assertEquals(store.getAllAlbums().size(), 15);
	}

}
