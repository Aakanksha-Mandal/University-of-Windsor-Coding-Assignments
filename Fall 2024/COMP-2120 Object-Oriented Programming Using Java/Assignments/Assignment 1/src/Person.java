// Name: Aakanksha Mandal
// Student Number: 110189000

public class Person {
    // Instance variables
    private String name;
    private Date birthday;
    private String country;

    // Constructor that takes name, birthday, and country
    public Person(String name, Date birthday, String country) {
        setName(name);
        setBirthday(birthday);
        setCountry(country);
    }

    // Constructor that takes a Person object
    public Person(Person other) {
        setName(other.name);
        setBirthday(other.birthday);
        setCountry(other.country);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for birthday
    public Date getBirthday() {
        return new Date(birthday);
    }

    // Setter for birthday
    public void setBirthday(Date birthday) {
        if (!birthday.getValidDate()) {
            throw new IllegalArgumentException("Error: Invalid Date.");
        }
        this.birthday = new Date(birthday);
    }

    // Getter for country
    public String getCountry() {
        return country;
    }

    // Setter for country
    public void setCountry(String country) {
        this.country = country;
    }

    // toString method for Person details
    @Override
    public String toString() {
        return name + ", born on " + birthday.toString() + " in " + country;
    }
}