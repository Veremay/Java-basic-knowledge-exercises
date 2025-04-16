import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionsHomework02 {
    /*
    1)使用HashMap类实例化一个Map类型的对象m，键(String)和值(int)分别用于员工的姓名和工资，存入数据如下:jack-650元;tom-1200元;smith-2900元:
    2)将jack的工资更改为2600元
    3)为所有员工工资加薪100元;
    4)遍历集合中所有的员工
    5)遍历集合中所有的工资
     */
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        m.put("jack", 2600);


        // 使用keyset
        Set keyset = m.keySet();
        for (Object key : keyset) {
            m.put(key, (int)m.get(key) + 100);
            System.out.println(key);
        }

        // 使用values
        Collection values = m.values();
        for (Object value :values) {
            System.out.println(value);
        }
    }


}
