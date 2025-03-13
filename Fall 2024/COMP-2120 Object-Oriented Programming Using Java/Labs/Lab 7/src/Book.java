public class Book extends Media {
    // Attributes
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String genre, int year, int rating, String author, String isbn) {
        super(title, genre, year, rating);
        setAuthor(author);
        setIsbn(isbn);
    }

    // Setter & Getter Methods
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // Display Information Method
    @Override
    public String toString() {
        return String.format("%s, Author: %s, ISBN: %s", super.toString(), author, isbn);
    }
}