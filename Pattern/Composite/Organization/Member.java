public class Member  implements OrganizationMember{
    private String name;

    public Member(String name) {
        this.name = name;
    }
    
    @Override
    public void showInfo() {
        System.out.println("Member: " + name);
    }
    
}
