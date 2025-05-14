package TCPFileUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //创建客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        //创建服务端磁盘的文件输入流
        String filePath = "13Network/src/TCPFileUpload/Jerry.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));

        //把文件读入字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //通过socket获取到输出流，将bytes数据发送给服务端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);//将文件对应的字节数组的内容，写入到数据通道
        bufferedInputStream.close();
        socket.shutdownOutput();

        //接收从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils的方法直接将inputstream读取到的内容转为字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bufferedOutputStream.close();
        socket.close();
    }
}
