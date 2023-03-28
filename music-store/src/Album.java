import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Album {
    private Integer id;
    private List<Music> musics;
    private String albumName;
    private String albumArtist;
    private LocalDate albumDate;
    private Double price;


    public Album(Integer id, List<Music> musics, String albumName, String albumArtist, LocalDate albumDate,Double price) {
        this.id = id;
        this.musics = musics;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.albumDate = albumDate;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id.equals(album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }


    public LocalDate getAlbumDate() {
        return albumDate;
    }


    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
