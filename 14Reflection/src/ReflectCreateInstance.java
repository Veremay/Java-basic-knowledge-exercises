
/*
    演示通过反射机制创建实例
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.先获取到User类的Class对象
        Class<?> userClass = Class.forName("User");
        //2.通过public无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3.通过public有参构造器创建实例
        Constructor<?> constructor = userClass.getConstructor(String.class);
        Object user1 = constructor.newInstance("hmy");
        System.out.println("hmy: " + user1);
        //4.通过非公有有参构造器创建实例
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);  //暴破，使用反射可以访问非公有构造器
        Object user2 = declaredConstructor.newInstance(25, "joy");
        System.out.println(user2);
    }
}

class User {
    private int age = 23;
    private String name = "may";

    public User() {
    }

    public User(String name){
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String tostring() {
        return "User [age=" + age + "name =" + name + "]";
    }
}
