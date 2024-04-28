package application;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
public class AddBookControlor implements Initializable{

	    @FXML
	    private TableColumn<Person, String> lastNameCol;

	    @FXML
	    private TextField prenomId;

	    @FXML
	    private TextField nomId;

	    @FXML
	    private TextField mailId;

	    @FXML
	    private Button Addbtn;

	    @FXML
	    private TableView<Person> tableViewId;

	    @FXML
	    private TableColumn<Person, String> firstNameCol;
	    


	    @FXML
	    private TableColumn<Person, String> emailCol;

	    @FXML
	    private Button removeBtn;

	    @FXML
	    private Button importBtn;

	    @FXML
	    private Button exportBtn;

	    @FXML
	    private Button quitBtn;
	    private DataClass data;
	    
	    public static boolean isEmailAdress(String email){
	    	Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$" );
	    	Matcher m = p.matcher(email.toUpperCase());
	    	return m.matches();
	    	}

	    @FXML
	    public void Add() {
	    	String nom = nomId.getText();
	    	String prenom = prenomId.getText();
	    	String mail = mailId.getText();
	    	tableViewId.getItems().add(new Person(prenom,nom , mail));	
	    
	    }
	    @FXML
	    public void remove() {
	    	Person selectedItem = tableViewId.getSelectionModel().getSelectedItem();
	    	tableViewId.getItems().remove(selectedItem);
	    	
	    }
	   
	    @FXML
	    void importer(ActionEvent event) {
	    	for(Person p :data.getImportList())
	    	{
	    		tableViewId.getItems().add(p);

	    	}
				
	    	
	    	
	    }
	    @FXML
	    void exporter(ActionEvent event) {
	    	List<Person> p =tableViewId.getItems();
	    	data.setExportList(p);
	    	System.out.println(data.getExportList());
	    	
	    	}

	    @FXML
	    void quiter(ActionEvent event) {
	    	Platform.exit();
	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			firstNameCol.setCellFactory(new PropertyValueFactory("Name"));
			lastNameCol.setCellValueFactory(new PropertyValueFactory("lastname"));
			emailCol.setCellValueFactory(new PropertyValueFactory("email"));
			firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
			lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
			emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
			data = new DataClass();

			
		}

	

	

}
