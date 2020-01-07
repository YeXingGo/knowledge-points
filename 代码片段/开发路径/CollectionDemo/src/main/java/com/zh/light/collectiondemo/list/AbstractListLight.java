package com.zh.light.collectiondemo.list;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/7  21:17
 * @版本：
 */
public abstract class AbstractListLight<E> extends AbstracCollectionLight<E> {
    protected  transient  int modCount = 0;
    protected  AbstractListLight () {

    }
}
