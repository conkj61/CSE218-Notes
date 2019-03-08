package lowerBoundConstraints;

// 3/5/19  11:43 A.M.
public class Point<T> { // 11:43 make class generic by adding <T>
	private T x;
	private T y;

	public Point(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void display(Point<? super Integer> point) { // 11:47 A.M. added <M super Integer> this is a lower
					//bound, that means that only classes above integer are allowed
		System.out.println(point);
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
	}
}
