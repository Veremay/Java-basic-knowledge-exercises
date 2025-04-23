public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个cat对象，可以当作线程使用
        Cat cat = new Cat();
        cat.start();    //启动线程

        //说明:当main线程启动一个子线程 Thread-0，主线程不会阻塞

        System.out.println("主线程继续执行"+ Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i=" + i);//让主线程休眠
            Thread.sleep(1000);
        }
    }
}

// 1.当一个类继承了 Thread类，该类就可以当做线程使用
// 2.我们会重写run方法，写上自己的业务代码
// 3.run Thread 类实现了 Runnable 接口的run方法
/*
    @Override
    public void run(){
        if(target != null){
            target.run();
        }
    }
 */

class Cat extends Thread {
    @Override
    public void run() { //重写run方法，写上自己的业务逻辑
        super.run();
        int times = 0;
        while (true) { // 不停地做
            if (times == 8)
                break;
            System.out.println("小猫叫 " + times + "线程：" + Thread.currentThread().getName());
            // 快捷键ctrl + alt + t
            try {
                Thread.sleep(1000);    //休眠一秒钟
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            times++;
        }
    }
}