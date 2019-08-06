package p1;

import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Demo extends Application {
	private Stage primaryStage;
	private AnchorPane root;
	private static HashMap<String, UserAccount> allAccounts;
	
	public static void main(String[] args) {
		//Big O complexity of this program should be 1. Using a hashmap, when the program searches for account
		//it doesn't actually traverse the whole map. It just tries to ping the key, and if it fails to do so
		//it just "throws away" the result and signals an alert. The only thing that can raise the complexity
		//value is when enough user accounts are created to do a re-hash. But after that re-hash big O should
		//return back to 1 for creation/login.
		allAccounts = new HashMap<>();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Accounts");
		
		initializeView();
	}

	private void initializeView() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/p1/View.fxml"));
            root = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
			
			Controller controller = loader.getController();
			controller.setMain(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public AnchorPane getRoot() {
		return root;
	}

	public void setRoot(AnchorPane root) {
		this.root = root;
	}

	public static HashMap<String, UserAccount> getAllAccounts() {
		return allAccounts;
	}

}
