package service;

import common.Message;
import common.MessageType;

import java.io.*;

/*
    该类完成文件传输服务
 */
public class FileClientService {

    /**
     * @param src        源文件
     * @param dest       目标目录
     * @param senderId   发送人
     * @param receiverId 接收人
     */
    public void sendFileToOne(String src, String dest, String senderId, String receiverId) {
        //读取src文件 --> message
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setReceiver(receiverId);
        message.setSrc(src);
        message.setDest(dest);
        // 读取文件
        // 创建一个文件输入流
        FileInputStream fileInputStream = null;
        byte[] fileByte = new byte[(int) new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileByte); //将src文件读入程序的字节数组
            message.setFileByte(fileByte);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭文件输入流
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //发送
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n" + "你给" + receiverId + "发送文件 " + src + " 到对方本地目录 " + dest);

    }
}
