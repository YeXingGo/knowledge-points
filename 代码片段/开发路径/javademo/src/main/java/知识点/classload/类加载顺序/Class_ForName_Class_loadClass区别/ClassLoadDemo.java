package 知识点.classload.类加载顺序.Class_ForName_Class_loadClass区别;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/5  15:15
 * @版本：
 */
public class ClassLoadDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoadDemo.class.getClassLoader();
        //1、使用ClassLoader.loadClass()来加载类，不会执行初始化块
        classLoader.loadClass("知识点.classload.类加载顺序.Class_ForName_Class_loadClass区别.Demo");

        //2、使用Class.forName()来加载类，默认会执行初始化块
       Class.forName("知识点.classload.类加载顺序.Class_ForName_Class_loadClass区别.Demo");

        //3、使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        Class.forName("知识点.classload.类加载顺序.Class_ForName_Class_loadClass区别.Demo",false,classLoader);


    }

}



class Demo {
    static  {
        System.out.println(" static 静态代码块");
    }
}