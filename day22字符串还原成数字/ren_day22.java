package com.rent.mytestapplication.homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by RenTao on 17/2/26.
 */
public class Daily {

    /**
     * 有一个系统，用来接收用户的输入的数字并转化成乱序的英文串，
     * 如：输入"1" 可能会得到"eon"或"one"或"noe"或"eno"
     * 输入"7" 可能会得到"seven"或"esnve"或...
     * 输入"17"可能会得到"seenovne"或"veenonse"
     * 现在你得到一个来自系统转化后的字符串，请你写出自己的算法，将其转化成原来的数字。要求：
     * 1.数字可以无序，但必须完整。
     * 2.时间复杂度尽可能小。
     * 如：你得到 "etohienngie"， 需要转化成 "819"或"918"或"189"...
     */
    @Test
    public void day22() {
        String[] numbers = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        String output = "";
        for (int i = 0; i < (int) (Math.random() * 3) + 1; i++) {
            output += numbers[(int) (Math.random() * numbers.length)];
        }
        System.out.println("output: " + output);

        // e: 0 1 3 5 7 8 9             9
        // f: 4 5                   5
        // g: 8                 8
        // h: 3 8                   3
        // i: 5 6 8 9                   9
        // n: 1 7 9                     9
        // o: 0 1 2 4               1
        // r: 0 3 4                 3
        // s: 6 7                   7
        // t: 2 3 8                 3
        // u: 4                 4
        // v: 5 7
        // w: 2                 2
        // x: 6                 6
        // z: 0                 0
//        for (char i = 'a'; i <= 'z'; i++) {
//            System.out.print(i + ": ");
//            for (int j = 0; j < numbers.length; j++) {
//                if (numbers[j].contains(i + "")) {
//                    System.out.print(j + " ");
//                }
//            }
//            System.out.println();
//        }

        // 1.如果包含z x w u g，则必定分别为0 6 2 4 8，这样就排除了这5个数字
        Map<Integer, Integer> step1 = new HashMap<>(5);
        step1.put((int) 'z', 0);
        step1.put((int) 'x', 6);
        step1.put((int) 'w', 2);
        step1.put((int) 'u', 4);
        step1.put((int) 'g', 8);
        // 2.如果包含f h o r s t，则必定为5 3 1 3 7 3，这样就排除了这4个数字
        Map<Integer, Integer> step2 = new HashMap<>(6);
        step2.put((int) 'f', 5);
        step2.put((int) 'h', 3);
        step2.put((int) 'o', 1);
        step2.put((int) 'r', 3);
        step2.put((int) 's', 7);
        step2.put((int) 't', 3);
        // 3.如果包含e i n，则必定为9
        Map<Integer, Integer> step3 = new HashMap<>(3);
        step3.put((int) 'e', 9);
        step3.put((int) 'i', 9);
        step3.put((int) 'n', 9);

        Map<Integer, Integer> count = new HashMap<>();
        for (char c : output.toCharArray()) {
            Integer num = count.get((int) c);
            if (num == null) {
                num = 0;
            }
            num++;
            count.put((int) c, num);
        }
        String result = "";
        result += parse(count, step1, numbers);
        result += parse(count, step2, numbers);
        result += parse(count, step3, numbers);
        System.out.println("number is " + result);
    }

    private String parse(Map<Integer, Integer> count, Map<Integer, Integer> step, String[] numbers) {
        String result = "";
        for (Map.Entry<Integer, Integer> excludeEntry : step.entrySet()) {
            // 查看字符串中是否包含指定(step.getKey())的字符
            Integer size = count.get(excludeEntry.getKey());
            while (size != null && size > 0) {
                // 存在的话，取出该数字对应的英文字母（numbers[excludeEntry.getValue()]）
                // 遍历每个字母，并从去除count中对应的字母，每次去除一个
                for (char c : numbers[excludeEntry.getValue()].toCharArray()) {
                    int remain = count.get((int) c) - 1;
                    count.put((int) c, remain);
                }
                result += excludeEntry.getValue();

                size = count.get(excludeEntry.getKey());
            }
        }
        return result;
    }
}
