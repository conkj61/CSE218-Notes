package generic_class;
// 2/28/19  12:33 P.M.
public class Demo {

	public static void main(String[] args) {
		//showcase our generic class
//		Point p1 = new Point(1.1, 2.2);
//		System.out.println(p1);
		
//		Point<String> p1 = new Point<>("1.1", "2.2"); //but ideally, we should try to specify what type we want
//				//when actually using generics
//		System.out.println(p1);
		
		Point<String, Double> p1 = new Point<>("1.1", 2.2); //12:40 P.M. this obeys our new way of generics,
						//being able to use two different types
		System.out.println(p1);
	}

}
