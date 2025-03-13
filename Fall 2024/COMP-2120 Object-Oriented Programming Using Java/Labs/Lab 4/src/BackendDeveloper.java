// Inherits from Developer
public class BackendDeveloper extends Developer {
    String mainLanguage;

    public BackendDeveloper(String name, int id, double salary, String role, String mainLanguage) {
        super(name, id, salary, role);
        this.mainLanguage = mainLanguage;
    }

    // Overide performDuties()
    @Override
    public void performDuties() {
        System.out.println(name + " is building APIs and ensuring database integration.");
    }

    // Unique method
    public void optimizeDatabase() {
        System.out.println(name + " is optimizing database queries for better performance.");
    }
}
