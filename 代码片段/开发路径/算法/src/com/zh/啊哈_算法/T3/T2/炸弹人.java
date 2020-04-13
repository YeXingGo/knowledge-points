package com.zh.suanfa.啊哈_算法.T3.T2;

import java.util.Date;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/2  9:41
 * @版本：
 */
public class 炸弹人 {
    public static void main(String[] args) throws Exception{
        String  a = "#";
        String b = ".";
        String c = "G";
        String [][]  arr = new String[20] [21];
        String  [] arr1 =  {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr2 =  {a,c,c,b,c,c,c,a,c,c,c,b,a};
        String  [] arr3 =  {a,a,a,b,a,c,a,c,a,c,a,c,a};
        String  [] arr4 =  {a,b,b,b,b,b,b,b,a,b,b,c,a};
        String  [] arr5 =  {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr6 =  {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr7 =  {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr8 =  {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr9 =  {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr10 = {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr11 = {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr12 = {a,a,a,a,a,a,a,a,a,a,a,a,a};
        String  [] arr13 = {a,a,a,a,a,a,a,a,a,a,a,a,a};
//        arr[0] = a;
        synchronized (炸弹人.class) {
            new 炸弹人().wait(12);
        }
        System.out.println(123434);
        System.out.println(new Date().getDate());
    }
}
