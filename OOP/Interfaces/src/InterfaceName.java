public interface InterfaceName {

    // constant: can not be modified, use capital characters
    int CONSTANT = 10;

    // abstract methods
    void methodName();

    // default methods
    default void defaultMethod(){
        System.out.println("Default implementation");
    }

    // static methods
    // can be used without having to create a object of the thing
    static void staticMethod(){
        System.out.println("Static implementation");
    }
}
