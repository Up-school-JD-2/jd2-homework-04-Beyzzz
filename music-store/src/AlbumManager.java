import java.util.ArrayList;
import java.util.List;

public class AlbumManager {
    private List<Album> albums;

    public AlbumManager(List<Album> albums) {
        this.albums = albums;
    }

    public List<Album> findAllAlbums(){
        return albums;
    }


    public Album addAlbum(Album album) {
        albums.add(album);
        System.out.println("Albüm eklendi.");
        return album;
    }
    public Album searchAlbumById(Integer id) {
        for (Album album : albums) {
            if (album.getId().equals(id)) {
                System.out.println("Albüm bulundu.");
                return album;
            }

        }
        throw new RuntimeException("Albüm bulunamadı");
    }


    public Album removeAlbumById(Integer id) {
        for (Album album : albums) {
            if (album.getId().equals(id)) {
                albums.remove(album);
                return album;
            }
        }
        throw new RuntimeException("Silmek istediğiniz album bulunamadı");
    }

}

