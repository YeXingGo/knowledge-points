package com.zh.suanfa.t1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/14  23:06
 * @版本：
 */
public class 骑士 {
    public static void main(String[] args) {
        while (true) {
            int n[];
            int m[];

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            n = new int[Integer.parseInt(s.split(" ")[0])];
            m = new int[Integer.parseInt(s.split(" ")[1])];
            //
            if (n.length == 0 && m.length == 0) {

                break;
            }
            // 龙头
            for (int i = 0; i < n.length; i++) {
                n[i] = scanner.nextInt();
            }
            // 骑士
            for (int i = 0; i < m.length; i++) {
                m[i] = scanner.nextInt();
            }
            Arrays.sort(n);
            Arrays.sort(m);
            System.out.println(Arrays.toString(m));
            System.out.println(Arrays.toString(n));
            // 使用金币数
            int gold = 0;
            int index = 0;
            //骑士能力
            for (int i = 0; i < m.length; i++) {
                if (n[index] <= m[i]) {
                    gold += m[i];
                    index ++ ;
                }
                // 有结果
                if (index == n.length) {
                    System.out.println("金币个数： " + gold);
                    break;
                }
                // 可以修改为 判断两个数组的长度
                if (i >= m.length-1 && index < n.length) {
                    System.out.println("无结果。。");
                    break;
                }
            }

        }

    }
}
