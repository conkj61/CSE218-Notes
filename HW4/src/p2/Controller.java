package p2;

public class Controller {
	private View userInterface;

	public Controller(View userInterface) {
		this.userInterface = userInterface;
		buttonFunctionality();
	}

	private void buttonFunctionality() {
		userInterface.getAdd().setOnAction(e -> {
			
		});
	}
	
}
