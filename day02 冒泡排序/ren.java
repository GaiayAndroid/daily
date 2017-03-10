package homework;

/**
 * Ã°ÅİÅÅĞò
 */
public class Day2 {
	private static int[] initData() {
		int len = 10;
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * len);
			System.out.print(i + "_" + arr[i] + "; ");
		}
		System.out.println();
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = initData();
		sort(arr, true);
		sort(arr, false);
	}
	
	private static void sort(int[] arr, boolean asc) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if ((asc && arr[j] > arr[j + 1]) // ÉıĞò
						|| (!asc && arr[j] < arr[j + 1])) { // ½µĞò
					swap(arr, j, j + 1);
				}
			}
		}
		System.out.print(asc ? "asc: " : "desc: ");
		printArr(arr);
	}
	
	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + "_" + arr[i] + "; ");
		}
		System.out.println();
	}
	
	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}
