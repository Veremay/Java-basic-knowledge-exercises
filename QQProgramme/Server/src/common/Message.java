package common;

import java.io.Serializable;

/*
    表示客户端和服务器端通信时的一个消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID=1L;
    private String sender; //发送方
    private String receiver; //接收方
    private String content; //消息内容
    private String sendTime; //发送时间
    private String messageType; //消息类型[可以在接口中定义已知的消息类型]

    // 进行拓展，和文件相关的字段
    private byte[] fileByte;
    private int fileLen = 0;
    private String dest; //将文件传输到哪里
    private String src; //源文件

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public byte[] getFileByte() {
        return fileByte;
    }

    public void setFileByte(byte[] fileByte) {
        this.fileByte = fileByte;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
