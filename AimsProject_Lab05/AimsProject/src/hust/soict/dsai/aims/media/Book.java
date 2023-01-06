package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
	private int Length;
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category,String Author, int Length, float cost) {
		super(title, category, cost);
		this.authors.add(Author);
		this.Length = Length;
		
	}
	
	
	public boolean addAuthor(String authorName) {
		for(String s: authors) {
			if(s == authorName) {
				return false;
			}
		}
		authors.add(authorName);
		return true;
	}
	
	public boolean removeAuthor(String authorName) {
		for(String s: authors) {
			if(s == authorName) {
				authors.remove(authorName);
				return true;
			}
		}
		return false;
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
	@Override
	public void setLength(int nextInt) {
		// TODO Auto-generated method stub
		
	}
}
