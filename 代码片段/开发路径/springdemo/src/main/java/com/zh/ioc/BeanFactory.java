package com.zh.ioc;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/13  17:52
 * @版本：
 */
public class BeanFactory {
    private BeanFactory (){

    }
    public static void main(String[] args) throws  Exception {

        System.out.println(getBean(BraveKnight.class));

    }
    public static <T> T  getBean (Class<T> t) throws  Exception {

        return t.newInstance();
    }
}
