package Model;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * This is the view class that houses the main method.
 * The role of this class is to provide a UI for the 
 * user to interact with so they can create albums
 * and search for music using the previously created classes
 */

public class View {
	private static MusicStore store = new MusicStore();
	private static UserLibrary library = new UserLibrary();
	
	
	/* search for information from the music store
	● for a song by title
	● for a song by artist
	● for an album by title
	● for an album by artist
	*/

	public static void getSongByTitle(String title) {
		System.out.println(store.getSongTitle(title));
	}
	
	public static void getSongByArtist(String artist) {
		System.out.println(store.getSongArtist(artist));
	}
	
	public static void getAlbumByTitle(String title) {
		System.out.println(store.getAlbumTitle(title));
	}
	
	public static void getAlbumByArtist(String artist) {
		System.out.println(store.getAlbumArtist(artist));
	}
	
	/*
	 * ● should cover all the search cases listed for the music store
	   ● should also be able to search for a playlist by name – the result should print the songs
	   (title and artist)

	 */
	
	public static void getSongByArtistUserLibrary(String artist) {
		System.out.println(library.getSongArtist(artist));		
	}
	
	public static void getSongByTitleUserLibrary(String title) {
		System.out.println(library.getSongTitle(title));
	}

	public static void getAlbumByArtistUserLibrary(String artist) {
		System.out.println(library.getAlbumArtist(artist));
	}
	
	public static void getAlbumByTitleUserLibrary(String title) {
		System.out.println(library.getAlbumTitle(title));
	}
	
	public static void getPlaylist(String name) {
		System.out.println(library.getPlayList(name));
	}
	
	public static void addSongToLibrary(String song, String artist) {
		Song s = store.getSong(song, artist);
		library.addSong(s);
	}
	
	public static void addAlbumToLibrary(String album, String artist) {
		Album a = store.getAlbum(album, artist);
		library.addAlbum(a);
	}
	
	public static void getArtistsFromLibrary() {
		System.out.println(library.getAllArtists());
	}
	
	public static void getAlbumsFromLibrary() {
		System.out.println(library.getAllAlbums());
	}
	
	public static void getFavoritesFromLibrary() {
		System.out.println(library.getFavorites());
	}
	
	public static void getSongsFromLibrary() {
		System.out.println(library.getAllSongs());
	}
	
	public static void getPlaylistsFromLibrary() {
		System.out.println(library.getAllPlayists());
	}
	
	public static void createPlayList(String name) {
		library.makePlaylist(name);
	}
	
	public static void rateASong(String song, int rating) {
		ArrayList<Song> songs = library.getSongs();
		for (Song s : songs) {
			if (s.getName().equals(song)) {
				s.rate(rating);
			}
		}
	}
	
	public static void addSongPlaylist(String name, String artist, String playlist) {
		library.addSongPlaylist(name, artist, playlist);
	}
	
	// if statement for 
	// switch statement
	public static void main(String[] args) {
		// have a while loop that is always true as long as quit is false
		// be able to switch between userLibrary and Music store
		// be able to add songs to library, search for songs
		// be able to search for songs in Music store
		Scanner reader = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.println("Command:");
			String input = reader.nextLine();
			input.toLowerCase().trim();
			boolean back = false;
			switch (input) {
				case "userlibrary":
					while (!back) {
						System.out.println("What would you like to do?");
						input = reader.nextLine();
						input.toLowerCase().trim();
						switch (input) {
							case "get songs by artist":
								System.out.println("Who is the Artist?");
								input = reader.nextLine();
								input.toLowerCase().trim();
								getSongByArtistUserLibrary(input);
							case "get songs by title":
								System.out.println("What is the title?");
								input = reader.nextLine();
								input.toLowerCase().trim();
								getSongByTitleUserLibrary(input);
							case "get album by artist":
								System.out.println("Who is the Artist?");
								input = reader.nextLine();
								input.toLowerCase().trim();
								getAlbumByArtistUserLibrary(input);
							case "get album by title":
								System.out.println("What is the title?");
								input = reader.nextLine();
								input.toLowerCase().trim();
								getAlbumByTitleUserLibrary(input);
							case "get my playlists":
								System.out.println("What is it called?");
								input = reader.nextLine();
								input.toLowerCase().trim();
								getPlaylist(input);
							case "add a song":
								System.out.println("What is the song's name and artist?");
								input = reader.nextLine();
								String[] info = input.split(" ");
								info[0].toLowerCase().trim();
								info[1].toLowerCase().trim();
								addSongToLibrary(info[0], info[1]);
							case "add an album":
								System.out.println("What is the album's name and artist?");
								input = reader.nextLine();
								String[] info1 = input.split(" ");
								info1[0].toLowerCase().trim();
								info1[1].toLowerCase().trim();
								addAlbumToLibrary(info1[0], info1[1]);
							case "get artists":
								getArtistsFromLibrary();
							case "get albums":
								getAlbumsFromLibrary();
							case "get songs":
								getSongsFromLibrary();
							case "get favorites":
								getFavoritesFromLibrary();
							case "get playlists":
								getPlaylistsFromLibrary();
							case "create a playlist":
								System.out.println("What is it's name?");
								input = reader.nextLine();
								input.toLowerCase().trim();
								createPlayList(input);
							case "rate song":
								System.out.println("What is the songs name, and what is your rating?");
								input = reader.nextLine();
								String[] data = input.split(" ");
								data[0].toLowerCase().trim();
								data[1].toLowerCase().trim();
								rateASong(data[0], Integer.valueOf(data[1]));
							case "add a song to playlist":
								System.out.println("What is the songs name, artists?");
								input = reader.nextLine();
								String[] data = input.split(" ");
								data[0].toLowerCase().trim();
								data[1].toLowerCase().trim();
								rateASong(data[0], Integer.valueOf(data[1]));
						}
					}
				case "musicstore":
					
				case "quit":
					quit = true;
				default:
					System.out.println("Invalid input");
			}
		}

	}
}