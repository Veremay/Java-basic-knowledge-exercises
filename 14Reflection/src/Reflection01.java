import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception {
        //1.使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("14Reflection/src/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        //2.使用反射机制
        //(1)加载类，返回Class类型的对象
        Class cls = Class.forName(classfullpath);
        //(2)通过cls 得到加载的类的对象实例
        Object o = cls.newInstance();
        //(3)通过 cls 得到加载的类的 methodName"hi"的方法对象
        //   即:在反射中，可以把方法视为对象(万物皆对象)
        Method method1 = cls.getMethod(methodName);
        //(4)通过method1 调用方法:
        // 即通过方法对象来实现调用方法
        method1.invoke(o);  //传统方法：对象.方法()，反射机制：方法.invoke(对象)

        //得到name字段
        //getField不能得到私有的属性
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o)); //成员变量对象.get(对象)

        //java.lang.reflect.Constructor:代表类的构造方法，Constructor对象表示构造器
        Constructor constructor = cls.getConstructor();//()中可以指定构造器参数类型，返回无参构造器
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class); //这里传入的 String.classs 就是String类的Class对象
        System.out.println(constructor1);

        Constructor constructor2 = cls.getConstructor(String.class, int.class); //这里传入的 String.classs 就是String类的Class对象
        System.out.println(constructor2);
    }
}
