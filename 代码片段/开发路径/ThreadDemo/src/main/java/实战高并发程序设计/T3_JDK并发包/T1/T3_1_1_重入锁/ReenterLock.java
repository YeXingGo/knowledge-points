package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_1_重入锁;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述： TODO  java.util.concurrent.locks.ReentrantLock; 重入锁
 * @作者: Light
 * @时间: 2019/11/17  21:23
 * @版本：
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public  static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
//            lock.lock();
            lock.lock();
            try {
                i ++;
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
