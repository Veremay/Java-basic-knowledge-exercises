import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Intro {

    public static void main(String[] args) throws Exception {
        //1.使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("14Reflection/src/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
//        System.out.println(classfullpath.getClass());

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

    }

}
