package com.zl.design.patterns.Internal;

import java.util.Date;

/**
 * @描述： TODO 测试内部的加载顺序
 * @作者: Light
 * @时间: 2019/8/24  23:14
 * @版本：
 */
public class InternalTest {
    public  InternalTest() {
//        System.out.println("InternalTest ......");
    }
   /*static*/ class A {
       /* static {
            System.out.println("A ..static..........");
        }*/
        public  A () {
//            System.out.println("A ............");
        }
    }

    public static void main(String[] args) {
        InternalTest internalTest = new InternalTest();
        //静态调用
//        InternalTest.A  a =  new InternalTest.A();
        //动态调用
        InternalTest.A  b = internalTest.new A ();
//        System.out.println("1237");
        String s = null;
        System.out.println(s);
        System.out.println(new Date());  //你是记忆 //&&&&*
    }
}
