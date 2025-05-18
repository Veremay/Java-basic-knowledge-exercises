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
            // TODO 服务器验证代码

            //读取从服务端回送的message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();

            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                // TODO 创建一个和服务器端保持通信的线程->创建一个类ClientConnectServerThread
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
}
