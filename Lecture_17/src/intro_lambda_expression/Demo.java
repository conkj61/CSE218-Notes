package intro_lambda_expression;
import java.util.Optional;

// 5/9/19
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Demo extends Application {
	private int x =3; //12:08
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("OK");
		button.setMaxSize(80, 30);
		
//		button.setOnAction(new MyEventHandler()); //commented out at 11:59 because we don't do this
		button.setOnAction(e -> { //12:01 this is now no longer object oriented, but rather functional
							//programming. We are taking the handle method, and giving it to another
							//method. This is the first time we take a function and use it as data.
			x = x + 3; //12:10 unsure why we added this
			System.out.println("Button clicked!" + x); //12:10 x added
		});
		
		TextInputDialog dialog = new TextInputDialog(); //12:12
		dialog.setTitle("ID");
		dialog.setContentText("Enter an ID");
		dialog.setHeaderText("ID, Please");
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(idnumber -> { //this is asking for consumer object
			System.out.println(idnumber); //12:13 this is another functional programming, by checking
								//to see if data is present, it does something specific. By using the
								//accept method within consumer interface
		});
		
		HBox root = new HBox(); //11:52
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(button);
		Scene scene = new Scene(root, 300, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if(e.getCode() == KeyCode.ESCAPE) {
				Platform.exit();
			}
		});
	}

}
