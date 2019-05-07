package p2_Objects;
// 5/7/19
public class Student {
	private String name;
	private double gpa;
	
	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}
	
//	@Override
//	public boolean equals(Object o) { //12:25 overwrite .equals
//		return (this.name.equals(((Student) o).name) && this.gpa == ((Student) o).gpa);
//		// return true for contents, == used for primitive double
//	}  //12:35 we proved that this didn't do what we wanted initially
	
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}

	@Override //12:37 this is auto-generated and how was we alter hash code, expect to never ever
	//actually write this complex code
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override //12:37 this is auto-generated and how was we alter .equal in tandem of hash code,
	// expect to never ever actually write this complex code
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
