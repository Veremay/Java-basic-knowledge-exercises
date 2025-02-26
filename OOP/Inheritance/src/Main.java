public class Main {
    public static void main(String[] args) {
    Dog myDog = new Dog("Daisy", "dwarf poodle");
    myDog.eat();
    myDog.bark();
    myDog.makeSound();
    myDog.fetch();
    myDog.sleep();

    System.out.println("-----------------------");

    //Polymorphism
    Animal myDog2 = new Dog("Jenny", "Collie");
    //polymorphic method call
    myDog2.makeSound();
    //direct call of subclass specific method
    //requires casting to the appropriate subclass
    ((Dog) myDog2).fetch();



    System.out.println("-----------------------");

    Laptop myLaptop = new Laptop("Apple", "M4", 64,1024, 2000, 14);
    myLaptop.displayInfo();
    myLaptop.powerOn();
    }
}
