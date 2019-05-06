package p4;
//model
public class Student {
	private String name;
	private double gpa;
	private String id;
	
	private static int idGenerator = 0;
	
	public Student(String name, double gpa) {
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return name + " has a gpa of: " + gpa + ",  with id: " + id;
	}
	
	
}
