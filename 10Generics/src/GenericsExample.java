public class GenericsExample {
    public static void main(String[] args) {
        Person<String> person1 = new Person<>("may");
        Person<Integer> person2 = new Person<>(23);

        person1.f2("jack");
        // person1.f2(123);
        person1.f3();
    }

    //泛型作用：用于在类定义时充当类的属性类型/方法返回值类型/方法形参类型
    static class Person<E>{
        E s;   //在实体化对象时，定义的类型会替代E
        public Person(E s) {
            this.s = s;
        }
        public E f1(){
            return s;
        }
        public void f2(E s){
            System.out.println(s);
        }
        public void f3(){
            System.out.println(s.getClass());
        }
    }

}


