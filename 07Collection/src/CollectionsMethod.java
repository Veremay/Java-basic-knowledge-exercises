import java.util.ArrayList;
import java.util.List;

public class CollectionsMethod {
    public static void main(String[] args) {
        List list = new ArrayList(); //ArrayList是接口，接口不能实例化，所以要向上转型
        //1.添加元素
        list.add("三国演义");
        list.add("水浒传");
        list.add(true);
        list.add(10);
        System.out.println(list);
        //2.检查是否为空
        System.out.println(list.isEmpty());
        //3.获取长度
        System.out.println(list.size());
        //4.添加多个元素
        ArrayList arrayList = new ArrayList();
        arrayList.add("红楼梦");
        arrayList.add("西游记");
        list.addAll(arrayList);
        System.out.println(list);
        //5.检查某个元素是否存在
        System.out.println(list.contains("三国演义"));
        //6.检查多个元素是否存在
        System.out.println(list.containsAll(arrayList));
        //7.清除所有元素
//        list.clear();
//        System.out.println(list);
        //8.删除元素
        list.remove(0);    //根据下标删除元素
        System.out.println(list);
        list.remove("西游记");   //根据值删除元素
        System.out.println(list);
        list.remove(Integer.valueOf(10)); //删除数字
        System.out.println(list);
        //9.删除多个元素
        list.removeAll(arrayList);
        System.out.println(list);
    }
}
