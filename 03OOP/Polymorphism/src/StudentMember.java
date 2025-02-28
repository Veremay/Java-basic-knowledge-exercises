public class StudentMember extends LibraryMember{

    public StudentMember(String name){
        super(name);
    }

    @Override
    public void borrowBook(){
        System.out.println(name + " can borrow up to 3 books.");
    }
}
