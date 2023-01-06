package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.*;

public class Store {
	public static final int MAX_NUMBER_ORDERED = 1000;
	private ArrayList<Media> itemsInStore =
			new ArrayList<Media>();
	private int qtyOrdered = 0;
	public float priceAll = 0;
	
	public  void addDVD(Media disc) {
		itemsInStore.add(disc);
		++qtyOrdered;
	}

	public void addDVD(Media[] dvdList) {
		int i = 0;
		while(dvdList[i] != null) {
			itemsInStore.add(dvdList[i]);
			++qtyOrdered;
			i++;
		}
	}

	
	public boolean removeDVD(Media disc) {
		for(Media e: itemsInStore) {
			if(e.getTitle().equals(disc.getTitle()) &&  e.getCategory().equals(disc.getCategory())) {
				itemsInStore.remove(e);
				return true;
			}
		}
		return false;
	}
	
	public int getQtyOrdered() {
		return itemsInStore.size();
	}
	
	public float totalCost() {
		float result = 0;
		
		for(Media e: itemsInStore) {
			result = result + e.getCost();
		}
		return result;
	}
	
// 6. print Store
	public void print() {
		float priceAll = 0;
		System.out.printf("\n***********************STORE***********************" +"\n");
			for(Media e: itemsInStore) {
				System.out.printf("" +e.getId() + "DVD" + " - " +e.getTitle() + " - " 
						+ e.getCategory() + " - " 
						+ e.getCost() + "\n");
				priceAll = priceAll + e.getCost();
			}
			this.priceAll = priceAll;
			System.out.printf("Total Cost: " + priceAll +"\n");
		System.out.printf("***************************************************");
		
	}
	
	public ArrayList<Media> getItemsInStore() {
		ArrayList<Media> tmp = new ArrayList<Media>();
		tmp.addAll(itemsInStore);
		return tmp;
	}
	
	public boolean addMedia(Media m) {
		for(Media e: itemsInStore) {
			if(e.getTitle().equals(m.getTitle()) &&  e.getCategory().equals(m.getCategory())) {
				return true;
			}
		}
		itemsInStore.add(m);
		return true;
	}
}
