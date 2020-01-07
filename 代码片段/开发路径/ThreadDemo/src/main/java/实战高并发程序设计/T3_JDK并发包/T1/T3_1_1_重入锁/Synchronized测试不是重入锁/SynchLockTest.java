package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_1_重入锁.Synchronized测试不是重入锁;

/**
 * @描述： TODO 测试 synchronized
 * @作者: Light
 * @时间: 2019/11/20  15:12
 * @版本：
 */
public class SynchLockTest implements Runnable {
    public static Object object = new Object();
    @Override
    public void run() {
        synchronized (object) {
            System.out.println("1233");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println("12333333");
            }
            System.out.println("================");
        }
    }

    public static void main(String[] args) {
        SynchLockTest synchLockTest = new SynchLockTest();
        Thread thread = new Thread(synchLockTest);
        thread.start();
    }
}
