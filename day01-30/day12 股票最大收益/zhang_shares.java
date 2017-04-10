package com.rent.businesscard;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
//    每日一题 12 :假设有一支股票，在过去的一天里看到一组价格(单位;元)分别为[6,3,9,2,5,9,1,4,6]。
// 根据这组数据计算出，什么时候买入，什么时候卖出收益最大？比如这题答案为下标为3(2元)买入，
// 下标为5(9元)的时候卖出，收益最大。
    int[] arr = {6,3,9,2,5,9,1,4,6};
    int b = 0;
    int start;
    int end;

@Test
    public void getEarn(){
    for (int i = 0; i <arr.length ; i++) {
        for (int j = i; j <arr.length ; j++) {
            if (arr[j]-arr[i]>b ) {
                b = arr[j]-arr[i];
                start = i;
                end = j;
            }
        }
    }
    System.out.println("下标为"+start+"买入，"+"下标为"+end+"买出，"+"最大收益为"+b);

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