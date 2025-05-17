package Homework;


/*
(1)使用字符流的方式，编写一个客户端程序和服务器端程序,
(2)客户端发送"name",服务器端接收到后，返回"我是 nova" nova是你自己的名字
(3)客户端发送"hobby",服务器端接收到后，返回"编写java程序”
(4)不是这两个问题，回复"你说啥呢”
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HW01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("9999端口已建立，等待连接...");
        Socket socket = serverSocket.accept();  // 如果没有客户端连接这个端口，将会阻塞在这里，下面的程序将不执行

        //通过socket.getInputStream()读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //IO读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String answer = "";
        if(s.equals("name")){
            answer = "我是May";
        }else if(s.equals("hobby")){
            answer = "摄影";
        }else{
            answer = "你说什么呢";
        }

        bufferedWriter.write(answer);
        bufferedWriter.newLine();//插入换行符，表示写入结束
        bufferedWriter.flush();

        bufferedReader.close();//关闭外层流
        socket.close();
        serverSocket.close();
        bufferedWriter.close();
        System.out.println("服务端退出...");
    }
}
