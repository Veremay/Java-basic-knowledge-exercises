import java.util.Random;
import java.util.Scanner;

public class ThreadHomework {
    /*
    (1)在main方法中启动两个线程
    (2)第1个线程循环随机打印100以内的整数
    (3)直到第2个线程从键盘读取了“Q”命令,

    分析：
    main方法启动A、B两个线程
    A线程循环打印
    B线程持有A线程对象，以通知的方式终止A线程
     */
    public static void main(String[] args) {

        PrintNum printNum = new PrintNum();
        Terminate terminate = new Terminate(printNum);
        terminate.start();
        printNum.start();
    }
}

class PrintNum extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        super.run();
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop){
        this.loop = loop;
    }
}

class Terminate extends Thread{
    private PrintNum printNum;
    private Scanner scanner = new Scanner(System.in);

    public Terminate(PrintNum printNum) {
        this.printNum = printNum;
    }

    @Override
    public void run() {
        super.run();
        while(true){
            //接收用户输入
            System.out.println("请输入指令：(Q)表示退出");
            char key=scanner.next().toUpperCase().charAt(0);
            if(key == 'Q'){
                //以通知的方式终止A线程
                this.printNum.setLoop(false);
                break;
            }
        }

    }
}
