public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        StateThread stateThread = new StateThread();
        System.out.println("主线程" + stateThread.getName() + " 状态：" + stateThread.getState());
        stateThread.start();

        while (stateThread.getState() != Thread.State.TERMINATED) {
            System.out.println("主线程" + stateThread.getName() + " 状态：" + stateThread.getState());
            Thread.sleep(1000);
        }

        System.out.println("主线程" + stateThread.getName() + " 状态：" + stateThread.getState());
    }
}

class StateThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 10; i++) {
            System.out.println("子线程执行" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.println("----子线程执行结束----");
    }
}
