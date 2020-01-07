package 算法竞赛_2.T2_循环结构程序设计.T5_注解与习题.C_水仙花数;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/3  22:51
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        for (int i = 100 ; i <= 999 ; i ++ ) {
            int A = i % 10;
            int B = (i / 10)  % 10;
            int C = i / 100;
            if (A * A * A + B * B * B + C * C * C == i) {
                System.out.print(i + " ");
            }
        }
    }
}
