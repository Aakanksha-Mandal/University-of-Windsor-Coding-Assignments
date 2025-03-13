import java.util.List;

public class DigitalLibraryTest {
    public static void main(String[] args) {
        // Create instances of media items
        Book book1 = new Book("The Catcher in the Rye", "Fiction", 1951, 0, "J.D. Salinger", "9780316769488");
        Book book2 = new Book("The Great Gatsby", "Fiction", 1925, 1, "F. Scott Fitzgerald", "9780743273565");
        Movie movie1 = new Movie("Inception", "Sci-Fi", 2010, 2, "Christopher Nolan", 148, "PG-13");
        Movie movie2 = new Movie("The Dark Knight", "Action", 2008, 3, "Christopher Nolan", 152, "PG-13");
        Podcast podcast1 = new Podcast("Joe Rogan Experience", "Talk", 2020, 4, "Joe Rogan", 1750);
        MusicAlbum album1 = new MusicAlbum("Abbey Road", "Rock", 1969, 5, "The Beatles", 17, "26/09/1969");

        // Create a DigitalLibrary instance
        DigitalLibrary<Media> library = new DigitalLibrary<>();
        
        // Add media items to the library
        System.out.println("Adding media items...");
        library.addMedia(book1);
        library.addMedia(book2);
        library.addMedia(movie1);
        library.addMedia(movie2);
        library.addMedia(podcast1);
        library.addMedia(album1);
        
        // Test: Add and Remove Items
        System.out.println("\nRemoving item: 'The Catcher in the Rye'");
        boolean removed = library.removeMedia(book1);
        System.out.println("Item removed: " + removed);
        
        // Test: Sorting by title
        System.out.println("\nLibrary sorted by title:");
        library.sortByTitle();
        library.printAllItems();
        
        // Test: Sorting by year
        System.out.println("\nLibrary sorted by year:");
        library.sortByYear();
        library.printAllItems();
        
        // Test: Sorting by rating
        System.out.println("\nLibrary sorted by rating:");
        library.sortByRating();
        library.printAllItems();
        
        // Test: Filtering by genre (Fiction)
        try{
            System.out.println("\nFiltering by genre: Fiction");
            List<Media> fictionItems = library.filterByGenre("Fiction");
            fictionItems.forEach(item -> System.out.println(item));
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        // Test: Filtering by rating (>= 3)
        try {
            System.out.println("\nFiltering by rating (>= 3):");
            List<Media> highRatedItems = library.recommendByRating(3);
            highRatedItems.forEach(item -> System.out.println(item));
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        // Test: Filtering books by author
        try {
            System.out.println("\nFiltering books by author: F. Scott Fitzgerald");
            List<Book> booksByAuthor = library.filterBooksByAuthor("F. Scott Fitzgerald");
            booksByAuthor.forEach(book -> System.out.println(book));
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Test: Filtering movies by director
        try {
            System.out.println("\nFiltering movies by director: Christopher Nolan");
            List<Movie> moviesByDirector = library.filterMoviesByDirector("Christopher Nolan");
            moviesByDirector.forEach(movie -> System.out.println(movie));
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Test: Searching for an item by title
        System.out.println("\nSearching for 'Inception'...");
        try {
            Media searchedItem = library.searchByTitle("Inception");
            System.out.println("Item found: " + searchedItem);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Test: Searching for a non-existent item by title
        System.out.println("\nSearching for 'The Alchemist'...");
        try {
            Media searchedItem = library.searchByTitle("The Alchemist");
            System.out.println("Item found: " + searchedItem);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}