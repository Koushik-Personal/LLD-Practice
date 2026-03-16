import java.util.ArrayList;
import java.util.List;

public class Manager implements OrganizationMember {
    
    private String name;
    private List<OrganizationMember> members;


    public Manager(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public void showInfo() {
        System.out.println("Manager: " + name);

        for (OrganizationMember member : members) {
            member.showInfo();
        }
    }
    
}
