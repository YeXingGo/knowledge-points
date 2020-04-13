package 算法竞赛_2.T2_循环结构程序设计.T4_算法竞赛中的输入输出框架.数据统计2;

import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/2  23:08
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Integer INF = 1000000000;
        int x, n = 0, min = INF , max = -INF , s = 0, kase = 0;
        while ((x = scanner.nextInt()) != 0  ) {
            n = 0;
            for (int i = 0; i < x ; i++) {
                int i1 = scanner.nextInt();
                s += i1;
                if (i1 < min)  min = i1;
                if (i1 > max)  max = i1;
                n ++ ;
            }
            System.out.println();
            ++ kase;
            System.out.println(min +" " + max + " " + (double) s / n );
        }
     }
}
