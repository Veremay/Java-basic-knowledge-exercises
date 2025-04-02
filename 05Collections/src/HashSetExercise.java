import java.util.HashSet;

public class HashSetExercise {
    /*
    定义一个Employee类，该类包含:private成员属性name,age
    要求:创建3个 Employee 对象放入 HashSet 中
    当 name 和 age 的值相同时，认为是相同员工，不能添加到HashSet集合中
     */
    public static void main(String[] args) {
        HashSet employees = new HashSet();
        employees.add(new Employee("May", 23));
        employees.add(new Employee("Sheeran", 26));
        employees.add(new Employee("May", 23));
    }

    static class Employee{
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
