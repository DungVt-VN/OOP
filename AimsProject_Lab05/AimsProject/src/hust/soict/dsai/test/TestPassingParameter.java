package hust.soict.dsai.test;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

// week3

public class TestPassingParameter {
	// Swap dvd 
	public static void swapDvD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String title = dvd1.getTitle();
		String category = dvd1.getCategory();
		String director = dvd1.getDirector();
		float cost = dvd1.getCost();
		
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(title);
		dvd1.setCategory(dvd2.getCategory());
		dvd2.setCategory(category);
		dvd1.setDirector(dvd2.getDirector());
		dvd2.setDirector(director);
		dvd1.setCost(dvd2.getCost());
		dvd2.setCost(cost);
	}

	
	
public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD,cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		swapDvD(jungleDVD,cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object o1,Object o2) {
		Object tmp = o1 ;
		o1 = o2 ;
		o2 = tmp ;
		
	}
	public static void changeTitle(DigitalVideoDisc dvd , String title) {
		String oldTitle = dvd.getTitle() ;
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
}
