package genericSequentialSearch;
// 3/5/19  12:14 P.M.
public class GenericSearchArray {
	public static void main(String[] args) {
		String[] letters = {"A", "B", "C", "D"};
		Integer[] numbers = {1, 2, 3, 4, 5, 6};
		System.out.println(sequentialSearch(letters, "c"));
		System.out.println(sequentialSearch(numbers, 4));
	}
	
	public static <E extends Comparable<E>> int sequentialSearch(E[] array, E value) {
		//12:26  changed <E> to <E extends Comparable<E>> see below
		//12:16  There is a slight problem here, we need to do a comparison when we search
		int index = 0;
		int position = -1;
		boolean found = false;
		
		while(!found && index < array.length) {
			if(array[index].compareTo(value) == 0) { //12:19 compareTo doesn't compile. Why?
						//We don't have a standard way to compare things that is applicable to everything
						//So we instead will use the interface with a constraint
					//12:26 in generic <E> we added "extends Comparable<E>, which is an upper bound constraint
					//this allowed our compareTo to compile now that it will definitely be comparable
				found = true;
				position = index;
			}
			index++;
		}
		return position;
	}
}
