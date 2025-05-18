package service;

import common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
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
                System.out.println("服务端和客户端保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // TODO 后面会使用Message

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
