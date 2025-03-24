package view;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Album;
import Model.MusicStore;
import Model.Song;
import Model.User;
import Model.UserDataBase;
import Model.LibraryModel;

/*
 * This is the view class that houses the main method.
 * The role of this class is to provide a UI for the 
 * user to interact with so they can create albums
 * and search for music using the previously created classes
 */

public class View {
	private static MusicStore store = new MusicStore();
	private static LibraryModel library;
	private static UserDataBase database = new UserDataBase();
	
	/*
	 * ● should cover all the search cases listed for the music store
	   ● should also be able to search for a playlist by name – the result should print the songs
	   (title and artist)
	 */
	
	private static void addSongToLibrary(String song, String artist) {
		Song s = store.getSong(song, artist);
		Album a = store.getSongAlbum(song, artist);
		if (s == null) System.out.println("Song not in store");
		else {
			library.addSong(s, a);
			System.out.println("Added to library!");
		}
	}
	
	private static void addAlbumToLibrary(String album, String artist) {
		Album a = store.getAlbum(album, artist);
		if (a == null) System.out.println("Album not in store");
		else {
			library.addAlbum(a);
			System.out.println("Added to library!");
		}
	}
	
	private static void createPlayList(String name) {
		library.makePlaylist(name);
		System.out.println("Playlist Created!");
	}
	
	private
	static void rateASong(String song, int rating) {
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
	
	public static void addSongPlaylist(String artist, String playlist, String name) {
		library.addSongPlaylist(name, artist, playlist);
		System.out.println(name + " Added to " + playlist + "!");
	}
	
	public static void removeSongPlaylist(String artist, String playlist, String name) {
		library.removeSongPlaylist(name, artist, playlist);
		System.out.println(name + " Removed from " + playlist);
	}
	
	public static void favoriteSong(String name, String artist) {
		// not working as intended
		library.favoriteSong(name, artist);
		System.out.println(name + " is now a Favorite!");
	}
	
	// if statement for 
	// switch statement
	public static void main(String[] args) throws Exception {
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
				User u = database.getUser(username);
				while (!u.getPassword().equals(password)) {
					System.out.println("Password: ");
					password = reader.nextLine();
					System.out.println("Wrong Password, Try Again");
				}
				library = u.getUserLibrary();
				break;
			case "create account":
				System.out.println("Create Username: ");
				String user = reader.nextLine();
				// make user username is not already in database
				System.out.println("Password must include uppercase, lowercase, number and special character: ");
				String newPassword = reader.nextLine();
				// authenticate the password works
				// create an user object that has that accounts userLibrary and info
				User newUser = new User(user, newPassword);
				database.addUser(newUser);
				// add that to a database of files for all users
				// encrypt the password
				library = newUser.getUserLibrary();
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
								System.out.println(library.getSongArtist(input.toLowerCase().trim()));	
								break;
							case "get songs title":
								System.out.println("Title?");
								input = reader.nextLine();
								System.out.println(library.getSongTitle(input.toLowerCase().trim()));
								break;
							case "get song":
								// get a very sepcific song by title and artist
								String[] data4;
								while (true) {
									System.out.println("Title and Arist? (Split by comma)");
									input = reader.nextLine();
									data4 = input.split(",");
									if (data4.length == 2) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								System.out.println(library.getSong(data4[0].toLowerCase().trim(), data4[1].toLowerCase().trim()));
								System.out.println("Get Songs Album Info?");
								input = reader.nextLine();
								if (input.toLowerCase().trim().equals("yes")) {
									Album a = store.getSongAlbum(data4[0].toLowerCase().trim(), data4[1].toLowerCase().trim()); 
									System.out.println(a);
								}
							case "get album artist":
								System.out.println("Artist?");
								input = reader.nextLine();
								System.out.println(library.getAlbumArtist(input.toLowerCase().trim()));
								break;
							case "get songs by genre":
								System.out.println("Genre:");
								input = reader.nextLine();
								System.out.println(library.getSongGenre(input.toLowerCase().trim()));
								break;
							case "get album title":
								System.out.println("Title?");
								input = reader.nextLine();
								System.out.println(library.getAlbumTitle(input.toLowerCase().trim()));
								break;
							case "get playlist":
								System.out.println("Name?");
								input = reader.nextLine();
								System.out.println(library.getPlayList(input.toLowerCase().trim()));
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
								System.out.println(library.getAllArtists());
								break;
							case "get albums":
								System.out.println(library.getAllAlbums());
								break;
							case "get songs":
								System.out.println(library.getAllSongs());
								break;
							case "get favorites":
								System.out.println(library.getFavorites());
								break;
							case "get playlists":
								System.out.println(library.getAllPlaylists());
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
								addSongPlaylist(data1[0].toLowerCase().trim(), data1[1].toLowerCase().trim(), data1[2].toLowerCase().trim());
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
								removeSongPlaylist(data2[0].toLowerCase().trim(), data2[1].toLowerCase().trim(), data2[2].toLowerCase().trim());
								break;
							case "favorite song":
								// loop to make sure input is correctly split by comma
								String[] data3;
								while (true) {
									System.out.println("Name and Artist? (Split by comma)");
									input = reader.nextLine();
									data3 = input.split(",");
									if (data3.length == 2) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								favoriteSong(data3[0].toLowerCase().trim(), data3[1].toLowerCase().trim());
								break;
							case "play":
								String[] play_song;
								while (true) {
									System.out.println("Song name and Artist? (Split by commas)");
									input = reader.nextLine();
									play_song = input.split(",");
									if (play_song.length == 2) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								library.play(play_song[0].toLowerCase().trim(), play_song[1].toLowerCase().trim());
								break;
							case "get recents":
								System.out.println(library.getRecents());
								break;
							case "get frequents":
								System.out.println(library.getFrequents());
								break;
							case "get sorted by title":
								System.out.println(library.getSortedBySongTitle());
								break;
							case "get sorted by artist":
								System.out.println(library.getSortedBySongArtist());
								break;
							case "get sorted by rating":
								System.out.println(library.getSortedbyRating());
								break;
							case "remove from library":
								// both album or song
								String[] remove_info;
								while (true) {
									System.out.println("Name, Artist, Album or Song? (split by commas");
									input = reader.nextLine();
									remove_info = input.split(",");
									if (remove_info.length == 3) break;
									else {
										System.out.println("Invalid Input");
									}
								}
								if (remove_info[2].toLowerCase().trim().equals("song")) {
									System.out.println(library.removeFromLibrary(remove_info[0].toLowerCase().trim(), remove_info[1].toLowerCase().trim()));
								}
								else {
									System.out.println(library.removeAlbumFromLibrary(remove_info[0].toLowerCase().trim(), remove_info[1].toLowerCase().trim()));
								}
								break;
							case "shuffle songs":
								// both playlist and all songs
								System.out.println("Playlist or All Songs?");
								input = reader.nextLine();
								if (input.toLowerCase().trim().equals("all")) {
									library.shuffleSongs();
								}
								else {
									System.out.println("Name?");
									input = reader.nextLine();
									library.shuffleSongs(input.toLowerCase().trim());
								}
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
								System.out.println(store.getSongTitle(input.toLowerCase().trim()));
								break;
							case "get songs artist":
								System.out.println("Artist?");
								input = reader.nextLine();
								System.out.println(store.getSongArtist(input.toLowerCase().trim()));
								break;
							case "get album title":
								System.out.println("Title?");
								input = reader.nextLine();
								System.out.println(store.getAlbumTitle(input.toLowerCase().trim()));
								break;
							case "get album artist":
								System.out.println("Artist?");
								input = reader.nextLine();
								System.out.println(store.getAlbumArtist(input.toLowerCase().trim()));
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