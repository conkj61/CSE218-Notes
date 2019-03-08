package objectSorting;
// 2/7/19
public class ArrayInOb {
	private Person[] a;
	private int nElems;
	
	public ArrayInOb(int maxSize) {
		a = new Person[maxSize];
		this.nElems = 0;
	}
	
	public void insert(String last, String first, int age) {
		a[nElems++] = new Person(last, first, age);
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			a[i].displayPerson();
			System.out.println();
		}
	}
	
	public void insertionSort() {
		int in;  //while loop
		int out; //for loop
		
		for(out = 1; out < nElems; out++) {
			Person temp = a[out];
			in = out;
			
			while(in > 0 && a[in - 1].getLast().compareTo(temp.getLast()) > 0) { //in is our index to sort down from
				//the greater than zero means, the last name is longer(?) than the one we are comparing to
				//it is compared by unicode value!!! that is why this works even of varying/equal length names
				a[in] = a[in - 1];
				in--;
			}
			a[in] = temp;
		}
	}
	
}
