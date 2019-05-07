package mergeSort;
//  3/19/19
public class DArray {
	private long[] theArray;
	private int nElems;

	public DArray(int maxSize) {
		theArray = new long[maxSize];
		nElems = 0;
	}
	
	public void mergeSort() { //12:11 P.M.
		long[] workSpace = new long[nElems];
		//12:13  we need to run a recursive method similar to binary search for the merging
		recMergeSort(workSpace, 0, nElems -1); //our method will take our array and a start/end index
	}
	
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		//12:15 P.M. 
		if(lowerBound == upperBound) { //this should only happen after sorting
//			System.out.println();
			return; //if they have the same value, then we signal a return to all callers
		} else {
			int mid = (lowerBound + upperBound) / 2; //if our array is not sorted, we will create a mid point to work with
			recMergeSort(workSpace, lowerBound, mid); //we will try to sort towards the left first
								//using only the first half of the given array
			recMergeSort(workSpace, mid + 1, upperBound); //12:21 P.M. This one is tricky....what is the
						//mid point? The mid point when first getting here is actually 0 index because it 
						//attempted to sort all the way to the left. so the first time it makes it here,
						//we make it 0+1 index, and mid+1 every successive time.
			merge(workSpace, lowerBound, mid +1, upperBound);
		}
		
	}

	private void merge(long[] workSpace, int lowPointer, int highPointer, int upperBound) {
		//12:24  actual merge
		int j = 0; //workSpace index
		int lowerBound = lowPointer;
		int mid = highPointer - 1;
		int n = upperBound - lowerBound + 1; //number of items
		
		while(lowPointer <= mid && highPointer <= upperBound) { //neither subarray is empty
			if(theArray[lowPointer] < theArray[highPointer]) {
				workSpace[j++] = theArray[lowPointer++];
			} else {
				workSpace[j++] = theArray[highPointer++];
			}
		}
		
		while(lowPointer <= mid) { //high half is empty
			workSpace[j++] = theArray[lowPointer++];
		}
		
		while(highPointer <= upperBound) { //low half is empty
			workSpace[j++] = theArray[highPointer++];
		}
		
		for(int k = 0; k < n; k++) {
			theArray[lowerBound + k] = workSpace[k];
					//12:30P.M. this is to copy the data back into where it came from
		}
	}
	
	public void insert(long value) {
		theArray[nElems++] = value;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println();
 	}
}