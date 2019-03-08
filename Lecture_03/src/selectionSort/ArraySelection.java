package selectionSort;
// 2/5/2019
public class ArraySelection {
	private int[] a;
	private int nElms;
	
	public ArraySelection(int max) {
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
	
	public void selecetionSort() {
		int out;
		int in;
		int min = 0; //index value of smallest number
		for (out = 0; out < nElms - 1; out++) {
			min = out;
			for(in = out + 1; in < nElms; in++) {
				if(a[in] < a[min]) {
					min = in;
				}
			}
			swap(out, min);
		}
	}

	private void swap(int one, int two) {
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}