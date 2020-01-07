package com.zh.light.collectiondemo.list.testT;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.List;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/10  23:41
 * @版本：
 */
public class A {
    public static <T> C<T> asList(T ... a)  {
        B<T> objectB = new B<T>(a);
        objectB.aggg(a);
        T a1 = objectB.getA(0);
        if (a1 instanceof  B) {
            System.out.println("123465");
        }
        return   objectB;
    }


    private static class B<T>  extends  C <T>{
        private   T[] a;
        B () {

        }
        B (T [] array) {
            if (array instanceof  B []) {
                System.out.println("1");
            }
            a = array;
        }
        public   void aggg(T[] a) {
            if (a instanceof  B []) {
                System.out.println("1 ..........");
            }
            this.a = a;
        }
        public T getA (int index) {
            return a[index];
        }
    }

    public static void main(String[] args) {
        A.asList(new B(),new B());

        Object[] o = null;
        A []  a = {};
        o = a;
        System.out.println(o == a);
        if (o instanceof  A[]) {
            System.out.println("234654");
        }
    }

}


class C<T>{

}