package p1;

public class BinarySearchGeneric {

	public static void main(String[] args) {
		String[] things = { "Basketball", "Car", "Card", "Food", "Glass", "Toy"};
		Integer[] numbers = {1, 3, 4, 6, 7, 9, 12};
		System.out.println("The word \"Glass\" appears at index " + binarySearch(things, 0, 5, "Glass"));
		System.out.println("The number \"3\" appears at index " + binarySearch(numbers, 0, 5, 3));
	}
	
	public static <E extends Comparable<E>> int binarySearch(E[] array, int first, int last, E searchTarget) {
		int middle;
		if(first > last) {
			return -1;
		}
		
		middle = (first + last) / 2;
		if(array[middle].compareTo(searchTarget) == 0) {
			return middle;
		} else if(array[middle].compareTo(searchTarget) < 0) {			
			return binarySearch(array, middle + 1, last, searchTarget);
			
		} else {
			return binarySearch(array, first, middle - 1, searchTarget);
		}
	}
	
}