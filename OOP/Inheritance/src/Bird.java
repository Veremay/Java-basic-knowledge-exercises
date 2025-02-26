public class Bird  extends  Animal{

    public Bird(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " the bird is chirping.");
    }

    void fly(){
        System.out.println("This bird can fly!");
    }
}
