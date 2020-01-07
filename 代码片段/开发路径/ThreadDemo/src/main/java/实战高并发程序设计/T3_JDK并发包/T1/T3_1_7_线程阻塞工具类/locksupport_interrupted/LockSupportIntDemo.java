package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_7_线程阻塞工具类.locksupport_interrupted;

import java.util.concurrent.locks.LockSupport;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/4  22:35
 * @版本：
 */
public class LockSupportIntDemo {
    public static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends  Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(getName() + " 被中断了");
                }
            }
            System.out.println(getName() + " 执行结束");
        }
    }

    public static void main(String[] args) throws Exception {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
//        System.out.println("t2 unpark");
        LockSupport.unpark(t2);
    }
}
