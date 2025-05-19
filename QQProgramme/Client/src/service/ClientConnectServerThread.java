package service;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
    //该线程需要持有socket
    private Socket socket;

    //构造器可以接收一个socket对象
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为Thread要在后台挂起和服务器通信，所以用while循环控制
        while(true){
            try {
                System.out.println("客户端线程，等待从读取从服务器端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象,线程会阻塞在这里
                Message message = (Message) ois.readObject();
                // TODO 处理message
                //判断message类型，然后做相应的业务处理
                if(message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){
                    //取出在线列表信息并显示
                    //规定了在线列表形式  用户名用空格隔开
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n==========当前在线用户==========");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }

                }else{
                    System.out.println("其他类型message");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //为了更方便地拿到socket
    public Socket getSocket() {
        return socket;
    }
}
