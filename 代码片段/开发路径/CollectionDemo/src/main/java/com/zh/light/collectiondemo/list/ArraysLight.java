package com.zh.light.collectiondemo.list;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/10  9:50
 * @版本：
 */
public class ArraysLight {
    /* @Author Light
     * @Description //TODO
     * @Date 9:40 2019/10/10
     * @Param [elementDataA  修改的数组  , modifyIndex   迁移下标, elementDataB 修改的数组 , StartIndex 开始下标 , count 循环次数]
     * @return void
     **/
    public static void arrayCopy (Object[] elementDataA,int modifyIndex , Object[] elementDataB,int StartIndex ,int count) {
        Object[] array = new Object[elementDataA.length];
        // 赋值之前的值
        for (int index = 0; index <= modifyIndex;index++) {
            array[index] = elementDataA[index];
        }
        // 遍历 循环次数 ，更改后边的值
        for (  ;count > 0; count--) {

            array[StartIndex] = elementDataA[StartIndex-1];
            StartIndex ++ ;
        }
        /// 把新数组赋值给 老数组
        for(int i =0; i < array.length -1 ; i++) {
            elementDataB[i]  = array [i];
        }
    }

    /* @Author Light
     * @Description //TODO 不创建数组
     * @Date 9:40 2019/10/10
     * @Param [elementDataA  修改的数组  , modifyIndex   迁移下标, elementDataB 修改的数组 , StartIndex 开始下标 , count 循环次数]
     * @return void
     **/
    public static void arrayCopyPlus (Object[] elementDataA,int modifyIndex , Object[] elementDataB,int StartIndex ,int count) {
        elementDataA = new Object[elementDataB.length];
        // 赋值之前的值
        for (int index = 0; index <= modifyIndex;index++) {
            elementDataA[index] = elementDataB[index];
        }
        // 遍历 循环次数 ，更改后边的值
        for (  ;count > 0; count--) {

            elementDataA[StartIndex] = elementDataB[StartIndex-1];
            StartIndex ++ ;
        }
        /// 把新数组赋值给 老数组
        for(int i =0; i < elementDataA.length -1 ; i++) {
            elementDataB[i]  = elementDataA [i];
        }
    }
}
