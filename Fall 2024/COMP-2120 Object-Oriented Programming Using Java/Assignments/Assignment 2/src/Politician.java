public class Politician extends Person {
    private String party;

    // Constructor
    public Politician(String name, Date birthday, String country, int difficulty, String party) {
        super(name, birthday, country, difficulty);
        this.party = party;
    }

    // Copy constructor
    public Politician(Politician other) {
        super(other.getName(), other.getBirthday(), other.getCountry(), other.getDifficulty());
        this.party = other.party;
    }

    @Override
    public String personType() {
        return "politician";
    }

    @Override
    public Person clone() {
        return new Politician(this);
    }

    @Override
    public String toString() {
        return super.toString() + ". " + getName() + " is a member of Party " + party + ".";
    }
}