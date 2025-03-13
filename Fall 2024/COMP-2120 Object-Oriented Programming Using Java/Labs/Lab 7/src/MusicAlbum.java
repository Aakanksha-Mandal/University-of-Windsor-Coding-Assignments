public class MusicAlbum extends Media {
    // Attributes
    private String artist;
    private int trackCount;
    private String releaseDate;

    // Constructor
    public MusicAlbum(String title, String genre, int year, int rating, String artist, int trackCount, String releaseDate) {
        super(title, genre, year, rating);
        setArtist(artist);
        setTrackCount(trackCount);
        setReleaseDate(releaseDate);
    }

    // Setter & Getter Methods
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    // Display Information Method
    @Override
    public String toString() {
        return String.format("%s, Artist: %s, Tracks: %d, Release Date: %s", super.toString(), artist, trackCount, releaseDate);
    }
}