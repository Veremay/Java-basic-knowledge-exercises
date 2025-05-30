package Class;

public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        String path="Class.Car";
        //1.在编译阶段，通过输入完整路径获得的类对象  forname
        //适用于读取配置文件，获得完整路径
        Class<?> cls1 = Class.forName(path);
        System.out.println(cls1);

        //2.在加载阶段，通过类型.Class的方法获取对象
        //适用于参数的传递
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3.在运行阶段，通过getclass获取对象
        //由此可见，car对象是知道自己在加载阶段属于的是哪个class对象
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> aClass = classLoader.loadClass(path);
        System.out.println(aClass);

        //5.获取基本数据类型对应的对象
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        //6.获取包装类的对应的对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);
        System.out.println(type.hashCode());
        System.out.println(integerClass.hashCode());
    }
}
