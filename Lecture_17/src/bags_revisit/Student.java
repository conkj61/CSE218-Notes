package bags_revisit;
// 5/9/19  12:36 We are revisiting our original bag classes to see what we can do with functional
			//programming
public class Student {
	private String name;
	private Double gpa;

	public Student(String name, Double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
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

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

}