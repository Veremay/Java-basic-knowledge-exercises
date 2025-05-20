package service;

import java.util.HashMap;
import java.util.Iterator;

/*
    用于管理和客户端通信的线程们
 */
public class ManageServerConnectClientThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //添加线程对象到hm集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread){
        hm.put(userId, serverConnectClientThread);
    }
    //通过UserId得到对应线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    //从hm集合移出线程对象
    public static void deleteClientThread(String userId){
        hm.remove(userId);
    }

    //返回在线用户列表的方法
    //格式： 100 200 紫霞仙子
    public static String getOnlineFriend(){
        //遍历hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while(iterator.hasNext()){
            onlineUserList += iterator.next() + " ";
        }
        return onlineUserList;
    }
}
