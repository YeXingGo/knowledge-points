package com.zh.suanfa.排序.插入排序;

import java.util.Arrays;

/**
 * @描述： TODO  插入排序
 * @作者: Light
 * @时间: 2019/12/5  16:06
 * @版本：
 */
public class InsertSort {
    public static void main(String[] args) {
         int [] arr = {3,44,38,5,47,15,36,26};
        System.out.println(Arrays.toString(arr));
        sortMaxToMin(arr);
        System.out.println(Arrays.toString(arr));
        int a = 1 , b = 2;
        a = a ^ b ;
        b = a ^ b ;
        a = a ^ b ;
        System.out.println(a);
        System.out.println(b);
    }
    // 从小到大
    private  static void  sortMaxToMin(int[] arr) {
        for (int i = 1; i <= arr.length -1 ; i ++) {
            int index = i;
            for (int j = i - 1; j >= 0 ; j-- ) {
                if (arr[index] < arr[j]) {
                    arr[index] = arr[index] ^ arr[j];
                    arr[j] = arr[index] ^ arr[j];
                    arr[index] = arr[index] ^ arr[j];
                    index = j;
                }
                else {
                    break;
                }
            }
        }
    }
}
