package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	//	Total Cost of Card
	public float totalCost() {
		float total = 0;
		for(Media m: itemsOrdered) {
			total += m.getCost();
		}
		return total;
	}
	// Add Media to Cart

	public void addMedia(Media m) throws LimitExceededException{
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			for(Media e: itemsOrdered) {
				if(e.getTitle().equals(m.getTitle() )) {
					JOptionPane.showMessageDialog(null, "Error!");
					return;
				}
			}
			itemsOrdered.add(m);
			JOptionPane.showMessageDialog(null, "The media has been added!");
			return;
		} else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
		
	}
	// Remove Media to Cart	
	public void removeMedia(Media m) {
		totalCost();
		for(Media media: itemsOrdered) {
			if(media.getTitle() == m.getTitle()) {
				itemsOrdered.remove(m);
				return;
			}
		}
	}
	// Search by ID	
	public boolean search(int id) {
		for(Media m: itemsOrdered) {
			if(m.getId() == id) {
				return true;
			}
		}
		return false;
	}
	// Search by Title
	public boolean search(String title) {
		for(Media m: itemsOrdered) {
			if(m.getTitle() == title) {
				return true;
			}
		}
		return false;
	}
	

	// Print Cart
	public void printCart() {
		System.out.println("***********************CART***********************");
		int i = 1;
		for(Media m: itemsOrdered) {
			System.out.println(m.getId() + ".DVD - " + m.getTitle() + " - " + 
					m.getCategory() + " - " + 
					m.getTitle() + " - " + 
					m.getCost());
			i++;
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void printLength() {
		System.out.println(itemsOrdered.size());
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void setItemsOrdered(ObservableList<Media> item){
		itemsOrdered.clear();
		itemsOrdered.addAll(item);
		return;
	}

	public void removeAll() {
		itemsOrdered.removeAll(itemsOrdered);
		return;
		
	}
}
