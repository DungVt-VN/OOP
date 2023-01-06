package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	public Cart cart;
	public CartScreenController(Cart cart){
		super();
		this.cart = cart;
	}
	
	void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    		
    	}else {
    		btnPlay.setVisible(false);
    	}
	}
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private RadioButton radiaBtnFilterTitle;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private TextField tfFilter;
    
    @FXML
    private TableColumn<Media, Integer> colMediaID;
    
    @FXML
    private Label totalCost;
    
    @FXML
    private MenuItem viewStore;
    
    @FXML
    private Button placeOrder;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private void initialize() {
    	totalCost.setText(String.valueOf(cart.totalCost()));
    	colMediaID.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	
    	
    	
    	
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>(){
    				

					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if(newValue != null) {
							updateButtonBar(newValue);
						}
						
					}
    			});
    	
    	
    	
    	FilteredList<Media>  filteredList = new FilteredList<>(this.cart.getItemsOrdered(), i -> true);
    	
    	tfFilter.textProperty().addListener((ObservableList, oldValue, newValue) -> {
    		filteredList.setPredicate(productSearchModel -> {
    			if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
    				return true;
    			}
				String searchKeyword = newValue.toLowerCase();
				if(radiaBtnFilterTitle.isSelected()) {
					if(productSearchModel.getTitle().toLowerCase().contains(searchKeyword)) {
						return true;
					} else 
						return false;
				}else {
					try {
						if(productSearchModel.getId()== Integer.parseInt(searchKeyword)) {
							return true;
						}else
							return false;
					} catch (NumberFormatException ex){
			            return false;
			        }
				}
				
    		});
    	});
    	
    	SortedList<Media> sorteData = new SortedList<>(filteredList);
    	
    	sorteData.comparatorProperty().bind(tblMedia.comparatorProperty());
    	tblMedia.setItems(sorteData);
    	
    	
    }
    
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	totalCost.setText(String.valueOf(cart.totalCost()));
    }
    
    
    @FXML
    void btnPlaceOrder(ActionEvent event) {
		String total = "Order cost is: " + cart.totalCost() + " $";
		Alert alert = new Alert(AlertType.NONE, total, ButtonType.FINISH);
		alert.setTitle("Order");
		cart.removeAll();
		alert.show();
		totalCost.setText(Float.toString(cart.totalCost()) + "$");
    }
    
    
    
 
}