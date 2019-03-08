package generics_upperBoundConstraints;
// 2/28/19
public class Demo {

	public static void main(String[] args) {
		Point<Integer> p1 = new Point<>(1, 2); //just re-showing no constraint
//		Point<String> p2 = new Point<>("1", "2"); //12:53 P.M. we show that point can no longer accept strings
//						//or anything not included in the subclasses of Number
					//We have placed an "upperbound" on our generic class
		p1.display(p1);
	}

}
/* Constraints - limit the things our generic classes can use.
 * An upperbound tells our class that it cannot use any superclass to our class.
 * A lowerbound tells our class that it cannot use any subclasses of it.
 * both use the "extends" keyword, "extends" doesn't actually have to mean inheritance
 * it is about imposing upperbound constraints.
 */