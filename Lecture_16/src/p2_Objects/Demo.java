package p2_Objects;

import java.util.HashSet;

// 5/7/19  12:08
public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("John", 3.5);
//		Student s2 = new Student("Jane", 4.0); //12:14 commented out
//		Student s2 = new Student("John", 3.0); //12:14 replaced original s2
		Student s2 = new Student("John", 3.5); //12:15 commented and replaced second s2
		
		System.out.println(s1.equals(s2)); //12:28 this should now print true since we
								//overwrote .equals
					//12:38 this returns true after our altering of hash code and .equals
		
//		HashSet<Student> studentSet = new HashSet<>();
		// 12:09 created to put students in, remember this is a "array" type
		HashSet<Student> studentSet = new HashSet<>(10);
		// 12:11 commented previous hashset to write this one with a size to stop re hashing
		studentSet.add(s1);
		studentSet.add(s2);
		for(Student s : studentSet) {
			System.out.println(s);
			// 12:12  when printed to the console we noticed:
			// a) they were indeed two different objects to be stored
			// b) the order was not kept
		} //12:15 when printed with two of the "same" object both were printed instead of one
		  //	  this happened because the constructor was called twice, for two different
		  //	  objects. And when you try to compare objects, it's based on .equals.
		  //	  The string example was based on the content of the strings, but here .equals
		  //	  was false because it compared address.
	}
		//12:18 With the only exception of strings, == and .equals do the same thing.
}
/*	12:19
 *  Conclusion:
 *  1) When comparing objects, .equals is used. If false, two different objects.
 *  	Compares the memory address.
 *  2) == and .equals are the same when comparing objects, with String being an exception
 *  		Since int is primitive, .equals will not work. No primitive type will work
 *  
 *  
 *  If you wanted .equals to compare contents, you can write a method to overwrite it.
 *  12:24 We will write that method in the Student class.
 *  
 *  
 *  12:33
 *  After re-writing .equals hashSet still took to objects, so more is needed.
 *  In order to truly be the same, we have to alter the "hash code" as well.
 *  
 *  12:38
 *  Finally after hash code alter, our hashSet only takes one object since their contents are
 *  absolutely true.
 *  
 *  12:41
 *  Most times in life we don't really care about the memory address(where they are stored).
 *  We can whether or not their contents show that they are exactly the same, so feel comfortable
 *  using hash and equals overwrite.
 *  
 *  12:44
 *  A hashSet should be used over a treeSet only when the number of items is known.
 *  treeSet's big o is O(logn), so it's slower but doesn't need the size to be known.
 *  
 *  12:45
 *  We also said that hashSet can grow, when a set is almost full a new hashTable will be created
 *  of double size. When that happens it must "re-hash" which means calculate where the new values
 *  will be located. Doing this slows everything down, and should attempt to be avoided.
 *  The treeSet does not encounter this problem, but of course has a slower natural speed.
 *  
 *  If you have literally no idea about the size (even general projected expansions), then treeSet
 *  should be used as it is safer to not going through so many re-hashes.
 *  
 *  
 *  12:50
 *  Maps are generally the same thing, just with a key which must be comparable. So it will have
 *  unique keys, and (possibly?) unique values.
 *  
 *  
 *  12:54
 *  A lot of people don't know the difference between a method and a function. Many people use them
 *  interchangeably, and that is not correct.
 *  We know what a method is, given a parameter it returns some result to us. Each one is based on
 *  objects. A method is not self contained, it relies on other factors to return a result.
 *  A function is different, consider the fact that functions were learned in math.
 *  f(x): y = x+1. This is self contained, there is no external factor influencing y given x.
 *  But method, you can input any object, but what it returns really depends on the object you are
 *  dealing with, it is not always the same.
 *  
 *  1:01
 *  So functional programming is trying to recreate a function. Methods aren't always fully predictable
 *  but if we can get it to mimic functions, then it is functional programming. One example that we use
 *  is setOnAction, when this button is hit some specific thing will always happen. Recall that any
 *  variable within a set on action, must be detached from the outside world, it must be final
 *  or effectively final.
 */