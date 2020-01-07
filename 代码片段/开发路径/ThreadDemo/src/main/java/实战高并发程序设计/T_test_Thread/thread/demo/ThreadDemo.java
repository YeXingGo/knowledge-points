package 实战高并发程序设计.T_test_Thread.thread.demo;


/**
 * @描述： TODO 测试Thread 方法
 * @作者: Light
 * @时间: 2019/11/25  9:20
 * @版本：
 */
public class ThreadDemo {
    public static void main(String[] args)  throws  Exception{

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("112");
        });
        thread.start();
//        thread.join(200);
        ThreadDemo threadDemo = new ThreadDemo();
//        wait(200);
        System.out.println(thread.isAlive());

    }
}
