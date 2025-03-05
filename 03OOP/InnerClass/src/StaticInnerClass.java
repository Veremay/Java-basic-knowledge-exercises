public class StaticInnerClass {
    public static void main(String[] args) {
        // 方式1
        Outer02.Inner02 inner02 = new Outer02.Inner02();
        inner02.say();
        // 方式2
        Outer02.Inner02 inn02Instance = new Outer02().getInner02Instance();
        // 方式3
        Outer02.Inner02 inner02InstanceStatic = Outer02.getInner02Instance_static();

    }
}

class Outer02 {//外部类
    private int n1 = 10;
    private static String name = "张三";

    // 1.放在外部类的成员位置
    // 2.使用static 修饰
    // 3.可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    // 4.可以添加任意访问修饰符(public、protected、默认、private),因为它的地位就是一个成员
    // 5.作用域:同其他的成员，为整个类体
    static class Inner02 {
        public void say() {
            System.out.println(name);//不能直接访问外部类的非静态成员
            // System.out.println(n1);
        }
    }

    public void show() {//外部类使用内部类
        new Inner02().say();
    }

    public Inner02 getInner02Instance(){
        return new Inner02();
    }

    public static Inner02 getInner02Instance_static(){
        return new Inner02();
    }
}