// Inherits from Tester
public class AutomationTester extends Tester{
    String automationTool;

    public AutomationTester(String name, int id, double salary, String role, String automationTool) {
        super(name, id, salary, role);
        this.automationTool = automationTool;
    }

    // Overide performDuties()
    @Override
    public void performDuties() {
        System.out.println(name + " is writing scripts to automate test cases.");
    }

    // Unique method
    public void writeAutomationScript() {
        System.out.println(name + " is writing an automation script for regression testing.");
    }
}
