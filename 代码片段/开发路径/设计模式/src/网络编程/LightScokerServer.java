package 网络编程;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/4  9:03
 * @版本：
 */
public class LightScokerServer {
    public static void main(String[] args) {
        System.out.println("服务器启动 ..............");

        try (
                ServerSocket serverSocket = new ServerSocket(8080);

        ) {
            Socket accept = serverSocket.accept();
//            while (true) {
                InputStream inputStream = accept.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                StringBuilder sb = new StringBuilder();
                byte[] b = new byte[1024];
                while ((bufferedInputStream.read(b)) > -1) {
                    sb.append(new String(b));
                }
                System.out.println(sb.toString());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("..............结束");
    }
}
