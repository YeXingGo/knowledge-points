package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_5_到计数器;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @描述： TODO  测试到计数器 CountDownLatch
 * @作者: Light
 * @时间: 2019/11/24  15:01
 * @版本：
 */
public class CountDownLatchDemo implements  Runnable {
    private static final CountDownLatch end = new CountDownLatch(10);
    private static final CountDownLatchDemo demo = new CountDownLatchDemo();
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complate");
            // 每次都会减一，
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(demo);
        }

        // 等待检查 检查 是否是 0 ，
        end.await();
        // 发射火箭
        System.out.println("Fire !");
        executorService.shutdown();
    }
}
