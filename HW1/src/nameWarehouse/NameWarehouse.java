package nameWarehouse;

import java.io.FileNotFoundException;
import java.util.Random;

import utilities.DataImporter;

public class NameWarehouse {
	private DataImporter malesFromText;
	private DataImporter femalesFromText;
	private DataImporter lastNamesFromText;
	private String[] maleNames;
	private String[] femaleNames;
	private String[] lastNames;
	private Random lastNameSelector = new Random();
	private Person[] people;
	private int nPeople;
	
	public NameWarehouse() throws FileNotFoundException { //exception handled within importer
		createNameArrays();
		people = new Person[maleNames.length + femaleNames.length];
		nPeople = 0;
		createPersonArray();
	}

	private void createPersonArray() {
		for(int i = 0; i < maleNames.length; i++) {
			Person p = new Person(maleNames[i], lastNames[lastNameSelector.nextInt(lastNames.length)], true);
			insert(p);
		}
		for(int j = 0; j < femaleNames.length; j++) { //this should pick up where males ended
			Person q = new Person(femaleNames[j], lastNames[lastNameSelector.nextInt(lastNames.length)], false);
			insert(q);
		}
	}

	private void insert(Person p) {
		people[nPeople++] = p;
	}

	public int getNumberOfPeople() {
		return nPeople;
	}
	
	public String displayPerson(int target) {
		return people[target].toString();
	}

	private void createNameArrays() throws FileNotFoundException { //exception handled within importer
		malesFromText = new DataImporter("raw data/boys_names.txt");
		maleNames = new String[malesFromText.getnElems()];
		for(int i = 0; i < maleNames.length; i++) {
			maleNames[i] = malesFromText.getName(i);
		}
		
		femalesFromText = new DataImporter("raw data/girls_names.txt");
		femaleNames = new String[femalesFromText.getnElems()];
		for(int i = 0; i < femaleNames.length; i++) {
			femaleNames[i] = femalesFromText.getName(i);
		}
		
		lastNamesFromText = new DataImporter("raw data/Last_Names.txt");
		lastNames = new String[lastNamesFromText.getnElems()];
		for(int i = 0; i < lastNames.length; i++) {
			lastNames[i] = lastNamesFromText.getName(i);
		}
	}
	
	public Person[] getPersonArray() {
		return people;
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