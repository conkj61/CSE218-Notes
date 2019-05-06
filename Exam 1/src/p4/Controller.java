package p4;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class Controller {
	private View mainScreen;
	private LinkedList theList;
	
	public Controller(View mainScreen) {
		this.mainScreen = mainScreen;
		theList = new LinkedList();
		buttonFunctionality();
	}

	private void buttonFunctionality() {
		mainScreen.getStackPush().setOnAction(e -> {
			if(checkFieldAccuracy()) {
				Student s = (new Student(mainScreen.getNameField().getText(), Double.valueOf(mainScreen.getGpa().getText())));
				theList.insertLast(s);
			}
		});
		
		mainScreen.getStackPop().setOnAction(e -> {
//			Text temp = new Text(theList.deleteLast());
			mainScreen.setInfoDisplay(theList.deleteLast());
		});
		
		mainScreen.getQueueInsert().setOnAction(e -> {
			if(checkFieldAccuracy()) {
				Student s = new Student(mainScreen.getNameField().getText(), Double.valueOf(mainScreen.getGpa().getText()));
				theList.insertLast(s);
			}
		});
		
		mainScreen.getQueueRemove().setOnAction(e -> {
//			Text temp = new Text(theList.deleteFirst());
			mainScreen.setInfoDisplay(theList.deleteFirst());
		});
	}

	private boolean checkFieldAccuracy() {
		boolean allFieldsClear = false;
		boolean gpaFormatCheck = false;
		
		if(mainScreen.getNameField().getText().equals("") || mainScreen.getGpa().getText().equals("")) {
			showInputError();
		} else gpaFormatCheck = true;
		
		if(gpaFormatCheck) {
			String format = mainScreen.getGpa().getText();
			if(format.length() != 3) {
				showInputError();
			} else {
				if(!Character.isDigit(format.charAt(0)) || !Character.isDigit(format.charAt(2))) {
					showInputError();
				} else {
					char formatCheck2 = format.charAt(1);
					if(formatCheck2 != '.') {
						showInputError();
					} else allFieldsClear = true;
				}
			}
		}
		return allFieldsClear;
	}

	private void showInputError() {
		Alert missingField = new Alert(AlertType.ERROR);
		missingField.setHeaderText("Incorrect Entry");
		missingField.setContentText("All fields needs input and gpa must be in X.X format without letters.");
		missingField.showAndWait();
	}
}
