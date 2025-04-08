import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorMethod {
    public static void main(String[] args) {
        Collection col = new ArrayList(); //ArrayList是接口，接口不能实例化，所以要向上转型
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));

        System.out.println("=======Iterator循环=======");
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        //此时iterator指向最后一个元素
        //再次遍历需要重置迭代器
        iterator = col.iterator();


        System.out.println("=======增强for循环=======");
        //底层实现就是迭代器那一套 hasnext() next()
        for(Object object:col){     //将col中的元素逐个赋给object
            System.out.println(object);
        }
    }


    static class Book {
        private String name;
        private String author;
        private double price;

        public Book(String name, String author, double price) {
            this.name = name;
            this.author = author;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}


