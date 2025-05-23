package service;

import common.Message;
import common.MessageType;
import utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/*
    该类用于服务器给所有用户发消息
 */
public class SendNoticeToAllService implements Runnable{

    @Override
    public void run() {
        //为了可以多次推送消息
        while(true){
            System.out.println("请输入服务器要推送的内容[输入exit表示退出推送服务]：");
            String notice = Utility.readString(1000);
            if(notice.equals("exit")){
                break;
            }
            Message message = new Message();
            message.setMessageType(MessageType.MESSAGE_TOALL_MES);
            message.setSender("服务器");
            message.setContent(notice);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人：" + notice);

            //遍历当前所有通信线程，得到socket，发送message
            HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while(iterator.hasNext()){
                String onlineUserId = iterator.next().toString();
                ServerConnectClientThread serverConnectClientThread = hm.get(onlineUserId);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
