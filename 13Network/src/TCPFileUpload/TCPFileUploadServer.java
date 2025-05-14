package TCPFileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1.服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听");
        //2.等待连接
        Socket socket = serverSocket.accept();

        //3.读取客户端发送的数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //4.将bytes数组写入指定路径
        String destFilePath = "13Network/src/TCPFileUpload/Jerry_copy.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bufferedOutputStream.write(bytes);

        bufferedOutputStream.close();

        //向客户端回复“收到图片”
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();
        socket.shutdownOutput();

        //5.关闭其他资源
        bufferedWriter.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
