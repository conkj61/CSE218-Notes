package p2;

public class Bag <T extends Comparable<T>> {
	private Object[] arr;
	private int numItems;
	
	public Bag(int initialSize) {
		arr = new Object[initialSize];
		numItems = 0;
	}
	
	public void addValue(T value) {
		arr[numItems++] = value;
	}
	
	public String display() {
		String guiStatus = "";
		for(int i = 0; i < numItems; i++) {
			guiStatus = guiStatus + String.valueOf(arr[i]) + ", ";
		}
		guiStatus = guiStatus.substring(0, guiStatus.length() - 2);
		return guiStatus;
	}
	
	@SuppressWarnings("unchecked")
	public T findMax() {
		T max = (T) arr[0];
		for(int i = 1; i < numItems; i++) {
			if(max.compareTo((T) arr[i]) < 0) {
				max = (T) arr[i];
			}
		}
		return max;
	}
	
	@SuppressWarnings("unchecked")
	public T findMin() {
		T min = (T) arr[0];
		for(int i = 1; i < numItems; i++) {
			if(min.compareTo((T) arr[i]) > 0) {
				min = (T) arr[i];
			}
		}
		return min;
	}
	
	@SuppressWarnings("unchecked")
	public void insertionSort() {
		int in, out;

		for(out = 1; out < numItems; out++) {
			T temp = (T) arr[out];
			in = out;
			while(in > 0 && ((T) arr[in-1]).compareTo(temp) >= 0) {
				arr[in] = arr[in - 1];
				in--;
			}
			arr[in] = temp;
		}
	}

	public Object[] getArr() {
		return arr;
	}

	public int getNumItems() {
		return numItems;
	}
	
}