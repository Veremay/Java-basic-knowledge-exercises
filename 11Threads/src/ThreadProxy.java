public class ThreadProxy {
    public static void main(String[] args) {
        //接下来通过模拟线程的代理模式，来探究Thread thread = new Thread(dog);到底是如何实现的
        Tiger tiger = new Tiger();
        Proxy threadProxy = new Proxy(tiger);// tiger实现了Runnable接口，proxy的构造器也接收Runnable类型

        threadProxy.start();
    }
}

class Animal{}
class Tiger extends Animal implements Runnable{
    int num=0;
    @Override
    public void run() {
        while (true){
            System.out.println("老虎叫"+(++num));
            if(num==10)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//模拟Thread中的代理模式，最简单的一种
//简单来讲，我没有这个方法，就让有这个方法的人代我去做，结果返还给我
class Proxy implements Runnable{
    Runnable target=null;
    //构造器
    public Proxy(Runnable target){   //接收实现了Runnable接口的类
        this.target=target;
    }

    @Override
    public void run() {
        if(target!=null)
            target.run();   //动态绑定到实现了Runnable的类，从而启动线程,本例中是绑定到了Tiger类的run方法
    }

    //start是线程创建时调用的函数，其底层实现是start0
    public void start(){
        start0();
    }
    //底层的start0会调用run()
    //start0()是最重要的，是真正实现多线程的方法
    public void start0(){
        run();
    }
}
