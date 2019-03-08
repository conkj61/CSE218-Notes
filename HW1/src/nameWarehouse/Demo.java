package nameWarehouse;

import java.io.FileNotFoundException;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		NameWarehouse test = new NameWarehouse();
		for(int i = 0; i < test.getNumberOfPeople(); i++) {
			System.out.println(test.displayPerson(i));
		}
	}

}