package com.zh.注入.testPrimary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/16  23:40
 * @版本：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigA.class)
public class TestA {
    @Autowired
    private A a;
    @Test
    public void test1() {
        System.out.println(a);
    }
}
