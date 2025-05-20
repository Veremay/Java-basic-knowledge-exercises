package service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
    该类完成用户登录验证和注册等功能
 */
public class UserClientService {
    private boolean isValid = false;
    private User user = new User(); //可能会在其他地方用到user信息，因此变成一个成员属性
    private Socket socket; //可能在其他地方也会使用到

    //根据userId和pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        //创建user对象
        user.setUserId(userId);
        user.setPasswd(pwd);

        //连接到服务端，发送对象
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);//发送user对象

            //读取从服务端回送的message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();

            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                // 创建一个和服务器端保持通信的线程->创建一个类ClientConnectServerThread
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                // 启动客户端的线程
                ccst.start();
                //为了后面客户端的扩展，我们将线程放入到集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, ccst);
                isValid = true;
            } else {
                //如果登录失败，就不能启动和服务器通信的线程，关闭socket
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }

    //向服务器请求在线用户列表
    public void getOnlineFriendList(){
        //发送一个消息，类型是请求在线用户列表
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
        message.setSender(user.getUserId());

        //发送给服务器
        try {
            //从管理线程的集合中取得线程
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId());
            //得到当前线程socket对应的ObjectInputStream对象
            Socket socket1 = clientConnectServerThread.getSocket();
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket1.getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //退出客户端，并向服务器请求退出
    public void exit(){
        //发送一个消息，类型是请求退出
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUserId());

        //发送给服务器
        try {
            //从管理线程的集合中取得线程
            ClientConnectServerThread ccst = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId());
            //得到当前线程socket对应的ObjectInputStream对象
            Socket socket2 = ccst.getSocket();
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket2.getOutputStream());
            oos.writeObject(message);
            ManageClientConnectServerThread.deleteClientConnectServerThread(user.getUserId());
            System.out.println(user.getUserId() + " 退出了系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
