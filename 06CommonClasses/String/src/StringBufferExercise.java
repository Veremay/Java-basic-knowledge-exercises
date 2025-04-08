import java.util.Scanner;

public class StringBufferExercise {
    public static void main(String[] args) {
        String str = null;// ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str);//需要看源码，底层调用的是 AbstractStringBuilder 的 appendNull()
        System.out.println(sb.length());  //4
        System.out.println(sb); //null
//        StringBuffer sb1 = new StringBuffer(str); //NullPointerException
//        System.out.println(sb1);

        System.out.println("===================");
        /*
        输入商品名称和商品价格，要求打印效果示例,使用前面学习的方法完成
        商品名  商品价格
        手机  123,564.59
        要求:价格的小数点前面每三位用逗号隔开。
         */

        String price = "12345678.34";
        StringBuffer sb2 = new StringBuffer(price);
        //找到小数点的索引，然后在该位置的前位，插入，即可
        for (int i = sb2.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb2 = sb2.insert(i, ",");
        }
        System.out.println(sb2);

    }
}
