package 反射.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/21  9:09
 * @版本：
 */
public class SerialeSingletonTest {
    public static void main(String[] args) {
        SeriableSingleton s1 = null;
        SeriableSingleton s2  = SeriableSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            // 使用对象流
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(s2);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            s1 = (SeriableSingleton) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
