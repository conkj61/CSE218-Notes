package bags_revisit;

import java.util.Arrays;
import java.util.function.Predicate;

// 5/9/19  12:36
public class Bag {
	private Student[] array;
	private int nElems;
	private int maxSize;
	
	public Bag(int maxSize) {
		array = new Student[maxSize];
		this.maxSize = maxSize;
		nElems = 0;
	}
	
	public void insert(Student s) {
		array[nElems++] = s;
	}
	
	public Student[] search(Predicate<Student> tester) { //12:39 we used to write this as searchById
						//but now we don't want to be locked into how we search.
						//So we will use what is known as Predicate
		
		Student[] arr = new Student[maxSize]; //12:44 added lines 26-32
		int n = 0;
		for(int i = 0; i < nElems; i++) {
			if(tester.test(array[i])) { //I want to test each element, if it is true store it into
				arr[n++] = array[i];	//the other array.
			}
		}
//		return array; //12:40
		return Arrays.copyOf(arr, n); //12:47 replaced above line after implementing tester
		//12:50 this is known as a test function, and a function should come in as an argument
	}
}
/* 12:42
 * The Predicate interface, is a functional interface because it only has one unimplemented method.
 */