package Homework;


/*
(1)编写一个接收端A,和一个发送端B， 使用UDP协议完成
(2)接收端在 8888端口等待接收数据(receive)
(3)发送端向接收端 发送 数据“四大名著是哪些"
(4)接收端接收到 发送端发送的 问题后，返回"四大名著是<<红楼梦>>…"，否则返回what?
(5)接收端和发送端程序退出
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class HW02Sender {
    public static void main(String[] args) throws IOException {
        //发送一条信息
        //创建Socket，用于发送信息，每一方都有自己的端口号
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String question = scanner.next();

        //创建Packet，用于包装信息
        byte[] data = question.getBytes();
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
