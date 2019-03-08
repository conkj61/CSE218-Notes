package generic_methods;
// 2/28/19  12:16 P.M.
public class GenericMethodDemo {

	public static void main(String[] args) {
		String[] names = {"Adam", "Bill", "Cathy"};
		displayArray(names);
		Integer[] numbers = {1, 2, 3, 4}; //12:18 P.M.
		displayArray(numbers); //this forces us to write a new overloaded method
			//12:21 P.M until we created a generic method
	}
	
	private static <E> void displayArray(E[] n) { //12:21 P.M.  instead of writing two overloaded methods we want to
					//write a generic method using a placeholder, E. Then java tried to get us to write an E
					//class, so within the method header we put an E in angle brackets, telling java this will
					//be a generic method. Angle brackets is what matters
		for(E e : n) {
			System.out.println(e);
		}
		System.out.println();
		//We could have put anything instead of E, but by convention it usually E for element, T for type
	}

//	private static void displayArray(Integer[] numbers) { //12:18 P.M.
//		for(Integer i : numbers) {
//			System.out.println(i);
//		}
//		System.out.println();
//	}
//
//	private static void displayArray(String[] names) { //12:17 P.M.
//		for(String name : names) {
//			System.out.println(name);
//		}
//		System.out.println();
//	}

}
