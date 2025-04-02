import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise_Birthday {
    public static void main(String[] args) {
        HashSet employees = new HashSet();
        employees.add(new Employee("May", 8000, new MyDate("1990","03","29")));
        employees.add(new Employee("May", 7000, new MyDate("1994","03","29")));
        employees.add(new Employee("May", 6000, new MyDate("1990","03","29")));

        System.out.println(employees);
    }

    static class Employee{
        private String name;
        private int salary;
        private MyDate birthday;

        public Employee(String name, int salary, MyDate birthday) {
            this.name = name;
            this.salary = salary;
            this.birthday = birthday;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, birthday);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", birthday=" + birthday +
                    '}';
        }
    }

    static class MyDate{
        private String year;
        private String month;
        private String day;

        public MyDate(String year, String month, String day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyDate myDate = (MyDate) o;
            return Objects.equals(year, myDate.year) && Objects.equals(month, myDate.month) && Objects.equals(day, myDate.day);
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }

        @Override
        public String toString() {
            return  year + '年' +
                    month + '月' +
                    day + '日' ;
        }
    }
}
