package application;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.json.JSONException;

import controllers.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CompanyData;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane root;
	private static HashMap<String, CompanyData> holdAllCompanies;
	
	public static void main(String[] args) throws JSONException, IOException, ParseException {
		holdAllCompanies = new HashMap<String, CompanyData>();
		utilities.JsonParse.createStartingCompanies(holdAllCompanies);
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Stock Analysis App");

        initRootLayout();

        showMainView();
	}
	
	private void showMainView() {
		try {
            // Load main view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/MainView.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();
            
            // Set main view into the center of root layout.
            root.setCenter(mainOverview);
            
            //hand to controller
            MainViewController controller = loader.getController();
            controller.setMainApp(this);
            controller.populateComboBox();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/RootLayout.fxml"));
            root = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimary() {
		return primaryStage;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public HashMap<String, CompanyData> getHoldAllCompanies() {
		return holdAllCompanies;
	}

}
