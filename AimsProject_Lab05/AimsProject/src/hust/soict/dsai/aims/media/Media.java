package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {
	private static int dem = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	public int getId() {
		return id;
	}
	
	public int setId() {
		dem++;
		return dem;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Media() {
		
	}
	
	public Media(String title) {
		this.id = setId();
		this.title = title;
	}
	
	public Media(String title, String category, float cost) {
		this.id = setId();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	

	
	public abstract void setArtist(String artist);
	public abstract String getArtist();
	public abstract void setLength(int nextInt);
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

}
