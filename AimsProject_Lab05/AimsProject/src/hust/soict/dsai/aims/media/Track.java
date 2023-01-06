package hust.soict.dsai.aims.media;

import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.dsai.aims.Exception.PlayerException;

public class Track implements Playable {
	private String tilte;
	private float length;
	

// Constructor
	public Track(String tilte, float length) {
		this.tilte = tilte;
		this.length = length;
	}
	
// Getter
	public String getTilte() {
		return tilte;
	}
	
	public float getLength() {
		return length;
	}
	
// play
	
	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		if (this.getLength() > 0) {
			JDialog dialog = new JDialog();
			dialog.setSize(300, 200);

			// create Label
			JLabel text = new JLabel("Track - Title : " + this.getTilte() + " Length : " + this.getLength());
			dialog.add(text);
			dialog.setTitle("Play Track");
			dialog.setVisible(true);
		} else
			throw new PlayerException("ERROR : Track length is non-positive");
	}
	
	@Override
	public boolean equals(Object o) {
		Track tmp = (Track)o;
		if(this.getTilte() == tmp.getTilte() && this.getLength() == tmp.getLength()) {
			return true;
		}
		else return false;
	}

}
