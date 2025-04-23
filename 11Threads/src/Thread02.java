public class Thread02 {
    /*
    请编写程序,该程序可以每隔1秒。在控制台输出“hi!”,当输出10次后，自动退出
    请使用实现Runnable接口的方式实现。
     */
    public static void main(String[] args) {
        Dog dog = new Dog();
        //Runnable接口并没有start()方法
        //通过借用Thread中的start达到启动线程的目的
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + (++count) + "\t当前thread：" + Thread.currentThread().getName());
            if (count == 10)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
