package com.zh.light.collectiondemo.list;

import java.util.ArrayList;

/**
 * @描述： TODO  看 ArrayList 源码
 * @作者: Light
 * @时间: 2019/9/30  9:14
 * @版本：
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        Object o = arrayList.get(0);
        System.out.println(o);
    }
    // 测试无参构造
    private  static void t () {
        ArrayList<Integer> integers = new ArrayList<>();
        Integer integer = integers.get(0);
    }
}
