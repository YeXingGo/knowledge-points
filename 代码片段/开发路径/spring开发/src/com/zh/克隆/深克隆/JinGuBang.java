package com.zh.克隆.深克隆;

import java.io.Serializable;

/**
 * @描述： TODO 金箍棒
 * @作者: Light
 * @时间: 2019/10/28  22:40
 * @版本：
 */
public class JinGuBang implements Serializable {
    public float h = 100;
    public float d = 10;
    public void big (){
        this.d *= 2;
        this.h *= 2;
    }
    public void small () {
        this.d /= 2;
        this.h /= 2;
    }
}
