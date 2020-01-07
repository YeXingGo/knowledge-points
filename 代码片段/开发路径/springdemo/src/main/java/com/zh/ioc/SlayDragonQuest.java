package com.zh.ioc;

import java.io.PrintStream;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/14  22:07
 * @版本：
 */
public class SlayDragonQuest  implements Quest {
    private PrintStream stream = System.out;

    public void setStream(PrintStream stream) {
        this.stream = stream;
    }

    public SlayDragonQuest(PrintStream stream) {
        System.out.println("我是构造 SlayDragonQuest ...... ");
        this.stream = stream;
    }

    public SlayDragonQuest() {
    }

    @Override
    public void embark () {
        stream.println("Embarking on quest to slay the dragon");
    }
}
