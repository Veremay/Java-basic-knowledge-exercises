package service;

import java.util.HashMap;

/*
    管理客户端连接到服务器端的线程类们
 */
public class ManageClientConnectServerThread {
    //我们把多个线程放入一个HashMap集合，key就是用户id，value 就是线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }

    //通过UserId得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }

    //将某个线程移出集合
    public static void deleteClientConnectServerThread(String userId) {
        hm.remove(userId);
    }
}
