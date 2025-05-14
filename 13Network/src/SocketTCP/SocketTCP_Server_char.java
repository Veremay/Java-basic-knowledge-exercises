package SocketTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP_Server_char {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("9999端口已建立，等待连接...");
        Socket socket = serverSocket.accept();  // 如果没有客户端连接这个端口，将会阻塞在这里，下面的程序将不执行
        System.out.println("server_socket返回：" + socket.getClass());
        //3.通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        //4.IO读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);//输出
        //5.获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client 字符流");
        bufferedWriter.newLine();//插入换行符，表示写入结束
        bufferedWriter.flush();
//        // 不需要结束标记
//        socket.shutdownOutput();
        //6.关闭流和socket
        bufferedReader.close();//关闭外层流
        socket.close();
        serverSocket.close();
        bufferedWriter.close();
        System.out.println("服务端退出...");

    }
}
