package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_8_Guava和RateLimiter限流;

import com.google.common.util.concurrent.RateLimiter;
import 实战高并发程序设计.T_test_Thread.thread.demo.ThreadDemo;

/**
 * @描述： TODO 令牌桶
 * @作者: Light
 * @时间: 2019/12/5  23:32
 * @版本：
 */
public class RateLimiterDemo {
    static RateLimiter limiter = RateLimiter.create(3);

    public static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i ++) {
            // 不丢弃
            limiter.acquire();

            //  请求 超除部分直接丢弃
            if (!limiter.tryAcquire()) {
                continue;
            }
                // 结果为一个，因为在 500ms内完全可以执行完成
            new Thread(new Task()).start();
        }
    }
}
