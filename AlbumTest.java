package Model;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlbumTest {

	@Test
	void testLoadAlbum() {
		Album a = new Album("19_Adele.txt");
		ArrayList<Song> songs = a.getSongs();
		Assertions.assertEquals(songs.get(0).getName(), "Daydreamer");
	}
	
	@Test
	void testgetSongs() {
		Album a = new Album("19_Adele");
		Assertions.assertEquals(a.getSongs().size(), 2);
	}
	
	
	
	@Test
	void testArtist() {
		Album a = new Album("19_Adele.txt");
		Assertions.assertEquals(a.getArtist(), "Adele");
	}
	
	@Test
	void testTitle() {
		Album a = new Album("19_Adele.txt");
		Assertions.assertEquals(a.getTitle(), "19");
	}
	
	@Test 
	void testToString() {
		Album a = new Album("19_Adele");
		Assertions.assertEquals(a.toString(), "19,by: Adele\nDaydreamer\nBest for Last\n");
	}

}
