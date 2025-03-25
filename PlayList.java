/*
 * Playlist class is for the user to create playlists
 * full of songs that are already in their library
 */
package Model;

import java.util.ArrayList;
import java.util.*;

public class PlayList {
	private String name;
	private ArrayList<Song> playList;

	/*
	 * @Pre name != null 
	 */
	public PlayList(String name) {
		this.name = name.toLowerCase();
		this.playList = new ArrayList<Song>();
	}

	public void addSong(Song song) {
		playList.add(song);
	}

	public Boolean removeSong(Song song) {
		return playList.remove(song);
	}

	/*
	 * @Pre name != null && artist != null
	 */
	public Song getSong(String name, String artist) {
		assert name != null && artist != null;
		for (Song s: playList) {
			if (s.getName().equalsIgnoreCase(name) && s.getArtist().equalsIgnoreCase(artist)) {
				return s;
			}
		}
		return null;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Song> getSongs() {
		return new ArrayList<>(playList);
	}
	
	public void shuffle() {
		Collections.shuffle(playList);
	}
	@Override
	public String toString() {
		// prints out the song title and artist followed by all it's songs
		String str = name + ":\n";
		for (Song s : playList) {
			str += s.getName() + "\n";
		}
		return str;
	}
}