public class Service {

    public static void main(String[] args) {
        Manager manager = new Manager("John");
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");
        manager.addMember(member1);
        manager.addMember(member2);
        manager.showInfo();
    
    }
}