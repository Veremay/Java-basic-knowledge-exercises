import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GenericsExercise {

    /*
    定义Employee类
    1)该类包含:private成员变量name,sal,birthday，其中 birthday 为 MyDate 类的对象;
    2)为每一个属性定义 getter, setter 方法;
    3)重写 toString 方法输出 name, sal, birthday
    4)MyDate类包含: private成员变量month,day,year;并为每一个属性定义 getter,setter 方法;
    5)创建该类的3个对象，并把这些对象放入 ArrayList 集合中(ArrayList 需使用泛型来定义)，对集合中的元素进行排序，并遍历输出:
    排序方式:调用ArrayList 的 sort 方法,传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即:定制排序】
     */

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("may", 15000,new MyDate(2002,2,24)));
        employees.add(new Employee("lucy", 9000,new MyDate(2002,8,17)));
        employees.add(new Employee("emma", 10000,new MyDate(2002,9,17)));
        employees.add(new Employee("may", 15000,new MyDate(2005,2,24)));



        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // 先对传入的参数进行验证
                if(!(e1 instanceof Employee && e2 instanceof Employee)){
                    return 0;
                }

                // 比较name
                int name_diff = e1.getName().compareTo(e2.getName());
                if(name_diff != 0){
                    return name_diff;
                }

                return e1.getBirthday().compareTo(e2.getBirthday());
                // IMPORTANT!!!
                // 下面是对birthday的比较，因此，我们最好把这个比较，放在MyDate类完成
        /*
                // 比较birthday
                int year_diff = e1.getBirthday().getYear() - e2.getBirthday().getYear();
                if(year_diff != 0){
                    return year_diff;
                }

                int month_diff = e1.getBirthday().getMonth() - e2.getBirthday().getMonth();
                if(month_diff != 0){
                    return month_diff;
                }

                return e1.getBirthday().getDay() - e2.getBirthday().getDay();

         */

            }
        });



        System.out.println(employees);
    }



}

class Employee{
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee(String name, int sal, MyDate birthday) {
        this.birthday = birthday;
        this.sal = sal;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        // 比较birthday
        int year_diff = this.year - o.getYear();
        if(year_diff != 0){
            return year_diff;
        }

        int month_diff = this.month - o.getMonth();
        if(month_diff != 0){
            return month_diff;
        }

        return this.day - o.getDay();
    }
}
