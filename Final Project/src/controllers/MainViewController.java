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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
	
	private MainApp mainApp;
	
	@FXML
	public void initialize() {
		
		loadedBox.setOnAction(e -> {
			selectedCompany = mainApp.getHoldAllCompanies().get(loadedBox.getSelectionModel().getSelectedItem());
		});
		
		loadedDatePicker.setOnAction(e -> {
			selectedDate = loadedDatePicker.getValue();
		});
		loadButton.setOnAction(e -> { //set button function for existing data
			Date date = null;
			try {
				date = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			} catch (Exception e1) {
				alerts.Alerts.dateInputError();
			}
			if(date != null) {
				selectedCompany.showTestDate(date);
			}
//			System.out.println("you are a noob");
		});
		
		searchButton.setOnAction(e -> { //button function to add new data
			setSearchString(searchNewStock.getText());
			LocalDate selectedDate2 = searchDatePicker.getValue();
			Date date = Date.from(selectedDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			try {
				mainApp.getHoldAllCompanies().put(searchToTest, utilities.JsonParse.createDailyCompanyData(searchToTest));
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
			populateComboBox();
//			System.out.println("you are a donkey");
		});
	}
	
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