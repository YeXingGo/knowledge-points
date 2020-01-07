package com.zh.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  0:31
 * @版本：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  ConcertConfig.class)
public class TestAop {
      @Autowired
      private Performance performance;
      @Test
      public void test () {
         performance.perform();
     }
}
