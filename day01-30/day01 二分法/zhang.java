package com.rent.businesscard;


/**
 * ZY:
 * Created by zhanglibin.
 */

public class testDemo {
    private int[] arr = {2,3,4,5,6,7,8,9};
    private  int start = 0;
    private  int end = arr.length - 1;
    private  int index = - 1;

    public  void test(int a ,int[] arr){
        while (start !=end){
            int length = (start+end)/2;
            if (a == arr[length]) {
                index = length;
                break;
            } else if (a>arr[length]){
                start = length+1;
            }else if(a<arr[length]){
                end = length-1;
            }
        }

        if (index == -1){
            System.out.println("亲，当前数组没有这个值");
        }else {
            System.out.println("亲，这个值的index是："+index);
        }

    }

}
