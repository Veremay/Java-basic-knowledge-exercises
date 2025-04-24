public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        //线程插队与礼让
        T2 t2 = new T2();
        t2.start();
        //主线程也开始吃包子
        for (int i = 1; i <=20 ; i++) {
            System.out.println("主线程执行"+i);
            Thread.sleep(50);
            //吃了5个之后让子线程插队，待其全部吃完再返回主线程
            if(i==5){
                System.out.println("----让给子线程先执行----");
                //join() 让子线程先执行完
                //t2.join();
                //yield()礼让，可能分配失败   注意是Thread.方法名
                Thread.yield();
            }
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 20; i++) {
            System.out.println("子线程执行"+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("----子线程执行结束----");

    }
}