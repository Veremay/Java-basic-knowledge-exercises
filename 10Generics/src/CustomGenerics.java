import java.util.ArrayList;
import java.util.HashMap;

public class CustomGenerics {
    public static void main(String[] args) {
        // 实体化泛型类，同时赋予泛型实值
        Tiger<Double, String, Integer> john = new Tiger<>("john");
        System.out.println(john);
        Tiger<Double, String, Integer> marry = new Tiger<>("marry", 50.0,"Emma",5);
        System.out.println(marry);
        Tiger james = new Tiger("james");
        james.setWeight("50");
        james.setFeeder("may");
        james.setAge("9");
        System.out.println(james);

        john.f1("healthy", 7);
        Tiger<String, ArrayList, HashMap> lucy = new Tiger<>("lucy");
        lucy.hello("nice to meet you", new ArrayList());
    }
}

//定义泛型类
class Tiger<R,M,T>{
    String name;
    R weight;
    M feeder;
    T age;

    //泛型数组不能在定义时初始化，还不知道数据类型->不知道大小，所以不知道要开辟多大的空间
    //R[] rr=new R[9];


    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(String name, R weight, M feeder, T age) {
        this.name = name;
        this.weight = weight;
        this.feeder = feeder;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getWeight() {
        return weight;
    }

    public void setWeight(R weight) {
        this.weight = weight;
    }

    public M getFeeder() {
        return feeder;
    }

    public void setFeeder(M feeder) {
        this.feeder = feeder;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public <T,S> void f1(T t,S s){
        System.out.println(t.getClass());   //参考下面第三点，类型输出为String
        System.out.println(s.getClass());   //Integer
    }

    //泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型
    public<K> void hello(R r, K k){
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + weight +
                ", m=" + feeder +
                ", t=" + age+
                '}';
    }
}
