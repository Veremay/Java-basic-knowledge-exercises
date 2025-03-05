public class SystemEnum {
    public static void main(String[] args) {
        System.out.println(Season2.SUMMER);
    }
}

enum Season2{
    //枚举对象必须写在首部，有多个时，用逗号间隔，最后一个带分号
    SPRING("春天","温暖"),   //由括号内的参数决定调用哪个构造器
    what,           //当创建无参对象时，可以不写括号,也可以写
    What(),
    SUMMER("夏天","炎热");
    private String season;
    private String desc;

    //1.构造器私有化
    private Season2(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

    private Season2(){} // 无参构造器

    //2.只能读取不能修改数据
    public String getSeason() {
        return season;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "season='" + season + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
