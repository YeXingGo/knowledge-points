package 网络编程.书.test2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @描述： TODO 聊天服务器
 * @作者: Light
 * @时间: 2019/9/4  22:55
 * @版本：
 */
public class ChatServer {
    public static void main(String[] args) {
        System.out.println("服务器运行......");
        Thread t = new Thread(
                //使用lambda 表达式
                () -> {
                    try (
                            //创建一个ServerSocket监听端口8080客户请求
                            ServerSocket server  = new ServerSocket(8080);
                            //使用accept() 阻塞等待客户端请求
                            Socket socket = server.accept();
                            //使用了装饰者模式
                            DataInputStream in = new DataInputStream(socket.getInputStream());
                            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                            //使用了适配器模式
                            BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))
                            ) {
                        while (true) {
                            //接受数据
                            String str = in.readUTF();
                            //打印接收数据
                            System.out.println("从客户端接收的数据: "+str);
                            //发送数据
                            String keyboardInputString = keyboardIn.readLine();
                            //接收聊天
                            if (keyboardInputString.equals("bye")) {
                                break;
                            }
                            //发送
                            out.writeUTF(keyboardInputString);
                            out.flush();

                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("客户端下线...............");
                    }
                    System.out.println("服务器停止...............");
                },""
        );
        t.start();
    }
}
