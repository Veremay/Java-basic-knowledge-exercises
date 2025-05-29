public class Cat {
    private String name = "咪咪";
    public int age = 2;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 必须是public 不然没法调用
    public void hi(){
        System.out.println("hi~");
    }
}
