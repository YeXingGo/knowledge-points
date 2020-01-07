package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_4_ReadWriteLock读写锁;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @描述： TODO 测试读写锁
 * @作者: Light
 * @时间: 2019/11/21  23:26
 * @版本：
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 读取和读取之间 不存在堵塞
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    /* @Author Light
     * @Description //TODO  处理读取的方法
     * @Date 23:34 2019/11/21
     * @Param [lock]
     * @return java.lang.Object
     **/
    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 获得锁 ==========");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 读取到结果返回");
            return value;
        } finally {
            lock.unlock();
        }
    }

    /* @Author Light
     * @Description //TODO  处理读写操作
     * @Date 23:36 2019/11/21
     * @Param [lock, index]
     * @return void
     **/
    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 写入获得锁");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 写入结果返回");
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        // 读取
        Runnable readRunnale = new Runnable() {
            @Override
            public void run() {
                try {
//                    demo.handleRead(readLock);
                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
//                    demo.handleWrite(writeLock, new Random().nextInt());
                    demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnale).start();
        }
        for (int i = 18;  i < 20; i++) {
            new Thread(writeRunnable).start();
        }
    }
}
