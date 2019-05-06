package p3;

public class Student implements Comparable<Student> {
	private String name;
	private Double gpa;
	private String id;

	private static int idGenerator = 0;

	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
		id = String.format("%08d", idGenerator++);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	@Override
	public int compareTo(Student s) {
		return gpa.compareTo(s.getGpa());
	}

	@Override
	public String toString() {
		return "Student " + name + " with ID number: " + id + " has a gpa of " + gpa;
	}

}
