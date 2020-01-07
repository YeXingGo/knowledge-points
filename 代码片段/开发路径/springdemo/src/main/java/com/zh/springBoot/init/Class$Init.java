package com.zh.springBoot.init;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/6  17:01
 * @版本：
 */
@Component
public class Class$Init {
    public Class$Init  () {
        System.out.println("Class$Init 创建..........");
    }
    @PostConstruct
    public void init () {
        System.out.println("@PostConstruct  .......Init............");
    }
    @PreDestroy
    public void des () {
        System.out.println("des .........................");
    }

}
