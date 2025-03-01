package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Done
class PlayListTest {

	@Test
	void testBasicPlayList() {
		PlayList myPlaylist = new PlayList("Fye");
		Song rollingDeep = new Song("Rolling Deep", "Adele", "19");
		Song nine = new Song("19", "Adele", "19");
		
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
		Song rollingDeep = new Song("Rolling Deep", "Adele", "19");
		Song nine = new Song("19", "Adele", "19");
		
		myPlaylist.addSong(rollingDeep);
		myPlaylist.addSong(nine);
		
		assertEquals(myPlaylist.getSong("19", "Adele"), nine);
	}
	
	@Test
	void testToString() {
		PlayList myPlaylist = new PlayList("Fye");
		Song rollingDeep = new Song("Rolling Deep", "Adele", "19");
		Song nine = new Song("19", "Adele", "19");
		
		myPlaylist.addSong(rollingDeep);
		myPlaylist.addSong(nine);
		
		assertEquals(myPlaylist.toString(), "Fye:\nRolling Deep\n19\n");
		
		myPlaylist.setName("Dog");
		
		assertEquals(myPlaylist.toString(), "Dog:\nRolling Deep\n19\n");
		
	}
}