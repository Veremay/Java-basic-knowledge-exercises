import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String path="12IO_Flow/data.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        //要符合序列化时的输入顺序
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());
        Object object = objectInputStream.readObject();
        System.out.println(object.getClass());
        System.out.println(object);
        Dog dog=(Dog)object;  //向下转型
        dog.bark();
    }
}