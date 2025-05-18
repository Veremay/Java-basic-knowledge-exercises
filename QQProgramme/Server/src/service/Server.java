package service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    这是服务器，在监听9999，等待客户端的连接，并保持通信
 */
public class Server {
    private ServerSocket serverSocket= null;

    public Server() {

        try {
            //端口其实可以写在一个配置文件中
            System.out.println("服务端在9999端口监听");
            serverSocket = new ServerSocket(9999);
            //监听的行为是个持续的过程
            while(true){
                Socket socket = serverSocket.accept(); //如果没有客户端连接，就会阻塞

                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //读取客户端发送的User对象
                User user = (User) ois.readObject();
                //创建一个message对象 准备回复客户端
                Message message = new Message();
                //验证
                //照理说是应该去数据库里查找的，但这里先写死了
                if(user.getUserId().equals("100") && user.getPasswd().equals("123456")) {
                    //验证通过
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复给客户端
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    serverConnectClientThread.start();
                    //把线程对象放入一个集合中进行管理
                    ManageServerConnectClientThread.addClientThread(user.getUserId(), serverConnectClientThread);

                }else{
                    //验证失败
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务器退出了while，说明服务器不再监听，因此需要关闭serverSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
