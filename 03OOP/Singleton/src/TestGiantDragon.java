/**
 * 饿汉模式
 */
public class TestGiantDragon {

    public static void main(String[] args) {
        //通过new实例化会报错
//      GiantDragon g = new GiantDragon();

        //只能通过getInstance得到对象
        GiantDragon g1 = GiantDragon.getInstance();
        System.out.println(g1);
        GiantDragon g2 = GiantDragon.getInstance();
        GiantDragon g3 = GiantDragon.getInstance();

        //都是同一个对象，指向同一个static堆空间
        System.out.println(g1==g2);
        System.out.println(g1==g3);
    }

}


class GiantDragon {
    private String name;

    //私有化构造方法使得该类无法在外部通过new 进行实例化
    private GiantDragon(String name){
        this.name = name;
        System.out.println("私有化构造方法");
    }

    //准备一个类属性，指向一个实例化对象。 因为是类属性，所以只有一个
    private static GiantDragon instance = new GiantDragon("Demo");

    //public static 方法，提供给调用者获取定义的对象
    public static GiantDragon getInstance(){
        return instance;
    }

    @Override
    public String toString() {
        return "name='" + name + "'";
    }
}
