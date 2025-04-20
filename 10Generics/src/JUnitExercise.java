/*
定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为T 类型。
分别创建以下方法:
(1)public void save(String id,T entity): 保存T 类型的对象到 Map 成员变量中
(2)publicT get(String id):从 map 中获取 id 对应的对象
(3)public void update(String id,T entity):替换 map 中key为id的内容,改为 entity 对象
(4)public List<T> list():返回 map 中存放的所有T对象
(5)public void delete(String id): 删除指定 id 对象

定义一个 User 类:该类包含:private成员变量(int类型)id，age;(String 类型)name。
创建 DAO 类的对象，分别调用其 save、get、update、list、delete 方法来操作 User 对象使用 Junit 单元测试类进行测试。
 */

import org.junit.Test;

import java.util.*;

public class JUnitExercise {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        //说明
        //这里我们给T 指定类型是User
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, 10, "jack"));
        dao.save("002", new User(2, 14, "may"));

        List<User> list = dao.list();
        System.out.println("list=" + list);

        dao.update("001", new User(3, 58, "milan"));
        System.out.println("===修改后====");
        list = dao.list();
        System.out.println("list=" + list);
        dao.delete("001");
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    //返回map 中存放的所有T对象
    // 遍历map[k-v],将map的 所有value(T entity),封装到ArrayList返回即可
    public List<T> list() {
        //创建 Arraylist
        List<T> list = new ArrayList<>();
        //遍历map
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(map.get(key));//也可以直接使用本类的 get(string id)
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void save(String id, T entity) {//把entity保存到map
        map.put(id, entity);
    }
}


class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
