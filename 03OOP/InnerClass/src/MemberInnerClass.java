public class MemberInnerClass {
    public static void main(String[] args) {
        //其它外部类访问内部类，方式1
        Outer01 outer01 = new Outer01();
        Outer01.Inner01 inner01 = outer01.new Inner01();
        //方式2:
        Outer01.Inner01 inner012 = new Outer01().new Inner01();
        //方式3: 使用一个方法来获取，更加简洁
        Outer01.Inner01 inner01Instance = new Outer01().getInner01Instance();
    }
}

class Outer01 {
    private int n1 = 10;
    public String name = "张三";

    class Inner01 {
        private int sale = 99;
        public void say() {
            System.out.println("Outer01的n1= " + n1 + "outer01的name= " + name);

        }
    }


    public Inner01 getInner01Instance() {
        return new Inner01();
    }

    private void show() {
        //使用成员内部类
        //创建成员内部类的对象，然后使用相关的方法
        // 私有的也可以使用
        Inner01 inner01 = new Inner01();
        inner01.say();
        System.out.println("Inner01 sale = " + inner01.sale);
    }
}
