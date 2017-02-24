package homework;

import java.util.Arrays;

/**
 * ¶þ·Ö·¨
 */
public class Day1 {
	private static int[] initData() {
		int len = 10;
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * len);
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + "_" + arr[i] + "; ");
		}
		System.out.println();
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = initData();
//		int target = arr[(int) (Math.random() * arr.length)];
		int target = (int) (Math.random() * arr.length);
		System.out.println("target: " + target);
		int start = 0, end = arr.length;
		int mid = arr.length / 2;
		int index = -1;
		while (end > start) {
			System.out.println("arr[mid]: " + arr[mid] + ", start: " + start + ", mid: " + mid + ", end: " + end);
			if (target < arr[mid]) {
				end = mid - 1;
				mid = (start + end) / 2;
			} else if (target > arr[mid]) {
				start = mid + 1;
				mid = (start + end) / 2;
			} else {
				index = mid;
				break;
			}
			System.out.println("start: " + start + ", mid: " + mid + ", end: " + end);
		}
		System.out.println("index: " + index);
	}
}
