package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_1_重入锁.公平锁;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述： TODO 公平锁
 * @作者: Light
 * @时间: 2019/11/20  0:03
 * @版本：
 */
public class FairLock  implements  Runnable {
    // 设置为公平锁
    public static ReentrantLock failLock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true) {
            try {
                failLock.lock();
                System.out.println(Thread.currentThread().getName()+" 获得锁");
            }

            finally {
                failLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r1,"t2");
//        Thread t3 = new Thread(fairLock,"t3");
        t1.start();
        t2.start();
//        t3.start();
    }
}
