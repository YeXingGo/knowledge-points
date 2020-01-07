package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_1_重入锁.锁申请等待限时;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述： TODO  lock.tryLock(int,TimeUnit) 等待指定时间，如果指定时间为获取锁，直接返回false
 * @作者: Light
 * @时间: 2019/11/19  23:19
 * @版本：
 */
public class Timelock implements  Runnable {
    public static ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        try {
            // 获取锁，如果没有最大等待时间是 5s，
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName()+" 上锁");
            }
            else {
                System.out.println(Thread.currentThread().getName()+" get Lock failed");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
             if (lock.isHeldByCurrentThread()) lock.unlock();
        }
    }

    public static void main(String[] args) {
        Timelock timelock = new Timelock();
        Thread t1 = new Thread(timelock,"t1");
        Thread t2 = new Thread(timelock,"t2");
        t1.start();
        t2.start();
    }
}
