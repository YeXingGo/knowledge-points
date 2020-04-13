package com.zh.suanfa.分享.最长连续递增子序列;

import java.util.Arrays;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/24  9:08
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        int [] array = {1,9,2,5,7,3,4,6,8,0};
        System.out.println(Arrays.toString(getArray(array)));
    }
    public static int[] getArray (int [] array) {
        int begin = 0;   // 是 表示 每段递增的开始 （最后）
        int end = 0;   // 结束 （最后）
        int num =  0;  // 最大的递增长度
        int left = 0;  // 每段的开始
        for (int i = 1 ; i < array.length ; i ++) {
            if (array [i] < array[i - 1]) {
                int length = i - left ;
                if (length > num) {
                    num = length;
                    begin = left;
                    end = i - 1;
                }
                left = i;
            }
        }
        int arrays [] = new int[num];
        for (int i = 0; i < arrays.length;i ++) {
            arrays [i] = array[begin++];
        }
        return arrays;
    }
}
