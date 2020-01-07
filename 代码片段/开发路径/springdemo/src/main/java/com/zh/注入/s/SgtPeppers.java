package com.zh.注入.s;

import com.zh.注入.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/15  16:46
 * @版本：
 */
@Component
public class SgtPeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.println("你好");
    }
}
