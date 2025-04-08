import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class localDateTime {
    public static void main(String[] args) {
        LocalDateTime a= LocalDateTime.now();

        System.out.println(a.getYear());
        System.out.println(a.getMonth());    //November
        System.out.println(a.getMonthValue());  //11
        System.out.println(a.getDayOfMonth());
        System.out.println(a.getHour());
        System.out.println(a.getMinute());
        System.out.println(a.getSecond());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        //同样使用String类接收
        String s1=dateTimeFormatter.format(a);
        System.out.println(s1);
    }
}
