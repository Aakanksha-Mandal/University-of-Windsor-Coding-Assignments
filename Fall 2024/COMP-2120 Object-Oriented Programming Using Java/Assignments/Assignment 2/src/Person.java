// Name: Aakanksha Mandal
// Student Number: 110189000

public abstract class Person {
    // Instance variables
    private String name;
    private Date birthday;
    private String country;
    private int difficulty;

    // Constructor to initialize difficulty
    public Person(String name, Date birthday, String country, int difficulty) {
        this.name = name;
        if (!birthday.getValidDate()) {
            throw new IllegalArgumentException("Error: Invalid Date.");
        }
        this.birthday = new Date(birthday);
        this.country = country;
        this.difficulty = difficulty;
    }

    // Abstract methods
    public abstract String personType();
    public abstract Person clone();

    // Welcome message method
    public String welcomeMessage() {
        return "Welcome! Guess the birthday of " + personType() + " named " + name + ".";
    }

    // Success message method
    public String successMessage() {
        return "Wow! You are able to successfully guess the birthday of " + toString() + ".";
    }

    // Getters
    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return new Date(birthday);
    }

    public String getCountry() {
        return country;
    }

    public int getDifficulty() {
        return difficulty;
    }

    // toString method
    @Override
    public String toString() {
        return name + ", born on " + birthday.toString() + " in " + country;
    }
}