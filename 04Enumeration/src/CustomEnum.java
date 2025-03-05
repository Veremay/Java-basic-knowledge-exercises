public class CustomEnum {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}

class Season{
    private String season;
    private String desc;

    //1.构造器私有化，防止外部直接new实例化
    private Season(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

    //2.只能读取不能修改数据，去掉set相关方法
    public String getSeason() {
        return season;
    }

    public String getDesc() {
        return desc;
    }

    //3.直接在类内创建静态对象
    //static+final 避免类加载，底层优化
    // final: 减少加载  static: 可以被直接访问
    /*
    避免类加载的主要目的之一是延迟对类的初始化，从而提高程序的性能。
    在某些情况下，如果一个类的初始化开销较大，而且可能在程序运行的早期阶段并不需要使用，
    延迟加载可以减少不必要的性能开销
     */
    public static final Season SPRING=new Season("春天","温暖");
    public static final Season SUMMER=new Season("夏天","炎热");
    public static final Season AUTUMN=new Season("秋天","凉爽");
    public static final Season WINTER=new Season("冬天","寒冷");

    @Override
    public String toString() {
        return "Season{" +
                "season='" + season + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
