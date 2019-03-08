package p1_stackOverflowError;
// 3/7/2019
public class Demo {
	static int n = 0; //11:49 set the "base case" here, so that way it has a global scale to leave recursion
	public static void main(String[] args) {
		//recursion is the idea of a method calling itself within itself 11:38 A.M.
		displayHello();
	}

	private static void displayHello() {
		n++; //11:52 increment is placed here so that way the first thing this method does, is increase the
			//base case before anything else, so it may evventually leave the stack.
		if(n > 5) {
			return; //11:47 we add a condition that will force the method to leave the loop.
					//this is known as using a "base case".
		}
		System.out.println("Hello");
		displayHello();
		//11:39 A.M the way the above two lines currently written, it will keep displaying "Hello" until the
		//program crashes.
		
//		n++; //11:51 if we put the induction here, it will never increment because the recursion cuts it off.
	}
	
}

/* The reason why recursion crashes is because it never "resolves" the stack. Looking at the code written
 * before 11:40, what is actually happening is that the main method puts the displayHello() method on the
 * stack, then that method puts the sysout("Hello") on the stack, "Hello" gets printed then removed from the
 * stack. But the displayHello() method from main isn't finished, and it's next line puts itself on the stack
 * causing the method to continue ad infinitum. This eventually crashes the java virtual machine with a
 * "stack overflow" error.
 * 
 * 11:54 A.M.
 * A "base case" is setting up a scenario so that when recursion is used, we put in a way to leave the recursion
 * loop. Recursion isn't typically efficient, but it is easy to code and work with. How sometimes it just makes
 * a lot more sense to use recursion instead of trying to figure out a way to use loops.
 */