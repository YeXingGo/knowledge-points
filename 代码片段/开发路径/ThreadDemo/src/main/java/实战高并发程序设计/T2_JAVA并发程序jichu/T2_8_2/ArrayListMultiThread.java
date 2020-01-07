package 实战高并发程序设计.T2_JAVA并发程序jichu.T2_8_2;

import java.util.ArrayList;

/**
 * @描述： TODO 并发下的ArrayList
 * @作者: Light
 * @时间: 2019/11/17  20:45
 * @版本：
 */
public class ArrayListMultiThread  {
    static ArrayList<Integer> al = new ArrayList<>(10);
    // 内部类
    public static class AddThread implements  Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}
