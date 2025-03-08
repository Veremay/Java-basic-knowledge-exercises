import java.io.FileNotFoundException;

public class throwsDetail {
    public static void main(String[] args) {

    }

    public static void f1() {
        //因为f2抛出的是运行异常，系统不要求必须处理，且f1默认会有throws方法继续往上抛出
        f2();
    }

    public static void f2() throws ArrayIndexOutOfBoundsException {

    }

    public static void f3() throws FileNotFoundException {
        //因为f4抛出的是编译异常，必须处理，try和throws二选一
        f4();
    }
    public static void f4() throws FileNotFoundException {

    }

    public static void f5(){
        try {
            f4();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

class Father {
    public void work() throws RuntimeException {
    }
}

class Son extends Father {
    //子类抛出的异常类型必须和父类抛出的类型相同，或是其子类
    @Override
    public void work() throws NullPointerException {

    }
}



