package java高并发程序设计.T2_JAVA并行程序基础.test.t1;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/14  9:13
 * @版本：
 */
public class ThreadTest1_Method {

    private  class Thread1 extends  Thread {
        private Thread1 (String name) {
            super.setName(name);
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                new ThreadTest1_Method().sleep();
                System.out.println("线程：  "+Thread.currentThread().getName()+" i= "+i);
            }
        }
    }

    private  class Thread2 extends  Thread {
        private Thread2 (String name) {
            super.setName(name);
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                new ThreadTest1_Method().sleep();
                System.out.println("线程：  "+Thread.currentThread().getName()+" i= "+i);

            }
        }
    }

    public void sleep () {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws  Exception {
        ThreadTest1_Method threadTest1_method = new ThreadTest1_Method();
        Thread1 thread1 = threadTest1_method.new Thread1("Thread1 ");
        Thread2 thread2 = threadTest1_method.new Thread2("Thread2 ");
//        Thread.currentThread().join();
        thread1.start();
//        thread1.join();

        Thread1.yield();
        thread2.start();
//        thread2.join();
        System.out.println("124");
    }
}
