public class StringExercise {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";
        System.out.println(p1.name.equals(p2.name));//比较内容: True
        System.out.println(p1.name == p2.name);// True,指向同一个常量池
        System.out.println(p1.name == "hspedu"); //true
        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2); //false

        System.out.println("===================================");
        String s3="hello"+"world";
        //字符串变量相加
        //1.生成StringBuilder对象sb
        //2.sb.append("wanke")
        //3.sb.append("syx")
        //4.返回新的String类对象，return new String
        //因此最后s5指向的是堆中的对象地址
        String s4="wanke";
        String s5="syx";
        String s6=s4+s5;
        System.out.println(s6=="wankesyx");    //false
        System.out.println(s3=="helloworld");   //true
    }

    public static class Person{
        private String name;

        public Person(){

        }
    }
}
