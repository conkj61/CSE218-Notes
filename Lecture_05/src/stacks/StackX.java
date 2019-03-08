package stacks;
// 2/14/19  12:29 P.M.
public class StackX {
	//Using the abstract data type "stack", is literally the same as the stack in MTG
	//the first thing to go into the stack is the last one to come out.
	private long[] stackArray;
	private int nElems;
	private int maxSize;
	private int top; //this is the variable we will use to hold the top spot of the stack
	
	public StackX(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new long[maxSize];
		top = -1; //starting with nothing, putting something on the stack would make it index 0
	}
	
	public void push(long n) {
		stackArray[++top] = n; //here we make sure our top index increases before storing to keep the index
		//"at the top" of the stack
	}
	
	public long pop() {
		return stackArray[top--]; //we want to use the index value before decrementing the index
	}
	
	public long peek() { //this method allows us to see whats at the top without taking it off the stack
		return stackArray[top];
	}
	
	public boolean isEmpty() { //if the stack works as intended, when it is empty index shoud be back at -1
		return top == -1;
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
}