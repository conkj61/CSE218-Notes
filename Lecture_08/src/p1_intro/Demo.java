package p1_intro;

import java.util.ArrayList;

// 2/28/19  11:56 P.M.
public class Demo {

	public static void main(String[] args) {
		// Introduction to talking about "Generics"
//		ArrayList<String> theList = new ArrayList<>(); //the angle bracket is generics. It allows you to
				//specify the data type.
//		theList.add("Hi");
//		theList.add(1); this doesn't work, because we specified that we would only put in strings
		
//		ArrayList theList = new ArrayList(); //12:08 P.M.
//		theList.add("Hi");
//		theList.add(1);
//		theList.add(1.1);
		
//		String str1 = theList.get(0); //since our list is generic java does not know the our target will be a string
//		String str1 = (String)theList.get(0); //so to fix the problem, we cast it to string, this is us telling
			//java that we know there is a string at that position. However, if we are wrong, the program will
			//definitely crash
		
		ArrayList<String> theList = new ArrayList<>();
	}

}

/*ArrayList theList = new ArrayList(); Using the list in this manner allows us to store raw objects
		meaning we can put any class into this
  theList.add(1.1); this is a primitive data type, but works because java does what is known as autoboxing
  theList.ass(new Double(1.1)); this is what is actually happening when autoboxing occurs, the same
		will happen for int to (new Integer), java converts it to the class version
  
  12:14 P.M. We can actually specify that our list, can take CERTAIN data types instead of everything.
*/