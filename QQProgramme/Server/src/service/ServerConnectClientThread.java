package service;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
    该类对应的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{

    private Socket socket;
    private String userId; //连接到客户端的userid

    @Override
    public void run() {//线程处于运行状态，可以发送/接收消息
        while(true){
            try {
                System.out.println("服务端和客户端" + userId + "保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // TODO 后面会使用Message
                //判断message类型，然后做相应的业务处理
                if(message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){
                    System.out.println(message.getSender() + " 请求在线用户列表");
                    String onlineUsers = ManageServerConnectClientThread.getOnlineFriend();
                    // 返回message
                    Message message2 = new Message();
                    message2.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
                    message2.setContent(onlineUsers);
                    message2.setReceiver(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }
}
