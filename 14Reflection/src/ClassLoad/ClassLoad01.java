package ClassLoad;

/*
    演示类加载-连接-准备阶段
 */
public class ClassLoad01 {
    public static void main(String[] args) {

    }

}
class A{
    //属性-成员变量-字段
    //分析类加载的链接阶段-准备 属性是如何处理
    public int n1= 10;   //1.n1 是实例属性，不是静态变量，因此在准备阶段，是不会分配内存
    public static int n2 = 20;    //2.n2 是静态变量，分配内存n2是默认初始化0,而不是20
    public static final int n3 = 3;    //3.n3 是static final 是常量，他和静态变量不一样，因为一旦赋值就不变 n3 = 30
}
