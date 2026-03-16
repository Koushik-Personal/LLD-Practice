import java.util.ArrayList;
import java.util.List;

public class Folder implements FileComponent {

    private String name;
    private List<FileComponent> children = new ArrayList<>(); 

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileComponent child : children) {
            child.showDetails();
        }
    }

    public void add(FileComponent fileComponent) {
        children.add(fileComponent); 
    }

    
}
