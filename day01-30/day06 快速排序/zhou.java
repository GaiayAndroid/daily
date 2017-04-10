package com.example.zc.dometest;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2��27�գ��ÿ��������һ�����������������
 * <p>
 * Created by zc on 2017/3/5.
 */

public class TestDemo {
    int[] ints = {12, 22, 1, 5, 4, 54, 5, 94, 16, 14, 64, 2, 36, 9, 12};
    //2��27�գ��ÿ��������һ�����������������
    @Test
    public void test() {
//        sort(ints, 0, ints.length - 1);
        speedySort(ints, 0, ints.length - 1);
//        sort1(ints,0,ints.length - 1);
    }

    private void speedySort(int[] arrays, int start, int end) {

        int key = arrays[start];
        int s = start;
        int e = end;
        System.out.println("key = " + key + ",s = " + s + ",e = " + e);
        while (s < e) {
            while (key < arrays[e] && s < e) {
                e--;
            }
            if (key > arrays[e]) {
                int team = arrays[e];
                arrays[e] = arrays[s];
                arrays[s] = team;

            }
            System.out.println("key = " + key + ",e = " + e + ",arrays�Ӻ��� = " + Arrays.toString(arrays));
            while (key >= arrays[s] && s < e) {
                s++;
            }
            if (key <= arrays[s]) {
                int team = arrays[s];
                arrays[s] = arrays[e];
                arrays[e] = team;
            }
            System.out.println("key = " + key + ",s = " + s + ",arrays ��ǰ��= " + Arrays.toString(arrays));
            System.out.println("----------------------");


        }
        if (s > start) {
            speedySort(arrays, start, s - 1);
        }
        if(e < end && end == ints.length - 1){
            System.out.println("���Ұ�� =="+"key = " + key + ",s = " + s + ",stat = " + start + ",e = " + e + ", end = " + end );
        }
        if (e < end) {
            speedySort(arrays, e + 1, end);
        }
    }
}
