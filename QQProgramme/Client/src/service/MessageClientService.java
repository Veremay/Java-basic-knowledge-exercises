package service;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/*
    该类向服务端提供message相关的服务方法
 */
public class MessageClientService {

    /**
     *
     * @param content 发送消息的内容
     * @param senderId 发送者id
     * @param receiverId 接收者id
     */
    public void sendMessageToOne(String content, String senderId, String receiverId){
        //构建message
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderId);
        message.setReceiver(receiverId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + "对" + receiverId + "说：" + content);
        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
