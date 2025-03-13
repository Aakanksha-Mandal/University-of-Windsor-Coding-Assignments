// Base class
public class Employee {
    String name;
    int id;
    double salary;
    String role;

    public Employee(String name, int id, double salary, String role) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.role = role;
    }

    // Base method for performing duties
    public void performDuties() {
        System.out.println(name + " is performing general duties.");
    }
}
