package com.song.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zz on 2017/4/23.
 *
 */

public class Day33 {

    /**
     * 给你一个长度为n的序列, 你需要：1.移除里面重复的元素2.保留最后出现的元素。
     */

    public  int[] makeData() {
        return new int[]{1, 2, 3, 4, 1, 1, 1};
    }

    @Test
    public  void main() {
        int[] data = makeData();
        List<Integer> list = new ArrayList<>();

        for (int j = data.length - 1; j >= 0; j--) {
            if (!list.contains(data[j])) {
                list.add(data[j]);
            }
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            System.out.println(list.get(j));
        }
    }


}
