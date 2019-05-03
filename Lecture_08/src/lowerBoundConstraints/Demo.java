package lowerBoundConstraints;
// 3/5/19  11:45 A.M.
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Point<String> point = new Point<>("one", "two");
//		point.display(point); //after changing display method, this line no longer works since String is not
					//above the Integer class. For reference Lang.Object and Lang.Number is above Integer
		Point<Double> point = new Point<>(1.1, 2.2);
		point.display(point);
	}

}
