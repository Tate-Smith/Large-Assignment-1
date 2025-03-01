package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Done
class SongTest {
	
	@Test
	void testName() {
		Song s = new Song("Self Control", "Frank Ocean");
		Assertions.assertEquals(s.getName(), "Self Control");
	}
	
	@Test
	void testArtist() {
		Song s = new Song("Self Control", "Frank Ocean");
		Assertions.assertEquals(s.getArtist(), "Frank Ocean");
	}
	
	@Test
	void testToSTring() {
		Song s = new Song("Self Control", "Frank Ocean");
		Assertions.assertEquals(s.toString(), "Self Control, by: Frank Ocean");
	}

	@Test
	void testFavorite() {
		Song s = new Song("Self Control", "Frank Ocean");
		s.favorite();
		Assertions.assertTrue(s.isFavorite());
	}
	
	@Test
	void testRate() {
		Song s = new Song("Self Control", "Frank Ocean");
		s.rate(2);
		Assertions.assertEquals(2, s.getRating());
		Assertions.assertFalse(s.isFavorite());
	}
	
	@Test
	void testRateTwo() {
		Song s = new Song("Self Control", "Frank Ocean");
		s.rate(5);
		Assertions.assertTrue(s.isFavorite());
	}
}