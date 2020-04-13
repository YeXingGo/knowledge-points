package 数据结构.不增正整数;

import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2020/3/23  17:46
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[100] ;

        Scanner scanner = new Scanner(System.in);
        System.out.println(" 请输入： ");
        int i = scanner.nextInt();
      a [0] = i;
        int k = 1;
        rd(a,i,k);
    }
    public static void rd (int[] a, int i, int k) {
        int j = 0, p = 0;
        for  (j = i ; j >= 1 ; j--) {
            if (j <= a [k-1]) {
                a[k] = j;
                if (j == i) {
                    System.out.print(a[0] +" = "+a[1]);
                    for (p = 2; p <= k; p++) {
                        System.out.print(" + " + a[p]);
                    }
                    System.out.println();
                }
                else {
                    rd(a,i-j,k+1);
                }
            }
        }
    }
}
