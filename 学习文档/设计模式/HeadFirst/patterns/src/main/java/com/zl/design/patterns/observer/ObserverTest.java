package com.zl.design.patterns.observer;

import java.io.*;

/**
 * @描述： TODO 学习观察者模式，java.io 就是使用了观察者模式
 * @作者: Light
 * @时间: 2019/8/24  9:08
 * @版本：
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 测试读取
        s();
    }
    /* @Author Light
     * @Description //TODO  读取本地文件
     * @Date 9:31 2019/8/24
     * @Param
     * @return
     **/
    public static void s() {
        InputStream io = null;
        try {
            FileInputStream fileInputStream =
                    new FileInputStream("G:\\geren\\ziliao\\个人仓库\\学习文档\\设计模式\\HeadFirst\\a.txt");
            io = new LowerCaseInputStream(new BufferedInputStream(fileInputStream));
            int c = 0 ;
            //当读取 完成后 c == -1
            while ((c = io.read()) >= 0) {
                System.out.print((char)c);
//                System.out.print(Character.toUpperCase(((char) c)));
            }
            io.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                io.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
