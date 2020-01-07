package com.zh.aop.aop_args;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  22:37
 * @版本：
 */
@Component
public class CompactDisc {
    public void playTrack (int trackNumber) {
        System.out.println("CompactDisc  number = "+trackNumber);
    }
}
