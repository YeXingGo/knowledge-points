package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_3_信号量;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @描述： TODO  测试信号量
 * @作者: Light
 * @时间: 2019/11/20  23:46
 * @版本：
 */
public class SemapDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            // 获得许可证
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ":done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放许可证
            semp.release();
        }
    }

    public static void main(String[] args) {
        //固定线程池 ， 放入 n 个任务， 每次执行 20个
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        // 定时线程池
        Executors.newScheduledThreadPool(2).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("skjflajsdfjklas");
            }
        },10, TimeUnit.SECONDS);

        // 固定频率执行
        Executors.newScheduledThreadPool(2).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("jksdajflkajflkjdfkalsjfkl+++++++++");
            }
            // 先等待一s ，之后 2秒
        },5, 2,TimeUnit.SECONDS);


        final SemapDemo semapDemo = new SemapDemo();
        for (int i = 0; i < 25 ; i++) {
          //  executorService.submit(semapDemo);
        }

    }
}
