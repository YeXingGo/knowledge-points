package com.zh.java.内部类;


/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/6  17:45
 * @版本：
 */
public class Implementation1 implements Service {
    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }
    private Implementation1 () {

    }
    public static ServiceFactory serviceFactory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
    public static void main(String[] args) {
        Implementation1.serviceFactory.getService().method1();
    }
}
