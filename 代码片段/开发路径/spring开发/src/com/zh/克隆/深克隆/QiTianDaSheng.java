package com.zh.克隆.深克隆;

import java.io.*;
import java.util.Date;

/**
 * @描述： TODO 齐天大圣
 * @作者: Light
 * @时间: 2019/10/28  22:44
 * @版本：
 */
public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {
    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        //只是初始化
        this.brithday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    /* @Author Light
     * @Description //TODO 深克隆  ，防止深克隆破坏单例模式;
     * @Date 22:59 2019/10/28
     * @Param []
     * @return java.lang.Object
     **/
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return INSTANCE;
        return this.deepClone();
    }

    public Object deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            QiTianDaSheng copy = (QiTianDaSheng) ois.readObject();
            copy.brithday = new Date();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* @Author Light
     * @Description //TODO 浅克隆；
     * @Date 23:00 2019/10/28
     * @Param [target]
     * @return com.zh.克隆.深克隆.QiTianDaSheng
     **/
    public QiTianDaSheng shallowClone (QiTianDaSheng target) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.weight;

        qiTianDaSheng.jinGuBang = target.jinGuBang;
        qiTianDaSheng.brithday = new Date();
        return qiTianDaSheng;
    }
}
