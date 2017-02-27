package com.rent.businesscard;


import org.junit.Test;

/**
 * ZY:
 * Created by zhanglibin.
 */

public class testDemo {
    private int[] arr = {5, 2, 9, 8, 6, 4, 3};
    private int c;
@Test
    public void formSmall() {
        for (int i = arr.length; i > 0; i--) {
            for (int b = 0; b < i - 1; b++) {
                if (arr[b] > arr[b + 1]) {
                    c = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = c;

                }
            }
        }

    }
@Test
    public void formMax() {
        for (int i = arr.length; i > 0; i--) {
            for (int b = 0; b < i - 1; b++) {
                if (arr[b] < arr[b + 1]) {
                    c = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = c;

                }
            }
        }

    }

}
