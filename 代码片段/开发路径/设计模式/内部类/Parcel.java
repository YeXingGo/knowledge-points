/**
 * @描述： TODO 测试内部类对象的创建
 * @作者: Light
 * @时间: 2019/9/8  22:56
 * @版本：
 */
public class Parcel {
    public Parcel() {
        System.out.println("Parcel ................");
    }

    class A {
        {
            System.out.println("A {}");
        }
        public A() {
            System.out.println("init A ..............");
        }
    }
    static class B {
        static  {
            System.out.println("B static ");
        }
        public B() {
            System.out.println("init B ..............");
        }
    }

    public static void main(String[] args) {
        new Parcel();
        System.out.println("\"a\" :{ \"name\" : \" 中国\" }");
        System.out.println(String.format("a %s  %s", 1,2 ));
        System.out.println("a,".substring(0,"aa".length()-1));
    }
}
