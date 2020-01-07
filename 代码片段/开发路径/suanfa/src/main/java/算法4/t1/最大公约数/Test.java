package 算法4.t1.最大公约数;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/16  16:14
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(gcd(18,9));

    }
    public static int gcd (int p ,int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;

        return gcd(q,r);
    }
}
