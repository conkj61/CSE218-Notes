package shellSort;
//  3/21/19 12:23 P.M.
public class ArrayShell {
	private long[] theArray;
	private int nElems;
	
	public void shellSort() { //12:28 P.M. new material regarding shell sort begins here
		int inner;
		int outer;
		long temp;
		int h = 1;
		
		while(h < nElems/3) { //method to calculate the first gap
			h = h * 3 + 1; //calculate new gap
		} //when we get out of the first gap, that mean we have found the gap between indecies
		
		while(h > 0) {
			for(outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;
				
				while(inner > h - 1 && theArray[inner - h] >= temp) {
					theArray[inner] = theArray[inner - h]; //swap occurs
					inner -= h;
				}
				theArray[inner] = temp;
			} //end of for loop
			h = (h - 1)/3;
		} //end of outer while
		
	} //end of shellSort
	
	public ArrayShell(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems++] = value;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println();
	}
}
