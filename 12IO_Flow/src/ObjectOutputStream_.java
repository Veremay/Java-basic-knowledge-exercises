import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception {
        String path = "12IO_Flow/data.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeInt(1);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeDouble(0.9);
        objectOutputStream.writeUTF("hello");    //存储String类型用writeUTF

        //以上几个都是实现了Serializable的类，存储时会自动装箱
        //必须是实现了Serializable接口的类才能进行序列化操作
        objectOutputStream.writeObject(new Dog(10, "Cici", "白色", 2));
        objectOutputStream.close();
    }
}

//其中的自定义Dog类
class Dog implements Serializable {
    private int age;
    private String name;
    private static final long serialVersionUID = 1;   //版本控制，当该类出现修改时，无需重新序列化和反序列化
    private transient String color;
    private static int add;

    public Dog(int age, String name, String color, int add) {
        this.age = age;
        this.name = name;
        this.color = color;
        this.add = add;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}' + color + add;
    }

    public void bark() {
        System.out.println("汪汪汪");
    }
}