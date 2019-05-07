package p1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo extends Application {
	private static BorderPane window;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primary) throws Exception {
		primary.setTitle("Stack and Queues");
		window = new BorderPane();
		
		View test = new View(window);
		
		Scene scene = new Scene(window, 450, 200);
		primary.setScene(scene);
		primary.show();
	}

}
