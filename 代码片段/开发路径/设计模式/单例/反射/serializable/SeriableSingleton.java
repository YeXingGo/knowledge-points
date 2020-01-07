package 反射.serializable;

import java.io.Serializable;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/21  9:02
 * @版本：
 */
public class SeriableSingleton implements Serializable {
    // 序列化就是把内存中的状态通过装换成字节码的形式
    // 从而装换成一个I/O流，写入其他地方（可以是磁盘、网络I/O）
    // 内存中的状态会永久保存下来

    //反序列化是将已经持久化的字节码内容装换成I/O流
    //通过I/O流的读取，进而将读取的内容装换成JAVA对象
    //在装换过程中重新创建对象  new

    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private  SeriableSingleton ()  {

    }
    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }
    /* @Author Light
     * @Description //TODO  不加此方法，使用序列化是两个对象，如果使用这个方法则是同一个对象
     * @Date 9:16 2019/10/21
     * @Param []
     * @return java.lang.Object
     **/
    private Object readResolve () {
        return  INSTANCE;
    }
}
