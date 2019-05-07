package object_bag;
// 1/31/19
public class Bag {
	private Student[] array; /*at this line, Student has a red underline to start because it can't find the 
	Student class. The compiler is always running in the background checking for these type of errors, JVM
	only checks at runtime. When compiler catches an error it is known as a checked error. If program ran, 
	then crashed, it is known as an unchecked exception, a "runtime error". Any unchecked error that occur
	are things that the programmer is supposed to know, always mistakes made by the programmer.*/
	private int numberStudents;
	
	public Bag(int maxSize) {
		array = new Student[maxSize];
		numberStudents = 0;
	}
	
	public void insert(Student s) {
		array[numberStudents++] = s;
	}
	
	public void display() {
		for(int i = 0; i < numberStudents; i++) {
			System.out.println(array[i]);
		}
	}
	
	public Student findByName(String name) {
		for(int i = 0; i < numberStudents; i++) {
			if(array[i].getName().equals(name)) {
				return array[i];
			}
		}
		return null;
	}
	
	public Student removeByName(String name) {
		int count = -1;
		for(count = 0; count < numberStudents; count++) {
			if(array[count].getName().equals(name)) {
				break;
			}
		}
		if(count == numberStudents) {
			return null;
		} else {
			Student temp = array[count];
			for(int i = count; i < numberStudents - 1; i++) {
				array[i] = array[i + 1];
			}
			numberStudents--;
			return temp;
		}
	}
	
}
