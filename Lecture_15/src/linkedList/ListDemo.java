package linkedList;
// 5/2/19
import java.util.LinkedList;
import java.util.ListIterator;

public class ListDemo {
	//this will demonstrate API incoperated in Java instead of using out own.
	public static void main(String[] args) {
		LinkedList<String> staff = new LinkedList<>();
		staff.add("Diana");
		staff.add("Harry");
		staff.add("Romeo");
		staff.add("Tom");
		
		// 12:48
		// I = iterator, D = Diana, H = Harry, etc
		// each comment will show where the iterator and names are
		ListIterator<String> iterator = staff.listIterator(); // IDHRT
		iterator.next(); //DIHRT
		iterator.next(); //DHIRT
		
		iterator.add("Juliet"); //DHJIRT
		
		iterator.next(); //DHJRIT
		iterator.remove(); //DHJIT
		// 12:52 the above line removes the value before the iterator (Romeo for this case)
		
		System.out.println(staff);
	}

}
