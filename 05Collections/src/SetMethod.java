import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        // 1.以Set 接口的实现类 HashSet 来讲解Set接口的方法
        // 2.Set接口的实现类对象不能存放重复元素
        // 3.存放数据是无序的
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");
        set.add("jack");
        set.add(null);
        set.add(null);

        System.out.println("set = " + set);

        // Hashset不能添加相同的元素/数据?
        Set set2 = new HashSet<>();
        set2.add("lucy");// 添加成功
        set2.add("lucy");// 添加失败
        set2.add(new Dog("lucy"));// 添加成功
        set2.add(new Dog("lucy"));// 添加成功
        System.out.println("set="+ set2);

        //非常经典的面试题
        set2.add(new String("hmy"));// 添加成功
        set2.add(new String("hmy"));// 添加失败
        System.out.println("set="+ set2);

    }

    public static class Dog{
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
