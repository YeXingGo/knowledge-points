package com.zh.aop.aop_declateParents;

import com.zh.aop.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  23:22
 * @版本：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  Config_1.class)
public class TestDeclateParents {
    @Autowired
    private Performance performance;
    @Test
    public void t () {
        performance.perform();
        // 使用了 @ DeclareParents 注解
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();

    }
}
