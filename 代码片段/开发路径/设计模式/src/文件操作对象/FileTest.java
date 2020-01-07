package 文件操作对象;

import java.io.File;
import java.io.InputStreamReader;

/**
 * @描述： TODO 文件操作测试
 * @作者: Light
 * @时间: 2019/9/1  22:00
 * @版本：
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("G://");
        System.out.println(file.getPath());
        File file1 = new File("G://", "g.txt");
        System.out.println(file1.getPath());
    }
}
