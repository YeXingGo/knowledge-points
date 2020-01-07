package 网络编程.书;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @描述： TODO  文件上传服务器
 * @作者: Light
 * @时间: 2019/9/4  22:07
 * @版本：
 */
public class UploadServer {
    public static void main(String[] args) {
        System.out.println("服务器运行.....");
        try (
                //创建一个ServerSocket监听8080端口的客户端请求
                ServerSocket serverSocket = new ServerSocket(8080);
                //使用accept()阻塞当前线程，等待客户端请求
                Socket socket = serverSocket.accept();
                //由Socket获取输入流，并创建缓冲输入流
                BufferedInputStream io = new BufferedInputStream(socket.getInputStream());
                //由文件输出流创建缓冲输出流
                FileOutputStream out  = new FileOutputStream("src/网络编程/书/a.jpg");
                ) {
                //准备一个缓冲区
                byte[] buffer = new byte[1024];
                //首次从socket读取数据
            int len = io.read(buffer);
            while (len != -1) {
                //写入数据到文件
                out.write(buffer,0,len);
                //再从Socket读取数据
                len = io.read(buffer);
            }
            System.out.println("接受完成 !");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
