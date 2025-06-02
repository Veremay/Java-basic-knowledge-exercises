
/*
    演示反射操作成员属性
 */

import java.lang.reflect.Field;

public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1.得到student类对应的 Class对象
        Class<?> stuClass = Class.forName("Student");
        //2.创建对象
        Object o = stuClass.newInstance();//o 的运行类型就是Student
        //3.使用反射得到age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 88);
        System.out.println(o);
        System.out.println(age.get(o)); //返回age属性的值

        //4。使用反射操作name 属性
        Field name =stuClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "hmy");
        System.out.println(o);
        name.set(null, "may");//因为name是static属性，因此o也可以写出null
        System.out.println(o);

    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    public String toString() {
        return "Student [age=" + age + ",name=" + name + "]";
    }
}
