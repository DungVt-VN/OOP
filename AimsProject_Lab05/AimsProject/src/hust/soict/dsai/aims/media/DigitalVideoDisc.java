package hust.soict.dsai.aims.media;

import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.dsai.aims.Exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		if (this.getLength() > 0) {
			JDialog dialog = new JDialog();
			dialog.setSize(300, 200);

			// create Label
			JLabel text = new JLabel("DVD - Title : " + this.getTitle() + " Length : " + this.getLength());
			dialog.add(text);
			dialog.setTitle("Play DVD");
			dialog.setVisible(true);
		} else {
			throw new PlayerException("ERROR : DVD length is non-positive");
			
		}
		
	}

}