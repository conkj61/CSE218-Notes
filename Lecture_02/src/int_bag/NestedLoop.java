package int_bag;
// 1/31/19
public class NestedLoop {
	
	public static void main(String[] args) {
		int n = 10;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			System.out.println("i = " + i);
		} /*this whole loop's big O is N^2. This is because everytime the outer loop (i), is run once
			the inner loop (j) has to run 10 times. */
	}
}
