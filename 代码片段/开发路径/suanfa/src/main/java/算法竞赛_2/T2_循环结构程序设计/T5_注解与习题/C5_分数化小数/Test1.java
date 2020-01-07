package 算法竞赛_2.T2_循环结构程序设计.T5_注解与习题.C5_分数化小数;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/4  22:44
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            double a = scanner.nextDouble() , b = scanner.nextDouble();
            int c = scanner.nextInt();
            if (a == b & a == c & c == 0) {
                break;
            }
            double d =  a / b;

            String result = String.format("%."+c+"f",d);
            System.out.println(result);
        }

    }
}
