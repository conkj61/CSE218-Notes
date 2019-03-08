package generic_class;
// 2/28/19  12:28 P.M.
public class Point <T, S> { //12:30 P.M. added <T> to the header to tell java not to look for the T class
	//12:38 P.M. added ", S" to enable the second generic
	//here we learn to create a generic class
//	private int x;
//	private int y; //right here we have already committed ourselves to a certain type of variable, int
//	
//	private String xPosition = "five";
//	private String yPosition = "ten"; //but what if we wanted to use strings?
	
//	private T x; //so what if we wanted to use a placeholder for generics?
//	private T y; //java tries to get us to write the T class, so we change the header
//
//	public Point(T x, T y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//
//	public T getX() {
//		return x;
//	}
//
//	public void setX(T x) {
//		this.x = x;
//	}
//
//	public T getY() {
//		return y;
//	}
//
//	public void setY(T y) {
//		this.y = y;
//	}
//
//	@Override
//	public String toString() {
//		return "Point [x=" + x + ", y=" + y + "]";
//	}
	
	private T x; // 12:39 P.M. what if we wanted to make sure we take to different type, and not
					// the same
	private S y; // we would add another generic

	public Point(T x, S y) {
		super();
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public S getY() {
		return y;
	}

	public void setY(S y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
