package p4;

public class Link {
	//variables public for ease to work with for this problem
	public Student data;
	public Link next;
	public Link previous;
	
	public Link(Student data) {
		this.data = data;
		next = null;
		previous = null;
	}
	
	public String displayLink() {
		return data.toString();
	}
}
