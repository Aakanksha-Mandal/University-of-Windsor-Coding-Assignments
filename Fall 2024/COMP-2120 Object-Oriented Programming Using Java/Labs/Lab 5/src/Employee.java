public class Employee {

    // Private Fields (attributes)
    private String employeeName;
    private String employeeID;
    private double salary;
    private double bonusPercentage;
    private String address;
    private String jobTitle;

    // Constructor
    public Employee(String employeeName, String employeeID, double salary, double bonusPercentage, String address, String jobTitle) {
        setEmployeeName(employeeName);
        setEmployeeID(employeeID);
        setSalary(salary);
        setBonusPercentage(bonusPercentage);
        setAddress(address);
        setJobTitle(jobTitle);
    }

    // Setter Method for employeeName with Validation
    public void setEmployeeName(String employeeName) {
        if (!employeeName.isEmpty() && employeeName != null) {
            this.employeeName = employeeName;
        } else {
            System.out.println("Error: employeeName " + employeeName + " cannot be empty.");
        }
    }

    // Getter Method for employeeName with Validation
    public String getEmployeeName() {
        return this.employeeName;
    }

    // Setter Method for employeeID with Validation
    public void setEmployeeID(String employeeID) {
        if (employeeID.length() == 6) {
            this.employeeID = employeeID;
        } else {
            System.out.println("Error: employeeID " + employeeID + " is not 6 characters long.");
        }
    }

    // Getter Method for employeeID with Validation
    public String getEmployeeID() {
        return this.employeeID;
    }

    // Setter Method for salary with Validation
    public void setSalary(double salary) {
        if (salary >= 30000 && salary <= 200000) {
            this.salary = salary;
        } else {
            System.out.println("Error: salary " + salary + " is not between 30,000 and 200,000.");
        }
    }

    // Getter Method for salary with Validation
    public double getSalary() {
        return this.salary;
    }

    // Setter Method for bonusPercentage with Validation
    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage >= 0 && bonusPercentage <= 100) {
            this.bonusPercentage = bonusPercentage;
        } else {
            System.out.println("Error: bonusPercentage " + bonusPercentage + " is not between 0 and 100.");
        }
    }

    // Getter Method for bonusPercentage with Validation
    public double getBonusPercentage() {
        return this.bonusPercentage;
    }

    // Setter Method for address with Validation
    public void setAddress(String address) {
        if (!address.isEmpty() && !address.trim().isEmpty() && address.contains(" ")) {
            this.address = address;
        } else {
            System.out.println("Error: address " + address +" cannot be empty and must contain a space seperting street and number.");
        }
    }

    // Getter Method for address with Validation
    public String getAddress() {
        return this.address;
    }

    // Setter Method for jobTitle with Validation
    public void setJobTitle(String jobTitle) {
        if (jobTitle.matches("Manager") || jobTitle.matches("Developer") || jobTitle.matches("Designer") || jobTitle.matches("Tester")) {
            this.jobTitle = jobTitle;
        } else {
            System.out.println("Error: jobTitle " + jobTitle + " must be one of \"Manager\", \"Developer\", \"Designer\", or \"Tester\".");
        }
    }

    // Getter Method for jobTitle with Validation
    public String getJobTitle() {
        return this.jobTitle;
    }

    // Method to calculate total pay with bonus
    public double calculateTotalPay() {
        return salary + (salary * bonusPercentage / 100);
    }
}
