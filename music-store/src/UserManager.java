import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private AlbumManager albumManager;

    public UserManager(List<User> users, AlbumManager albumManager) {
        this.users = users;
        this.albumManager = albumManager;
    }

    public Album buyAlbum(Integer albumId, User user) {
        for (Album album : albumManager.findAllAlbums()) {
            if (album.getId().equals(albumId)) {
                if (user.getBalance() >= album.getPrice()) {
                    user.getUserAlbums().add(album);
                } else {
                    throw new RuntimeException("Yetersiz bakiye.");
                }
            }

        }
        throw new RuntimeException("Satın almak istediğiniz albüm bulunamadı.");
    }
}
