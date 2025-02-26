public class LibraryMember {
    String name;

    public LibraryMember(String name) {
        this.name = name;
    }

    // Method to borrow books (overriden in subclass)
    public void borrowBook(){
        System.out.println(name + " can borrow books.");
    }
}
