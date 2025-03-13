import java.util.ArrayList;
import java.util.Scanner;

public class GuessMaker2 {
    private ArrayList<Person> persons;
    private int currentPerson;

    // Constructor
    public GuessMaker2() {
        persons = new ArrayList<>();
        currentPerson = -1;
    }

    // Add a person to the list
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Start the game loop
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose a person to guess their birthday:");
            for (int i = 0; i < persons.size(); i++) {
                System.out.println((i + 1) + ". " + persons.get(i).getName());
            }

            System.out.print("\nChoice (or type 'quit' to exit): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                scanner.close();
                break;
            }

            if (!choice.matches("\\d+") || Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > persons.size()) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            currentPerson = Integer.parseInt(choice) - 1;
            Person selectedPerson = persons.get(currentPerson);
            System.out.println(selectedPerson.welcomeMessage());

            while (true) {
                System.out.print("Guess the birthday (DD/MM/YYYY): ");
                String guess = scanner.nextLine();

                if (guess.equalsIgnoreCase("quit")) {
                    System.out.println("Exiting the game...");
                    scanner.close();
                    return;
                }

                Date guessedDate = new Date(guess);

                if (!guessedDate.getValidDate()) {
                    System.out.println("Invalid date. Try again.");
                    continue;
                }

                if (guessedDate.equals(selectedPerson.getBirthday())) {
                    System.out.println(selectedPerson.successMessage());
                    break;
                } else {
                    giveHint(selectedPerson, guessedDate);
                }
            }
        }
    }

    // Provide hints based on difficulty
    private void giveHint(Person person, Date guessedDate) {
        Date correctDate = person.getBirthday();
        int difficulty = person.getDifficulty();

        if (difficulty >= 1) {
            if (guessedDate.getYear() == correctDate.getYear()) {
                System.out.println("Correct year!");
            } else {
                System.out.println((guessedDate.getYear() < correctDate.getYear() ? "Later" : "Earlier") + " year.");
            }
        }
        if (difficulty >= 2) {
            if (guessedDate.getMonth() == correctDate.getMonth()) {
                System.out.println("Correct month!");
            } else {
                System.out.println((guessedDate.getMonth() < correctDate.getMonth() ? "Later" : "Earlier") + " month.");
            }
        }
        if (difficulty >= 3) {
            if (guessedDate.getDay() == correctDate.getDay()) {
                System.out.println("Correct day!");
            } else {
                System.out.println((guessedDate.getDay() < correctDate.getDay() ? "Later" : "Earlier") + " day.");
            }
        }
    }

    public static void main(String[] args) {
        Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), "Canada", 1, "Liberal");
        Player ronaldo = new Player("Leo Messi", new Date(24, 6, 1987), "Argentina", 2, "Soccer", "Barcelona");
        Politician pierre = new Politician("Pierre Poilievre", new Date(3, 6, 1979), "Canada", 3, "Conservative");
    
        GuessMaker2 game = new GuessMaker2();
        game.addPerson(trudeau);
        game.addPerson(ronaldo);
        game.addPerson(pierre);
    
        game.startGame();
    }
}