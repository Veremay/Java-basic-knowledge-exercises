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

public class HW02Receiver {
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
        String question = new String(data, 0, length);
        System.out.println(question);

        String answer = "";
        if(question.equals("四大名著是哪些")){
            answer = "四大名著是《红楼梦》《水浒传》《三国演义》《西游记》";
        }else{
            answer = "What?";
        }

        //发送一条消息给SenderA
        byte[] data_2 = answer.getBytes();
        //用packet封装
        DatagramPacket datagramPacket1 = new DatagramPacket(data_2, data_2.length, InetAddress.getLocalHost(), 9998);
        //用socket发送
        datagramSocket.send(datagramPacket1);

        //关闭socket
        datagramSocket.close();
        System.out.println("B端退出");
    }
}
