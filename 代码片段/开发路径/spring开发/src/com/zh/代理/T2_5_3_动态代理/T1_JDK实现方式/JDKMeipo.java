package com.zh.代理.T2_5_3_动态代理.T1_JDK实现方式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @描述： TODO 媒婆（婚介所）
 * @作者: Light
 * @时间: 2019/12/1  19:38
 * @版本：
 */
public class JDKMeipo implements InvocationHandler {
    // 被代理的对象 ， 把引用保存下来
    private Object target;

    public Object  getInstance (Object target) throws  Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.target, args);
        after();
        return object;
    }
    private void before () {
        System.out.println("我是媒婆： 我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }
    private void after () {
        System.out.println("如果合适的话，就准备办事");
    }


    public static void main(String[] args) throws Exception {
        Person person = (Person) new JDKMeipo().getInstance(new Customer());
        person.findLove();
    }
    public static void test () throws  Exception {
        JDKMeipo jdkMeipo = new JDKMeipo();
        System.out.println(jdkMeipo.getInstance(jdkMeipo) );
        Class<? > aClass = jdkMeipo.getClass();
        Object o = Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), jdkMeipo);
        System.out.println(o);
    }
}

