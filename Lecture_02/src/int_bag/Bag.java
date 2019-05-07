package int_bag;
// 1/31/19
public class Bag {
	private int[] array;
	private int numberOfElements;
	private int maxSize;
	
	public Bag(int maxSize) {
		array = new int[maxSize];
		numberOfElements = 0;
		this.maxSize = maxSize;
	}
	
	public void add(int number) {
		array[numberOfElements++] = number;
//		numberOfElements++;
	}
	
	public boolean isFull() {
		if (numberOfElements == maxSize) {
			return true;
		} else {
			return false;
		}
	} //big O for this method, is 1. Effort is the same regarless of number of items in array
	
	public void display() {
		for (int i = 0; i < numberOfElements; i++) {
			System.out.println(array[i]);
		}
	}
	
	public boolean find(int searchNumber) {
		for (int i = 0; i < numberOfElements; i++) {
			if (array[i] == searchNumber) {
				return true;
			}
		}
		return false;
		/*big O here is N, because if true is returned early, it doesn't need to go through the
		whole array*/
	}
	
	public boolean delete(int number) {
		int count = -1;

		for (count = 0; count < numberOfElements; count++) {
			if (array[count] == number) {
				break;
			} //Big O here is N, searching entire array
		}

		if (count == numberOfElements) {
			return false; //at this step big O, is 1
		} else {
//			return true; //big O at this step was also 1. Will stop when found

			for (int j = count; j < numberOfElements - 1; j++) {
				array[j] = array[j + 1];
			}
			numberOfElements--;
			return true; //big O here is N, it will work throughout the whole array
		}
	} /*So the Big O for the entire method ends up being N (even though we know its 2*N, all
		that matters is the order of magnitude, which is N */
	
}
//whenever we see a for loop, big O is usually N
//whenever there is no loop, big O should be 1
//and an example of Big O being N^2 are nested loops