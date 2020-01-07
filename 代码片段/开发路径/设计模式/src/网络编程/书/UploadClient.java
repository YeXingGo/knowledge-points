package 网络编程.书;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * @描述： TODO 文件上传客户端
 * @作者: Light
 * @时间: 2019/9/4  22:22
 * @版本：
 */
public class UploadClient {
    public static void main(String[] args) {
        System.out.println("客户端运行.....");
        try (
                //向本机的8080端口发出请求
                Socket socket = new Socket("127.0.0.1",8080);
                //由Socket获的输入流，并创建缓冲输出流
                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                //创建文件输入流
                FileInputStream fin = new FileInputStream("C:\\Users\\Lenovo\\Pictures\\aa1.jpg");
                //有文件输入流创建缓冲输入流
                BufferedInputStream in = new BufferedInputStream(fin);
                ) {
            //准备一个缓冲区
            byte [] buffer = new byte[1024];
            int len = in.read(buffer) ;
            while (len != -1) {
                out.write(buffer ,0,len);
                len = in.read(buffer);
            }
            System.out.println("上传成功.........");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
