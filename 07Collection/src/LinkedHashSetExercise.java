import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet cars = new LinkedHashSet();
        cars.add(new Car("奥拓", 1000));
        cars.add(new Car("奥迪", 300000));
        cars.add(new Car("法拉利", 10000000));
        cars.add(new Car("奥迪", 300000));
        cars.add(new Car("保时捷", 70000000));
        cars.add(new Car("奥迪", 300000));

        System.out.println(cars);
    }


    static class Car {
        private String brand;
        private int price;

        public Car(String brand, int price) {
            this.brand = brand;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return price == car.price && Objects.equals(brand, car.brand);
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, price);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
