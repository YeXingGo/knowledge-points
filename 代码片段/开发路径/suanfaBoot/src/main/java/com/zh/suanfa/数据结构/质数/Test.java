package 数据结构.质数;

import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2020/3/23  15:43
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        boolean flag = false;
        for (int i = 2; i <= Math.sqrt(m); i++) {
            int r = m % i;
            if (r == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(m +" 是质数");
        }
        else {
            System.out.println(m + " 不是质数");
        }
    }
}
