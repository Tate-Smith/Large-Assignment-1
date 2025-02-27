package Model;


import java.util.ArrayList;

public class PlayList {
	private String name;
	private ArrayList<Song> playList;
	
	/*
	 * @pre name != null 
	 */
	public PlayList(String name) {
		this.name = name;
		this.playList = new ArrayList<Song>();
	}
	
	public void addSong(Song song) {
		playList.add(song);
	}
	
	public void removeSong(String name, String artist) {
		assert name != null && artist != null;
		for (Song s: playList) {
			if (s.getName().equals(name) && s.getArtist().equals(artist)) {
				playList.remove(s);
			}
		}
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		return name;
	}

}
