package SocketTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP_Client {
    public static void main(String[] args) throws IOException {
        //1.连接本机的9999端口，如果连接成功，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("client_socket返回：" + socket.getClass());
        //2.连接上后，生成Socket，通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到数据通道
        outputStream.write("hello,server".getBytes());
        //设置结束标记（不然一直结束不了）
        socket.shutdownOutput();
        //4.通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        //5.IO读取
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buffer)) != -1) {
            //根据读取到的实际长度，显示内容
            System.out.println(new String(buffer, 0, readLen));
        }

        //6.关闭流对象和socket，必须关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
