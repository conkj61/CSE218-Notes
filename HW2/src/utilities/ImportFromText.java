package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ImportFromText {
	private String[] nameArray;
	private int nElems;
	
	public ImportFromText(String fileLocation) throws FileNotFoundException {
		//this method method throws, because it is handled within findSize
		nameArray = new String[findSize(fileLocation)];
		nElems = 0;
		populateArray(fileLocation);
	}

	private void populateArray(String fileLocation) throws FileNotFoundException {
		//this method will throw, because exception was handled before code could arrive at this method
		File testFile = new File(fileLocation);
		Scanner testFinder = null;
		testFinder = new Scanner(new BufferedReader(new FileReader(testFile)));
		
		while(testFinder.hasNext()) {
			String testName = testFinder.next();
			if(Character.isLetter(testName.charAt(0))) {
				nameArray[nElems++] = testName;
			}
		}
		
		testFinder.close();
	}

	private int findSize(String fileLocation) {
		int count = 0;
		File testFile = new File(fileLocation);
		Scanner testFinder = null;
		try {
			testFinder = new Scanner(new BufferedReader(new FileReader(testFile)));
		} catch (FileNotFoundException e) {
			System.out.println("Input file does not exist.");
		}
		
		while(testFinder.hasNext()) {
			String testCount = testFinder.next();
			if(Character.isLetter(testCount.charAt(0))) {
				count++;
			}
		}
		return count;
	}
	
	public void displayTargetIndex(int targetNumber) {
		System.out.println(nameArray[targetNumber]);
	}
	
	public String getName(int targetIndex) {
		return nameArray[targetIndex];
	}

	public String[] getNameArray() {
		return nameArray;
	}

	public int getnElems() {
		return nElems;
	}
	
}