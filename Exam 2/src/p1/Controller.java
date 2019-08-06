package p1;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {
	private Demo demo;
//	private HashMap<String, UserAccount> allAccounts;
	
	@FXML
	private GridPane view;
	
	@FXML
	private TextField userField;
	
	@FXML
	private PasswordField passField;
	
	@FXML
	private Button createBtn;
	
	@FXML
	private Button loginBtn;

	public Controller() {
	}
	
	public void initialize() {
		
		createBtn.setOnAction(e -> {
			if (checkFields()) {
				if (Demo.getAllAccounts().containsKey(userField.getText())) {
					triggerExisting();
					userField.requestFocus();
					userField.selectAll();
					passField.clear();
				} else {
					UserAccount fresh = new UserAccount(userField.getText(), passField.getText());
					Demo.getAllAccounts().put(userField.getText(), fresh);
					triggerCreated();
					userField.clear();
					passField.clear();
				}
			} else {
				triggerEmpty();
			}
		});

		loginBtn.setOnAction(e -> {
			if (checkFields()) {
				if (!Demo.getAllAccounts().containsKey(userField.getText())) {
					triggerNoExist();
					userField.requestFocus();
					userField.selectAll();
					passField.clear();
				} else {
					UserAccount testPass = Demo.getAllAccounts().get(userField.getText());
					if (testPass.getPassword().equals(passField.getText())) {
						triggerSuccess();
					} else if (!testPass.getPassword().equals(passField.getText())) {
						triggerWrong();
						passField.clear();
						passField.requestFocus();
					}
				}
			} else {
				triggerEmpty();
			}
		});	
	}

	private void triggerEmpty() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Fields Missing");
		alert.setHeaderText("Empty field");
		alert.setContentText("Please make sure all fields are filled.");
		alert.showAndWait();
		if(userField.getText().equals("")) {
			userField.requestFocus();
		} else {
			passField.requestFocus();
		}
	}

	private boolean checkFields() {
		boolean notEmpty = false;
		if(!userField.getText().equals("") && !passField.getText().equals("")) {
			notEmpty = true;
		}
		return notEmpty;
	}
	
	private void triggerCreated() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("Account successfully created.");
		alert.showAndWait();
	}

	private void triggerWrong() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Unsuccessful");
		alert.setHeaderText("Wrong password");
		alert.setContentText("Remeber that passwords are case sensitive.");
		alert.showAndWait();
	}

	private void triggerSuccess() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("Successfully logged in.");
		alert.showAndWait();
	}

	private void triggerNoExist() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Account Missing");
		alert.setHeaderText("No Account with that username exist");
		alert.setContentText("Please check username spelling.");
		alert.showAndWait();
	}

	private void triggerExisting() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Account Taken");
		alert.setHeaderText("An Account with that username already exist");
		alert.setContentText("Please think of a new username.");
		alert.showAndWait();
	}
	
	public void setMain(Demo demo) {
		this.demo = demo;
	}

}
