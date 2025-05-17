package Homework;


/*
(1)使用字符流的方式，编写一个客户端程序和服务器端程序,
(2)客户端发送"name",服务器端接收到后，返回"我是 nova nova 是你自己的名字
(3)客户端发送"hobby",服务器端接收到后，返回"编写java程序”
(4)不是这两个问题，回复"你说啥呢”
 */

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HW01Client {
    public static void main(String[] args) throws IOException {
        //1.连接本机的9999端口，如果连接成功，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.连接上后，生成Socket，通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到数据通道，使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //从键盘读取用户的问题
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入你的问题");
        String question=scanner.next();

        bufferedWriter.write(question);
        bufferedWriter.newLine();//插入换行符，表示写入内容结束，此时也要求对方使用readLine()来读结束符
        bufferedWriter.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

        //4.通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        //5.IO读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);//输出
        //6.关闭流对象和socket，必须关闭
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
