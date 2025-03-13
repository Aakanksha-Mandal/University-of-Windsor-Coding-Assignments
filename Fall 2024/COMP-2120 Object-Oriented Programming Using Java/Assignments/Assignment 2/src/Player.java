public class Player extends Person {
    private String game;
    private String team;

    // Constructor
    public Player(String name, Date birthday, String country, int difficulty, String game, String team) {
        super(name, birthday, country, difficulty);
        this.game = game;
        this.team = team;
    }

    // Copy constructor
    public Player(Player other) {
        super(other.getName(), other.getBirthday(), other.getCountry(), other.getDifficulty());
        this.game = other.game;
        this.team = other.team;
    }

    @Override
    public String personType() {
        return "player";
    }

    @Override
    public Person clone() {
        return new Player(this);
    }

    @Override
    public String toString() {
        return super.toString() + ". " + getName() + " is a Player of Team " + team + ".";
    }
}