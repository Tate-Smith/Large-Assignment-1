package Model;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlbumTest {

	@Test
	void testAddSong() {
		Album a = new Album("Utopia", "Travis Scott");
		a.addSong("SIRENS", "Travis Scott");
		ArrayList<Song> songs = a.getSongs();
		Assertions.assertEquals(songs.get(0).getName(), "SIRENS");
	}
	
	@Test
	void testRemoveSong() {
		Album a = new Album("Utopia", "Travis Scott");
		a.addSong("SIRENS", "Travis Scott");
		a.addSong("MY EYES", "Travis Scott");
		a.removeSong("SIRENS", "Travis Scott");
		ArrayList<Song> songs = a.getSongs();
		Assertions.assertEquals(songs.get(0).getName(), "MY EYES");
	}
	
	@Test
	void testRemoveSongTwo() {
		Album a = new Album("Utopia", "Travis Scott");
		a.addSong("SIRENS", "Travis Scott");
		a.addSong("MY EYES", "Travis Scott");
		a.removeSong("TELEKINESIS", "Travis Scott");
		ArrayList<Song> songs = a.getSongs();
		Assertions.assertEquals(songs.size(), 2);
	}
	
	@Test
	void testArtist() {
		Album a = new Album("Utopia", "Travis Scott");
		Assertions.assertEquals(a.getArtist(), "Travis Scott");
	}
	
	@Test
	void testTitle() {
		Album a = new Album("Utopia", "Travis Scott");
		Assertions.assertEquals(a.getTitle(), "Utopia");
	}
	
	@Test
	void testToString() {
		Album a = new Album("Utopia", "Travis Scott");
		a.addSong("SIRENS", "Travis Scott");
		a.addSong("MY EYES", "Travis Scott");
		Assertions.assertEquals(a.toString(), "Utopia, by: Travis Scott\nSIRENS\nMY EYES\n");
	}

}
