## 注意：

1. 一个源程序文件包含多个类时，需要注意：
       1. 只能有一个类声明为公有的（public)
       2. 文件命名必须与公共类名一致，包括字母大小写。
       3. public static void main (String [] args) 只能定义在公共类中 	
2. 注释
      1. 地标注释
           1. TODO ：说明此处有待处理的任务，或代码没有编写完成。
           2. FIXME:    说明此处代码错误的，需要修正
           3. XXX：      说明此处代码虽然实现了功能，但是实现的方法有待商榷，希望将来能改进。
3. JAVA 数据类型
     1. long类型最好使用大写的L ，因为这样可读性高。
     2. 数值的表示方式
     	 1. 进制数值表示
               1. 二进制数： 	以0b或0B为前缀，注意0是阿拉伯数字，
               2. 八进制数： 	以0为前缀，注意0是阿拉伯数字
               3. 十六进制数：    以0x或0X为前缀，注意0是阿拉伯数字
          2. 指数表示
               1. 如果采用十进制表示指数，则需要使用大写或小写的e表示幂，e2表示10 * 10 ，也就是10的二次方。 


4. 位运算：(70页)
	运算符       		   名称 		 例子  			说明
	  ~ 			            位反		    ~x 			 将x的值按位取反
	  &			            位与		   x&y			 x与y位进行位与运算
	  |			             位或		   x | Y		   x 与y位进行位或运算
	  ^			           位异或	     x ^ y 		  x与y位进行位移或运算
      \>> 		        有符号右移    x >> a 	   x右移a位，高位采用符号位补位
      <<		              左移		   x<<a 		  x左移a位，低位用0补位
      \>>>		       无符号右移	x>>> a	   x右移a为，高位用0补位
      &=		           位与等于	  a &= b 	  等价于a = a & b
   
5. 控制语句
	
1. switch 语句，直至遇到break才会结束，default也会执行。   
	
6. 接口
```
1.jdk 1.8之后的接口
	1.	接口中可以有默认的方法，不用子类是实现，但是接口中的默认方法只能是 default
	2.	接口中可以有static方法，
	
	代码
	
	package com.cn.qilong.mall.nfc;

/**
 * @描述： TODO 测试 jdk 1.8 之后是否接口可以有static方法
 * @作者: Light
 * @时间: 2019/8/23  8:51
 * @版本：
 */
public interface  TestInterface {
    public static String a =" a";

    public static void method() {
        // a = " b";
        System.out.println("123434");
    }
    default  void A() {
        System.out.println("我是TestInterface 中的A方法");
    }


}



package com.cn.qilong.mall.nfc;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/8/23  8:53
 * @版本：
 */
public class TestClass implements  TestInterface {
    public static void method() {
        System.out.println("123434");
    }


    public static void main(String[] args) {
        //调用接口的静态方法
        TestInterface.method();

        //调用通过子类重写接口中的方法
        new TestClass().A();
    }
}

```

7. 枚举
```
	1. 枚举类不可以进行继承操作
	2. 枚举可以实现接口
	3. 枚举中不可以被继承 和  继承其他类
	4. 枚举类中不能有抽象方法，可以有普通方法，
	5. 枚举类中可以有 静态变量和静态常量 、 
	6. 枚举类中 在定义其他方法或 变量  之前 须有 创建对象的并以 , 隔开，并且最后必须有 ；  如果不想 调用对象的构造，可以直接使用 ;


package com.cn.qilong.mall.nfc;

/**
 * @描述： TODO 测试 枚举
 * @作者: Light
 * @时间: 2019/8/23  9:07
 * @版本：
 */
public enum  TestEnum /*extends TestEnum1*/ implements  TestInterface{
    //调用构造方法
    aa("1","2"),
    bb("2","3"),;
    ;
    public static final String a = "b";
    private String  name ="1";
    public String password = " ";


    public static void  Enum() {
        System.out.println("这是一个 静态方法");
    }
    public void A() {
        System.out.println("这是一个  普通方法");
    }

    @Override
    public void C() {
        System.out.println("4646");
    }


    private TestEnum(String name ,String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestEnum{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        TestEnum aa = TestEnum.aa;
        System.out.println(aa.toString());
        System.out.println(aa.getName());
        System.out.println(TestEnum.a);
        TestEnum.Enum();
    }
}

```
​     



​	

 	