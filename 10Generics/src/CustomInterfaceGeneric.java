public class CustomInterfaceGeneric {

}

class C implements IUsb<Object, Object>{
    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }
}

// 实现接口IUsb时，直接指定了泛型数据类型
class A implements IUsb<String,Integer> {
    @Override
    public Integer get(String s) {
        return 0;
    }

    @Override
    public void hi(Integer integer) {

    }

    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}

// 继承了接口IUsb，并指定了泛型数据类型
interface MyInterface extends IUsb<String,Integer>{}

// 实现了接口MyInterface,所以泛型数据类型和接口的一样
class D implements MyInterface{
    @Override
    public Integer get(String s) {
        return 0;
    }

    @Override
    public void hi(Integer integer) {

    }

    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}
