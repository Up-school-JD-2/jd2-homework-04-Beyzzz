import java.util.Objects;

public class Music {
    private Integer id;
    private String musicName;
    private String artistName;
    private double musicLength;


    public Music(Integer id, String musicName, String artistName, double musicLength) {
        this.id = id;
        this.musicName = musicName;
        this.artistName = artistName;
        this.musicLength = musicLength;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return id.equals(music.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public double getMusicLength() {
        return musicLength;
    }

    public void setMusicLength(double musicLength) {
        this.musicLength = musicLength;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", musicLength=" + musicLength +
                '}';
    }
}
