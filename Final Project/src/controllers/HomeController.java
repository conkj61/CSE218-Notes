package controllers;

import java.io.IOException;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController {
	private MainApp mainApp;
	@FXML
	private Button backBtn;
	
	public HomeController() {
	}
	
	public void handleNewBtn(ActionEvent event) {
        try {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("/view/MainView.fxml"));
			AnchorPane mainOverview = (AnchorPane) loader.load();
			
			mainApp.getRoot().setCenter(mainOverview);

            MainViewController controller = loader.getController();
            controller.setMainApp(this.mainApp);
            controller.populateComboBox();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMainApp(MainApp main) {
		this.mainApp = main;
	}
}
