public class Podcast extends Media {
    // Attributes
    private String host;
    private int episodeCount;

    // Constructor
    public Podcast(String title, String genre, int year, int rating, String host, int episodeCount) {
        super(title, genre, year, rating);
        setHost(host);
        setEpisodeCount(episodeCount);
    }

    // Setter & Getter Methods
    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    // Display Information Method
    @Override
    public String toString() {
        return String.format("%s, Host: %s, Episodes: %d", super.toString(), host, episodeCount);
    }
}