package CodeBlock;

/**
 * 创建对象时的调用顺序
 */
public class Sequence1 {
    public static void main(String[] args) {
        A a = new A();
    }
}


class A {
    //静态属性初始化
    private static int n1 = getVal();//(1)
    //普通属性初始化
    private int n2 = getVal2(); //(3)

    //普通代码块
    { //(4)
        System.out.println("A的普通代码块..");
    }

    //静态代码块
    static { //(2)
        System.out.println("A的静态代码块...");
    }

    public A() {
        super();
        System.out.println("A()的构造器被调用");//(5)
    }

    public static int getVal() {
        System.out.println("getVal()方法被调用，静态属性初始化");
        return 10;
    }

    public int getVal2() {
        System.out.println("getVal2()方法被调用，普通属性初始化");
        return 30;
    }


}