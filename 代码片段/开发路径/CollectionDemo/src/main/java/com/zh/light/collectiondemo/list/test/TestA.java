package com.zh.light.collectiondemo.list.test;

import com.zh.light.collectiondemo.list.CollectionLight;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/8  23:33
 * @版本：
 */
public class TestA {
    /*
        A > B > C

        Collection<? extends B>  代表 只有父类为 B 的才可以放入
        Collection<? super B> 代表只有  传入的值是 B 类的父类或者 B类就可以
    */
    public <T> void testS(Collection<? super B> c) {
        System.out.println(c);
    }

    public <T> void testE(Collection<? extends B> c) {
        System.out.println(c);
    }

    public static<T> void main(String... args) {
        TestA testA = new TestA();
        System.out.println(testA);
    }

    // 验证 Collection<? super C>   代表只有  传入的值是 B 类的父类或者 B类就可以
    public void testSuper(TestA testA) {
//                List<A> as = Arrays.asList(new B(), new C(), new A());
        List<B> as = Arrays.asList(new B(), new C());
//        List<C> as = Arrays.asList(new C());
        testA.testS(as);
    }

    //Collection<? extends B>  代表 只有父类为 B 的才可以放入
    public void testExtends(TestA testA) {
//                List<A> as = Arrays.asList(new B(), new C(), new A());
        List<B> as = Arrays.asList(new B(), new C());
//        List<C> as = Arrays.asList(new C());
        testA.testE(as);
    }
}
