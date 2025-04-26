//模拟线程死锁
public class DeadLock {
    public static void main(String[] args) {
        //创建两个线程，分别去抢夺两个资源
        DL dl = new DL(true);
        DL dl1 = new DL(false);
        dl.start();
        dl1.start();
    }
}

class DL extends Thread{
    //创建两个对象，用于代表两个不同的锁
    static Object o1=new Object();    //保证多个线程共享一个对象，若不是static，每个线程对应的o1和o2都不同，那就不是同一把锁->做不到互斥
    static Object o2=new Object();
    boolean flag;

    public DL(boolean flag){
        this.flag=flag;
    }

    @Override
    public void run() {
        super.run();
        //模拟抢资源的方式
        //1.如果flag 为T，线程A 就会先得到/持有 o1 对象锁，然后尝试去获取 o2 对象锁
        //2.如果线程A 得不到 o2 对象锁，就会Blocked
        //3.如果flag 为F，线程B 就会先得到/持有 o2 对象锁，然后尝试去获取 o1 对象锁
        //4.如果线程B得不到o1对象锁，就会Blocked
        if(flag){
            synchronized (o1){
                System.out.println(this.getName()+"进入1");
                synchronized (o2){
                    System.out.println(this.getName()+"进入2");
                }
            }
        }else{
            synchronized (o2){
                System.out.println(this.getName()+"进入3");
                synchronized (o1){
                    System.out.println(this.getName()+"进入4");
                }
            }
        }
    }
}