package com.rent.businesscard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/24.
 */

public class test {
    private String str = "adfadfsgle";

    @Test
    public void test() {
        byte[] arr = str.getBytes();
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size()-1; j++) {
                if (list.get(i).equals(list.get(j + 1))) {
                    list.remove(j + 1);
                }

            }
        }
        System.out.println(list.size());

    }


}
