package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_1_重入锁.锁申请等待限时;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述： TODO 测试ReentrantLock.tryLock() 获取锁不到直接返回结果，不会进行等待
 * @作者: Light
 * @时间: 2019/11/19  23:34
 * @版本：
 */
public class TryLock implements  Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock ;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            System.out.println(Thread.currentThread().getName()+" 开始休眠======");
                            Thread.sleep(500);
                            System.out.println(Thread.currentThread().getName()+" 结束休眠======");
                        }
                        catch (Exception e) {

                        }
                       if (lock2.tryLock()) {
                           try {
                               System.out.println(Thread.currentThread().getName() + ":My job done");
                                return ;
                           }
                           finally {
                                lock2.unlock();
                           }
                       }
                    }
                    finally {
                        lock1.unlock();
                    }
                }
            }
        }
        else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            System.out.println(Thread.currentThread().getName()+" 开始休眠======");
                            Thread.sleep(500);
                            System.out.println(Thread.currentThread().getName()+" 结束休眠======");
                        }
                        catch (Exception e) {

                        }
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + ":My job done");
                                return ;
                            }
                            finally {
                                lock1.unlock();
                            }
                        }
                    }
                    finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r2,"t2");
        t1.start();
        t2.start();
    }
}
