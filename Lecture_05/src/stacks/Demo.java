package stacks;
// 2/14/19
public class Demo {

	public static void main(String[] args) {
		//example of StackX code in practice
		StackX theStack = new StackX(4);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		theStack.push(50);
		System.out.println(theStack.pop());		
	}

}
