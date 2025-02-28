public class Main {
    public static void main(String[] args) {
    LibraryMember[] members = new LibraryMember[3];

    members[0] = new LibraryMember("Alex");
    members[1] = new StudentMember("Emily");
    members[2] = new ProfessorMember("Dr. Smith");

    StudentMember frank = new StudentMember("frank");
    frank.borrowBook();

    for(LibraryMember member: members){
        member.borrowBook(); // Dynamic method dispatch in action
    }
    }
}
