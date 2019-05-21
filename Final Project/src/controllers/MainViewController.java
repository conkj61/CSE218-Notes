package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;

import application.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.CompanyData;

public class MainViewController {
	@FXML
	private GridPane loadedPane;
	@FXML
	private ComboBox<String> loadedBox;
	private ObservableList<String> boxChoices = FXCollections.observableArrayList();
	@FXML
	private DatePicker loadedDatePickerFrom;
	@FXML
	private DatePicker loadedDatePickerTo;
	@FXML
	private Button loadButton;

	@FXML
	private GridPane searchPane;
	@FXML
	private TextField searchNewStock;
	private String searchToTest;
	@FXML
	private DatePicker searchDatePickerFrom;
	@FXML
	private DatePicker searchDatePickerTo;
	@FXML
	private Button searchButton;
	
	private CompanyData selectedCompany;
	private LocalDate selectedDate;
	private LocalDate selectedDate2;
	private Date date;
	private Date date2;
	
	private MainApp mainApp;

	public MainViewController() {//HashMap<String, CompanyData> allCompanies) {
	}
	
	@FXML
	public void initialize() {
	}
	
	@FXML
	public void handleLoadBtn(ActionEvent event) throws IOException {
		selectedCompany = mainApp.getHoldAllCompanies().get(loadedBox.getSelectionModel().getSelectedItem());
		if (selectedCompany == null) {
			alerts.Alerts.noSelection();
		} else if (checkDates("load")) {
			changePrep();
		}
		
	}

	@FXML
	public void handleSearchBtn(ActionEvent event) throws JSONException, IOException {
		searchToTest = searchNewStock.getText().toUpperCase();
		if (checkDates("search")) {

			if (mainApp.getHoldAllCompanies().containsKey(searchToTest)) {
				selectedCompany = mainApp.getHoldAllCompanies().get(searchToTest);
				try {
					changePrep();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (utilities.CompanyStockLookup.exists(searchToTest)) {
				alerts.Alerts.successfulSearch();
				try {
					mainApp.getHoldAllCompanies().put(searchToTest,
							utilities.JsonParse.createDailyCompanyData(searchToTest));
					selectedCompany = mainApp.getHoldAllCompanies().get(searchToTest);
					try {
						changePrep();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
			} else {
				alerts.Alerts.failedSearch();
			}
		}
	}

	private void changePrep() throws IOException {
		//in order to get here at least one of the appropriate date fields has data
		if(date != null && date2 != null) {
			if (date.after(date2)) { //if from is after to then swap them
				Date temp = date;
				date = date2;
				date2 = temp;
			}
			changeViewRange();
		} else if (date == null) {
			date = date2;
			changeViewUnique();
		} else {
			changeViewUnique();
		}
	}

	private void changeViewUnique() throws IOException {
		if (date.before(utilities.CompareMapKeys.findEarliestStockDate(selectedCompany))) {
			Date test = utilities.CompareMapKeys.findEarliestStockDate(selectedCompany);
			SimpleDateFormat formatter = new SimpleDateFormat("E, MMMM dd yyyy");
			String strDate = formatter.format(test);
			alerts.Alerts.companyFoundPrePublicRequest(strDate);
			changeDateForData(1, 1);
		}
		if (!selectedCompany.getStockData().containsKey(date)) {
			alerts.Alerts.dateNotFound();
			changeDateForData(1, -1);
		}
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/StockView.fxml"));
		AnchorPane stockView = (AnchorPane) loader.load();
		mainApp.getRoot().setCenter(stockView);

		StockViewController controller = loader.getController();
		controller.setMainApp(this.mainApp);
		controller.loadData(selectedCompany, date, "Daily");
	}

	private void changeViewRange() throws IOException {
		if (date.before(utilities.CompareMapKeys.findEarliestStockDate(selectedCompany))) {
			Date test = utilities.CompareMapKeys.findEarliestStockDate(selectedCompany);
			SimpleDateFormat formatter = new SimpleDateFormat("E, MMMM dd yyyy");
			String strDate = formatter.format(test);
			alerts.Alerts.companyFoundPrePublicRequest(strDate);
			changeDateForData(1, 1);
			if (!date.before(date2)) { // if date caught date2 then also increment date2
				while (!date.before(date2)) {
					changeDateForData(2, 1);
				}
			}
		}

		if (!selectedCompany.getStockData().containsKey(date)) {
			alerts.Alerts.dateNotFound();
			changeDateForData(1, -1);
		}
		if (!selectedCompany.getStockData().containsKey(date2)) {
			alerts.Alerts.dateNotFound();
			changeDateForData(2, -1);
			if (!date2.after(date)) { // if date2 has fallen back into date1 then push date1 back one
				while (!date2.after(date)) {
					changeDateForData(1, -1);
				}
			}
		}
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/StockView.fxml"));
		AnchorPane stockView = (AnchorPane) loader.load();
		mainApp.getRoot().setCenter(stockView);

		StockViewController controller = loader.getController();
		controller.setMainApp(this.mainApp);
		controller.loadData(selectedCompany, date, date2, "Daily");
	}

	private boolean checkDates(String source) {
		boolean proceed = false;
		if(source.equals("load")) {
			selectedDate = loadedDatePickerFrom.getValue();
			selectedDate2 = loadedDatePickerTo.getValue();
		} else if (source.equals("search")) {
			selectedDate = searchDatePickerFrom.getValue();
			selectedDate2 = searchDatePickerTo.getValue();
		}
		date = null;
		date2 = null;
		if (selectedDate != null && selectedDate2 != null) {
			date = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			date2 = Date.from(selectedDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			proceed = true;
		} else {
			try {
				if (selectedDate == null) {
					date2 = Date.from(selectedDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
					proceed = true;
				} else if (selectedDate2 == null) {
					date = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
					proceed = true;
				}
			} catch (Exception e) {
				alerts.Alerts.dateInputError();
			}
		}
		return proceed;
	}
	
	public void populateComboBox() {
		loadedBox.getItems().clear();
		boxChoices.clear();
		for(String key : mainApp.getHoldAllCompanies().keySet()) {
			boxChoices.add(key);
		}
		loadedBox.setItems(boxChoices);
	}
	
	private void changeDateForData(int fromOrTo, int direction) {
		Calendar c = Calendar.getInstance();
		if(fromOrTo == 1) {
			c.setTime(date);
			while (!selectedCompany.getStockData().containsKey(date)) {
				c.add(Calendar.DATE, direction);
				date = c.getTime();
			}
		} else if(fromOrTo == 2) {
			c.setTime(date2);
			while (!selectedCompany.getStockData().containsKey(date2)) {
				c.add(Calendar.DATE, direction);
				date2 = c.getTime();
			}
		}
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
}