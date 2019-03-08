package merge;
// 3/7/2019  12:27 P.M.
public class MergeApp {

	public static void main(String[] args) {
		//first look at merging
		int[] arrayA = {1, 3, 6, 8, 10};
		int[] arrayB = {4, 7, 11, 13, 16, 17, 28, 31, 33};
		int[] arrayC = new int[arrayA.length + arrayB.length];
		// 12:28 P.M. again for ease of example, we have created the above arrays already pre sorted.
				//THIS WILL NOT WORK IF THE ARRAYS ARE NOT SORTED. 
		
		merge(arrayA, 5, arrayB, 9, arrayC);
		display(arrayC, arrayC.length);
	}

	private static void display(int[] array, int size) {
		// 12:42 P.M.
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
		//look at bottom notes for what a merge is
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		
		while(aIndex < sizeA && bIndex < sizeB) { //neither array (B or A) are finished
			if(arrayA[aIndex] < arrayB[bIndex]) {
				arrayC[cIndex++] = arrayA[aIndex++]; //if current index of A is smaller than B we put it into
						//arrayC at it's current index. While also incrementing both of their indexes
			} else {
				arrayC[cIndex++] = arrayB[bIndex++];
				//similar to the if part, this will do the same general thing. Only difference is if A's
				//index is equal to OR greater this will happen.
			}
		}
		
		while(aIndex < sizeA) { //this happens when arrayB is empty but arrayA is not
			arrayC[cIndex++] = arrayA[aIndex++];
		}
		
		while(bIndex < sizeB) { //the opposite of the previous while loop so we ensure everything gets copied
			arrayC[cIndex++] = arrayB[bIndex++];
		}
		
	}

}
/* What is a merge?
 * Say we have two arrays that we want to merge into one, while keeping it sorted.
 * To do this we will look at two ALREADY SORTED arrays, A and B, and put them into array C.
 * This will happen by comparing whatever index we may be at for A and B, then putting the smaller one
 * into array C. While also making sure that if A or B reach their respective end, that the other array
 * will just copy the rest of it's remaining data.
 * 
 * We know that the bigO value of this technique, is just n instead of n^2.
 */