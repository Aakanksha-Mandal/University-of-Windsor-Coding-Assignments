// Inherits from Employee
public class ProjectManager extends Employee {
    int teamSize;

    public ProjectManager(String name, int id, double salary, String role, int teamSize) {
        super(name, id, salary, role);
        this.teamSize = teamSize;
    }

    // Overide performDuties()
    @Override
    public void performDuties() {
        System.out.println(name + " is managing teams and overseeing project deadlines.");
    }

    // Unique method
    public void scheduleMeeting() {
        System.out.println(name + " is scheduling a team meeting.");
    }
}
