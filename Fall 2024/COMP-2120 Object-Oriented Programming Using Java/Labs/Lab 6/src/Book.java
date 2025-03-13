public class Book extends LibraryItem implements Loanable {
    // Attributes
    private String author;
    private boolean available;

    // Constructor
    public Book(String title, int year, String author)  {
        super(title, year);
        this.author = author;
        this.available = true;
    }

    // Methods
    @Override
    public void getItemDetails() {
        System.out.println("Book: " + getTitle() + " by " + author + ", Year: " + getYear() + ", Available: " + available);
    }

    @Override
    public void checkout() {
        if (available) {
            available = false;
            System.out.println("Book '" + getTitle() + "' checked out.");
        } else {
            System.out.println("Book '" + getTitle() + "' is already checked out.");
        }
    }

    @Override
    public void returnItem() {
        if (!available) {
            available = true;
            System.out.println("Book '" + getTitle() + "' returned.");
        } else {
            System.out.println("Book '" + getTitle() + "' is already in the library.");
        }
    }
}
