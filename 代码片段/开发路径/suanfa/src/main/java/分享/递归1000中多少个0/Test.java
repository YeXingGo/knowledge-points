package 分享.递归1000中多少个0;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/20  11:22
 * @版本：
 */
public class Test {
    public static Long getInt (long num) {

        if (num <= 1) {
            return 1L;
        }
        return num * getInt(num - 1);
    }
    public static Long getNum(int num) {
        Long aLong = getInt(num);
        System.out.println(aLong);
        long count = 0;
        while (true) {
            if (aLong ==0) {
                break;
            }
            long c = aLong % 10;
            if (c == 0) {
                count ++;
            }
            aLong = aLong / 10;
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(getNum(10));
    }
}
