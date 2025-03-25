package Model;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryModelTest {
	private LibraryModel myLibrary = new LibraryModel();
	private MusicStore store = new MusicStore();
	
	@Test 
	void testAddSongPlaylist() {
		myLibrary.makePlaylist("My Playlist");
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s, a);
		String str = myLibrary.addSongPlaylist("Dog", "Xavier", "My Playlist");
		Assertions.assertEquals(str, "Song Added");
	}
	
	@Test
	void testRemoveSongPlaylist() {
		myLibrary.makePlaylist("My Playlist");
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		myLibrary.addSongPlaylist("Dog", "Xavier", "My Playlist");
		String string = myLibrary.removeSongPlaylist("Dog", "Xavier", "My Playlist");
		Assertions.assertEquals(string, "Song Removed");
	}
	
	@Test
	void testGetSongTitle() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		String str = s.toString();
		Assertions.assertEquals(myLibrary.getSongTitle("Dog"), str);
		Assertions.assertEquals(myLibrary.getSong(s.getName(), s.getArtist()), s.toString());
	}
	
	@Test
	void testGetSongArtist() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Assertions.assertEquals(myLibrary.getSongArtist("Xavier"), s.toString());
	}
	
	@Test
	void testGetAlbumTitle() {
		Album a = new Album("21_Adele.txt");
		myLibrary.addAlbum(a);
		String str = myLibrary.getAlbumTitle("Blonde");
		Assertions.assertEquals(str, "Album Not Found");
	}
	
	@Test
	void testGetAlbumArtist() {
		Album a = new Album("21_Adele.txt");
		myLibrary.addAlbum(a);
		String str = myLibrary.getAlbumArtist("21");
		Assertions.assertEquals(str, "Album Not Found");
	}
	
	@Test
	void testGetAllArtists() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		Assertions.assertEquals(myLibrary.getAllArtists(), "Artists:\ncoldplay\nxavier\n");
	}
	
	@Test 
	void testGetAllAlbums() {
		Album a = new Album("21_Adele.txt");
		myLibrary.addAlbum(a);
		String str = a.toString();
		Assertions.assertEquals(myLibrary.getAllAlbums(), "Albums:\n" + str);
	}
	
	@Test 
	void testGetAllPlaylists() {
		myLibrary.makePlaylist("My Playlist");
		Assertions.assertEquals(myLibrary.getAllPlaylists(), "Playlists:\nfavorites:\nmy playlist:\n");
	}
	
	@Test 
	void testGetAllSongs() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		String str = song2.toString() + s.toString();
		Assertions.assertEquals(myLibrary.getAllSongs(), "Songs:\n" + str);
	}
	
	@Test
	void testGetSongs() {
		ArrayList<Song> songs = myLibrary.getSongs();
		Assertions.assertEquals(songs.size(), 0);
	}
	
	@Test
	void testGetFavorites() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		s.favorite();
		String str = s.toString();
		Assertions.assertEquals(myLibrary.getFavorites(), "Favorites:\n" + str);
	}
	
	@Test
	void testGetPlayList() {
		myLibrary.makePlaylist("My Playlist");
		Assertions.assertEquals(myLibrary.getPlayList("My Playlist"), "my playlist:\n");
	}
	
	@Test 
	void testRemoveFromLibrary(){
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		String og = myLibrary.getAllSongs();
		myLibrary.removeSongFromLibrary(s.getName(), s.getArtist());
		Assertions.assertEquals(false, og.equalsIgnoreCase(myLibrary.getAllSongs()));
	}

	@Test 
	void testPlay() {
		Song s = store.getSong("Dog", "Xavier");
		Album a = store.getAlbum(s.getAlbum(), s.getArtist());
		myLibrary.addSong(s,a);
		Song song2 = store.getSong("Clocks", "Coldplay");
		Album album2 = store.getAlbum(song2.getAlbum(), song2.getArtist());
		myLibrary.addSong(song2,album2);
		
		myLibrary.play(s.getName(), s.getAlbum());
		myLibrary.play(song2.getName(), song2.getAlbum());
		myLibrary.getRecents();
		
		Assertions.assertEquals(myLibrary.getRecents(), "Recent Songs:\n"+ song2.toString() + s.toString());
	}
	
	@Test
    public void testGetSortedBySongTitle() {
        Song s1 = store.getSong("Dog", "Xavier");
        Album a1 = store.getAlbum(s1.getAlbum(), s1.getArtist());
        Song s2 = store.getSong("Clocks", "Coldplay");
        Album a2 = store.getAlbum(s2.getAlbum(), s2.getArtist());
        Song s3 = store.getSong("It Was You", "Norah Jones");
        Album a3 = store.getAlbum(s3.getAlbum(), s3.getArtist());

        myLibrary.addSong(s1, a1);
        myLibrary.addSong(s2, a2);
        myLibrary.addSong(s3, a3);

        
        String expected = s2.toString() + s1.toString() + s3.toString();
        Assertions.assertEquals(expected, myLibrary.getSortedBySongTitle());
    }

    @Test
    public void testGetSortedBySongArtist() {
        Song s1 = store.getSong("Dog", "Xavier");
        Album a1 = store.getAlbum(s1.getAlbum(), s1.getArtist());
        Song s2 = store.getSong("Clocks", "Coldplay");
        Album a2 = store.getAlbum(s2.getAlbum(), s2.getArtist());
        Song s3 = store.getSong("It Was You", "Norah Jones");
        Album a3 = store.getAlbum(s3.getAlbum(), s3.getArtist());

        myLibrary.addSong(s1, a1);
        myLibrary.addSong(s2, a2);
        myLibrary.addSong(s3, a3);

     
        String expected = s2.toString() + s3.toString() + s1.toString();
        Assertions.assertEquals(expected, myLibrary.getSortedBySongArtist());
    }

    @Test
    public void testGetSortedByRating() {
        Song s1 = store.getSong("Dog", "Xavier");
        s1.rate(4);
        Album a1 = store.getAlbum(s1.getAlbum(), s1.getArtist());
        Song s2 = store.getSong("Clocks", "Coldplay");
        s2.rate(2);
        Album a2 = store.getAlbum(s2.getAlbum(), s2.getArtist());
        Song s3 = store.getSong("It Was You", "Norah Jones");
        Album a3 = store.getAlbum(s3.getAlbum(), s3.getArtist());

        myLibrary.addSong(s1, a1);
        myLibrary.addSong(s2, a2);
        myLibrary.addSong(s3, a3);
        
        myLibrary.favoriteSong(s3.getName(), s3.getArtist());
        
        String expected = s2.toString() + s1.toString() + s3.toString();
        Assertions.assertEquals(expected, myLibrary.getSortedbyRating());
    }
	
    @Test
    public void testGetFrequents() {
    	Song s1 = store.getSong("Dog", "Xavier");
        Album a1 = store.getAlbum(s1.getAlbum(), s1.getArtist());
        Song s2 = store.getSong("Clocks", "Coldplay");
        Album a2 = store.getAlbum(s2.getAlbum(), s2.getArtist());
        Song s3 = store.getSong("It Was You", "Norah Jones");
        Album a3 = store.getAlbum(s3.getAlbum(), s3.getArtist());

        myLibrary.addSong(s1, a1);
        myLibrary.addSong(s2, a2);
        myLibrary.addSong(s3, a3);
        
        myLibrary.play(s1.getName(), s1.getAlbum());
		myLibrary.play(s2.getName(), s2.getAlbum());
    	
		Assertions.assertEquals(myLibrary.getFrequents(), "Frequent Songs:\n" + s1.toString() + s2.toString());
    }
	
    @Test
    // sometimes will be wrong because how shuffle works
    public void testShuffle() {
    	Song s1 = store.getSong("Dog", "Xavier");
        Album a1 = store.getAlbum(s1.getAlbum(), s1.getArtist());
        Song s2 = store.getSong("Clocks", "Coldplay");
        Album a2 = store.getAlbum(s2.getAlbum(), s2.getArtist());
        Song s3 = store.getSong("It Was You", "Norah Jones");
        Album a3 = store.getAlbum(s3.getAlbum(), s3.getArtist());
        
        myLibrary.addSong(s1, a1);
        myLibrary.addSong(s2, a2);
        myLibrary.addSong(s3, a3);  
        
        myLibrary.play(s1.getName(), s1.getAlbum());
		myLibrary.play(s2.getName(), s2.getAlbum());
		
		myLibrary.makePlaylist("my playlist");
		
		myLibrary.addSongPlaylist(s1.getName(), s1.getArtist(), "my playlist");
		myLibrary.addSongPlaylist(s2.getName(), s2.getArtist(), "my playlist");
		myLibrary.addSongPlaylist(s3.getName(), s3.getArtist(), "my playlist");
		
		String og = myLibrary.getPlayList("my playlist");
		
		myLibrary.shuffleSongs("my playlist");
		String newFreq = myLibrary.getPlayList("my playlist");
		Assertions.assertEquals(false, og.equals(newFreq));
		
    }
    
    @Test 
    public void testRemoveAlbumLibrary() {
    	Song s1 = store.getSong("Dog", "Xavier");
        Album a1 = store.getAlbum(s1.getAlbum(), s1.getArtist());
        Song s2 = store.getSong("Clocks", "Coldplay");
        Album a2 = store.getAlbum(s2.getAlbum(), s2.getArtist());
        Song s3 = store.getSong("It Was You", "Norah Jones");
        Album a3 = store.getAlbum(s3.getAlbum(), s3.getArtist());
        
        myLibrary.addSong(s1, a1);
        myLibrary.addSong(s2, a2);
        myLibrary.addSong(s3, a3);  
        
        Assertions.assertEquals(myLibrary.removeAlbumFromLibrary(a3.getTitle(), a3.getArtist()), "Album Removed");
    }
    
    @Test 
    public void testGetSongGenre() {
    	Song s1 = store.getSong("Dog", "Xavier");
        Album a1 = store.getAlbum(s1.getAlbum(), s1.getArtist());
        Song s2 = store.getSong("Clocks", "Coldplay");
        Album a2 = store.getAlbum(s2.getAlbum(), s2.getArtist());
        Song s3 = store.getSong("It Was You", "Norah Jones");
        Album a3 = store.getAlbum(s3.getAlbum(), s3.getArtist());
        
        myLibrary.addSong(s1, a1);
        myLibrary.addSong(s2, a2);
        myLibrary.addSong(s3, a3);  
        
        Assertions.assertEquals(myLibrary.getSongGenre(s3.getGenre()), s3.toString()+ s1.toString());
    }
}
