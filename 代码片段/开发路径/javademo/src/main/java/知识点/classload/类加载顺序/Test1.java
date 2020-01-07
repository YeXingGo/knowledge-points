package 知识点.classload.类加载顺序;

import java.util.UUID;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/4  9:50
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Testsdgfdfs.str);
    }
}
class Testsdgfdfs{
    static {
        System.out.println("static 静态代码块");
    }

        public static final String str= UUID.randomUUID().toString();
//    public static final double str=Math.random();  //编译期不确定
}




