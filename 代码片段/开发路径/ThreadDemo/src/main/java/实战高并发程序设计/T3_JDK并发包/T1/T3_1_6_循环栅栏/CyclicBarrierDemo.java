package 实战高并发程序设计.T3_JDK并发包.T1.T3_1_6_循环栅栏;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/24  15:13
 * @版本：
 */
public class CyclicBarrierDemo  {
    public static class Soldier implements  Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(String soldier, CyclicBarrier cyclic) {
            this.soldier = soldier;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                // 等待所有士兵到齐
                cyclic.await();
                doWork ();
                //等待所有士兵完成任务
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ": 任务完成");
        }
    }

    public static class BarrierRun implements  Runnable {
        boolean flag ;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令： [士兵"+ N + "个， 任务完成！]");
            }
            else {
                System.out.println("司令： [士兵"+ N + "个， 集合完毕！]");
                flag = true;
            }
        }
    }
    public static void main(String[] args) {
        final  int N = 10;
        Thread [] allSoldier = new Thread[N];
        boolean flag = false;

        CyclicBarrier cyclic  = new CyclicBarrier(10,new BarrierRun(flag,N));
        // 设置屏障点 ， 主要是 为了执行这个方法
        System.out.println("集合队伍 ！");
        for (int i = 0; i < N ; i++) {
            System.out.println("士兵 "+ i + " 报道! ");
            allSoldier[i] =  new Thread(new Soldier("士兵 "+i,cyclic));
            allSoldier[i] .start();
           /* if ( i == 5) {
                allSoldier [i] .interrupt();
            }*/
        }
    }
}
