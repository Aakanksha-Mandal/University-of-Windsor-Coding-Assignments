public class DVD extends LibraryItem implements Loanable {
    // Attributes
    private int duration; // Duration in minutes
    private boolean available;

    // Constructor
    public DVD(String title, int year, int duration) {
        super(title, year);
        if (duration < 0) {
            throw new IllegalArgumentException("Error: Invalid duration. Please enter a valid duration.");
        }
        this.duration = duration;
        this.available = true;
    }

    // Methods
    @Override
    public void getItemDetails() {
        System.out.println("DVD: " + getTitle() + ", Year: " + getYear() + ", Duration: " + duration + " mins, Available: " + available);
    }

    @Override
    public void checkout() {
        if (available) {
            available = false;
            System.out.println("DVD '" + getTitle() + "' checked out.");
        } else {
            System.out.println("DVD '" + getTitle() + "' is already checked out.");
        }
    }

    @Override
    public void returnItem() {
        if (!available) {
            available = true;
            System.out.println("DVD '" + getTitle() + "' returned.");
        } else {
            System.out.println("DVD '" + getTitle() + "' is already in the library.");
        }
    }
}