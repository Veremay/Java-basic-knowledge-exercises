import java.util.*;

public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("吴承恩", new Book("西游记", 1000));
        map.put("吴承恩", null);
        map.put("may", "hmy");
        map.put("verena", "hmy");
        map.put(null, "jimmy");
        map.put("sherry", "martina");

        System.out.println(map);

        // 可以用增强for循环和迭代器进行遍历
        Set set = map.keySet();      //也可以直接通过map对象获取键和值，跳过了entryset
        System.out.println("keyset：" + set);
        Collection values = map.values();    //注意Set和Collection只是编译类型
        System.out.println("values：" + values);
        System.out.println(set.getClass());    //运行类型：class java.util.map$KeySet
        System.out.println(values.getClass());   //class java.util.map$Values

        //第一组:先取出所有的Key，通过Key 取出对应的Value
        //(1)增强for
        System.out.println("-----第一种方式-------");
        for(Object key : set){
            System.out.println(key +"-"+ map.get(key));
        }
        //(2)迭代器
        System.out.println("----第二种方式----");
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组:取出所有的Value
        //(1)增强for
        System.out.println("-----value第一种方式-------");
        for(Object value : values){
            System.out.println(value);
        }
        //(2)迭代器
        System.out.println("----value第二种方式----");
        Iterator iterator2 = values.iterator();
        while(iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
        }

        //第三组:通过EntrySet 来获取k-v
        Set entrySet = map.entrySet();// EntrySet<Map.Entry<K,V>>
        // (1)增强for
        System.out.println("----使用EntrySet 的 for增强----");
        for(Object entry :entrySet){
            //将entry 转成 Map.Entry
            Map.Entry m=(Map.Entry)entry;   // HashMap$Node没有实现获取值的方法，所以向下转型 实现->Map.Entry(getKey,getValue)
            System.out.println(m.getKey()+"-" + m.getValue());
        }

        // 同理 也可以用迭代器

        System.out.println("-----------------------");

        //查找元素
        Object object = map.get("may");
        System.out.println("查找元素：" + object);
        //根据键删除键值对
        Object remove = map.remove("吴承恩");
        System.out.print("删除键值对：");
        System.out.println(map);
        //检查map是否为空
        boolean empty = map.isEmpty();
        System.out.println("map是否为空：" +empty);
        //查看是否包含某个键
        boolean b = map.containsKey(null);
        System.out.println("是否包含某个键：" +b);
        //查看当前的entry个数
        System.out.println("entry个数：" +map.size());
        //清空所有映射
        map.clear();

        System.out.println(map);
    }

    static class Book{
        private String name;
        private int storage;

        public Book(String name, int storage) {
            this.name = name;
            this.storage = storage;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", storage=" + storage +
                    '}';
        }
    }
}
