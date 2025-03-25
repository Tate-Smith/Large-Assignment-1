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
		Assertions.assertEquals(songs.get(0).getName(), "daydreamer");
		Album b = new Album("Fire");
	}
	
	@Test
	void testGetSongs() {
		Album a = new Album("Junit_Test");
		Assertions.assertEquals(a.getSongs().size(), 2);
	}
	
	
	
	@Test
	void testArtist() {
		Album a = new Album("19_Adele.txt");
		Assertions.assertEquals(a.getArtist(), "adele");
	}
	
	@Test
	void testTitle() {
		Album a = new Album("19_Adele.txt");
		Assertions.assertEquals(a.getTitle(), "19");
	}
	
	@Test 
	void testToString() {
		Album a = new Album("Junit_Test");
		Assertions.assertEquals(a.toString(), "100, by: Xavier\ncat\ndog\n");
	}
	
	@Test 
	void testCopyAlbum() {
		Album a = new Album("Junit_Test");
		Album copy = new Album(a);
		Song copySong = new Song("Cat", "Xavier", "100", "Pop");
		Song copySong1 = new Song("Dog", "Xavier", "100", "Pop");
		copy.addSong(copySong);
		copy.addSong(copySong1);
		
		Assertions.assertEquals(a.toString(), copy.toString());
	}

}
