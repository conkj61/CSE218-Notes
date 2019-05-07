package shellSort;
//  3/21/19  12:35
public class Demo {

	public static void main(String[] args) {
		//demo to test shellSort from ArrayShell class
		ArrayShell arr = new ArrayShell(10);
		arr.insert(7);
		arr.insert(10);
		arr.insert(1);
		arr.insert(9);
		arr.insert(2);
		arr.insert(5);
		arr.insert(8);
		arr.insert(6);
		arr.insert(4);
		arr.insert(3);
		
		arr.display();
		arr.shellSort();
		arr.display();
	}

}
