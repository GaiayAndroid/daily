package homework;

import java.util.Arrays;

public class QuickSort {
	static int[] mArray = { 1, 8, 4, 7,4, 9, 5,5 };

	public static void quick(int[] array, int left, int right) {
		if(left < right){
			int k = split(array, left , right);
			quick(array ,left , k-1);
			quick(array , k+1, right);
		}
		
	}

	public static int split(int[] array, int left, int right) {
		int i = left - 1;
		int k = array[right];
		for (int j = left; j < right; j++) {
			if(array[j] < k){
				i++;
				swap(array, i, j);
			}
		}
		swap(array,right,i+1);
		return i +1;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		quick(mArray, 0, mArray.length-1);
		System.out.println(Arrays.toString(mArray));
	}

}
