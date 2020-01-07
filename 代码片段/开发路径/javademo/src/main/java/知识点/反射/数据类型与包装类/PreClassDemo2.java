package 知识点.反射.数据类型与包装类;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/6  9:18
 * @版本：
 */
public class PreClassDemo2 {
    public static void main(String[] args) {
        Class<?> in = int.class;
        System.out.println(in);//int
        Class<?> in2 = Integer.class;
        //包装类都有一个常量TYPE，用来表示其基本数据类型的字节码
        Class<?> in3 = Integer.TYPE;
        System.out.println(in2);//class java.lang.Integer

        System.out.println(in3);//int

        System.out.println(in3 == in);//true 包装类都有一个常量TYPE，用来表示其基本数据类型的字节码，所以这里会相等！

        System.out.println(in3 == in2);//false

        Class<String[]> s = String[].class;

        Class<int[]> i = int[].class;

//        System.out.println(i ==s);//编译根本就通过不了，一个是int，一个是String
        show(new Integer(1));
    }

    //这两个自定义的方法是可以的，一个int，一个Integer//包装类与基本数据类型的字节码是不一样的
    public static void show(int i) {
        System.out.println("int");
    }

    public  static void show(Integer i) {
        System.out.println("Integer");
    }


}
