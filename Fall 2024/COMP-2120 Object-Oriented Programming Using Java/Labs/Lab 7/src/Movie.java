public class Movie extends Media {
    // Attributes
    private String director;
    private int duration;
    private String mpaaRating;

    // Constructor
    public Movie(String title, String genre, int year, int rating, String director, int duration, String mpaaRating) {
        super(title, genre, year, rating);
        setDirector(director);
        setDuration(duration);
        setMpaaRating(mpaaRating);
    }

    // Setter & Getter Methods
    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    // Display Information Method
    @Override
    public String toString() {
        return String.format("%s, Director: %s, Duration: %d mins, MPAA Rating: %s", super.toString(), director, duration, mpaaRating);
    }
}