package bags_revisit;

import java.util.Arrays;

// 5/9/19  12:51
public class Demo {

	public static void main(String[] args) {
		//showing search test function
		Bag theBag = new Bag(100);
		Student s1 = new Student("Alan", 1.0);
		Student s2 = new Student("Bill", 3.0);
		Student s3 = new Student("Cathy", 1.5);
		Student s4 = new Student("Dave", 2.0);
		Student s5 = new Student("Ellen", 4.0);
		Student s6 = new Student("Franky", 3.0);
		theBag.insert(s1);
		theBag.insert(s2);
		theBag.insert(s3);
		theBag.insert(s4);
		theBag.insert(s5);
		theBag.insert(s6);
		
		//12:54 we are now going to pass a function to our search method
		Student[] arr = theBag.search(e -> {
			e.getName().equals("Dave");
			System.out.println(Arrays.toString(arr));
		}); //1:04 search method Chen wrote does not work.
	}

}
