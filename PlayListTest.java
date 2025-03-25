package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Done
class PlayListTest {

	@Test
	void testBasicPlayList() {
		PlayList myPlaylist = new PlayList("Fye");
		Song rollingDeep = new Song("Rolling Deep", "Adele", "19", "Pop");
		Song nine = new Song("19", "Adele", "19", "Pop");
		
		assertEquals(myPlaylist.getName(), "Fye");
		myPlaylist.addSong(rollingDeep);
		myPlaylist.addSong(nine);
		assertTrue(myPlaylist.getSongs().size() == 2);
		myPlaylist.removeSong(rollingDeep);
		assertTrue(myPlaylist.getSongs().size()==1);	
	}
	
	@Test 
	void testGetSong() {
		PlayList myPlaylist = new PlayList("Fye");
		Song rollingDeep = new Song("Rolling Deep", "Adele", "19", "Pop");
		Song nine = new Song("19", "Adele", "19", "Pop");
		
		myPlaylist.addSong(rollingDeep);
		myPlaylist.addSong(nine);
		
		assertEquals(myPlaylist.getSong("19", "Adele").toString(), nine.toString());
	}
	
	@Test
	void testToString() {
		PlayList myPlaylist = new PlayList("Fye");
		Song rollingDeep = new Song("Rolling Deep", "Adele", "19", "Pop");
		Song nine = new Song("19", "Adele", "19", "Pop");
		
		myPlaylist.addSong(rollingDeep);
		myPlaylist.addSong(nine);
		
		assertEquals(myPlaylist.toString(), "Fye:\nrolling deep\n19\n");
		
		myPlaylist.setName("Dog");
		
		assertEquals(myPlaylist.toString(), "Dog:\nrolling deep\n19\n");
		
	}
	

}