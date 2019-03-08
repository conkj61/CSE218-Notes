package utilities;

import java.io.FileNotFoundException;
//import java.util.Random;

public class NameWarehouse {
	private ImportFromText malesFromText;
	private ImportFromText femalesFromText;
	private ImportFromText lastNamesFromText;
	private String[] maleNames;
	private String[] femaleNames;
	private String[] lastNames;
//	private Random lastNameSelector = new Random();
//	private int numberOfNames;
	
	public NameWarehouse() throws FileNotFoundException { //exception handled within importer
		createNameArrays();
	}
	
	private void createNameArrays() throws FileNotFoundException { //exception handled within importer
		malesFromText = new ImportFromText("raw data/boys_names.txt");
		maleNames = new String[malesFromText.getnElems()];
		for(int i = 0; i < maleNames.length; i++) {
			maleNames[i] = malesFromText.getName(i);
		}
		
		femalesFromText = new ImportFromText("raw data/girls_names.txt");
		femaleNames = new String[femalesFromText.getnElems()];
		for(int i = 0; i < femaleNames.length; i++) {
			femaleNames[i] = femalesFromText.getName(i);
		}
		
		lastNamesFromText = new ImportFromText("raw data/Last_Names.txt");
		lastNames = new String[lastNamesFromText.getnElems()];
		for(int i = 0; i < lastNames.length; i++) {
			lastNames[i] = lastNamesFromText.getName(i);
		}
	}

	public String[] getMaleNames() {
		return maleNames;
	}

	public String[] getFemaleNames() {
		return femaleNames;
	}

	public String[] getLastNames() {
		return lastNames;
	}
	
}