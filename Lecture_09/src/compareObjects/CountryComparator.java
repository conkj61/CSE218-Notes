package compareObjects;

import java.util.Comparator;
// 3/5/19  1:00 P.M.
public class CountryComparator implements Comparator<Country> {

	@Override
	public int compare(Country o1, Country o2) {
		//contiued from end of Country notes
		return o1.getName().compareTo(o2.getName());
	}
	//1:08 P.M. this entire class actually only exists to allow us to compare both variables from the
	//Country class. Area is compared from within Country, and Name is compared here.

}
