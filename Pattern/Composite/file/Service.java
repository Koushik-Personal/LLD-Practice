public class Service {
    public static void main(String[] args) {
        
        Folder root = new Folder("Root");
        Folder folder1 = new Folder("Folder 1");
        Folder folder2 = new Folder("Folder 2");
        File file1 = new File("File 1");
        File file2 = new File("File 2");
        File file3 = new File("File 3");
        File file4 = new File("File 4");
        File file5 = new File("File 5");
        
        root.add(folder1);
        root.add(folder2);
        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);
        folder2.add(file4);
        folder2.add(file5);

        root.showDetails();
    }
}