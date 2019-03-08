package queues;
// 2/14/19  12:38 P.M.
public class QueueX {
	//Queue is an "Abstract Data Type"
	//this of a queue like a roller coaster queue, meaning the first one in is the first one out
	private int maxSize;
	private long[] queueArray;
	private int front; //front will be where you remove
	private int rear; //rear will be where things get added
	private int nElems;
	
	public QueueX(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new long[maxSize];
		front = 0; //because rear will always increment first, front will start at the first index something could
		//be removed, in this case index is 0. This should normally be the case
		rear = -1; //like stack, before we add we will increment
		nElems = 0;
	}
	
	public void insert(long n) {
		if(rear == maxSize - 1) { //in this method if rear hits the top of the array, we will wrap around
			rear = 1; //this wraps, because it will go back to the beginning index
		}
		queueArray[++rear] = n; //like stack, we increment before using.
		nElems++;
	}
	
	public long remove() {
		long temp = queueArray[front++]; //since things come out at the front of the queue, we use then increment
		if(front == maxSize) {
			front = 0; //same as insert wrap principal, except front goes to lowest usable index
		}
		nElems--;
		return temp;
	}
	
	public long peekFront() {
		return queueArray[front]; //see what is scheduled to come out of the queue without removing it
	}
	
	public boolean isEmpty() {
		return nElems == 0;
	}
	
	public boolean isFull() {
		return nElems == maxSize;
	}
	
	public int size() {
		return nElems;
	}
}
