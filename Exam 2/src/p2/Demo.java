package p2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo {

	public static void main(String[] args) {
		/* The idea was, given X type of transportation, charge would return Y price.
		 * Tried to implement Function util, could not get to work.
		 * */
		List<String> types = Arrays.asList("Car", "Truck", "Pedestrian", "Bike");
		
		Predicate<String> p = (s)->s.equals("Bike");
		
		for(String st : types) {
			if(p.test(st)) {
				System.out.println(st);
				Charge price = (t)->t.charge();
			}
		}
	}

}
