public class Thread03 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);

        thread.start();
        thread1.start();

    }
}

class Thread1 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("-----First Thread " + (++count) + " " + Thread.currentThread().getName() +  "-----");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (count == 10) {
                break;
            }
        }
    }
}

class Thread2 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("*****Second Thread " + (++count) + " " + Thread.currentThread().getName() +  "*****");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (count == 15) {
                break;
            }
        }
    }
}
