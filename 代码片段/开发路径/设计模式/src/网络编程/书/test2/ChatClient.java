package 网络编程.书.test2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.EmptyStackException;

/**
 * @描述： TODO 聊天客户端
 * @作者: Light
 * @时间: 2019/9/5  8:59
 * @版本：
 */
public class ChatClient {
    public static void main(String[] args) {
        System.out.println("客户端运行..........");
        Thread t = new Thread(
                () -> {
                    try (
                            //向本机的8080端口发出连接请求
                            Socket socket = new Socket("127.0.0.1",8080);
                            //使用了装饰者模式
                            DataInputStream in = new DataInputStream(socket.getInputStream());
                            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                            //使用了适配器模式
                            BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in))
                            ) {
                            while (true) {
                                //发送数据
                                //读取键盘输入的字符串
                                String keyboardInputString = keyboardIn.readLine();
                                //结束聊天
                                if (keyboardInputString.equals("bye")) {
                                    break;
                                }
                                //发送
                                out.writeUTF(keyboardInputString);
                                out.flush();
                                //接受数据
                                String str = in.readUTF();
                                //打印接收数据
                                System.out.println("从服务器接收的数据: "+str);
                            }
                    }
                    catch (Exception e) {
                        System.out.println("服务器未启动");
                        e.printStackTrace();
                    }
                    System.out.println("客户端停止..............");
                },""
        );
        t.start();


    }
}
