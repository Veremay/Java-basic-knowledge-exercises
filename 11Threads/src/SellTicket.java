public class SellTicket {
    public static void main(String[] args) {
        Selling selling = new Selling();

        // 这个地方先不考虑同步和互斥锁的问题
        (new Thread(selling)).start();
        (new Thread(selling)).start();

    }
}

class Selling implements Runnable {

    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + "售出一张票，剩余票数：" + (--ticketNum));
        }
    }
}
