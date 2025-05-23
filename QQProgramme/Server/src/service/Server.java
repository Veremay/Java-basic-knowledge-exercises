package service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
    这是服务器，在监听9999，等待客户端的连接，并保持通信
 */
public class Server {
    private ServerSocket serverSocket = null;
    //创建一个集合，存放多个用户
    //这里也可以使用并发集合，没有线程安全问题 ConcurrentHashMap
//    private static HashMap<String, User> validUsers = new HashMap<>();
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ArrayList<Message>> offlineDB = new ConcurrentHashMap<>();

    static { //静态代码块，初始化
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("may", new User("may", "123456"));
        validUsers.put("amy", new User("amy", "123456"));
        validUsers.put("lucy", new User("lucy", "123456"));
        validUsers.put("sherry", new User("sherry", "123456"));

    }


    //验证用户是否有效
    private boolean checkUser(String userId, String pwd) {
        User user = validUsers.get(userId);
        if (user == null) {
            System.out.println("user不存在");
            return false;
        }
        if (!user.getPasswd().equals(pwd)) {
            System.out.println("密码错误");
            return false;
        }
        return true;
    }

    //添加离线消息到数据库
    public static void addOfflineMessage(Message message) {
        String receiver = message.getReceiver();
        offlineDB.computeIfAbsent(receiver, k -> new ArrayList<>()).add(message);
    }

    //获取并清除用户的离线消息
    public static ArrayList<Message> getAndClearOfflineMessages(String userId) {
        return offlineDB.remove(userId);
    }

    public Server() {

        try {
            //端口其实可以写在一个配置文件中
            System.out.println("服务端在9999端口监听");
            //启动推送消息的线程
            new Thread(new SendNoticeToAllService()).start();
            serverSocket = new ServerSocket(9999);
            //监听的行为是个持续的过程
            while (true) {
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
                if (checkUser(user.getUserId(), user.getPasswd())) {
                    //验证通过
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复给客户端
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    serverConnectClientThread.start();
                    //把线程对象放入一个集合中进行管理
                    ManageServerConnectClientThread.addClientThread(user.getUserId(), serverConnectClientThread);
                    //检查是否有离线消息
                    ArrayList<Message> offlineMessages = getAndClearOfflineMessages(user.getUserId());
                    if (offlineMessages != null && !offlineMessages.isEmpty()) {
                        System.out.println("有发送离线消息给用户 " + user.getUserId());
                        for (Message offlineMessage : offlineMessages) {
                            ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
                            oos1.writeObject(offlineMessage);
                        }
                    }
                } else {
                    //验证失败
                    System.out.println("用户 id=" + user.getUserId() + " 登录失败...");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务器退出了while，说明服务器不再监听，因此需要关闭serverSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
