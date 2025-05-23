package view;

import service.FileClientService;
import service.MessageClientService;
import service.UserClientService;
import utils.Utility;

/*
    客户端菜单界面
 */
public class MainView {
    public static void main(String[] args) {
        new MainView().mainMenu();
    }

    private boolean loop = true; // 控制是否显示菜单
    private String key = ""; // 接收用户键盘输入
    private UserClientService userClientService = new UserClientService(); // 用于登录服务器
    private MessageClientService messageClientService = new MessageClientService(); //用于发送消息
    private FileClientService fileClientService = new FileClientService(); //用于传输文件

    // 显示主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("==========欢迎登录网络通信系统==========");
            System.out.println("\t\t1 登录系统");
            System.out.println("\t\t9 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.print("请输入用户id：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(50);
                    // 用户登录验证UserClientService
                    if (userClientService.checkUser(userId, pwd)) {
                        System.out.println("==========欢迎用户" + userId + "登录成功==========");
                        secondaryMenu(userId);
                    } else {
                        System.out.println("==========登录失败==========");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }

    // 二级菜单逻辑封装到一个独立方法中
    private void secondaryMenu(String userId) {
        boolean secondaryLoop = true;
        while (secondaryLoop) {
            System.out.println("==========网络通信系统二级菜单（用户 " + userId + "）==========");
            System.out.println("\t\t1 显示在线用户列表");
            System.out.println("\t\t2 群发消息");
            System.out.println("\t\t3 私聊消息");
            System.out.println("\t\t4 发送文件");
            System.out.println("\t\t9 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    // 写一个方法获取在线用户列表
                    userClientService.getOnlineFriendList();
//                    System.out.println("显示在线用户");
                    break;
                case "2":
//                    System.out.println("群发消息");
                    System.out.println("请输入想对大家说的话：");
                    String broadcastContent = Utility.readString(100);
                    // 把群发消息发送给服务端
                    messageClientService.sendMessageToAll(broadcastContent, userId);
                    break;
                case "3":
//                    System.out.println("私聊消息");
                    System.out.println("请输入想要聊天的用户（在线）：");
                    String receiverId = Utility.readString(50);
                    System.out.println("请输入想要发送的内容：");
                    String privateContent = Utility.readString(100);
                    // 编写一个方法，把私聊消息发送给服务端
                    messageClientService.sendMessageToOne(privateContent, userId, receiverId);
                    break;
                case "4":
//                    System.out.println("发送文件");
                    System.out.println("请输入想要发送文件的对象（在线）：");
                    String fileReceiverId = Utility.readString(50);
                    System.out.println("请输入你想发送的源文件路径：");
                    String src = Utility.readString(100);
                    System.out.println("请输入你想发送到的对方的路径：");
                    String dest = Utility.readString(100);
                    fileClientService.sendFileToOne(src, dest, userId, fileReceiverId);
                    break;
                case "9":
                    System.out.println("退出系统");
                    userClientService.exit();
                    secondaryLoop = false; // 退出二级菜单
                    loop = false;          // 退出主菜单
                    break;
                default:
                    System.out.println("无效的选项，请重新输入");
                    break;
            }
        }
    }
}
