package priorityQ;

public class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nElems;
	
	public PriorityQ(int maxSize) {
		this.maxSize = maxSize;
		nElems = 0;
		queArray = new long[maxSize];
	}
	
	public void insert(long item) {
		int j;
		if(nElems == 0) {
			queArray[nElems++] = item;
		} else {
			for(j = nElems-1; j >= 0; j--) {
				if(item > queArray[j]) {
					queArray[j+1] = queArray[j]; 
				} else {
					break;
				}
			} //end for
			queArray[j+1] = item;
			nElems++;
		}
	}
	
	public long remove() {
		return queArray[--nElems];
	}
	
	public long peekMin() {
		return queArray[nElems];
	}
	
	public boolean isEmpty() {
		return nElems == 0;
	}
	
	public boolean isFull() {
		return nElems == maxSize;
	}
}
