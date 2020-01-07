package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_1_重入锁.中断响应;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/17  21:39
 * @版本：
 */
public class IntLock implements  Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                    System.out.println("t1 要 t2");
                }
                catch (InterruptedException e) {

                }
                lock2.lockInterruptibly();
            }
            else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                    System.out.println("t2 要 t1");
                }
                catch (InterruptedException e) {

                }
                lock1.lockInterruptibly();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           if (lock1.isHeldByCurrentThread()) {
               System.out.println("lock1 unlock");
               lock1.unlock();
           }
            if (lock2.isHeldByCurrentThread()) {
                System.out.println("lock2 unlock");
                lock2.unlock();
           }
            System.out.println(Thread.currentThread().getId()+":线程退出");
        }
    }

    public static void main(String[] args) throws  Exception {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        // 中断其中一个线程
        t2.interrupt();
    }
}
