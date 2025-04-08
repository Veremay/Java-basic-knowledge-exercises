public class MemoryTest {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b); // false a和b分属两个不同对象
        System.out.println(a.equals(b)); // false Animal中没有重写equals()方法，所以还是在比较a和b两个对象
        System.out.println(a.name == b.name); // true a、b两个对象value指向池里面的地址是一样的

        String s4 = new String("hspedu");
        String s5 = "hspedu";
        System.out.println(s1 == s4); // false s4是在堆里新开了一个对象
        System.out.println(s4 == s5); // false
        String t1 = "hello" + s1; // 在堆里新开一个对象
        String t2 = "hellohspedu";
        System.out.println(t1.intern() == t2);// true intern()直接跳到池里的地址
    }

    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }
    }

}
