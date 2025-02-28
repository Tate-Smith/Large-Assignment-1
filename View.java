package Model;
/*
 * This is the view class that houses the main method.
 * The role of this class is to provide a UI for the 
 * user to interact with so they can create albums
 * and search for music using the previously created classes
 */


public class View {
	
	
	/* search for information from the music store
	● for a song by title
	● for a song by artist
	● for an album by title
	● for an album by artist
	*/

	public void getSongByTitle(String title, MusicStore store) {
		System.out.println(store.getSongTitle(title));
		
	}
	
	public void getSongByArtist(String artist, MusicStore store) {
		System.out.println(store.getSongArtist(artist));
	}
	
	public void getAlbumByTitle(String title, MusicStore store) {
		System.out.println(store.getAlbumTitle(title));
	}
	
	public void getAlbumByArtist(String artist, MusicStore store) {
		System.out.println(store.getAlbumArtist(artist));
	}
	
	/*
	 * ● should cover all the search cases listed for the music store
	   ● should also be able to search for a playlist by name – the result should print the songs
	   (title and artist)

	 */
	
	public void getSongByArtistUserLibrary(String songName, String artist, UserLibrary library) {

		
	}
	
	public void getSongByTitleUserLibrary(String name, String artist, UserLibrary library) {

		
	}

	public void getAlbumByArtistUserLibrary(String artist, UserLibrary library) {
	}
	
	public void getAlbumByTitleUserLibrary(String title, UserLibrary library) {
	}
	
	public void getPlaylist(String name, UserLibrary library) {
		System.out.println(library.getPlayList(name));
	}
	
	public void addSongToLibrary(Song song, UserLibrary library) {
		library.addSong(song);
	}
	
	public void addAlbumToLibrary(Album album, UserLibrary library) {
		library.addAlbum(album);
	}
	

		
	
	
	public void getArtistsFromLibrary(UserLibrary library) {
		System.out.println(library.getAllArtists());
	}
	
	public void getAlbumsFromLibrary(UserLibrary library) {
		System.out.println(library.getAllAlbums());
	}
	
	public void getFavoritesFromLibrary(UserLibrary library) {
		System.out.println(library.getFavorites());
		
	}
	
	public void createPlayList(String name, UserLibrary library) {
		library.makePlaylist(name);
	}
	
	public void rateASong(Song song, int rating) {
		
	}
	// if statement for 
	// switch statement
	public static void main(String[] args) {
		// create the users library
		UserLibrary userLibrary = new UserLibrary();
		// create the Music Store
		MusicStore store = new MusicStore();
		// create a UI for the user to somehow jump from their own
		// library to the store, and for them to add songs and albums to their
		// library, and create playlists, should all be done in the terminal

	}

}