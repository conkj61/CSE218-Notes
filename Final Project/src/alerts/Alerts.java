package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
	public static void timeOutAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Timed Out");
		alert.setHeaderText(null);
		alert.setContentText("We have made too many requests in too short a time. Please wait a few seconds");
		alert.showAndWait();
	}
	
	public static void successfulSearch() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Search Success");
		alert.setHeaderText(null);
		alert.setContentText("Company stock data found successfully!");
		alert.showAndWait();
	}
	
	public static void companyFoundPrePublicRequest(String firstAvailableDate) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Company Found");
		alert.setHeaderText("Date requested is too early.");
		alert.setContentText("The requested company has been found, but the date asked is before public information. Their earliest available information "
				+ "on " + firstAvailableDate + " is being shown. If this was a new search the data has been added to available date.");
		alert.showAndWait();
	}
	
	public static void failedSearch() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Failed Search");
		alert.setHeaderText("Company stock acronym does not exist.");
		alert.setContentText("Please double check that you are using the correct stock name for the company you wish to add.");
		alert.showAndWait();
	}
	
	public static void dateInputError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Date Error");
		alert.setHeaderText("The date field has an error");
		alert.setContentText("Please make sure the date field is filled with YYYY-MM-DD format. Or Select the date using the calendar button.");
		alert.showAndWait();
	}
	public static void dateNotFound() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Market closed");
		alert.setHeaderText("The markets were closed on the requested date");
		alert.setContentText("Instead showing data for the first available day BEFORE the requested date.");
		alert.showAndWait();
	}
	
	public static void noSelection() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Missing Selection");
		alert.setHeaderText("Cannot load without selecting company.");
		alert.setContentText("Please make a selection if you wish to view an already loaded company.");
		alert.showAndWait();
	}
}
