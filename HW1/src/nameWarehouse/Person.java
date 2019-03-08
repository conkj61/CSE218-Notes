package nameWarehouse;

import java.util.Random;

public class Person {
	private String firstName;
	private String lastName;
	private boolean genderCondition;
	
	public Person(String firstName, String lastName, boolean genderCondition) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.genderCondition = genderCondition;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getGender() {
		return genderCondition;
	}

	public void setGender(boolean genderCondition) {
		this.genderCondition = genderCondition;
	}

	@Override
	public String toString() {
		return "Person name: " + firstName + " " + lastName + ", is a " + (genderCondition? "male": "female");
	}
	
}
