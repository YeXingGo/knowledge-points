package com.zh.aop.aop_log;

import java.io.PrintStream;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/14  22:07
 * @版本：
 */
public class SlayDragonQuest  implements  Quest{
    private PrintStream stream;

    public void setStream(PrintStream stream) {
        this.stream = stream;
    }
    @Override
    public void embark () {
        stream.println("Embarking on quest to slay the dragon");
    }
}
