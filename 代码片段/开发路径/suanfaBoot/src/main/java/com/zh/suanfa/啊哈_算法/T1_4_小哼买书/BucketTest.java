package 啊哈_算法.T1_4_小哼买书;

import java.util.Scanner;

/**
 * @描述： TODO 利用桶排序 去重
 * @作者: Light
 * @时间: 2019/11/25  11:38
 * @版本：
 */
public class BucketTest {
    public static void main(String[] args) {
        int[] arr = new int[1001];
        Scanner sc = new Scanner(System.in);
//        int inputLegth = sc.nextInt();
        String[] s = sc.nextLine().split(" ");
       for (String s1 : s) {
           arr[Integer.parseInt(s1)] = arr[Integer.parseInt(s1)] + 1 ;
       }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > 0) {
                System.out.print(i+" ");
                count ++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
