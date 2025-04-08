import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Map employees = new HashMap();

        Employee employee1 = new Employee("may", 4000, "578320");
        employees.put(employee1.getId(), employee1);
        Employee employee2 = new Employee("sophie", 20000, "543298");
        employees.put(employee2.getId(), employee2);
        Employee employee3 = new Employee("sherry", 8000, "532978");
        employees.put(employee3.getId(), employee3);

        // 使用entryset
        Set entrySet = employees.entrySet();
        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry)entry;
            Employee employee = (Employee) m.getValue();
            if(employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }

        // 使用keyset
        Set keyset = employees.keySet();
        for (Object key : keyset) {
            Employee employee = (Employee) employees.get(key);
            if(employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }

        // 使用values
        Collection values = employees.values();
        for (Object value :values) {
            Employee employee = (Employee) value;
            if(employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }


    }

    static class Employee {
        private String name;
        private int salary;
        private String id;

        public Employee(String name, int salary, String id) {
            this.name = name;
            this.salary = salary;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", id='" + id + '\'' +
                    '}';
        }
    }
}
