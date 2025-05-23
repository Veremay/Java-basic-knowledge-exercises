package service;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/*
    该类对应的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId; //连接到客户端的userid

    @Override
    public void run() {//线程处于运行状态，可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + "保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // TODO 后面会使用Message
                //判断message类型，然后做相应的业务处理
                if (message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)) {
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
                } else if (message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + " 请求退出");

                    // 返回message
                    Message message3 = new Message();
                    message3.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
                    message3.setReceiver(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message3);

                    ManageServerConnectClientThread.deleteClientThread(message.getSender());
                    socket.close();
                    //退出while循环，结束run()方法
                    break;
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println(message.getSender() + "请求发送消息给" + message.getReceiver());
//                    //返回给客户端
//                    ObjectOutputStream oos =
//                            new ObjectOutputStream(
//                                    ManageServerConnectClientThread.
//                                            getServerConnectClientThread(message.getReceiver()).
//                                            getSocket().
//                                            getOutputStream());
//                    oos.writeObject(message); // 转发
                    // TODO 如果用户不在线，可以保存到数据库
                    //检查接收者是否在线
                    ServerConnectClientThread receiverThread = ManageServerConnectClientThread.getServerConnectClientThread(message.getReceiver());
                    if (receiverThread != null) {
                        //接收者在线，直接转发消息
                        ObjectOutputStream oos = new ObjectOutputStream(receiverThread.getSocket().getOutputStream());
                        oos.writeObject(message);
                    } else {
                        //接收者不在线，存储到离线消息数据库
                        Server.addOfflineMessage(message);
                        System.out.println("用户 " + message.getReceiver() + " 离线，消息已存储");
                    }
                } else if (message.getMessageType().equals(MessageType.MESSAGE_TOALL_MES)) {
                    //需要遍历管理线程的集合，把所有线程都得到，然后转发message
                    HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户id
                        String onlineUserId = iterator.next().toString();
                        if (!onlineUserId.equals(message.getSender())) { //排除群发消息的用户本人
                            //转发message
                            ObjectOutputStream oos = new ObjectOutputStream(
                                    hm.get(onlineUserId). //取出了线程
                                            getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                    System.out.println("\n" + message.getSender() + "对大家说：" + message.getContent());

                } else if (message.getMessageType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println(message.getSender() + "请求发送文件给" + message.getReceiver());
//                    //返回给客户端
//                    ObjectOutputStream oos =
//                            new ObjectOutputStream(
//                                    ManageServerConnectClientThread.
//                                            getServerConnectClientThread(
//                                                    message.getReceiver()).getSocket().getOutputStream());
//                    oos.writeObject(message); // 转发
                    //检查接收者是否在线
                    ServerConnectClientThread receiverThread = ManageServerConnectClientThread.getServerConnectClientThread(message.getReceiver());
                    if (receiverThread != null) {
                        //接收者在线，直接转发文件
                        ObjectOutputStream oos = new ObjectOutputStream(receiverThread.getSocket().getOutputStream());
                        oos.writeObject(message);
                    } else {
                        //接收者不在线，存储到离线消息数据库
                        Server.addOfflineMessage(message);
                        System.out.println("用户 " + message.getReceiver() + " 不在线，文件已存储");
                    }
                } else {
                    System.out.println("其他消息类型...");
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

    public Socket getSocket() {
        return socket;
    }
}
