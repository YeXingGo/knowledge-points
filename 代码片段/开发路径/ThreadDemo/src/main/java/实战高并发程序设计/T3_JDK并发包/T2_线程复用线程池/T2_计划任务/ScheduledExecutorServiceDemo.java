package 实战高并发程序设计.T3_JDK并发包.T2_线程复用线程池.T2_计划任务;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/17  0:01
 * @版本：
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        //如果前面的任务没有完成，则调度也不会启动
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    System.out.println(System.currentTimeMillis() / 1000 +" id: " + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },4,2, TimeUnit.SECONDS);
    }
}
