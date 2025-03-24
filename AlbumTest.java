package Model;
// Done

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlbumTest {

	@Test
	void testLoadAlbum() {
		Album a = new Album("19_Adele.txt");
		ArrayList<Song> songs = a.getSongs();
		Assertions.assertEquals(songs.get(0).getName(), "Daydreamer");
		Album b = new Album("Fire");
	}
	
	@Test
	void testgetSongs() {
		Album a = new Album("Junit_Test");
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
		Album a = new Album("Junit_Test");
		Assertions.assertEquals(a.toString(), "100, by: Xavier\nCat\nDog\n");
	}
	
	@Test 
	void testCopyAlbum() {
		Album a = new Album("Junit_Test");
		Album copy = new Album(a);
		Assertions.assertEquals(a, copy);
	}

}
