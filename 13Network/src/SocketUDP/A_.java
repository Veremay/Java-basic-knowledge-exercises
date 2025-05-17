package SocketUDP;

import java.io.IOException;
import java.net.*;

public class A_ {
    public static void main(String[] args) throws IOException {
        //发送一条信息
        //创建Socket，用于发送信息，每一方都有自己的端口号
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        //创建Packet，用于包装信息
        byte[] data = "你好！".getBytes();
        //包装的同时设置要发送的ip地址以及端口号
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);

        //接收来自ReceiverB的回复（9999端口）
        //准备字节数组进行接收
        //一个数据包最大64k
        byte[] data_2 = new byte[1024];
        //创建packet，接收传过来的信息
        datagramPacket = new DatagramPacket(data_2, data_2.length);
        //接收packet
        //当有数据包发送到本机的9999端口时，就会接收到数据
        //如果没有数据包发送到本机的9999端口，就会阻塞等待。
        System.out.println("A端等待接收数据...");
        datagramSocket.receive(datagramPacket);
        //获取数组的实际长度
        int length = datagramPacket.getLength();
        byte[] data1 = datagramPacket.getData();
        System.out.println(new String(data1, 0, length));

        //关闭socket
        datagramSocket.close();
        System.out.println("A端退出");
    }
}
