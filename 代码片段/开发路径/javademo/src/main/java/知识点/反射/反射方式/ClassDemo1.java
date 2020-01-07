package 知识点.反射.反射方式;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/6  9:15
 * @版本：
 */
public class ClassDemo1 {


    public static void main(String[] args) throws Exception {

//获得Class对象的方法（三种）

        //一：调用属性

        Class<String> c = String.class;
        System.out.println(c);//打印结果：class java.lang.String   
        //  String.class就表示JVM中一份表示String类的字节码

        Class<String> c2 = String.class;

        System.out.println(c == c2);//true都是String类的字节码        一个类在虚拟机中只有一份字节码；


//二：使用forName()方法

        //Class cla = Class.forName("String");//ERROR,

        Class<String> cla = (Class<String>) Class.forName("java.lang.String");
        //必须用上全限定名，否则报错

        System.out.println(c == cla);//true


        //三：利用对象调用Object的getClass方法；

        Class c3 = new String().getClass();
        System.out.println(c == c3);//ture

    }


}
