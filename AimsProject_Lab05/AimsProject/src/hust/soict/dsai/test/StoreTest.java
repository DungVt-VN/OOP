package hust.soict.dsai.test;
import hust.soict.dsai.aims.Exception.PlayerException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.*;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) throws PlayerException {
		//Create new Store
		Store Store = new Store();
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		Store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Warts", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		Store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		Store.addDVD(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Alkjjldl", 
				"Animati", 18.99f);
		Store.addDVD(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Badin", 
				"dfdation", 18.99f);
		Store.addDVD(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Helooos", 
				"Dolas", 18.99f);
		Store.addDVD(dvd6);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Hoodin", 
				"Octean", 18.99f);
		Store.addDVD(dvd7);
		
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Pack", 
				"Vantage", 18.99f);
		Store.addDVD(dvd8);
		
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Pddack", 
				"Vantaddge", 18.99f);
		Store.addDVD(dvd9);
			
		
		StoreScreen ss = new StoreScreen(Store,cart);
		
	}

	
}
