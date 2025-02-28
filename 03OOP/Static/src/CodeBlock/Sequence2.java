package CodeBlock;

/**
 * 在继承情况下，创建对象类中的调用顺序
 * 先静态再普通（优先级最高）
 * 先父类再子类
 */
public class Sequence2 {
    public static void main(String[] args) {
        new Sub();
    }
}

class Parent {
    private static int p_static = getPS(); //(1)
    private int p_normal = getPN(); //(5)

    {
        System.out.println("父类的普通代码块...");  //(6)
    }

    static {
        System.out.println("父类的静态代码块..."); //(2)
    }

    public Parent() {
        // (1)super()
        // (2)本类普通代码块
        System.out.println("父类构造器被调用..."); //(7)
    }

    private static int getPS() {
        System.out.println("父类getPS()被调用，静态属性初始化..."); //(1)
        return 10;
    }

    private int getPN(){
        System.out.println("父类getPN()被调用，普通属性初始化..."); //(5)
        return 20;
    }
}

class Sub extends Parent {

    {
        System.out.println("子类的普通代码块..."); //(8)
    }

    static {
        System.out.println("子类的静态代码块..."); //(3)
    }

    private static int s_static = getSS(); //(4)
    private int s_normal = getSN(); //(9)

    public Sub() {
        //(1)super()被隐藏
        //(2)调用本类普通代码块
        System.out.println("子类的构造器被调用..."); //(10)
    }

    private static int getSS() { //(4)
        System.out.println("子类getSS()被调用，静态属性初始化...");
        return 10;
    }

    private int getSN(){ //(9)
        System.out.println("子类getSN()被调用，普通属性初始化...");
        return 20;
    }
}