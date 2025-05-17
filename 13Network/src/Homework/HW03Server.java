package Homework;

import TCPFileUpload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
(1)编写客户端程序和服务器端程序
(2)客户端可以输入 一个 音乐 文件名，比如 高山流水,服务端 收到音乐名后，可以给客户端 返回这个 音乐文件，如果服务器没有这个文件，返回 一个默认的音乐即可.
(3)客户端收到文件后，保存到本地
(4)提示:该程序可以使用 StreamUtils.java
 */
public class HW03Server {
    public static void main(String[] args) throws Exception {
        //1.服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听");
        //2.等待连接
        Socket socket = serverSocket.accept();

        //3.读取客户端发送的下载文件名
        //通过socket.getInputStream()读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //IO读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String downLoadFileName = bufferedReader.readLine();
        System.out.println("客户端希望下载的文件：" + downLoadFileName);

        String resFileName = "";
        if(downLoadFileName.equals("Jerry")){
            resFileName = "13Network/src/Homework/Jerry.jpg";
        }else{
            resFileName = "13Network/src/Homework/Moon.jpg";
        }

        //4.创建一个输入流，读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));

        //5.读取文件到字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //6.得到socket关联的输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        //7.写入数据通道，返回给客户端
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();

        //8.关闭相关资源
        bufferedInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
//        bufferedOutputStream.close();
//        bufferedReader.close();

    }
}
