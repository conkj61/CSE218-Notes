package p2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo extends Application {
	private static BorderPane window;
	public static void main(String[] args) {
//		Bag<Double> dummy = new Bag<>(10);
//		dummy.addValue(4.1);
//		dummy.addValue((double) 2);
//		dummy.addValue(1.1);
//		dummy.addValue(1.8);
//		dummy.addValue(7.8);
//		dummy.addValue(1.3);
//		dummy.addValue(7.6);
//		System.out.println(dummy.display());
//		dummy.insertionSort();
//		System.out.println(dummy.display());
//		System.out.println(dummy.findMax());
//		System.out.println(dummy.findMin());
		launch(args);
	}

	@Override
	public void start(Stage primary) throws Exception {
		primary.setTitle("Generic bag testing");
		window = new BorderPane();
		window.setCenter(new View().getUserInterface());
		
//		View test = new View(window);
		
		Scene scene = new Scene(window, 600, 600);
		primary.setScene(scene);
		primary.show();
	}
	
}
