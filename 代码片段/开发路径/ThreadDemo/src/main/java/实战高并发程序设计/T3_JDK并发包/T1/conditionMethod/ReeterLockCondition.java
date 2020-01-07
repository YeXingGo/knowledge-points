package 实战高并发程序设计.T3_JDK并发包.T1.conditionMethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/20  23:18
 * @版本：
 */
public class ReeterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    public static Condition condition1 = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            // 会释放锁
            condition.await();
            System.out.println(Thread.currentThread().getName()+"Thread is going on");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
             lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ReeterLockCondition reeterLockCondition = new ReeterLockCondition();
        Thread t1 = new Thread(reeterLockCondition,"t1");
        t1.start();
        Thread.sleep(2000);

        lock.lock();
        //必须也和唤醒对象的锁一样  不然无法唤醒
        condition.signal();
        System.out.println("main  signal ");
        lock.unlock();

    }
}
