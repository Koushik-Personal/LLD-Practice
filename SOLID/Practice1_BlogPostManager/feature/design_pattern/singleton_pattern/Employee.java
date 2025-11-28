package feature.design_pattern.singleton_pattern;

/*
 * This is lazy initialization
 * This is correct but not thread safe
 */
// public class Employee {

//     private static Employee instance;
//     private String name;
//     private String id;

//     private Employee(String name, String id) {
//         this.name = name;
//         this.id = id;
//     }

//     public static Employee getInstance(String name, String id) {

//         if (instance == null) {
//             instance = new Employee(name, id);
//         }

//         return instance;
//     }

//     public String getName() {
//         return this.name;
//     }

//     public String getId() {
//         return this.id;
//     }

//     public void printName() {
//         System.out.println("Employee name is : " + this.name);
//     }

//     public void printId() {
//         System.out.println("Employee id is : " + this.id);
//     }

// }


/*
 * This is thread safe
 */

// public class Employee {

//     private static Employee instance;
//     private String name;
//     private String id;

//     private Employee(String name, String id) {
//         this.name = name;
//         this.id = id;
//     }

//     public static  Employee getInstance(String name, String id) {

//         synchronized (Employee.class) {
//             if (instance == null) {
//                 instance = new Employee(name, id);
//             }
//         }

//         return instance;
//     }

//     public String getName() {
//         return this.name;
//     }

//     public String getId() {
//         return this.id;
//     }

//     public void printName() {
//         System.out.println("Employee name is : " + this.name);
//     }

//     public void printId() {
//         System.out.println("Employee id is : " + this.id);
//     }

// }


enum Employee {

    INSTANCE;

    private String name;
    private String id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }
}