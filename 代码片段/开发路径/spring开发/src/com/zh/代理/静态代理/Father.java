package com.zh.代理.静态代理;

/**
 * @描述： TODO 父亲
 * @作者: Light
 * @时间: 2019/10/28  23:14
 * @版本：
 */
public class Father {
    private Son son;
    // 没有办法扩展
    public Father (Son son) {
        this.son = son;
    }
    //获取目标对象的引用
    public void findLove () {
        System.out.println("父亲物色对象");
        this.son.findLove();
        System.out.println("双方同意，确立关系");
    }

    public static void main(String[] args) {
        // 只能帮儿子 找对象
        Father father = new Father(new Son());
        father.findLove();
    }
}
