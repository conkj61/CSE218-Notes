package partitioning;
//  4/2/19
public class ArrayPar {
	private long[] theArray;
	private int nElems;
	
	public ArrayPar(int maxSize) {
		theArray = new long[maxSize];
		nElems = 0;
	}
	
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while (true) {
			while (leftPtr < right && theArray[++leftPtr] < pivot) {
				; // nop (no operation)
			}
			while (rightPtr > left && theArray[--rightPtr] > pivot) {
				;
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