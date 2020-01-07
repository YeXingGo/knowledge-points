package 知识点.classload.类加载顺序;

import java.util.UUID;

/**
 * @描述： TODO  考察 final 与 类初始化  得出结论如果 带有final 并且 能在 编译期确定的，不用对 类进行初始化
 * @作者: Light
 * @时间: 2019/12/3  16:17
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Son.strFather);
    }
}
class YeYe{
    static {
        System.out.println("YeYe静态代码块");
    }
}

class Father extends YeYe{
//    public final static String strFather="HelloJVM_Father";
    public final static String strFather= UUID.randomUUID().toString();

    static{
        System.out.println("Father静态代码块");
    }
}

class Son extends Father{
    public static String strSon="HelloJVM_Son";

    static{
        System.out.println("Son静态代码块");
    }
}




