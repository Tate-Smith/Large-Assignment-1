/*
 * This is the view class that houses the main method.
 * The role of this class is to provide a UI for the 
 * user to interact with so they can create albums
 * and search for music using the previously created classes
 */

package Model;

public class View {

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
