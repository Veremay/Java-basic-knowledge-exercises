
/*
    演示通过反射调用方法
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //1.用反射获取对象
        Class<?> bossClass = Class.forName("Boss");
        Object boss = bossClass.newInstance();
        //2.获取公有方法
        //先看看有哪些
        Method[] declaredMethods = bossClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        Method hi = bossClass.getMethod("hi", String.class);
        hi.invoke(boss,"hmy");

        //3.获取并运行私有方法
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        //爆破
        say.setAccessible(true);
        System.out.println(say.invoke(boss,23, "hmy", '女'));
        //因为say方法时static的，还可以这样调用，可以传入null
        System.out.println(say.invoke(null, 20, "李四",'女'));

    }
}

class Boss {//类
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) { //静态方法
        return n + " " + s + " " + c;
    }

    public void hi(String s) { //普通public方法
        System.out.println("hi " + s);
    }
}
