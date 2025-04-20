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

public class JUnitExercise {
}

class DAO<T>{

}


class User{
    private int id;
    private int age;
    private String name;

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
