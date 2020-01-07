package com.zh.aop.aop_args;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述： TODO  测试环境
 * @作者: Light
 * @时间: 2019/9/18  22:44
 * @版本：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)

public class AopArgsTest {
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void a() {
        compactDisc.playTrack(12);
    }
}
