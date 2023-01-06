package hust.soict.dsai.aims.media;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.Exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	

// Constructor
	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	
// getter
	public String getArtist() {
		return artist;
	}
	
// Method
	public String addTrack(Track t) {
		for(Track s: tracks) {
			if(s.getTilte() == t.getTilte()) {
				return "Author is exist";
			}
		}
		tracks.add(t);
		return "Done!";
	}
	
	public String removeTrack(Track t) {
		for(Track s: tracks) {
			if(s.getTilte() == t.getTilte()) {
				tracks.remove(t);
				return "Done!";
			}
		}
		return "Author is not exist!";
	}
	
// getLength;
	public double get_Length() {
		double length = 0;
		for(Track s: tracks) {
			length += s.getLength();		}
		
		return length;
	}
	
// play()
	@Override
	public void play() throws PlayerException {
		int size = tracks.size();
		JPanel layout = new JPanel(new GridLayout(size, 1));
		if (this.getLength() < 0) {
			throw new PlayerException("ERROR : CD length is non-positive");
		}
		for (Track track : tracks) {
			if (track.getLength() > 0) {
				// create Label
				JLabel text = new JLabel("CD - Title : " + track.getTilte() + " Length : " + track.getLength());

				layout.add(text);
			} else
				throw new PlayerException("ERROR : Disc length is non-positive");
		}
		JDialog dialog = new JDialog();
		dialog.setSize(300, 200);
		dialog.add(layout);
		dialog.setTitle("Play CD");
		dialog.setVisible(true);
	}

	@Override
	public String toString() {
		return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
				+ this.getLength() + " : " + this.getCost() + " $ " + " Artist: " + this.getArtist() + " Tracks: "
				+ this.tracks;
	}
}