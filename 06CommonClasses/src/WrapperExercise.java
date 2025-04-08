public class WrapperExercise {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    public static void method1() {
//        Integer i= new Integer(1);
//        Integer j= new Integer(1);
//        System.out.println(i == j);  //false

        Integer m = 1; //底层 Integer.valueOf(1); -> 阅读源码
        Integer n = 1;
        //所以，这里主要是看范围-128 ~127 就是直接返回
        //，否则，就new Integer(xx)
        System.out.println(m == n); //true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); //false
    }

    public static void method2() {
        //示例一
//        Integer i1=new Integer( 127 );
//        Integer i2=new Integer( 127 );
//        System.out.println(i1==i2);
//        //示例二
//        Integer i3=new Integer( 128 );
//        Integer i4=new Integer( 128 );
//        System.out.println(i3==i4);
        //示例三
        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);

        //示例四
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);
        //示例五
//        Integer i9 = 127;
//        Integer i10 = new Integer(127);
//        System.out.println(i9 == i10);

        //只要有基本数据类型，就是判断数值是否相等
        //示例六
        Integer i11 = 127;
        int i12 = 127;
        System.out.println(i11 == i12); //true
        //示例七
        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14); //true
    }
}
