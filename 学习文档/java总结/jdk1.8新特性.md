## 接口
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

## 时间操作对象
```
1. LocalDate
2. DateTimeFormatter


package com.zl.design.patterns;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @描述： TODO jdk1.8之后拥有的 时间类
 * @作者: Light
 * @时间: 2019/8/24  22:45
 * @版本：
 */
public class data {
    public static void main(String[] args) {
        //获取当前时间  now 年 月 日
        LocalDate now = LocalDate.now();
        System.out.println(now.toString());

        //调用 of 方法，可以进行设置
        now = LocalDate.of(2018, 10, 1);
        System.out.println(now);

        //获取当前时间  小时 分  秒  毫秒
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);
        System.out.println(now +" " + now1);

        //获取当前时间 年 月 日 小时 分  秒  毫秒
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2.toString().replaceAll("T"," "));
    }
}


```