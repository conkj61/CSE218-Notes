package insertionSort;
// 2/7/19
public class Demo {
	
	public static void main(String[] args) {
		ArrayInsertion arr = new ArrayInsertion(10);
		arr.insert(5);
		arr.insert(9);
		arr.insert(4);
		arr.insert(3);
		arr.insert(1);
		arr.insert(8);
		arr.insert(7);
		arr.insert(2);
		arr.display();
		arr.insertionSort();
		arr.display();
	}
	
}