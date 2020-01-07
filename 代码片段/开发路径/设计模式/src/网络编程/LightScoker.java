package 网络编程;


import java.io.*;
import java.net.Socket;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/4  8:48
 * @版本：
 */
public class LightScoker {
    public static void main(String[] args) {


        try (
                Socket socket = new Socket("localhost", 8080);
                InputStreamReader io = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(io);
        ) {


            System.out.println("LightScoker 开始..........");
//            while (true) {

                StringBuilder sb = new StringBuilder();
                byte[] b = new byte[1024];
                String s = bufferedReader.readLine();
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(s.getBytes());
                System.out.println("结束.................");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
