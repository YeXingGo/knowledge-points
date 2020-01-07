package com.zh.springBoot;

import com.zh.springBoot.config.BeanConfig;
import com.zh.springBoot.init.Class$Init;
import com.zh.springBoot.init.ClassInit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/6  16:54
 * @版本：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        BeanConfig.class
})
public class Start {
    @Autowired
    private ClassInit classInit;
//    @Autowired
//    private Class$Init class$Init;
    @Test
    public void t () {
//        System.out.println(classInit);
//        System.out.println(class$Init);
        classInit.test();
    }
}
