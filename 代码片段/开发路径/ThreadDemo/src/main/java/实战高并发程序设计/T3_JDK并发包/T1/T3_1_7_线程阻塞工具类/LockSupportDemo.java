package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_7_线程阻塞工具类;

import java.util.concurrent.locks.LockSupport;

/**
 * @描述： TODO 注意只有一个 许可 LockSupport 为每一个 线程 提供了一个 许可
 *          就算先被调用  unpark  也可以结束程序 ，因为 调用unpark直接让 许可变为可用，所以 park会直接返回
 * @作者: Light
 * @时间: 2019/12/4  22:22
 * @版本：
 */
public class LockSupportDemo {
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
                System.out.println(getName() +" park");
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        t1.start();
        Thread.sleep(100);
        t2.start();
        System.out.println("t1 unpark");
        LockSupport.unpark(t1);
        System.out.println("t2 unpark");
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
