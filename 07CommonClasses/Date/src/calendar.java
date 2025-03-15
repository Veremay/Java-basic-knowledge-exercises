import java.util.Calendar;

public class calendar {
    public static void main(String[] args) {
        Calendar c1=Calendar.getInstance();
        System.out.println("YEAR "+c1.get(Calendar.YEAR));
        System.out.println("MONTH "+ (c1.get(Calendar.MONTH)+1));    //若不用c1.get，获得的是默认值。 月份从0开始计算
        System.out.println("DAY_OF_MONTH "+c1.get(Calendar.DAY_OF_MONTH)); //一个月的第几天
        System.out.println("DATE "+c1.get(Calendar.DATE));
        System.out.println("12HOUR "+ c1.get(Calendar.HOUR)); //12小时进制
        System.out.println("24HOUR "+(c1.get(Calendar.HOUR)+12)%24);  // 24小时进制
        System.out.println("HOUR_OF_DAY "+c1.get(Calendar.HOUR_OF_DAY));   //获取到24小时制的时间
        System.out.println("MINUTE "+c1.get(Calendar.MINUTE));
        System.out.println("SECOND "+c1.get(Calendar.SECOND));
    }
}
