public class SellTicketSync {
    public static void main(String[] args) {
        SellingSync selling = new SellingSync();


        new Thread(selling).start();
        new Thread(selling).start();
        new Thread(selling).start();

    }
}

class SellingSync implements Runnable {
    private int ticketNum = 1000;
    private boolean loop = true;
    Object obj = new Object();

    @Override
    public void run() {
        while (loop) {
//            sell();
            sell2();
        }
    }

    public synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("售票结束...");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口 " + Thread.currentThread().getName() + "售出一张票，剩余票数：" + (--ticketNum));
    }

    // 方案2
    public /*synchronized*/ void sell2() {
        synchronized (/*this*/ obj) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + "售出一张票，剩余票数：" + (--ticketNum));
        }

    }

    //1.public synchronized static void m1(){}锁是加在 SellTicketSync.class
    // 2，如果在静态方法中，实现一个同步代码块。
    /*
    public synchronized static void m1(){
        synchronized(SellTicketSync.class){
            System.out.println("m2");
        }}

     */
}

