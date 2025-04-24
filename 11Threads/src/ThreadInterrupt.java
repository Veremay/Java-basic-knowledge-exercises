public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        T t = new T();
        t.setName("thread");
        t.setPriority(Thread.MIN_PRIORITY);

        System.out.println(t.getName());

        t.start();//启动子线程
        //主线程打印5*hi，然后就中断 子线程的休眠，相当于提前结束休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(Thread.currentThread().getName() + " 当前线程优先级：" + t.getPriority());

        t.interrupt();
    }
}

class T extends Thread { //自定义的线程类
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 运行中~~~" + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            //当该线程执行到一个interrupt方法（是中断不是终止）时，就会catch一个异常，可以加入自己的业务代码
            System.out.println(Thread.currentThread().getName() + "被 interrupt了");
        }
    }
}


