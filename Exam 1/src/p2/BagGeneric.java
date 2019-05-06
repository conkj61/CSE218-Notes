package p2;

public class BagGeneric <T extends Comparable<T>> {
	private Object[] arr;
	private int numItems;
	
	public BagGeneric(int initialSize) {
		arr = new Object[initialSize];
		numItems = 0;
	}
	
	public void addValue(T value) {
		arr[numItems++] = value;
	}
	
	public void display() {
		String guiStatus = "";
		for(int i = 0; i < numItems; i++) {
			guiStatus = guiStatus + String.valueOf(arr[i]) + ", ";
		}
		guiStatus = guiStatus.substring(0, guiStatus.length() - 2);
		System.out.println(guiStatus);
	}
	
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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

	public Object[] getArr() {
		return arr;
	}

	public int getNumItems() {
		return numItems;
	}
	
}