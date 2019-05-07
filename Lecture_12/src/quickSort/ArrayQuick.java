package quickSort;
//  4/2/19  12:49 P.M.
public class ArrayQuick {
	private long[] theArray;
	private int nElems;
	// bigO value: n*logn
	// if data is inverse sorted, quick sort collapses, bigO becomes: n^2
	public ArrayQuick(int maxSize) {
		theArray = new long[maxSize];
		nElems = 0;
	}
	
	public void quickSort() { //12:50
		recQuickSort(0, nElems - 1);
	}
	
	private void recQuickSort(int left, int right) { //12:51
		if(right - left <= 0) {
			return;
		} else {
			long pivot = theArray[right];
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition - 1);
			recQuickSort(partition, right);
		}
	}
	
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while (true) {
			while (leftPtr < right && theArray[++leftPtr] < pivot) {
				; // nop (no operation)
			}
			while (rightPtr > left && theArray[--rightPtr] > pivot) {
				; // nop (no operation)
			}
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		return leftPtr;
	}

	private void swap(int leftPtr, int rightPtr) {
		long temp = theArray[leftPtr];
		theArray[leftPtr] = theArray[rightPtr];
		theArray[rightPtr] = temp;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println();
	}

	public int size() {
		return nElems;
	}
}
