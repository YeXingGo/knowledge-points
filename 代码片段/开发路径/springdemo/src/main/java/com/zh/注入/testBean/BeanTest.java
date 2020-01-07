package com.zh.注入.testBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/15  23:14
 * @版本：
 */
//@ActiveProfiles("magic")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class BeanTest {
    @Autowired
    private BeanA beanA;
    @Test
    public void test () {
        System.out.println(beanA);
        System.out.println("test");
    }
}
