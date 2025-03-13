public class Media {
    // Attributes
    private String title;
    private String genre;
    private int year;
    private int rating;

    // Constructor
    public Media(String title, String genre, int year, int rating) {
        setTitle(title);
        setGenre(genre);
        setYear(year);
        setRating(rating);
    }

    // Setter & Getter Methods
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setYear(int year) {
        // Validate year: assume items must be between 0 and the current year
        int currentYear = java.time.Year.now().getValue();
        if (year <= 0 || year > currentYear) {
            throw new IllegalArgumentException("Error: Invalid year. Please enter a valid year.");
        }
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setRating(int rating) {
        // Validate rating
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Error: Invalid rating. Please enter a rating between 0 and 5.");
        }
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    // Display Information Method
    public String toString() {
        return String.format("Title: %s, Genre: %s, Year: %d, Rating: %d", title, genre, year, rating);
    }
}
