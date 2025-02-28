package CodeBlock;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("total = " + Person.total);
        System.out.println("total = " + Person.total);

    }
}

class Person {
    public static int total;

    static {
        total = 100;
        System.out.println("in static block!");//1
    }
}

/**
 * 输出
 * in static block!
 * total = 100
 * total = 100
 */

