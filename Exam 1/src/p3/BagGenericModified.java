package p3;

import java.util.Arrays;

public class BagGenericModified <T extends Student> {
	private T[] arr;
	private int numItems;
	
	@SuppressWarnings("unchecked")
	public BagGenericModified(int initialSize) {
		arr = (T[]) new Student[initialSize];
		numItems = 0;
	}
	
	public void addValue(T value) {
		arr[numItems++] = value;
	}
	
	public void display() {
		String guiStatus = "";
		for(int i = 0; i < numItems; i++) {
			guiStatus = guiStatus + String.valueOf(arr[i]) + "\n";
		}
		guiStatus = guiStatus.substring(0, guiStatus.length() - 1);
		System.out.println(guiStatus);
	}
	
	public void findGeneric(T value) {
		int count = -1;
		for(count = 0; count < numItems; count++) {
			if(value.compareTo((T) arr[count]) == 0) {
				break;
			}
		}
		if(count == numItems) {
			System.out.println("No match found.");
		} else {
			System.out.println("Match for " + value + " was found at index " + count);
		}
	}
	
	public void deleteGeneric(T value) {
		int count = -1;
		for(count = 0; count < numItems; count++) {
			if(value.compareTo((T) arr[count]) == 0) {
				break;
			}
		}
		if(count == numItems) {
			System.out.println("No match found.");
		} else {
			System.out.println("Match for " + value + " was found at index " + count + " and has been removed");
			for(int i = count; i < numItems - 1; i++) {
				arr[i] = arr[i + 1];
			}
			numItems--;
		}
	}
	
	public void sortByGPA() {
		Arrays.sort(arr);
	}
	
	public void sortByName() {
		Arrays.sort(arr, new StudentComparator());
	}

	public T[] getArr() {
		return arr;
	}

	public int getNumItems() {
		return numItems;
	}
}
