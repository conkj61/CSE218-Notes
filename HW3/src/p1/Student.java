package p1;
//model
public class Student {
	private String name;
	private double gpa;
	private String id;
	
	private static int uniqueID = 0;

	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
		id = String.format("%08d", uniqueID++);
	}
	
	
}
