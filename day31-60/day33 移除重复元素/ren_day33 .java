package com.rent.mytestapplication.homework;

import org.junit.Test;

/**
 *
 * Created by RenTao on 17/2/26.
 */
public class Daily {

    /**
     * 给你一个长度为n的序列, 你需要：1.移除里面重复的元素2.保留最后出现的元素。
     */
    @Test
    public void daily33() {
        String str = "abccbbda";
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];
        for (int i = chars.length - 1; i >= 0 ; i--) {
            boolean existed = false;
            for (int j = i; j < result.length; j++) {
                if (chars[i] == result[j]) {
                    existed = true;
                }
            }
            if (!existed) {
                result[i] = chars[i];
            }
        }
        System.out.println(new String(result));
    }
}
