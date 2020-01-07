package com.zh.spring.设计模式.工厂模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/13  22:59
 * @版本：
 */
public class TestBeanFactroy<T> {
    Map map = new HashMap<Class,T>();
    public static void main(String[] args)  throws Exception {
        TestBeanFactroy<TestBeanFactroy> testBeanFactroyTestBeanFactroy = new TestBeanFactroy<>();
        testBeanFactroyTestBeanFactroy.t(TestBeanFactroy.class);
        testBeanFactroyTestBeanFactroy.t(TestBeanFactroy.class);
        System.out.println(testBeanFactroyTestBeanFactroy.t(TestBeanFactroy.class) == testBeanFactroyTestBeanFactroy.t(TestBeanFactroy.class));
        System.out.println(testBeanFactroyTestBeanFactroy.map.toString());
    }
    public  <T> T t (Class<? extends T> c)  throws Exception{
        if (map.containsKey(c)) {
            return (T) map.get(c);
        }
        T t = c.newInstance();
        System.out.println(c.newInstance());
        map.put(c,t);
        return  t;
    }
}
