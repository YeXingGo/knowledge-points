package 实战高并发程序设计.T3_JDK并发包.T2_线程复用线程池.T1_固定大小的线程池;

import com.google.common.util.concurrent.Runnables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/6  0:03
 * @版本：
 */
public class ThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ": Thread ID:"+ Thread.currentThread().getId());
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0;i < 10 ; i++) {
            executorService.submit(myTask);
        }
    }
}
