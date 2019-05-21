package controllers;

import java.text.SimpleDateFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.IndividualStockInformation;

public class UpdateController {
	@FXML
	private Label dateLbl;
	@FXML
	private TextField openField;
	@FXML
	private TextField closeField;
	@FXML
	private TextField highField;
	@FXML
	private TextField lowField;
	@FXML
	private TextField volumeField;
	
	private Stage dialog;
	private IndividualStockInformation current;
	
	@FXML
	private void initialize() {}
	
	public void setDialog(Stage dialog) {
		this.dialog = dialog;
	}
	
	public void setStock(IndividualStockInformation stock) {
		current = stock;
		
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
		String dateStr = formatter.format(current.getDateOfStock());
		dateLbl.setText(dateStr);
		
		openField.setText(String.valueOf(current.getOpen()));
		closeField.setText(String.valueOf(current.getClose()));
		highField.setText(String.valueOf(current.getHigh()));
		lowField.setText(String.valueOf(current.getLow()));
		volumeField.setText(String.valueOf(current.getVolume()));
	}
	
	@FXML
	private void handleUpdate() {
		String test = null;
		test = openField.getText();
		if(testDouble(test)) {
			current.setOpen(Double.parseDouble(test));
		}
		test = closeField.getText();
		if(testDouble(test)) {
			current.setClose(Double.parseDouble(test));
		}
		test = highField.getText();
		if(testDouble(test)) {
			current.setHigh(Double.parseDouble(test));
		}
		test = lowField.getText();
		if(testDouble(test)) {
			current.setLow(Double.parseDouble(test));
		}
		test = volumeField.getText();
		if(testInt(test)) {
			current.setVolume(Long.parseLong(test));
		}
		dialog.close();
	}

	private boolean testInt(String test) {
		if(test == null || test.length() == 0) {
			return false;
		}
		for(int i = 0; i < test.length(); i++) {
			if(!Character.isDigit(test.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean testDouble(String test) {
		int decimalCount = 0;
		if(test == null || test.length() == 0) {
			return false;
		}
		for(int i = 0; i < test.length(); i++) {
			if(!Character.isDigit(test.charAt(i))) {
				return false;
			} else if(test.charAt(i) == '.') {
				decimalCount++;
			}
			if(decimalCount > 1) {
				return false;
			}
		}
		return true;
	}
}
