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

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

    public synchronized void sell(){
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

