/*
 * Playlist class is for the user to create playlists
 * full of songs that are already in their library
 */
package Model;

import java.util.ArrayList;

public class PlayList {
	private String name;
	private ArrayList<Song> playList;
	
	/*
	 * @Pre name != null 
	 */
	public PlayList(String name) {
		this.name = name;
		this.playList = new ArrayList<Song>();
	}
	
	public void addSong(Song song) {
		playList.add(song);
	}
	
	/*
	 * @Pre name != null && artist != null
	 */
	public void removeSong(String name, String artist) {
		// removes a song only if name and artist match song
		assert name != null && artist != null;
		for (Song s: playList) {
			if (s.getName().equals(name) && s.getArtist().equals(artist)) {
				playList.remove(s);
			}
		}
	}
	
	/*
	 * @Pre name != null && artist != null
	 */
	public Song getSong(String name, String artist) {
		assert name != null && artist != null;
		for (Song s: playList) {
			if (s.getName().equals(name) && s.getArtist().equals(artist)) {
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
	
	@Override
	public String toString() {
		// prints out the song title and artist followed by all it's songs
		String str = name + "\n";
		for (Song s : playList) {
			str += s.getName();
			str += "\n";
		}
		return str;
	}
}