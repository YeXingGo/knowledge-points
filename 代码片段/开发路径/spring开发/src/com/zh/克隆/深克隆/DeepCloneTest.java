package com.zh.克隆.深克隆;

import jdk.nashorn.internal.runtime.ECMAException;

/**
 * @描述： TODO  测试深浅克隆
  * @作者: Light
 * @时间: 2019/10/28  23:00
 * @版本：
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        try {
          QiTianDaSheng clone  = (QiTianDaSheng) qiTianDaSheng.clone();
            System.out.println("深克隆： " + (qiTianDaSheng.jinGuBang == clone.jinGuBang));
            System.out.println("深克隆： " + (qiTianDaSheng == clone));
        } catch (Exception e) {
            e.printStackTrace();
        }
        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng n = q.shallowClone(q);
        System.out.println("浅克隆： "+ (q.jinGuBang == n.jinGuBang));
        System.out.println("浅克隆： "+ (q == n));
    }
}
