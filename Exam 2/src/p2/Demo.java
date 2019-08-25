package p2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo {

//	public static void main(String[] args) {
//		/* The idea was, given X type of transportation, charge would return Y price.
//		 * Tried to implement Function util, could not get to work.
//		 * */
//		List<String> types = Arrays.asList("Car", "Truck", "Pedestrian", "Bike");
//		
//		Predicate<String> p = (s)->s.equals("Bike");
//		
//		for(String st : types) {
//			if(p.test(st)) {
//				System.out.println(st);
//				Charge price = (t)->t.charge();
//			}
//		}
//	}
	public static void main(String[] args) {
		int totalForDay = 0;
		int currentCharge;
		for(int i = 0; i < 10; i++) {
			Chargeable test = new Car("EYD 9057");
		
			currentCharge = test.charge();
			totalForDay += test.charge();
		
			System.out.println("Car price: " + currentCharge);
			System.out.println("Total so far is: " + totalForDay);
			
			Chargeable test2 = new Truck("Y0L0 SW6");
			currentCharge = test2.charge();
			totalForDay += test2.charge();
		
			System.out.println("Truck price: " + currentCharge);
			System.out.println("Total so far is: " + totalForDay);
			
			Chargeable test3 = new Pedestrain("778-11-6623");
			currentCharge = test3.charge();
			totalForDay += test3.charge();
		
			System.out.println("Person price: " + currentCharge);
			System.out.println("Total so far is: " + totalForDay);
			
			Chargeable test4 = new Bike("KMHD25LE1DU042025");
			currentCharge = test4.charge();
			totalForDay += test4.charge();
		
			System.out.println("Bike price: " + currentCharge);
			System.out.println("Total so far is: " + totalForDay);
		}
	}

}
