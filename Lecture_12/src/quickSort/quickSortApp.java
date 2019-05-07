package quickSort;

public class quickSortApp {

	public static void main(String[] args) {
		ArrayQuick arr = new ArrayQuick(16);
		for(int i = 0; i < 16; i++) {
			long n = (int)(Math.random() * 199);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
	}

}
