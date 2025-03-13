public class LibrarySystem {
    public static void main(String[] args) {
        // Create instances of Book, Magazine, and DVD
        LibraryItem book = new Book("The Alchemist", 1993, "Paulo Coelho");
        LibraryItem magazine = new Magazine("National Geographic", 2022, "Science");
        LibraryItem dvd = new DVD("Inception", 2010, 148);

        // Process each library item
        processLibraryItem(book);
        processLibraryItem(magazine);
        processLibraryItem(dvd);
    }

    // Polymorphic method to process library items
    public static void processLibraryItem(LibraryItem item) {
        System.out.println("\nProcessing Item:");
        item.getItemDetails();

        // Check if item is loanable and perform loan operations if applicable
        if (item instanceof Loanable) {
            Loanable loanableItem = (Loanable) item;
            loanableItem.checkout();
            loanableItem.returnItem();
        } else {
            System.out.println("This item is not loanable.");
        }
    }
}

/*Example Output:
Processing Item:
Book: The Alchemist by Paulo Coelho, Year: 1993, Available: true
Book 'The Alchemist' checked out.
Book 'The Alchemist' returned.

Processing Item:
Magazine: National Geographic, Genre: Science, Year: 2022
Note: This item is for reference only and cannot be loaned.
This item is not loanable.

Processing Item:
DVD: Inception, Year: 2010, Duration: 148 mins, Available: true
DVD 'Inception' checked out.
DVD 'Inception' returned.
*/