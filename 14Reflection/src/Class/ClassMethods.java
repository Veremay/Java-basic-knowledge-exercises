package Class;

import java.lang.reflect.Field;

public class ClassMethods {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        String str = "Class.Car";
        //获取到Class类对象,?表示不确定的java类型
        Class<?> clazz = Class.forName(str);
        System.out.println(clazz);
        //显示该clazz对象是哪个类的Class对象
        System.out.println(clazz.getClass());
        //得到package名称
        System.out.println(clazz.getPackage().getName());
        System.out.println(clazz.getName());
        //通过反射创建对象
        Object obj = clazz.newInstance();
        System.out.println(obj);
        //通过反射获取属性
        Field field = clazz.getField("brand");
        field.set(obj, "BMW"); // 通过字段对象 赋值
        Object obj2 = field.get(obj); // 获取值
        System.out.println("品牌：" + obj2); //输出

        Field[] fields = clazz.getFields();
        for (Field field_ : fields) {
            //输出属性名
            System.out.println(field_.getName());
        }
    }
}
