package compareObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 3/5/19  12:42 P.M.
public class Demo {

	public static void main(String[] args) {
		//showcase of the Country class' compare method
		Country c1 = new Country("A", 200);
		Country c2 = new Country("Z", 100); //12:46 changed "C" to "Z" to show Arrays.sort functionality
		//as everything written of 12:43 P.M. comparing these two will say that c1 is smaller because names
		//are being compared, not size
//		System.out.println(c1.compareTo(c2)); //this yields -1 (A is one less ASCII value than B)
		
		Country c3 = new Country("C", 500);
		Country[] countryArray = {c1, c2, c3}; //12:45 P.M. what if we wanted to sort this array?
			//In past it was either annoying, or not possible. Now since we gave Country class a compare
			//method it became so much easier, and allowed us to use Arrays.sort
//		Arrays.sort(countryArray); //commented out 1:03 P.M. for CountryComparator
		CountryComparator cc = new CountryComparator(); //1:04 P.M.
		Arrays.sort(countryArray, cc); //1:04 P.M. this method compares names using our comparator
				//Arrays.sort can take two arguments, the second being our comparator
		System.out.println(Arrays.toString(countryArray)); //12:57 commented out after writting ArrayList
											//just for ease of view
		
		ArrayList<Country> list = new ArrayList<>(); //12:56 P.M.
		list.add(c1);
		list.add(c2);
		list.add(c3);
		Collections.sort(list); //1:09 P.M. this uses Country, compares areas
		System.out.println(list);
	}

}
