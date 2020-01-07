package com.zh.light.collectiondemo.list.likeedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/23  8:52
 * @版本：
 */
public class LikedListTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1,1);
        integerIntegerHashMap.put(1,2);
        System.out.println(integerIntegerHashMap.get(1));
        System.out.println("---------------------");


        LinkedListLight<Integer> integers = new LinkedListLight<>();
        integers.add(1);
        for (Integer i : integers){
            System.out.println(i);
        }
        /*integers.add(1);
        integers.add(2);
        integers.add(null);
        System.out.println(integers.get(0));
        System.out.println(integers.get(1));*/
        System.out.println(integers.contains(null));
        easyLinkedList();
    }
    public static void easyLinkedList () {
          LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        for (Integer i : linkedList) {
            System.out.println(i);
        }

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));

    }
    public static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(4,5);// 添加到指定下标
        System.out.println("11263");
        System.out.println(linkedList.set(4, 10));
        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.toString());

        System.out.println(linkedList.element()); // 返回第一个值
        System.out.println(linkedList.peek());   // 返回第一个值
        System.out.println(linkedList.getFirst()); // 返回第一个值
        System.out.println(linkedList.getLast()); // 返回之后一个值
        System.out.println(linkedList.offer(6)); // 在最后加上
        System.out.println(linkedList.offerFirst(0));// 在开头添加 数字 0
        System.out.println(linkedList.offerLast(7)); // 在结尾添加 数字 7
        System.out.println(linkedList.poll());// 弹出开头的值，
        System.out.println(linkedList.pollLast());// 弹出结尾的值

        System.out.println(linkedList.toString());
    }
}
