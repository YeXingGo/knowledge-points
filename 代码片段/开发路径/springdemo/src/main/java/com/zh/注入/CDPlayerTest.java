package com.zh.注入;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/15  16:47
 * @版本：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
//    @Autowired
    private CompactDisc compactDisc;
    @Autowired(required =  true )
    public void setCompactDisc123456(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Test
    public void cd() {
        compactDisc.play();
    }
    @Bean(name = "ccc")
    public void ccc(){

    }
}
