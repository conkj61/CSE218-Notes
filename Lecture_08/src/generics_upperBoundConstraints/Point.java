package generics_upperBoundConstraints;
// 2/28/19  12:47 P.M.
public class Point <T extends Number>{ //12:51 to T we added extends Number, by doing this the class can only
					//take number objects
	private T x;
	private T y;

	public Point(T x, T y) {
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

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	} //at 12:48 P.M. this class currently has no constraints, can take anything
	
	public void display(Point point) {
		System.out.println(point);
	}

}