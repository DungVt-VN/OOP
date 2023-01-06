package hust.soict.dsai.aims.screen;

import javax.swing.JOptionPane;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class AddBookController {
	public Cart cart;
	public Store store;

    @FXML
    private TextField addAuthor;

    @FXML
    private BorderPane addBook;

    @FXML
    private Button addButton;

    @FXML
    private TextField addCategory;

    @FXML
    private TextField addLength;

    @FXML
    private TextField addTitle;
    
    @FXML
    private TextField addCost;
    
    public AddBookController(Store store, Cart cart) {
    	super();
    	this.cart = cart;
    	this.store = store;
    }
    	
    
    
    String title;
	String category;
	String author;
	int length;
	float cost;
	
	@FXML
	private void initialize() {
    	addButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					title  = addTitle.getText();
					category  = addCategory.getText();
					author = addAuthor.getText();
					length = Integer.parseInt(addLength.getText());
					cost = Float.parseFloat(addCost.getText());
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Nhap khong dung dia chi");
					return;
				}
				
				Book book = new Book(title, category, author, length, cost);
		    	try {
		    		if(store.addMedia(book)  == true){
		    			JOptionPane.showMessageDialog(null, "Done!!!!!");
		    			
		    		}else {
			    		JOptionPane.showMessageDialog(null, "Error!");
		    		}
		    		
		    		
		    	} catch (Exception e) {
		    		JOptionPane.showMessageDialog(null, "Error!");
		    	}
		    	
		    	new StoreScreen(store, cart);
		    	
			}
		}); 
    	
    }

}

