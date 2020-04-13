package com.zh.suanfa.排序.快速排序;

import java.util.Arrays;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/25  10:21
 * @版本：
 */
public class FastTest {
    public static void main(String[] args) {
        int arr[] = {
//          6,1,2,7,9,3,4,5,10,8
//          6,1,2,7,9,3,4,5,10,12,11
//            5,4,3,7,6
                5,4,3,1,7,6
//                15, 14, 13, 6, 4, 29
        };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        if (i >= j) {
            return;
        }
        int temp = arr[i];
        while (i < j) {
            // 先走哨兵j
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }

        }
        // 如果只有两位数，就会出现 0,所以，
//        i = j;
       /* if (i != left) {
            arr[i] = arr[left] ^ arr[i];
            arr[left] = arr[left] ^ arr[i];
            arr[i] = arr[left] ^ arr[i];

        }*/
        arr [left] = arr[i];
        arr [i] = temp;
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}
