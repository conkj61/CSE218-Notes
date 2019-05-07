package p2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class View {
	private GridPane userInterface;
	private Text selectionHeader;
	private HBox headerBox;
	
	private RadioButton intChoice;
	private RadioButton doubleChoice;
	private RadioButton stringChoice;
	private ToggleGroup radioGroup;
	private HBox radioBox;
	
	private Text currentSelectionInfo;
	
	private TextField userField01;
	private TextField userField02;
	private TextField userField03;
	private TextField userField04;
	private TextField userField05;
	private TextField userField06;
	private TextField userField07;
	private TextField userField08;
	private TextField userField09;
	private TextField userField10;
	
	private Button add;
	private Button display;
	private Button findMax;
	private Button findMin;
	private Button deleteMax;
	private Button deleteMin;
	private Button sort;
	private HBox buttonHolder;
	
	private HBox fieldHolder1;
	private HBox fieldHolder2;
	private VBox fieldHolder3;
	
	private Text statusMessage;
	
	public View() {
		userInterface = new GridPane();
		userInterface.setPadding(new Insets(20));
		selectionHeader = new Text("Select which data you would like to work with:");
		selectionHeader.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
		headerBox = new HBox();
		headerBox.getChildren().add(selectionHeader);
		headerBox.setAlignment(Pos.CENTER);
		userInterface.add(headerBox, 0, 0, 5, 1);
		createRadioGroup();
		createFields();
		createButtons();
		statusMessage = new Text("Testing");
		userInterface.add(statusMessage, 0, 4, 5, 2);
		
		Controller userInteractions = new Controller(this);
//		primaryStage.setCenter(userInterface);
//		hideFields();
	}

	private void createRadioGroup() {
		intChoice = new RadioButton("Integer");
		intChoice.setToggleGroup(radioGroup);
		doubleChoice = new RadioButton("Double");
		doubleChoice.setToggleGroup(radioGroup);
		stringChoice = new RadioButton("String");
		stringChoice.setToggleGroup(radioGroup);
		radioBox = new HBox(50);
		radioBox.getChildren().addAll(intChoice, doubleChoice, stringChoice);
		radioBox.setAlignment(Pos.CENTER);
		userInterface.add(radioBox, 0, 1, 5, 1);
	}

	private void createFields() {
		initializeTextFields();
		fieldHolder1 = new HBox(10);
		fieldHolder1.getChildren().addAll(userField01, userField02, userField03, userField04, userField05);
		fieldHolder1.setAlignment(Pos.CENTER);
		fieldHolder2 = new HBox(10);
		fieldHolder2.getChildren().addAll(userField06, userField07, userField08, userField09, userField10);
		fieldHolder3 = new VBox(15);
		fieldHolder3.getChildren().addAll(fieldHolder1, fieldHolder2);
		userInterface.add(fieldHolder3, 0, 2, 5, 2);
	}
	
	private void createButtons() {
		add = new Button("Store");
		display = new Button("Show stored");
		findMax = new Button("Show Max");
		findMin = new Button("Show Min");
		deleteMax = new Button("Delete Max");
		deleteMin = new Button("Delete Min");
		sort = new Button("Sort");
		buttonHolder = new HBox(10);
		buttonHolder.getChildren().addAll(add, display, findMax, findMin, deleteMax, deleteMin, sort);
	}

	private void initializeTextFields() {
		userField01 = new TextField();
		userField02 = new TextField();
		userField03 = new TextField();
		userField04 = new TextField();
		userField05 = new TextField();
		userField06 = new TextField();
		userField07 = new TextField();
		userField08 = new TextField();
		userField09 = new TextField();
		userField10 = new TextField();
	}

	public void hideFields() {
		userField01.setVisible(false);
		userField02.setVisible(false);
		userField03.setVisible(false);
		userField04.setVisible(false);
		userField05.setVisible(false);
		userField06.setVisible(false);
		userField07.setVisible(false);
		userField08.setVisible(false);
		userField09.setVisible(false);
		userField10.setVisible(false);
	}
	
	public void showFields() {
		userField01.setVisible(true);
		userField02.setVisible(true);
		userField03.setVisible(true);
		userField04.setVisible(true);
		userField05.setVisible(true);
		userField06.setVisible(true);
		userField07.setVisible(true);
		userField08.setVisible(true);
		userField09.setVisible(true);
		userField10.setVisible(true);
	}
	
	public void clearFields() {
		userField01.clear();
		userField02.clear();
		userField03.clear();
		userField04.clear();
		userField05.clear();
		userField06.clear();
		userField07.clear();
		userField08.clear();
		userField09.clear();
		userField10.clear();
		statusMessage.setText("");
	}

	public GridPane getUserInterface() {
		return userInterface;
	}

	public Text getSelectionHeader() {
		return selectionHeader;
	}

	public void setSelectionHeader(Text selectionHeader) {
		this.selectionHeader = selectionHeader;
	}

	public Text getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(Text statusMessage) {
		this.statusMessage = statusMessage;
	}

	public TextField getUserField01() {
		return userField01;
	}

	public TextField getUserField02() {
		return userField02;
	}

	public TextField getUserField03() {
		return userField03;
	}

	public TextField getUserField04() {
		return userField04;
	}

	public TextField getUserField05() {
		return userField05;
	}

	public TextField getUserField06() {
		return userField06;
	}

	public TextField getUserField07() {
		return userField07;
	}

	public TextField getUserField08() {
		return userField08;
	}

	public TextField getUserField09() {
		return userField09;
	}

	public TextField getUserField10() {
		return userField10;
	}

	public Button getAdd() {
		return add;
	}

	public Button getDisplay() {
		return display;
	}

	public Button getFindMax() {
		return findMax;
	}

	public Button getFindMin() {
		return findMin;
	}

	public Button getDeleteMax() {
		return deleteMax;
	}

	public Button getDeleteMin() {
		return deleteMin;
	}

	public Button getSort() {
		return sort;
	}
	
}