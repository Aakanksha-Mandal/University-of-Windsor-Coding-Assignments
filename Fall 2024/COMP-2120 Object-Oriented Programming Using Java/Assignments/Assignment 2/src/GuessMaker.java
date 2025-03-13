// Name: Aakanksha Mandal
// Student Number: 110189000

import java.util.ArrayList;
import java.util.Scanner;

public class GuessMaker {
    // Variables
    private ArrayList<Person> persons;
    private int currentPerson;
    private int personCount;

    // Constructor with initial persons
    public GuessMaker(Person p1, Person p2, Person p3) {
        persons = new ArrayList<>(); // Initialize the ArrayList
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        personCount += 3;
    }

    // Method to add more persons
    public void addPerson(Person person) {
        persons.add(person);
        personCount++;
    }

    // Game loop method
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hi, please choose a person to guess the birthday:");
            for (int i = 0; i < personCount; i++) {
                System.out.println("\t" + (i + 1) + ". " + persons.get(i).getName());
            }

            System.out.print("\nChoice: ");
            String user_input = scanner.nextLine();

            // Validate input choice
            if (!user_input.matches("\\d+")) {
                System.out.println("Error: Invalid input. Please enter a number.\n");
                continue;
            }

            int choice = Integer.parseInt(user_input) - 1;
            if (choice < 0 || choice >= personCount) {
                System.out.println("Error: Invalid choice. Try again!\n");
                continue;
            }

            currentPerson = choice;
            Person selectedPerson = persons.get(currentPerson);

            // Guessing loop for selected person
            while (true) {
                System.out.print("\nGuess the birthday of " + selectedPerson.getName() + " (format: DD/MM/YYYY): ");
                String guess = scanner.nextLine().trim();

                if (guess.equalsIgnoreCase("quit")) {
                    System.out.println("Thank you for playing!\n");
                    scanner.close();
                    return;
                }

                // Validate if the input is in DD/MM/YYYY format using regex
                if (!guess.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    System.out.println("Error: Invalid date format. Please enter in DD/MM/YYYY format.\n");
                    continue;  // Prompt the user for another guess
                }

                Date guessedDate = new Date(guess);

                // Validate if the date entered is correct
                if (!guessedDate.getValidDate()) {
                    System.out.println("Error: Invalid date. Please check day, month, and year values.\n");
                    continue;  // Prompt the user for another guess
                }

                if (guessedDate.equals(selectedPerson.getBirthday())) {
                    System.out.println("Congratulations. Correct guess!!\n\n");
                    break;
                } else {
                    System.out.println("Oops! Incorrect guess. Try an " + 
                        (guessedDate.getYear() < selectedPerson.getBirthday().getYear() ? "later" : "earlier") + 
                        " date.\n");
                }
            }
        }
    }

    // public static void main(String[] args) {
    //     Date date = new Date("14/03/1879");
    //     // Creating sample persons
    //     Person p1 = new Person("Terry Fox", new Date(28, 7, 1958), "Canada");
    //     Person p2 = new Person("Albert Einstein", new Date(date), "Germany");
    //     Person p3 = new Person("Marie Curie", new Date("07/11/1867"), "Poland");
    //     Person p4 = new Person("Queen Elizabeth II", new Date("apr 21, 1926"), "United Kingdom");

    //     GuessMaker game = new GuessMaker(p1, p2, p3);
    //     game.addPerson(p4);

    //     game.startGame();
    // }
}