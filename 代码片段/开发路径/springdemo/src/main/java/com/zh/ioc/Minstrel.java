package com.zh.ioc;

import java.io.PrintStream;

/**
 * @描述： TODO 吟游诗人 作为 aop的
 * @作者: Light
 * @时间: 2019/9/14  22:02
 * @版本：
 */
public class Minstrel {
    private PrintStream stream = System.out;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public Minstrel() {
        System.out.println();
    }

    public void setPrintStream(PrintStream printStream) {
        this.stream = printStream;
    }
    public void singBeforeQuest () {
        stream.println("Fa la la,the knight is so brave!");
    }
    public void singAfterQuest () {
        stream.println("Minstrel ================after==========");
    }
}
