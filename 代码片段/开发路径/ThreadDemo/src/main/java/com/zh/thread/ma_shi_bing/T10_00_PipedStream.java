package com.zh.thread.ma_shi_bing;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/24  22:42
 * @版本：
 */
public class T10_00_PipedStream {
    public static void main(String[] args) throws Exception{
        char [] aI = "1234567".toCharArray();
        char [] aC = "abcdefg".toCharArray();
        //管道流  线程之间的交互 ，一个写 一个读 形成管道
        PipedInputStream input1 = new PipedInputStream();
        PipedOutputStream output1 = new PipedOutputStream();
        PipedInputStream input2 = new PipedInputStream();
        PipedOutputStream output2 = new PipedOutputStream();

        //猜测进行 绑定对话
        input1.connect(output2);
        input2.connect(output1);

        String msg = "Your Turn";

        new Thread(() -> {
            byte[] buffer = new byte[9];
                try {
                    for (char c : aC) {
                        input1.read(buffer);
                        if (new String(buffer).equals(msg)) {
                            System.out.print(c);
                        }
                        output1.write(msg.getBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        },"t1").start();
        new Thread(() -> {
            byte[] buffer = new byte[9];
            try {
                for (char c : aI) {
                    System.out.print(c);
                    output2.write(msg.getBytes());
                    input2.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }

}
