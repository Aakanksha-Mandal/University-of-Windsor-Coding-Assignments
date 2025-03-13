public class Main {
    public static void main(String[] args) {
        // Create objects
        BackendDeveloper backendDev = new BackendDeveloper("Alice", 1001, 6000.0, "Backend Developer", "Java");
        AutomationTester tester = new AutomationTester("Bob", 1002, 5500.0, "Automation Tester", "Selenium");
        ProjectManager manager = new ProjectManager("Carol", 1003, 8000.0, "Project Manager", 5);
        BackendDeveloper backendDev2 = new BackendDeveloper("Mike", 1004, 6500.0, "Backend Developer", "Java");

        // Polymorphism: Treating each as an Employee
        Employee emp1 = backendDev;
        Employee emp2 = tester;
        Employee emp3 = manager;
        Employee emp4 = backendDev2;


        // Calling performDuties() using polymorphism
        emp1.performDuties(); // This should call BackendDeveloper's performDuties()
        emp2.performDuties(); // This should call AutomationTester's performDuties()
        emp3.performDuties(); // This should call ProjectManager's performDuties()
        emp4.performDuties(); // This should call BackendDeveloper's performDuties()

        // Calling specific methods of each class
        backendDev.optimizeDatabase(); // Specific method for BackendDeveloper
        tester.writeAutomationScript(); // Specific method for AutomationTester
        manager.scheduleMeeting(); // Specific method for ProjectManager
    }
}

/* Expected Output:
Alice is building APIs and ensuring database integration.
Bob is writing scripts to automate test cases.
Carol is managing teams and overseeing project deadlines.
Mike is building APIs and ensuring database integration.
Alice is optimizing database queries for better performance.
Bob is writing an automation script for regression testing.
Carol is scheduling a team meeting.
*/
