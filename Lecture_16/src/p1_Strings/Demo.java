package p1_Strings;
// 5/7/19
import java.util.HashSet;

public class Demo {

	public static void main(String[] args) {
		String name1 = "John"; //intern
//		String name2 = new String("John"); //commented out at 12:05
		String name2 = "John"; // reason the above was commented
		HashSet<String> nameSet = new HashSet<>();
		nameSet.add(name1);
		nameSet.add(name2);
		for(String s : nameSet) {
			System.out.println(s);
		}
	}
}
