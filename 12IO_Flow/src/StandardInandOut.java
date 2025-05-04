import java.util.Scanner;

public class StandardInandOut {
    public static void main(String[] args) {
        //System类的public final static InputStream in = null;//System.in 编译类型InputStream
        //System.in 运行类型BufferedInputStream
        //表示的是标准输入雪
        System.out.println(System.in.getClass());

        //1.System.out public final static PrintStream out = null;
        //2.编译类型 PrintStream
        //3.运行类型 PrintStream
        //4.表示标准输出显示器
        System.out.println(System.out.getClass());
        System.out.println("hello，may~");

        Scanner scanner =new Scanner(System.in);
        System.out.println("输入内容");
        String next =scanner.next();
        System.out.println("next="+ next);

    }
}
