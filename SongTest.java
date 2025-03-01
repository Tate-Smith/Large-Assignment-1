package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Done
class SongTest {
	
	@Test
	void testName() {
		Song s = new Song("Self Control", "Frank Ocean", "Blonde");
		Assertions.assertEquals(s.getName(), "Self Control");
	}
	
	@Test
	void testArtist() {
		Song s = new Song("Self Control", "Frank Ocean", "Blonde");
		Assertions.assertEquals(s.getArtist(), "Frank Ocean");
	}
	
	@Test
	void testToString() {
		Song s = new Song("Self Control", "Frank Ocean", "Blonde");
		Assertions.assertEquals(s.toString(), "Self Control, by: Frank Ocean, Blonde");
	}

	@Test
	void testFavorite() {
		Song s = new Song("Self Control", "Frank Ocean", "Blonde");
		s.favorite();
		Assertions.assertTrue(s.isFavorite());
	}
	
	@Test
	void testRate() {
		Song s = new Song("Self Control", "Frank Ocean", "Blonde");
		s.rate(2);
		Assertions.assertEquals(2, s.getRating());
		Assertions.assertFalse(s.isFavorite());
	}
	
	@Test
	void testRateTwo() {
		Song s = new Song("Self Control", "Frank Ocean", "Blonde");
		s.rate(5);
		Assertions.assertTrue(s.isFavorite());
	}
	
	@Test 
	void testGetAlbum() {
		Song s = new Song("Self Control", "Frank Ocean", "Blonde");
		Assertions.assertEquals(s.getAlbum(), "Blonde");;
	}
}