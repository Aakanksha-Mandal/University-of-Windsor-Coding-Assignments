public abstract class LibraryItem {
    // Attributes
    private String title;
    private int year;

    // Constructor
    public LibraryItem(String title, int year) {
        setTitle(title);
        setYear(year);
    }

    // Abstract Method
    public abstract void getItemDetails();

    // Setters and getters
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
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
    
}
