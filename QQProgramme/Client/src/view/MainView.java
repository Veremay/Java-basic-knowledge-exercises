package view;

import service.UserClientService;
import utils.Utility;

/*
    客户端菜单界面
 */
public class MainView {
    public static void main(String[] args) {
        new MainView().mainMenu();
    }

    private boolean loop = true; //控制是否显示菜单
    private String key = ""; //接收用户键盘输入
    private UserClientService userClientService = new UserClientService(); //用于登录服务器

    //显示主菜单
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
                    //需要到服务端去验证该用户是否合法
                    // 用户登录验证UserClientService
                    if (userClientService.checkUser(userId,pwd)) {
                        System.out.println("==========欢迎用户" + userId + "==========");
                        // 进入二级菜单
                        while (loop) {
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
                                    System.out.println("显示在线用户");
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                            }
                        }
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
}
