package view;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Album;
import Model.MusicStore;
import Model.Song;
import Model.LibraryModel;

/*
 * This is the view class that houses the main method.
 * The role of this class is to provide a UI for the 
 * user to interact with so they can create albums
 * and search for music using the previously created classes
 */

public class View {
	private static MusicStore store = new MusicStore();
	private static LibraryModel library = new LibraryModel();
	
	
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
		if (s == null) System.out.println("Song not in store");
		else {
			library.addSong(s);
			System.out.println("Added to library!");
		}
	}
	
	public static void addAlbumToLibrary(String album, String artist) {
		Album a = store.getAlbum(album, artist);
		if (a == null) System.out.println("Album not in store");
		else {
			library.addAlbum(a);
			System.out.println("Added to library!");
		}
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
		System.out.println(library.getAllPlaylists());
	}
	
	public static void createPlayList(String name) {
		library.makePlaylist(name);
		System.out.println("Playlist Created!");
	}
	
	public static void rateASong(String song, int rating) {
		ArrayList<Song> songs = library.getSongs();
		for (Song s : songs) {
			if (s.getName().toLowerCase().equals(song)) {
				s.rate(rating);
				System.out.println("Done!");
				return;
			}
		}
		System.out.println("Song Not Found");
	}
	
	public static void addSongPlaylist(String name, String artist, String playlist) {
		library.addSongPlaylist(name, artist, playlist);
		System.out.println(name + " Added to " + playlist + "!");
	}
	
	public static void removeSongPlaylist(String name, String artist, String playlist) {
		library.removeSongPlaylist(name, artist, playlist);
		System.out.println(name + " Removed from " + playlist);
	}
	
	public static void favoriteSong(String name, String artist) {
		// not working as intended
		library.favoriteSong(name, artist);
		System.out.println(name + " is now a Favorite!");
	}
	
	public static void findUser(String username, String password) {
		
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
		// runs until the user wnats to wuit the program
		// create user system with login or create account
		System.out.println("Login or Create New Account");
		String input = reader.nextLine();
		switch (input.toLowerCase().trim()) {
			case "login":
				System.out.print("Username: ");
				String username = reader.nextLine();
				System.out.println("Password: ");
				String password = reader.nextLine();
				findUser(username, password);
				break;
			case "create account":
				System.out.println("Create Username: ");
				String user = reader.nextLine();
				// make user username is not already in database
				System.out.println("Password must include uppercase, lowercase, number and special character: ");
				String newPassword = reader.nextLine();
				// authenticate the password works
				// create an user object that has that accounts userLibrary and info
				// add that to a database of files for all users
				// encrypt the password
				break;
			default:
				System.out.println("Invalid Input");
		}
		while (!quit) {
			System.out.println("Command:");
			input = reader.nextLine();
			boolean back = false;
			// determines whether to be in userLirary or music store
			// uses "back" to leave it
			switch (input.toLowerCase().trim()) {
			// while in userlibrary it is constantly looking for commands 
				case "userlibrary":
					while (!back) {
						System.out.println("What would you like to do?");
						input = reader.nextLine();
						switch (input.toLowerCase().trim()) {
							case "get songs artist":
								System.out.println("Artist?");
								input = reader.nextLine();
								getSongByArtistUserLibrary(input.toLowerCase().trim());
								break;
							case "get songs title":
								System.out.println("Title?");
								input = reader.nextLine();
								getSongByTitleUserLibrary(input.toLowerCase().trim());
								break;
							case "get album artist":
								System.out.println("Artist?");
								input = reader.nextLine();
								getAlbumByArtistUserLibrary(input.toLowerCase().trim());
								break;
							case "get album title":
								System.out.println("Title?");
								input = reader.nextLine();
								getAlbumByTitleUserLibrary(input.toLowerCase().trim());
								break;
							case "get my playlists":
								System.out.println("Name?");
								input = reader.nextLine();
								getPlaylist(input.toLowerCase().trim());
								break;
							case "add a song":
								// loop to make sure input is correctly split by comma
								String[] info;
								while (true) {
									System.out.println("Artist and name? (Split by comma)");
									input = reader.nextLine();
									info = input.split(",");
									if (info.length == 2) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								addSongToLibrary(info[1].toLowerCase().trim(), info[0].toLowerCase().trim());
								break;
							case "add an album":
								// loop to make sure input is correctly split by comma
								String[] info1;
								while (true) {
									System.out.println("Artist and name? (Split by comma)");
									input = reader.nextLine();
									info1 = input.split(",");
									if (info1.length == 2) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								addAlbumToLibrary(info1[1].toLowerCase().trim(), info1[0].toLowerCase().trim());
								break;
							case "get artists":
								getArtistsFromLibrary();
								break;
							case "get albums":
								getAlbumsFromLibrary();
								break;
							case "get songs":
								getSongsFromLibrary();
								break;
							case "get favorites":
								getFavoritesFromLibrary();
								break;
							case "get playlists":
								getPlaylistsFromLibrary();
								break;
							case "create playlist":
								System.out.println("Name?");
								input = reader.nextLine();
								createPlayList(input.toLowerCase().trim());
								break;
							case "rate song":
								// loop to make sure input is correctly split by comma
								String[] data;
								while (true) {
									System.out.println("Rating and name? (Split by comma)");
									input = reader.nextLine();
									data = input.split(",");
									if (data.length == 2) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								rateASong(data[1].toLowerCase().trim(), Integer.valueOf(data[0]));
								break;
							case "add song to playlist":
								// loop to make sure input is correctly split by comma
								String[] data1;
								while (true) {
									System.out.println("Artist, playlist name and name? (Split by commas)");
									input = reader.nextLine();
									data1 = input.split(",");
									if (data1.length == 3) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								addSongPlaylist(data1[1].toLowerCase().trim(), data1[2].toLowerCase().trim(), data1[0].toLowerCase().trim());
								break;
							case "remove song from playlist":
								// loop to make sure input is correctly split by comma
								String[] data2;
								while (true) {
									System.out.println("Artist, playlist name and name? (Split by commas)");
									input = reader.nextLine();
									data2 = input.split(",");
									if (data2.length == 3) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								removeSongPlaylist(data2[1].toLowerCase().trim(), data2[2].toLowerCase().trim(), data2[0].toLowerCase().trim());
								break;
							case "favorite song":
								// loop to make sure input is correctly split by comma
								String[] data3;
								while (true) {
									System.out.println("Artist and name? (Split by comma)");
									input = reader.nextLine();
									data3 = input.split(",");
									if (data3.length == 2) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								favoriteSong(data3[1].toLowerCase().trim(), data3[0].toLowerCase().trim());
								break;
							case "back":
								back = true;
								break;
							default:
								System.out.println("Invalid input");
						}
					}
					break;
					// while in musicstore its constantly looking for commands
				case "musicstore":
					while (!back) {
						System.out.println("What would you like to do?");
						input = reader.nextLine();
						input = input.toLowerCase().trim();
						switch (input) {
							case "get songs title":
								System.out.println("Title?");
								input = reader.nextLine();
								getSongByTitle(input.toLowerCase().trim());
								break;
							case "get songs artist":
								System.out.println("Artist?");
								input = reader.nextLine();
								getSongByArtist(input.toLowerCase().trim());
								break;
							case "get album title":
								System.out.println("Title?");
								input = reader.nextLine();
								getAlbumByTitle(input.toLowerCase().trim());
								break;
							case "get album artist":
								System.out.println("Artist?");
								input = reader.nextLine();
								getAlbumByArtist(input.toLowerCase().trim());
								break;
							case "back":
								back = true;
								break;
							default:
								System.out.println("Invalid input");
						}
					}
					break;
				case "quit":
					System.out.println("Quiting...");
					quit = true;
					break;
				default:
					System.out.println("Invalid input");
			}
		}
		reader.close();
	}
}