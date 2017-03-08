import org.junit.Test;

import java.util.Arrays;

/**
 * Created by RenTao on 17/2/26.
 */

public class Daily {

    /**
     * 快速排序
     */
    @Test
    public void testQuickSort() {
        int[] arr = randomArray(10);
        System.out.println("origin: " + Arrays.toString(arr));
        int start = 0, end = arr.length - 1;
        quickSort(arr, start, end);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int keyIndex = splitArray(arr, start, end);
        quickSort(arr, start, keyIndex - 1);
        quickSort(arr, keyIndex + 1, end);
    }

    private int splitArray(int[] arr, int start, int end) {
        int keyIndex = start, key = arr[keyIndex];
        while (start != end) {
            while (end > start) {
                if (key > arr[end]) {
                    swap(arr, keyIndex, end);
                    keyIndex = end;
                    break;
                }
                end--;
            }

            while (end > start) {
                if (key < arr[start]) {
                    swap(arr, keyIndex, start);
                    keyIndex = start;
                    break;
                }
                start++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return keyIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (size * Math.random());
        }
        return arr;
    }

}