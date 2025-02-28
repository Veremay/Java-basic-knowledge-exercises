package CodeBlock;

public class Test2 {
    //主方法
    public static void main(String str[]){
        Test a=new Test();//无参构造器
    }
}

class Sample{
    Sample(String s){
        System.out.println(s);
    }
    Sample(){
        System.out.println("Sample默认构造函数被调用");
    }

}

class Test{
    Sample sam_n=new Sample("普通成员sam_n初始化");// 3
    static Sample sam_s =new Sample("静态成员sam_s初始化");// 1
    static{
        System.out.println("static块执行");// 2
        if(sam_s==null)System.out.println("sam is null");
    }
    Test()
    {
        System.out.println("Test默认构造函数被调用");// 4
    }
}
