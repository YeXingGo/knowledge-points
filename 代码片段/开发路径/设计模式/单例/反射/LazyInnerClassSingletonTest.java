package 反射;

import java.lang.reflect.Constructor;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/15  9:02
 * @版本：
 */
public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
          // 在和无聊的情况下，进行破坏
          Class<LayInnerClassSingleton> clazz = LayInnerClassSingleton.class;
          // 通过放射获取私有的构造方法
            Constructor<LayInnerClassSingleton> constructor = clazz.getDeclaredConstructor(null);
        //强制访问
            constructor.setAccessible(true);
            // 暴力初始化
            Object object = constructor.newInstance();
            System.out.println(object);

            // 调用了两次构造方法，相当于"new" 了两次，犯了原则性错误
            LayInnerClassSingleton layInnerClassSingleton = constructor.newInstance();

            System.out.println( object = layInnerClassSingleton);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
