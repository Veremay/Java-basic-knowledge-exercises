package ClassLoad;

/*
    演示类加载-初始化阶段
 */
public class ClassLoad02 {
    public static void main(String[] args) {
        //1.加载B类，并生成 B的class对象
        //2.链接 num = 0
        //3.初始化阶段
        /*
            依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句
            clinit() {
                System.out.println("B 静态代码块被执行");
                num = 300;
                num = 100;
                //合并
                num = 100;
            }

         */
        //直接使用类的静态属性也会导致类的加载
        System.out.println(B.num);
        //加载类的时候，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
            //正因为有这个机制，才能保证某个类在内存中只存在一个Class对象
            synchronized (getClassLoadingLock(name)){
            // ....
            }
        }
         */
        B b = new B();
    }
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B() {
        System.out.println("B的构造器被执行");
    }
}