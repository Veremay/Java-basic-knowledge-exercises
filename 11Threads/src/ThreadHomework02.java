public class ThreadHomework02 {
    /*
    (1)有2个用户分别从同一个卡上取钱(总额:10000)
    (2)每次都取1000,当余额不足时，就不能取款了
    (3)不能出现超取现象 =》 线程同步问题,
     */
    public static void main(String[] args) {
        Account01 account = new Account01();
        Thread thread1 = new Thread(account);
        thread1.setName("t1");
        Thread thread2 = new Thread(account);
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }

}

//编程取款的线程
//1.因为这里涉及到多个线程共享资源，所以我们使用实现Runnable方式
class Account01 implements Runnable{
    private int money = 10000;

    @Override
    public void run() {
        while(true){

            synchronized (this){
                //1.这里使用 synchronized 实现了线程同步
                //2，当多个线程执行到这里时，就会去争夺this对象锁
                // 3.哪个线程争夺到(获取)this对象锁，就执行synchronized 代码块，执行完后会释放this对象锁
                // 4.争夺不到this对象锁，就blocked，准备继续争夺
                // this是非公平锁
                if(money < 1000){
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出了1000块，当前余额：" + money);
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
