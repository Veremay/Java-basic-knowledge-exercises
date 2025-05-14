package SocketTCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("9999端口已建立，等待连接...");
        Socket socket = serverSocket.accept();  // 如果没有客户端连接这个端口，将会阻塞在这里，下面的程序将不执行
        System.out.println("server_socket返回：" + socket.getClass());
        //3.通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        //4.IO读取
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buffer)) != -1) {
            //根据读取到的实际长度，显示内容
            System.out.println(new String(buffer, 0, readLen));
        }
        //5.关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
