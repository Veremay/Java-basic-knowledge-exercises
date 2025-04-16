import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsMethods {
    public static void main(String[] args) {
        //Collections工具类 可用于对集合的各种操作
        //以ArrayList为例
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");
        arrayList.add("tom");
        arrayList.add("jerry");
        System.out.println(arrayList);

        //1.翻转list
        System.out.println("=====翻转list=====");
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        //2.随机生成顺序
        System.out.println("=====随机生成顺序=====");
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(arrayList);
            System.out.println(arrayList);
        }


        //3.排序  默认是用compare排序
        System.out.println("=====排序=====");
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //自定义排序顺序以及规则
        Collections.sort(arrayList, new Comparator() {
            //按长度进行排序
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(arrayList);


        //4.交换两个元素的位置
        System.out.println("=====交换两个元素=====");
        Collections.swap(arrayList, 1, 2);
        System.out.println(arrayList);


        //5.获取最大值（默认字母排序，也可以通过比较器进行自定义）
        System.out.println("=====获取最大值最小值=====");
        System.out.println(Collections.max(arrayList));
        //获取最小值
        System.out.println(Collections.min(arrayList));


        //6.拷贝元素到另一个list中
        System.out.println("=====拷贝list=====");
        ArrayList desc = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            desc.add("");
        }
        Collections.copy(desc, arrayList);  //注意：若目标容量小于原数组容量，则会报错数组越界
        System.out.println(desc);


        //6.查找某一元素在数组中出现的频率
        System.out.println("=====查找频率=====");
        int tom = Collections.frequency(desc, "tom");
        System.out.println(tom);


        //7.将指定元素值进行替换
        System.out.println("=====替换元素=====");
        Collections.replaceAll(arrayList, "tom", "汤米");
        System.out.println(arrayList);
    }
}
