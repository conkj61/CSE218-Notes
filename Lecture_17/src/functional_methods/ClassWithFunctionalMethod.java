package functional_methods;
// 5/9/19  12:19
public class ClassWithFunctionalMethod {
	private int value = 0; //12:20 add this global
	
	public int sum(int a, int b) { //this is the definition of a functional method, it does not care
							//about the outside world. It will always do the same thing.
		return a + b;
	} //This is known as a function
	
	public int add(int nextValue) { //12:20 this is not a functional method, it really depends on
							//an outside value. A value that from one side, the other side's value
							//is unknown, but influencing the result.
		return value + nextValue;
	} //This in particular is known as a method
}
