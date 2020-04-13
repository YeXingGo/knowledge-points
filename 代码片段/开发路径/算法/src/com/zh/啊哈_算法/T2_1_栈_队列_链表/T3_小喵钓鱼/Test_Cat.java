package com.zh.suanfa.啊哈_算法.T2_1_栈_队列_链表.T3_小喵钓鱼;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/28  8:54
 * @版本：
 */
public class Test_Cat {
    public static void main(String[] args) {
       test();
    }
    public static void testMethod () {

        int [] stack1 = {1,2};
        Stack stack = new Stack();
        stack.stack =  stack1;
        System.out.println(isEquals(stack, 1));
        System.out.println(isEquals(stack, 2));
        System.out.println(isEquals(stack, 0));
        System.out.println(stack.top++);
        System.out.println(stack.top);
    }

    public static void test () {
        Queue q1 = new Queue();

        Queue q2 = new Queue();
        Stack stack = new Stack();
        init(q1);
        System.out.println("小============");
        init(q2);

        while (q1.head < q1.tail && q2.head < q2.tail ) {
            int t = 0;
            t = q1.data[q1.head];
            int result = isEquals(stack, t);
            // 说明是没有匹配成功
            if (result == -1) {
                stack.stack[stack.top] = t;
                q1.head ++;
                stack.top ++;
            }
            // 说明是成功的
            else {
                // 把当前的值放入到 stack中，
                stack.stack [stack.top] = t;
                stack.top ++;
                q1.head ++;
                for (int i = stack.top - 1; i >= result; i--) {
                    q1.data[q1.tail] = stack.stack[i];
                    stack.top --;
                    q1.tail ++;
                }
            }
            t = q2.data[q2.head];
            result = isEquals(stack, t);
            // 说明是没有匹配成功
            if (result == -1) {
                stack.stack[stack.top] = t;
                q2.head ++;
                stack.top ++;
            }
            // 说明是成功的
            else {
                stack.stack [stack.top] = t;
                stack.top ++;
                q2.head ++ ;
                for (int i = stack.top - 1 ; i >= result; i--) {
                    q2.data[q2.tail] = stack.stack[i];
                    stack.top --;
                    q2.tail ++;
                }
            }
        }
        if (q2.head == q2.tail) {
            System.out.println("小 哈q1胜");
        }
        else if(q1.head == q1.tail) {
            System.out.println("小 哼q2胜");

        }
        else {
            System.out.println("死局");
        }
        System.out.println(Arrays.toString(q1.data) +" head ="+ q1.head + "tail ="+ q1.tail);
        System.out.println(Arrays.toString(q2.data) +" head ="+ q2.head + "tail ="+ q2.tail);
    }
    /* @Author Light
     * @Description //TODO  初始化 小哈 和 小哼
     * @Date 9:02 2019/11/28
     * @Param [queue]
     * @return void
     **/
    public static void init (Queue queue) {
        Scanner sc = new Scanner(System.in);
        // 每人6张牌
        for(int i = 1; i <= 2; i++) {
            System.out.println("请输入 1 - 9 的数字");
            queue.data[i] = sc.nextInt();
            queue.tail += 1 ;
        }

    }

    public static int isEquals (Stack stack,int value) {
        boolean flag = false;
        int index = 0;
        for (int i : stack.stack) {
            if (i == value) {
                flag = true;

                break;
            }
            index ++;
        }
        if (!flag) {
            index = -1;
        }
        return index;
    }
}
