import java.util.ArrayList;
import java.util.List;

public class GenericsExtends {
    public static void main(String[] args) {
        Object o = new String("xx");

        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();

        //举例说明下面三个方法的使用
        List<Object> list_obj = new ArrayList<>();
        List<String> list_str = new ArrayList<>();
        List<AA> list_aa = new ArrayList<>();
        List<BB> list_bb = new ArrayList<>();
        List<CC> list_cc = new ArrayList<>();

        //如果是List<?>c，可以接受任意的泛型类型
        printCollection(list_obj);
        printCollection(list_str);
        printCollection(list_aa);
        printCollection(list_bb);
        printCollection(list_cc);

        //如果是List<? extends AA>c，可以接受AA或者AA的子类，即BB CC
        //printCollection_extends(list_obj);
        //printCollection_extends(list_str);
        //printCollection_extends(list_aa);
        printCollection_extends(list_bb);
        printCollection_extends(list_cc);

        //如果是List<? super AA>c，可以接收AA或者AA的父类，不限于直接父类
        printCollection_super(list_obj);
        // printCollection_super(list_str);
        printCollection_super(list_aa);
        //printCollection_super(list_bb);
        //printCollection_super(list_cc);


    }


    // List<?>表示所有泛型都可以接收
    public static void printCollection(List<?> c) {
        for (Object object : c) {// 通配符，取出时，就是Object
            System.out.println(object);
        }
    }

    //?extends AA 表示 上限，可以接受 AA或者AA子类
    public static void printCollection_extends(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    //?super 子类类名AA:支持AA类以及AA类的父类，不限于直接父类
    // 规定了泛型的下限
    public static void printCollection_super(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);

        }
    }
}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}
