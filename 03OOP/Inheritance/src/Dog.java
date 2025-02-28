public class Dog extends Animal{

    String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    // override eat() method of parent
    @Override
    void eat(){
        super.eat();
        System.out.println("This dog eats food!");
    }

    void bark(){
        System.out.println("This dog barks!");
    }

    @Override
    void makeSound(){
        System.out.println(name + " the dog is barking.");
    }

    void fetch(){
        System.out.println(name + " the dog is fetching the ball.");
    }
}
