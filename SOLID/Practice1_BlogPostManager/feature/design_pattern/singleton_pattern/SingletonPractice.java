package feature.design_pattern.singleton_pattern;


public class SingletonPractice {
    public static void main(String[] args) {
        
        Employee employee = Employee.INSTANCE;
        employee.setName("Koushik"); employee.setId("1");
        System.out.println("Hash code of " + employee.getName() + " is " + employee.hashCode());
        employee.getName();

        Employee employee2 = Employee.INSTANCE;
        employee2.setName("Babai"); employee2.setId("2");
        System.out.println("Hash code of " + employee2.getName() + " is " + employee2.hashCode());
        employee2.getName();
    }
}
