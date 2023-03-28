public class MusicManager {
    private final AlbumManager albumManager;

    public MusicManager(AlbumManager albumManager) {
        this.albumManager = albumManager;
    }

    public Music addMusic(Integer albumId, Music music){
        for(Album album : albumManager.findAllAlbums()){
            if(album.getId().equals(albumId)){
                album.getMusics().add(music);
            }
        }
        throw new RuntimeException("Müzik eklenicek albüm bulunamadı.");
    }

    public Music removeById(Integer id) {
        for (Album album : albumManager.findAllAlbums()) {
            for (Music music : album.getMusics()) {
                if (music.getId().equals(id)) {
                    album.getMusics().remove(music);
                    System.out.println("Müzik albümden kaldırıldı");
                    return music;
                }
            }
        }
        throw new RuntimeException("Müxik hiçbir albümde bulunamadı.");
    }

    public Music searchById(Integer id) {
        for (Album album : albumManager.findAllAlbums()) {
            for (Music music : album.getMusics()) {
                if (music.getId().equals(id)) {
                    System.out.println("Müzik bulundu");
                    return music;
                }
            }
        }
        throw new RuntimeException("Müxik hiçbir albümde bulunamadı.");


    }
}
