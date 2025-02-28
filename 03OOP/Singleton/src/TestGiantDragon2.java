/**
 * 懒汉模式
 */
public class TestGiantDragon2 {
    public static void main(String[] args) {
        //通过new实例化会报错
//      GiantDragon g = new GiantDragon();

        //只能通过getInstance得到对象
        GiantDragon2 g1 = GiantDragon2.getInstance();
        System.out.println(g1);
        GiantDragon2 g2 = GiantDragon2.getInstance();
        GiantDragon2 g3 = GiantDragon2.getInstance();

        //都是同一个对象
        System.out.println(g1==g2);
        System.out.println(g1==g3);
    }
}

class GiantDragon2 {
    private String name;
    //GiantDragon2 进行实例化
    private GiantDragon2(String name){
        this.name = name;
        System.out.println("私有化构造方法");
    }

    //准备一个类属性，用于指向一个实例化对象，但是暂时指向null
    private static GiantDragon2 instance;

    //public static 方法，返回实例对象 （非线程安全的，不推荐使用该写法）
    public static GiantDragon2 getInstance(){
        //第一次访问的时候，发现instance没有指向任何对象，这时实例化一个对象
        if(null==instance){
            instance = new GiantDragon2("Demo");
        }
        //返回 instance指向的对象
        return instance;
    }

    /*
    // 线程安全的，并且通过非空判断提升性能（因为如果只上锁，那么每次调用的时候都会上锁，事实上只有第一次创建对象的时候才需要加锁）
    public static GiantDragon2 getInstance(){
        if(instance == null){
            synchronized(instance){
                //第一次访问的时候，发现instance没有指向任何对象，这时实例化一个对象
                if(null==instance){
                    instance = new GiantDragon2();
                }
            }
        }
        //返回 instance指向的对象
        return instance;
    }

    //以上线程安全的写法在java单例设计模式中并非完美的写法，因为在JVM执行过程中可能会存在问题，感兴趣的小伙伴可以去找一下相关的资料。
     */

    @Override
    public String toString() {
        return "name='" + name + "'";
    }
}
