package SocketUDP;

import java.io.IOException;
import java.net.*;

public class B_ {
    public static void main(String[] args) throws IOException {
        //接收一条信息
        //监听9999端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //UDP一个数据包最大64k
        byte[] info = new byte[1024];
        //用packet来接收传送过来的信息包
        DatagramPacket datagramPacket = new DatagramPacket(info, info.length);
        //接收packet
        //当有数据包发送到本机的9999端口时，就会接收到数据
        //如果没有数据包发送到本机的9999端口，就会阻塞等待。
        System.out.println("B端等待接收数据...");
        datagramSocket.receive(datagramPacket);
        //拆包，取出数据并显示
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, length));

        //发送一条消息给SenderA
        byte[] data_2 = "明天见！".getBytes();
        //用packet封装
        DatagramPacket datagramPacket1 = new DatagramPacket(data_2, data_2.length, InetAddress.getLocalHost(), 9998);
        //用socket发送
        datagramSocket.send(datagramPacket1);

        //关闭socket
        datagramSocket.close();
        System.out.println("B端退出");
    }
}
