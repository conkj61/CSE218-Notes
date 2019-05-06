package p4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class View {
	private GridPane mainScreen;
	private Text infoHeader;
	
	private HBox headerBox;
	
	private Label nameLbl;
	private TextField nameField;
	private Label gpaLbl;
	private TextField gpa;
	
	private Button stackPush;
	private Button stackPop;
	private Button queueInsert;
	private Button queueRemove;
	
	private HBox btnBox;
	
	private Text infoDisplay;
	
	public View() {
		mainScreen = new GridPane();
		mainScreen.setPadding(new Insets(20));
		
		infoHeader = new Text("Stacks and Queues Demo");
		headerBox = new HBox();
		headerBox.getChildren().add(infoHeader);
		headerBox.setAlignment(Pos.CENTER);
		
		nameLbl = new Label("Student Name:");
		nameField = new TextField();
		nameField.setPromptText("First and Last");
		nameField.setMaxWidth(100);
		gpaLbl = new Label("Student GPA:");
		gpa = new TextField();
		gpa.setPromptText("X.X");
		gpa.setMaxWidth(100);
		
		stackPush = new Button("Stack Push");
		stackPop = new Button("Stack Pop");
		queueInsert = new Button("Queue Insert");
		queueRemove = new Button("Queue Remove");
		
		btnBox = new HBox(15);
		btnBox.getChildren().addAll(stackPush, stackPop, queueInsert, queueRemove);
		
		infoDisplay = new Text();
		
		setViewPlacement();
		Controller enable = new Controller(this);
//		window.setCenter(mainScreen);
	}

	private void setViewPlacement() {
		mainScreen.add(headerBox,  1, 0, 2, 1);
		mainScreen.add(nameLbl, 1, 1);
		mainScreen.add(nameField, 3, 1);
		mainScreen.add(gpaLbl, 1, 2);
		mainScreen.add(gpa, 3, 2);
		mainScreen.add(btnBox, 0, 3, 4, 1);
		mainScreen.add(infoDisplay, 0, 4, 1, 4);
//		mainScreen.add(stackPush, 0, 3);
//		mainScreen.add(stackPop, 1, 3);
//		mainScreen.add(queueInsert, 2, 3);
//		mainScreen.add(queueRemove, 3, 3);
	}
	
	

	public GridPane getMainScreen() {
		return mainScreen;
	}

	public Button getStackPush() {
		return stackPush;
	}

	public Button getStackPop() {
		return stackPop;
	}

	public Button getQueueInsert() {
		return queueInsert;
	}

	public Button getQueueRemove() {
		return queueRemove;
	}

	public TextField getNameField() {
		return nameField;
	}

	public TextField getGpa() {
		return gpa;
	}

	public Text getInfoDisplay() {
		return infoDisplay;
	}

	public void setInfoDisplay(String infoDisplay) {
		this.infoDisplay.setText(infoDisplay);
	}
	
	
	
}
