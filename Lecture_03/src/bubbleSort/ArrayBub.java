package bubbleSort;
// 2/5/2019
public class ArrayBub {
	private int[] a;
	private int nElms;
	
	public ArrayBub(int max) {
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
	
	public void bubbleSort() {
		int out;
		int in;
		for (out = nElms - 1; out >= 1; out--) {
			for(in = 0; in < out; in++) {
				if(a[in] > a[in + 1]) {
					swap(in, in + 1);
				}
			}
		}
	}

	private void swap(int one, int two) {
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}