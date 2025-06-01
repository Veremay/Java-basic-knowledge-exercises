
/*
    演示如何通过反射获取类的结构信息
 */

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //第一组测试API
    @Test
    public void api_01() throws ClassNotFoundException {
        //得到Class对象
        Class<?> personCls = Class.forName("Person");
//        1. `getName`:获取全类名
        System.out.println(personCls.getName());
//        2. `getSimpleNam`e:获取简单类名
        System.out.println(personCls.getSimpleName());
//        3. `getFields`:获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的public属性：" + field.getName());
        }
//        4. `getDeclaredFields`:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类的属性：" + declaredField.getName());
        }
//        5. `getMethods`:获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的public方法：" + method.getName());  //这里还有父类Object
        }
//        6. `getDeclaredMethods`:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法：" + declaredMethod.getName());
        }
//        7. `getConstructors`: 获取本类所有public修饰的构造器
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类public构造器：" + constructor.getName());
        }
//        8. `getDeclaredConstructors`:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器：" + declaredConstructor.getName());
        }
//        9. `getPackage`:以Package形式返回 包信息
        System.out.println(personCls.getPackage());
//        10. `getSuperClass`:以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println(superclass);
//        11. `getInterfaces`:以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息：" + anInterface);
        }
//        12. `getAnnotations`:以Annotation[]形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息：" + annotation);
        }
    }

    //第二组测试API
    @Test
    public void api_02() throws ClassNotFoundException {
        //得到Class对象
        Class<?> personCls = Class.forName("Person");
        //getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //默认修饰符是0，public 是1，private是2，protected 是4，static是8，final是16
            System.out.println("本类中所有属性：" + declaredField.getName()
                    + "，该属性的访问修饰符值：" + declaredField.getModifiers()
                    + "，该属性的类型：" + declaredField.getType());
        }

        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法：" + declaredMethod.getName()
                    + "，该方法的访问修饰符值：" + declaredMethod.getModifiers()
                    + "，该方法的返回类型：" + declaredMethod.getReturnType());

            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型：" + parameterType);
            }
        }

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("-------");
            System.out.println("本类中所有构造器：" + declaredConstructor.getName());

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型：" + parameterType);
            }
        }
    }
}

class A {
    public String hobby;

    public A() {
    }

    public A(String hobby) {
    }

    public void hi() {
    }
}

interface IA {
}

interface IB {
}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age;
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
    }

    private Person(String name, int age) {
    }

    //方法
    public void m1() {
    }

    protected String m2() {
        return "may";
    }


    void m3() {
    }

    private void m4() {
    }
}

