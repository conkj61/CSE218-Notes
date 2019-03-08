package nameFactory;

import java.io.FileNotFoundException;

import nameWarehouse.NameWarehouse;
import nameWarehouse.Person;

public class NameFactory {
	/* accept a search parameter of letter and gender
	 * compare the letter to the first letter of a name
	 * also compare the input gender
	 * return all results that match both
	 * sort results alphabetically
	 */
	private NameWarehouse searchEnabler;
	private Person[] allPeopleFromWarehouse;
	private Person[] candidatesFromSearch;
	
	public NameFactory() throws FileNotFoundException {
		searchEnabler = new NameWarehouse();
		allPeopleFromWarehouse = searchEnabler.getPersonArray();
	}
	
	public void searchByLetterAndGender(char searchTarget, String genderCondition) {
		boolean gender = false;
		if(genderCondition.toLowerCase().equals("male") || genderCondition.toLowerCase().equals("female")) {
			gender = checkGenderInput(genderCondition);
		} else {
			System.out.println("Gender input incorrectly");
			System.exit(0);
		}
		searchWarehouse(searchTarget, gender);
		sortCandidates();
		for(int i = 0; i < candidatesFromSearch.length; i++) {
			System.out.println(candidatesFromSearch[i].toString());
		}
	}
	
	private void sortCandidates() {
		int in;  //while loop
		int out; //for loop
		
		for(out = 1; out < candidatesFromSearch.length; out++) {
			Person temp = candidatesFromSearch[out];
			in = out;
			
			while(in > 0 && candidatesFromSearch[in - 1].getFirstName().compareTo(temp.getFirstName()) > 0) {
				candidatesFromSearch[in] = candidatesFromSearch[in - 1];
				in--;
			}
			candidatesFromSearch[in] = temp;
		}
	}

	private void searchWarehouse(char searchTarget, boolean gender) {
		int matchCount = 0;
		int possibleMatches = 0;
		for(int i = 0; i < allPeopleFromWarehouse.length; i++) {
			if(allPeopleFromWarehouse[i].getFirstName().charAt(0) == searchTarget && 
					gender == allPeopleFromWarehouse[i].getGender()) {
				matchCount++;
			}
		}
		candidatesFromSearch = new Person[matchCount];
		for(int i = 0; i < allPeopleFromWarehouse.length; i++) {
			if(allPeopleFromWarehouse[i].getFirstName().charAt(0) == searchTarget && 
					gender == allPeopleFromWarehouse[i].getGender()) {
				candidatesFromSearch[possibleMatches++] = allPeopleFromWarehouse[i];
			}
		}
	}

	private boolean checkGenderInput(String genderCondition) {
		boolean gender = false;
		if(genderCondition.toLowerCase().equals("male")) {
			gender = true;
		}
		return gender;
	}

//	public Person[] searchByFirstLetter(char searchTarget) {
//		int possibleMatches = 0;
//		for(int i = 0; i < allPeopleFromWarehouse.length; i++) {
//			if(allPeopleFromWarehouse[i].getFirstName().charAt(0) == searchTarget) {
//				candidatesFromSearch[possibleMatches++] = allPeopleFromWarehouse[i];
//			}
//		}
//		return candidatesFromSearch;
//	}
}