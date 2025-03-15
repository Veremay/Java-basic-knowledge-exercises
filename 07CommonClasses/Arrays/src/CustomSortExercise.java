import java.util.Arrays;
import java.util.Comparator;

public class CustomSortExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("三国演义", 30.0);
        books[1] = new Book("红楼梦", 70.0);
        books[2] = new Book("水浒传", 50.0);
        books[3] = new Book("西游记", 20.0);

       // 按照价格从小到大排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceDiff = book1.getPrice() - book2.getPrice();
                if(priceDiff > 0){
                    return 1;
                } else if (priceDiff < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(Arrays.toString(books));
    }


    static class Book{
        private String name;
        private double price;

        public Book(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
