import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        //先创建对象并插入一些元素
        List list=new ArrayList();
        list.add("may");
        list.add("jack");
        list.add("sophie");
        list.add("may");
        //list中存储的元素是有序且允许重复的
        System.out.println(list);
        //1.指定位置插入元素
        System.out.println("===指定位置插入元素===");
        list.add(1,"henry");
        System.out.println(list);
        //2.指定位置插入多个元素
        System.out.println("===指定位置插入多个元素===");
        List list1 = new ArrayList();
        list1.add("emma");
        list1.add("lucy");
        list.addAll(1,list1);
        System.out.println(list);
        //3.获取指定下标位置的元素
        System.out.println("===获取指定下标位置的元素===");
        System.out.println(list.get(1));
        //4.返回索引到的第一个元素的下标位置
        System.out.println("===返回索引到的第一个元素的下标位置===");
        int syx = list.indexOf("may");
        System.out.println(syx);
        //5.返回索引到的最后一个元素的下标位置
        System.out.println("===返回索引到的最后一个元素的下标位置===");
        int syx1 = list.lastIndexOf("may");
        System.out.println(syx1);
        //6.替换指定位置的元素,即更改值
        System.out.println("===替换指定位置的元素===");
        list.set(1,"sherry");
        System.out.println(list);
        //7.获取[a,b)的元素
        System.out.println("===获取[a,b)的元素===");
        List list2 = list.subList(0, 2);
        System.out.println(list2);
        //8.移除指定位置的元素  这个方法是Collection接口的
        System.out.println("===移除指定位置的元素===");
        list.remove(1);
        System.out.println(list);
    }
}
