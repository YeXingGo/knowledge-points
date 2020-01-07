package 实战高并发程序设计.T2_JAVA并发程序jichu;

/**
 * @描述： TODO 测试 join 方法
 * @作者: Light
 * @时间: 2019/11/17  19:40
 * @版本：
 */
public class AccountingVo1 implements Runnable {
    static AccountingVo1 instance = new AccountingVo1();
    static volatile int i = 0;



    public synchronized  void increase() {
        i++;
        System.out.print(Thread.currentThread().getName() + " ");
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
        System.out.println();
    }

    public static void main(String[] args) throws  Exception {
        int v1 = 1073741827;
        int v2 = 1431655768;
        int ave = v1 + v2;
        System.out.println(ave);
        testThread();
    }

    public static void testThread ()  throws  Exception{

         /*
            join () 方法必须在此线程启动之后，在其他线程未启动的时候，针对只有一个 join,
            i ++
             只有一个 join 的时候，是线程安全的，因为不会出现多个线程
        */
        Thread t1 = new Thread(instance,"T1");
        Thread t2 = new Thread(instance,"T2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        Thread.sleep(1000);
        System.out.println("main");
        System.out.println(i);
    }
}
