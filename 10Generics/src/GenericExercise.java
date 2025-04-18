import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        Student may = new Student("may", 23);
        Student jack = new Student("jack", 29);
        Student tom = new Student("tom", 18);

        System.out.println("====HashSet====");
        Set<Student> set = new HashSet<Student>();
        set.add(may);
        set.add(jack);
        set.add(tom);
        Iterator<Student> iterator = set.iterator();
        System.out.println("====Iterator====");
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
        System.out.println("====增强for====");
        for (Student student : set) {
            System.out.println(student);
        }


        System.out.println("====HashMap====");
        HashMap<String, Student> map = new HashMap<String, Student>();
        map.put(may.getName(), may);
        map.put(jack.getName(), jack);
        map.put(tom.getName(), tom);

        Set<Map.Entry<String, Student>> entries = map.entrySet();

        System.out.println("====Iterator===");
        Iterator<Map.Entry<String, Student>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Student> next =  iterator1.next();
            System.out.println(next.getKey() + "->" + next.getValue());
        }

        System.out.println("====增强for====");
        for (Object entry : entries) {
            System.out.println(entry);
        }

        System.out.println("====Keyset====");
        // 使用keyset
        Set keyset = map.keySet();
        for (Object key : keyset) {
            System.out.println(key);
        }

        System.out.println("====Values====");
        // 使用values
        Collection values = map.values();
        for (Object value :values) {
            System.out.println(value);
        }
    }

}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
