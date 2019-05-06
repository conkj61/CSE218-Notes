package p3;

public class Demo {

	public static void main(String[] args) {
		BagGenericModified<Student> test = new BagGenericModified<>(3);
		Student s1 = new Student("Rob", 3.4);
		Student s2 = new Student("Joe", 3.7);
		Student s3 = new Student("Jennifer", 3.2);
		test.addValue(s1);
		test.addValue(s2);
		test.addValue(s3);
		test.display();
		System.out.println();
		test.sortByGPA();
		test.display();
		System.out.println();
		test.sortByName();
		test.display();
	}
	
}