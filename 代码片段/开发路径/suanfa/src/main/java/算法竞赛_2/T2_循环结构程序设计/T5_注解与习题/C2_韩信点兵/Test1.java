package 算法竞赛_2.T2_循环结构程序设计.T5_注解与习题.C2_韩信点兵;

import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/3  23:01
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // a < 3 ,b < 5 , c < 7
        int a = 0, b = 0, c =0;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        int count = 0;
        for (int i = 10 ; i < 100 ; i++) {
            if (i % 3 == a) {
                if (i % 5 == b) {
                   if (i % 7 == c) {
                       count = i;
                       break;
                   }
                }
            }
        }
        if (count == 0) {
            System.out.println("无解");
        }
        else {
            System.out.println(count );
        }
    }
}
