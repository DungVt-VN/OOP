package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private String director;
	private float length;
	
	public String getDirector() {
		return director;
	}
	public float getLength() {
		return length;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Disc() {
		super();
	}
	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	@Override
	public void setArtist(String artist) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getArtist() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
