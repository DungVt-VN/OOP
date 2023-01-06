package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddBook extends JFrame{
	private Cart cart;
	private Store store;
	
	public AddBook(Store store,Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		
		this.setTitle("AddBook");
		setSize(600, 200);
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/fxml/addBook.fxml"));
					AddBookController controller =
							new AddBookController(store, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
		
				} catch (IOException e) {
				}
				
			}

		});
			}

}

