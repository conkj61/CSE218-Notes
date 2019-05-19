package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONException;

import application.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.CompanyData;

public class MainViewController {
	@FXML
	private GridPane loadedPane;
	@FXML
	private ComboBox<String> loadedBox;
	private ObservableList<String> boxChoices = FXCollections.observableArrayList();
	@FXML
	private DatePicker loadedDatePicker;
	@FXML
	private Button loadButton;

	@FXML
	private GridPane searchPane;
	@FXML
	private TextField searchNewStock;
	private String searchToTest;
	@FXML
	private DatePicker searchDatePicker;
	@FXML
	private Button searchButton;
	
	private CompanyData selectedCompany;
	private LocalDate selectedDate;
	private LocalDate selectedDate2;
	
	private MainApp mainApp;
	
	@FXML
	public void initialize() {
//		
//		loadedBox.setOnAction(e -> {
//			selectedCompany = mainApp.getHoldAllCompanies().get(loadedBox.getSelectionModel().getSelectedItem());
//		});
//		
//		loadedDatePicker.setOnAction(e -> {
//			selectedDate = loadedDatePicker.getValue();
//		});
//		loadButton.setOnAction(e -> { //set button function for existing data
//			Date date = null;
//			try {
//				date = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//			} catch (Exception e1) {
//				alerts.Alerts.dateInputError();
//			}
//			if(date != null) {
//				selectedCompany.showTestDate(date);
//			} else {
//				//handle no available date
//			}
////			System.out.println("you are a noob");
//		});
//		
//		searchButton.setOnAction(e -> { //button function to add new data
//			setSearchString(searchNewStock.getText());
//			LocalDate selectedDate2 = searchDatePicker.getValue();
//			Date date = Date.from(selectedDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
//			
//			//current problems include a failed search being added to combo box and printing an error from trying to show company data from failed search
//			try {
//				mainApp.getHoldAllCompanies().put(searchToTest, utilities.JsonParse.createDailyCompanyData(searchToTest));
//				populateComboBox();
//				mainApp.getHoldAllCompanies().get(searchToTest).showTestDate(date);
//			} catch (JSONException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
////			System.out.println("you are a donkey");
//		});
	}
	
	public void handleLoadBtn(ActionEvent event) throws IOException {
		selectedCompany = mainApp.getHoldAllCompanies().get(loadedBox.getSelectionModel().getSelectedItem());
		selectedDate = loadedDatePicker.getValue();
		Date date = null;
		try {
			date = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (Exception e1) {
			alerts.Alerts.dateInputError();
		}
		if (date != null) {
//			selectedCompany.showTestDate(date);
			changeView(event);
		} else {
			// handle no available date
//	}
//		Stage parent = (Stage) ((Node)event.getSource()).getScene().getWindow();
//			System.out.println("test");
		}
	}
	
	private void changeView(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/StockView.fxml"));
        AnchorPane stockView = (AnchorPane) loader.load();
        mainApp.getRoot().setCenter(stockView);
        
        StockViewController controller = loader.getController();
        controller.setMainApp(this.mainApp);
        controller.loadData(selectedCompany, Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), "Daily");
//        controller.populateComboBox();
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("/view/StockView.fxml"));
//		loader.load();
//		Parent main = loader.load();
//		Scene scene = new Scene (main);
//		Stage primary = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		Scene scene = loadButton.getScene();
//		Window window = scene.getWindow();
//		Stage stage = (Stage) loadButton.getScene().getWindow();
//		Scene scene = new Scene(loader.getRoot());
//		stage.setScene(scene);
	}

	public void handleSearchBtn(ActionEvent event) {
		setSearchString(searchNewStock.getText());
		selectedDate2 = searchDatePicker.getValue();
		Date date = Date.from(selectedDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		//current problems include a failed search being added to combo box and printing an error from trying to show company data from failed search
		try {
			mainApp.getHoldAllCompanies().put(searchToTest, utilities.JsonParse.createDailyCompanyData(searchToTest));
			populateComboBox();
			mainApp.getHoldAllCompanies().get(searchToTest).showTestDate(date);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		Stage parent = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		System.out.println("test2");
	}
	
//	public void changeView(ActionEvent event) throws IOException {
//		FXMLLoader loader = new FXMLLoader();
//	}
	
	public void populateComboBox() {
		loadedBox.getItems().clear();
		boxChoices.clear();
		for(String key : mainApp.getHoldAllCompanies().keySet()) {
			boxChoices.add(key);
		}
		loadedBox.setItems(boxChoices);
	}

	public MainViewController() {//HashMap<String, CompanyData> allCompanies) {
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	private void setSearchString(String test) {
		searchToTest = test;
	}
	
}