package nameFactory;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.print("First letter to search for? ");
		String charHolder = input.nextLine();
		char userInput = charHolder.toUpperCase().charAt(0);
		
		System.out.print("Male or Female? ");
		String genderHold = input.nextLine();
		
		NameFactory test = new NameFactory();
		
		test.searchByLetterAndGender(userInput, genderHold);
	}
	
}
