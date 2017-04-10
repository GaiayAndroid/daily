package com.rent.businesscard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * day 05  homework
 * Created by lenovo on 2017/2/24.
 */

public class test {
    private String str = "abcabcbb";
    int length;
    boolean b =false;

    @Test
    public void test() {
        byte[] arr = str.getBytes();
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        ;
        int size = list.size();
        List<Byte> listByte = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (listByte.size() == 0) {
                listByte.add(list.get(i));
            } else {
                for (int j = 0; j <listByte.size() ; j++) {
                    if (list.get(i).equals(listByte.get(j))) {
                        b = true;
                        break;
                    }
                }
                if (b) {
                    if (listByte.size()>length) {
                        length = listByte.size();
                    }
                    listByte.clear();
                    listByte.add(list.get(i));
                    b = false;
                }else {
                    listByte.add(list.get(i));
                }
            }
        }
        System.out.println(length);

    }


}
