package com.zh.light.collectiondemo.map.hash;

import java.util.HashMap;

/**
 * @描述： TODO  测试HashMap
 * @作者: Light
 * @时间: 2019/11/1  8:57
 * @版本：
 */
public class HashMapTest {
    public static void main(String[] args) {
        String key = "C:\\Program Files\\Java\\jdk1.8.0_201\\jre\\bin\\instrument.dll";
        int h ;
        System.out.println(key.hashCode());
        System.out.println("C:\\Program Files\\Java\\jdk1.8.0_201\\jre\\bin\\instrument.dll".hashCode());
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));


        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1",1);
        hashMap.put("1",2);
        System.out.println(hashMap.toString());
    }
}
