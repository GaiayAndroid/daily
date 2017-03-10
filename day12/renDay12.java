package com.rent.mytestapplication.homework;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * Created by RenTao on 17/2/26.
 */
public class Daily {

    private int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (size * Math.random());
        }
        return arr;
    }

    /**
     * 假设有一支股票，在过去的一天里看到一组价格(单位;元)分别为[6,3,9,2,5,9,1,4,6]。
     * 根据这组数据计算出，什么时候买入，什么时候卖出收益最大？比如这题答案为下标为3(2元)买入，下标为5(9元)的时候卖出，收益最大。
     */
    @Test
    public void day12() {
//        int[] arr = { 6, 7, 9, 8, 5, 9, 2, 8, 6 };
        int[] arr = randomArray(8);
        System.out.println(Arrays.toString(arr));
        int low = -1, high = -1, tempLow = -1, tempHigh = -1;
        for (int i = 0; i < arr.length; i++) {
            if (tempLow < 0 || tempLow > arr[i]) {
                tempLow = arr[i];
            } else if (tempHigh < 0 || (arr[i] - tempLow > high - low)) {
                low = tempLow;
                high = tempHigh = arr[i];
            }
//            System.out.println("tempLow: " + tempLow + " tempHigh: " + tempHigh + " low: " + low + " high: " + high);
        }
        System.out.println(low + " " + high);
    }

}
