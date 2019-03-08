package insertionSort;
// 2/7/19
public class ArrayInsertion {
	private int[] a;
	private int nElms;
	
	public ArrayInsertion(int max) {
		a = new int[max];
		nElms = 0;
	}
	
	public void insert(int n) {
		a[nElms++] = n;
	}
	
	public void display() {
		for(int i = 0; i < nElms; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public void insertionSort() {
		int in;
		int out;

		for(out = 1; out < nElms; out++) {
			int temp = a[out];
			in = out;
			while(in > 0 && a[in-1] >= temp) {
				a[in] = a[in - 1];
				in--;
			}
			a[in] = temp;
		}
	}
	
}
