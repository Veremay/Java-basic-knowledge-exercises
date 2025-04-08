public class CustomException {
    public static void main(String[] args) {
        int age = 80;//要求范围在18-120 之间，否则抛出一个自定义异常
        if(!(age >= 18 && age <= 120)){
            throw new AgeException("年龄需要在 18~120之间");
        }
        System.out.println("年龄范围正确");
    }
}

//自定义一个异常
class AgeException extends RuntimeException {
    public AgeException(String message) {//构造器
        super(message);
    }
}
