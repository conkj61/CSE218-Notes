package binarySearchUsingRecursion;
// 3/7/2019  11:56 A.M.
public class Demo {

	public static void main(String[] args) {
		//this is our first real look into using recursion
		int[] numbers = {101, 105, 112, 132, 213, 231, 310, 312, 344}; //remember that in order to use binary 
				//search, the data must already be sorted. So we wrote this already sorted just for ease of
				//example.  11:59 A.M.
		System.out.println(binarySearch(numbers, 2, 6, 213));  //12:01 P.M. creation of search method
	}

	private static int binarySearch(int[] numbers, int first, int last, int searchTarget) {
		/* 12:01 We want this method to be more flexible than a regular binarySearch. Like a regular one,
		 * it will take the array we would like to search as well as our searchTarget for the array. But
		 * for extra flexibility we allow the method to also specific a range of indexes in which we would
		 * like to search for our target.
		 */
		int middle; // 12:05 midpoint of search range
		if(first > last) { //if this condition is met, that means the two crossed and there was no match
			return -1; //so in this case we return -1, an impossible array index
			//12:14 this is our base case since we are using recursion
		}
		
		middle = (first + last) / 2; //set it to the middle of the array
		if(numbers[middle] == searchTarget) {
			return middle; //search successful
		} else if(numbers[middle] < searchTarget) {
			return binarySearch(numbers, middle + 1, last, searchTarget);
			/* when the target is greater than the middle, we use recursion with this method, setting our
			 * first index to be one above the current middle.
			 */
		} else {
			return binarySearch(numbers, first, middle - 1, searchTarget);
			/* when the target is less than the middle, we use recursion with this method, setting our
			 * last index to be one below the current middle.
			 */
		}
	}

}
