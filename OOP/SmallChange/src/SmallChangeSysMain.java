import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类完成零钱通的所有功能，最主要的类
 */

public class SmallChangeSysMain {
    //属性
    //定义相关的变量
    boolean loop = true;
    Scanner scanner =new Scanner(System.in);
    String key ="";
    //2.完成零钱通明细
    // 老韩思路，(1)可以把收益入账和消费，保存到数组(2)可以使用对象(3)简单的话可以使用String拼接
    String details ="----------零钱通明细---------";
    //3.完成收益入账 完成功能驱动程序员增加新的变化和代码
    // 老韩思路，定义新的变量
    double money = 0;
    double balance =0;
    Date date = null;// date 是 java.util.Date 类型，表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //可以用于日期格式化的

    //4.消费
    //定义新变量，保存消费的原因
    String note = "";


    //菜单
    public void mainMenu() {
        do {
            System.out.println("\n==========零钱通菜单===========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");
            System.out.print("请选择(1-4):");
            key = scanner.next();

            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.consume();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }

        } while (loop);
    }

    //明细
    public void detail(){
        System.out.println(details);
    }

    //收益入账
    public void income(){
        System.out.print("收益入账金额:");
        money = scanner.nextDouble();
        // money 的值范围应该校验-》一会完善
        // 老师思路，编程思想
        // 找出不正确的金额条件，然后给出提示，就直接return
        if(money <= 0){
            System.out.println("收益入账金额 需要 大于 0");
            return; //退出方法，不再执行之后的代码
        }
        //找出正确金额的条件
        balance += money;
        //拼接收益入账信息到 details
        date = new Date();//获取当前日期
        details += "\n收益入账\t+"+ money + "\t"+ sdf.format(date)+ "\t"+ balance;
    }

    public void consume(){
        System.out.print("消费金额:");
        money = scanner.nextDouble();
        //money 的值范围应该校验 -》一会完善
        //找出金额不正确的情况
        //过关斩将 校验方式
        if(money <= 0 || money > balance){
            System.out.println("你的消费金额 应该在 0-"+ balance);
            return;
        }
        System.out.print("消费说明:");
        note = scanner.next();
        balance -= money;
        //拼接消费信息到 details
        date = new Date();//获取当前日期
        details +="\n" + note +"\t-"+ money + "\t" +
                    sdf.format(date) + "\t" + balance;
    }

    public void exit(){
        //用户输入4退出时，给出提示"你确定要退出吗?y/n"，必须输入正确的y/n
        //否则循环输入指令，直到输入y或者n
        //老韩思路分析
        //(1)定义一个变量choice，接收用户的输入
        //(2)使用 while + break，来处理接收到的输入时 y 或者 n
        //(3)退出while后，再判断choice是y还是n，就可以决定是否退出
        //(4)建议一段代码，完成一个小功能，尽量不要混在一起
        String choice ="";
        while(true) {//要求用户必须输入y/n，否则就一直循环
            System.out.println("你确定要退出吗?y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }

            //第二个方案
//            if ("y".equals(choice)) {
//                loop = false;
//                break;
//            } else if ("n".equals(choice)) {
//                break;
//            }
        }
            //当用户退出while,进行判断
            if (choice.equals("y")) {
                loop = false;
            }
    }
}
