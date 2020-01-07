package com.zh.light.collectiondemo.list.test;

import java.util.Arrays;
import java.util.List;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/8  22:59
 * @版本：
 */
public class CollectionTest {
    public static void main(String[] args) {
        /*List<int[]> ints = Arrays.asList(new int[]{1, 2});
        List<Integer> integers = Arrays.asList(1, 2, 3);
        for(Integer integer : integers) {
            System.out.println(integer);
        }*/
        test(1,2,3);
        /*test(1,2,3);
        System.out.println("--------------------");
        test("a","b");*/
    }
    private static <E> void test(E ... a) {
        for (E b:a) {
            System.out.print(b+" ");
        }
    }
}
