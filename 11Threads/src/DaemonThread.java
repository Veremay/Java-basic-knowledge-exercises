public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        //守护线程 当用户进程结束时自己也会自动结束
        MyDaemonThread daemonThread = new MyDaemonThread();
        //先设置为守护线程再启动
        daemonThread.setDaemon(true);
        daemonThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("----主线程执行----" + i);
            Thread.sleep(700);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (; ; ) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("守护线程执行");
        }

    }
}