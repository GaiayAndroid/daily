package demo;

import java.util.Arrays;

public class day02 {
	public static void main(String[] args) {
		bubble();
		System.out.println(Arrays.toString(sData));
		System.out.println(times);
	}

	public static int[] sData = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	public static int times = 0;

	public static void bubble() {
		boolean flag = false;
		for (int i = 0; i < sData.length / 2; i++) {
			for (int j = i; j < sData.length - i-1; j++) {
				if (sData[j] < sData[j + 1]) {
					swap(j, j + 1);
					flag = true;
				}
				if (sData[sData.length - j - 1] > sData[sData.length - j - 2]) {
					swap(sData.length - j - 1, sData.length - j - 2);
					flag = true;
				}
				times++;
			}
			if (flag) {
				flag = false;
			} else {
				break;
			}
		}
	}

	public static void swap(int indexA, int indexB) {
		int temp = sData[indexA];
		sData[indexA] = sData[indexB];
		sData[indexB] = temp;
	}
}
