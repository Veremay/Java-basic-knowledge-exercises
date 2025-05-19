package common;

public interface MessageType {
    //在接口中定义一些常量，不同常量的值表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1"; //登陆成功
    String MESSAGE_LOGIN_FAIL = "2"; //登陆失败
    String MESSAGE_COMM_MES = "3"; //普通信息
    String MESSAGE_GET_ONLINE_FRIEND = "4"; //返回在线用户列表
    String MESSAGE_RETURN_ONLINE_FRIEND = "5";
    String MESSAGE_CLIENT_EXIT = "6"; //客户端请求退出
}
