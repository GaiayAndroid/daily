package com.rent.businesscard;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
//    每日一题:把一个给定一个字符串，字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。给出你的算法，然后求出算法的时间复杂度。例如：
//    OkhaoPingCeilXu 转换后 khaoingeiluOPCX
    String s = "OkhaoPingCeilXu";
    int b = 0;

@Test
    public void buildString(){
        char[] stringArr = s.toCharArray();
    for (int i = 0; i <stringArr.length-1 ; i++) {
        if (String.valueOf(stringArr[i]).matches("[A-Z]") && (stringArr.length - i) !=b){
            b++;
            char a = stringArr[i];
            for (int j = i; j <stringArr.length-1 ; j++) {
                stringArr[j]=stringArr[j+1];
            }
            stringArr[stringArr.length-1] = a;
        }

    }
    for (int i = 0; i < stringArr.length; i++) {
        System.out.println(stringArr[i]+"长度"+stringArr.length);
    }

    }


















//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
//    每日一题：用快速排序对一个无序数组进行排序
//    int[] arr = {5,3,9,7,6,4,2,1,};
//  List<Integer> list = new ArrayList<>();
//    List<Integer> small = new ArrayList<>();
//    List<Integer> max = new ArrayList<>();
//    int pivot = arr[0];
//    int a,b;
//    @Test
//    public void toRank(){
//        //将数组转化为List
//        for (int i = 0; i <arr.length ; i++) {
//            list.add(arr[i]);
//        }
//        //以pivot为基准将List 分为俩个
//        for (int i = 0; i <list.size() ; i++) {
//            if (list.get(i) <= pivot) {
//                small.add(list.get(i));
//            }else {
//                max.add(list.get(i));
//            }
//        }
//        //对small 进行排序
//        for (int i = 0; i <small.size() ; i++) {
//            for (int j = 0; j <small.size()-1-i ; j++) {
//                if (small.get(j) > small.get(j + 1)) {
//                    a = small.get(j);
//                    b = small.get(j + 1);
//                    small.remove(j);
//                    small.remove(j);
//                    small.add(j,a);
//                    small.add(j,b);
//                }
//            }
//        }
//        //对max 进行排序
//        for (int i = 0; i <max.size() ; i++) {
//            for (int j = 0; j <max.size()-1-i ; j++) {
//                if (max.get(j) > max.get(j + 1)) {
//                    a = max.get(j);
//                    b = max.get(j + 1);
//                    max.remove(j);
//                    max.remove(j);
//                    max.add(j,a);
//                    max.add(j,b);
//                }
//            }
//        }
//        for (int i = 0; i <max.size()-1 ; i++) {
//            small.add(small.size(),max.get(i));
//        }
//        for (int i = 0; i <small.size() ; i++) {
//            System.out.println(small.get(i));
//        }
//    }

}