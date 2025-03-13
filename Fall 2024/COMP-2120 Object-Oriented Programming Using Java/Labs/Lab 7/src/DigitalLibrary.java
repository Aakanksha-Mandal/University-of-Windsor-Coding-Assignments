import java.util.*;
import java.util.stream.Collectors;

public class DigitalLibrary<T extends Media> {
    private List<T> mediaItems;

    public DigitalLibrary() {
        mediaItems = new ArrayList<>();
    }

    // Add a media item to the library
    public void addMedia(T item) {
        mediaItems.add(item);
    }

    // Remove a media item from the library
    public boolean removeMedia(T item) {
        return mediaItems.remove(item);
    }

    // Search for an item by its title
    public T searchByTitle(String title) throws ItemNotFoundException {
        for (T item : mediaItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item with title '" + title + "' not found.");
    }

    // Filter items by genre
    public List<T> filterByGenre(String genre) throws ItemNotFoundException {
        List<T> filteredItems = mediaItems.stream()
                .filter(item -> item.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
        if (filteredItems.isEmpty()) {
            throw new ItemNotFoundException("No items found in genre '" + genre + "'.");
        }
        return filteredItems;
    }

    // Recommend items based on rating
    public List<T> recommendByRating(int minRating) throws ItemNotFoundException {
        List<T> recommendedItems = mediaItems.stream()
                .filter(item -> item.getRating() >= minRating)
                .collect(Collectors.toList());
        if (recommendedItems.isEmpty()) {
            throw new ItemNotFoundException("No items found with rating >= " + minRating + ".");
        }
        return recommendedItems;
    }

    // Filter books by author
    public List<Book> filterBooksByAuthor(String author) throws ItemNotFoundException {
        List<Book> booksByAuthor = new ArrayList<>();
        for (T item : mediaItems) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    booksByAuthor.add(book);
                }
            }
        }
        if (booksByAuthor.isEmpty()) {
            throw new ItemNotFoundException("No books found by author '" + author + "'.");
        }
        return booksByAuthor;
    }

    // Filter movies by director
    public List<Movie> filterMoviesByDirector(String director) throws ItemNotFoundException {
        List<Movie> moviesByDirector = mediaItems.stream()
                .filter(item -> item instanceof Movie)  // Ensure the item is a Movie
                .map(item -> (Movie) item)  // Cast to Movie type
                .filter(movie -> movie.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.toList());
        if (moviesByDirector.isEmpty()) {
            throw new ItemNotFoundException("No movies found by director '" + director + "'.");
        }
        return moviesByDirector;
    }

    // Sorting methods by title, year, or rating
    public void sortByTitle() {
        mediaItems.sort(Comparator.comparing(Media::getTitle));
    }

    public void sortByYear() {
        mediaItems.sort(Comparator.comparingInt(Media::getYear));
    }

    public void sortByRating() {
        mediaItems.sort(Comparator.comparingDouble(Media::getRating).reversed());
    }

    // Method to print the details of all media items
    public void printAllItems() {
        for (T item : mediaItems) {
            System.out.println(item.toString());
        }
    }
}