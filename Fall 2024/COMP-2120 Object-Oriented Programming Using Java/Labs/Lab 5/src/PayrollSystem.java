public class PayrollSystem {

    // Static method to display employee information using getters
    public static void displayEmployeeInfo(Employee employee) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Employee Name: " + employee.getEmployeeName());
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("Salary: $" + employee.getSalary());
        System.out.println("Bonus Percentage: " + employee.getBonusPercentage() + "%");
        System.out.println("Address: " + employee.getAddress());
        System.out.println("Job Title: " + employee.getJobTitle());
        System.out.println("Total Pay: $" + employee.calculateTotalPay());
        System.out.println("----------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Employee with valid data
        Employee emp1 = new Employee("Alice", "A12345", 50000.0, 10.0, "123 Main St", "Developer");

        // Employee with invalid salary and bonusPercentage, then corrected
        Employee emp2 = new Employee("Bob", "B12345", 25000.0, 150.0, "456 Elm St", "Tester");
        emp2.setSalary(60000.0); // Corrected salary
        emp2.setBonusPercentage(20.0); // Corrected bonus

        // Employee with invalid ID, corrected using setter
        Employee emp3 = new Employee("Carol", "C12", 70000.0, 15.0, "789 Oak St", "Manager");
        emp3.setEmployeeID("C12346"); // Corrected ID

        // Display information for each employee
        PayrollSystem.displayEmployeeInfo(emp1);
        PayrollSystem.displayEmployeeInfo(emp2);
        PayrollSystem.displayEmployeeInfo(emp3);
    }
}
