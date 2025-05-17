package Homework;

import TCPFileUpload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/*
(1)编写客户端程序和服务器端程序
(2)客户端可以输入 一个 音乐 文件名，比如 高山流水,服务端 收到音乐名后，可以给客户端 返回这个 音乐文件，如果服务器没有这个文件，返回 一个默认的音乐即可.
(3)客户端收到文件后，保存到本地
(4)提示:该程序可以使用 StreamUtils.java
 */
public class HW03Client {
    public static void main(String[] args) throws Exception {
        //1.连接本机的9999端口，如果连接成功，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.连接上后，生成Socket，通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到数据通道，使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //从键盘读取用户的问题
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入你想下载的歌曲：");
        String downLoadFileName=scanner.next();

        bufferedWriter.write(downLoadFileName);
        bufferedWriter.newLine();//插入换行符，表示写入内容结束，此时也要求对方使用readLine()来读结束符
        bufferedWriter.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

        //读取服务端发送的数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //将bytes数组写入指定路径
        String destFilePath = "13Network/src/Homework/" + downLoadFileName + "_copy.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bufferedOutputStream.write(bytes);

        System.out.println("下载完毕，路径为：" + destFilePath);

        bufferedOutputStream.close();
        bufferedInputStream.close();
        outputStream.close();
        socket.close();
        bufferedWriter.close();
    }
}
