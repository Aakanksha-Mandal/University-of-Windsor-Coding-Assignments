public class Magazine extends LibraryItem {
    // Attributes
    private String genre;

    // Constructor
    public Magazine(String title, int year, String genre) {
        super(title, year);
        this.genre = genre;
    }

    // Methods
    @Override
    public void getItemDetails() {
        System.out.println("Magazine: " + getTitle() + ", Genre: " + genre + ", Year: " + getYear());
        System.out.println("Note: This item is for reference only and cannot be loaned.");
    }
}