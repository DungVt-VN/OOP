package hust.soict.dsai.aims.screen;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;


public class StoreScreen extends JFrame{
	private Store store = new Store();
	private Cart cart = new Cart();
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);	
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar () {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Upade Store");
		
		JMenuItem addBook = new JMenuItem("Add Book");
		smUpdateStore.add(addBook);
		addBook.addActionListener(new addBook(this));
		
		JMenuItem addCd = new JMenuItem("Add Cd");
		smUpdateStore.add(addCd);
		addCd.addActionListener(new addCD(this));
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVD);
		addDVD.addActionListener(new addDVD(this));
		
		menu.add(smUpdateStore);
		
		JMenuItem viewStore = new JMenuItem("View Store");
		menu.add(viewStore);
		viewStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new StoreScreen(store,cart);
			}
		});
		
		
		
		JMenuItem viewCart = new JMenuItem("View Cart");
		menu.add(viewCart);
		viewCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CartScreen(cart);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton buttonCart = new JButton("View cart");
		buttonCart.setPreferredSize(new Dimension(100, 50));
		buttonCart.setMaximumSize(new Dimension(100, 50));
		buttonCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CartScreen(cart);
			}
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(buttonCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < store.getQtyOrdered(); i++) {
			try {
				MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
				center.add(cell);
			} catch(Exception e) {
				return center;
			}
		}
		
		return center;
	}
	
	
	
	private class addBook implements ActionListener {
		private StoreScreen storeScreen;
		public addBook(StoreScreen storeScreen) {
			this.storeScreen = storeScreen;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new AddBook(store, cart);
			this.storeScreen.dispose();
		}
	}
	
	private class addCD implements ActionListener {
		private StoreScreen storeScreen;
		public addCD(StoreScreen storeScreen) {
			this.storeScreen = storeScreen;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new addCd(store, cart);
			this.storeScreen.dispose();
		}
	}
	
	private class addDVD implements ActionListener {
		private StoreScreen storeScreen;
		public addDVD(StoreScreen storeScreen) {
			this.storeScreen = storeScreen;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new AddDVD(store, cart);
			this.storeScreen.dispose();
		}
	}

}
