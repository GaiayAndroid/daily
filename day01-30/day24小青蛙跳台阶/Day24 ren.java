package com.rent.mytestapplication.homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * Created by RenTao on 17/2/26.
 */
public class Daily {

    /**
     * day24 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    @Test
    public void daily24() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ": " + count(i));
        }
    }

    private int count(int length) {
        if (length == 1) {
            return 1;
        }
        int total = 0;
        // 统计1级阶梯到n-1级阶梯的次数
        for (int i = 1; i < length; i++) {
            total += count(i);
        }
        // 加上本身的一次
        return total + 1;
    }
}
