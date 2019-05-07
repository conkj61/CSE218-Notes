package mergeSort;
//  3/19/19 12:32 P.M.
public class MergeSortApp {

	public static void main(String[] args) {
		//testing mergeSort class
		int maxSize = 100;
		DArray arr = new DArray(maxSize);
		arr.insert(23);
		arr.insert(11);
		arr.insert(22);
		arr.insert(31);
		arr.insert(14);
		arr.insert(43);
		arr.insert(36);
		arr.insert(6);
		arr.insert(15);
		arr.display();
		arr.mergeSort();
		arr.display();
	}

}
