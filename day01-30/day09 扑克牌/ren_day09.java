package com.rent.mytestapplication.homework;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * Created by RenTao on 17/2/26.
 */
public class Daily {

    /**
     * 从扑克牌中随机抽 5 张牌,判断是不是顺子,即这 5 张牌是不是连续的。
     * 2-10 为数字本身,A 为 1,J 为 11,Q 为 12,K 为 13,而大小王可以看成任意的数字。
     */
    @Test
    public void fivePokers() {
        isStraight(new int[] { 6, 7, 8, 10, 13 });
        isStraight(new int[] { 9, 11, 8, 10, 12 });

        isStraight(new int[] { 6, 7, 3, 0, 5 });
        isStraight(new int[] { 6, 7, 8, 0, 5 });
        isStraight(new int[] { 6, 7, 8, 0, 13 });
    }

    private void isStraight(int[] picked) {
        System.out.println("picked: " + Arrays.toString(picked));
        bubbleSort(picked, true);
        // 是否有王牌
        boolean ghost = false;
        // 是否是顺子
        boolean straight = true;
        int length = picked.length - 1;
        for (int i = 0; i < length; i++) {
            if (i == 0 && picked[i] == 0) {
                ghost = true;
            } else if (picked[i] + 1 == picked[i + 1]) {

            } else if (ghost && i < length - 1) {
                ghost = false;
            } else {
                straight = false;
                break;
            }
        }
        System.out.println("picked is" + (straight ? "" : " not") + " straight");
    }

    private void bubbleSort(int[] arr, boolean asc) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if ((asc && arr[j] > arr[j + 1]) // 升序
                        || (!asc && arr[j] < arr[j + 1])) { // 降序
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.print(asc ? "asc: " : "desc: ");
        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
