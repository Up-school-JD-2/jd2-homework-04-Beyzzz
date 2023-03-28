import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Music> musics1 = new ArrayList<>() {{
            add(new Music(1, "Bayılırız Deliliğe", "Dolu Kadehi Ters Tut", 3.45));
            add(new Music(2, "Sevdirmeden Gidemezsin", "Dolu Kadehi Ters Tut", 3.23));
            add(new Music(3, "Kaçar Gider", "Dolu Kadehi Ters Tut", 2.58));
        }};

        List<Music> musics2 = new ArrayList<>() {{
            add(new Music(4, "Kollarıma Dön Bebeğim", "Can Ozan", 3.45));
            add(new Music(5, "Yaznlızlık Yeni Baştan", "Can Ozan", 3.0));
            add(new Music(6, "Hepsi Kafamda", "Can Ozan", 4.0));

        }};

        List<Music> musics3 = new ArrayList<>() {{
            add(new Music(7, "Gençliğime Sevgilerle", "Nil Karaibrahimgil", 6.25));
            add(new Music(8, "Benden Sana", "Nil Karaibrahimgil", 3.0));
            add(new Music(9, "Ben Aptal Mıyım", "Nil Karaibrahimgil", 3.21));

        }};

        Album album1 = new Album(101, musics1, "Dktt", "Dolu Kadehi Ters Tut", LocalDate.of(2022, 02, 03), 50.0);
        Album album2 = new Album(102, musics3, "Çiçek", "Nil Karaibrahimgil", LocalDate.of(2023, 01, 04), 30.0);
        Album album3 = new Album(103, musics2, "Dolunay", "Can Ozan ", LocalDate.of(2020, 01, 04), 100.0);
      //  Album album4 = new Album(104, musics1, "Ezhel", "Ezhel ", LocalDate.of(2021, 01, 04), 78.0);

        List<Album> allAlbums = new ArrayList<>() {{
            add(album1);
            add(album2);
            add(album3);
           // add(album4);
        }};


        User user1 = new User(1, "Ayşe", "ayse@gmail.com ", "123", 500.0, new ArrayList<>());
        User user2 = new User(2, "Gizem", "Gizem@gmail.com ", "345", 120.0, new ArrayList<>());

        List<User> users = new ArrayList<>() {{
            add(user1);
            add(user2);
        }};

        AlbumManager albumManager = new AlbumManager(allAlbums);
        UserManager userManager = new UserManager(users, albumManager);
        MusicManager musicManager = new MusicManager(albumManager);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Müzik Uygulamasına Hoş Geldiniz...");

        listAlbums(allAlbums);

        searchAlbum(albumManager, scanner);

        removeAlbum(albumManager, scanner);

        addAlbum(albumManager, scanner);


        System.out.println("Kullanıcı adı giriniz: ");
        String userName = scanner.nextLine();

        System.out.println("Lütfen Şifre Giriniz: ");
        String password = scanner.nextLine();

        User currentUser;

        while ((currentUser = authenticateUser(users, scanner, userName, password)) == null) {
            System.out.println("Böyle bir kullanıcı yok, lütfen geçerli bir kullanıcı girin...");
            userName = scanner.nextLine();
        }

        System.out.println("Mevcut albümleriniz: ");

        for (Album album : currentUser.getUserAlbums()) {
            System.out.println(album.getId() + " " + album.getAlbumName() + " "
                    + album.getPrice() + " " + album.getAlbumArtist() + " " + album.getAlbumDate());
        }

        buyAlbum(userManager, scanner, currentUser);


        System.out.println("Bulmak istediğiniz müziğin numarasını giriniz:");
        Integer musicId = scanner.nextInt();
        try {
            Music music = musicManager.searchById(musicId);
            System.out.println("Aradığınız müzik:" + music.getMusicName() + music.getArtistName() + music.getMusicLength());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Yeni bir müzik ekleyin, sırasıya" +
                " numarasını, isimini" +
                " şarkıcı ismini ve müzik uzunluğunu girin: ");

        Integer musicIdToAdd  = scanner.nextInt();
        Integer albumIdToAddMusic = scanner.nextInt();
        String musicName = scanner.nextLine();
        String artistName = scanner.nextLine();
        Double musicLenght = scanner.nextDouble();


        musicManager.addMusic(albumIdToAddMusic,new Music(musicIdToAdd,musicName,artistName,musicLenght));

        System.out.println("Silmek istediğiniz müzik numarsını giriniz:");
        Integer musicIdToRemove = scanner.nextInt();

        try {
            Music music = musicManager.removeById(musicIdToRemove);
            System.out.println("Silmek istediğiniz müzik:"+ music.getMusicName()+ music.getArtistName()+ music.getMusicLength());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }






    private static void buyAlbum(UserManager userManager, Scanner scanner, User currentUser) {
        System.out.println("Albümler arasından satın almak istediğiniz albümün numarasını girin: ");

        Integer albumId = scanner.nextInt();

        try {
            userManager.buyAlbum(albumId, currentUser);
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private static void listAlbums(List<Album> allAlbums) {
        System.out.println("Tüm albümler:");

        for (Album album : allAlbums) {
            System.out.println(album.getId() + " " + album.getAlbumName() + " "
                    + album.getPrice() + " " + album.getAlbumArtist() + " " + album.getAlbumDate());
            for (Music music : album.getMusics()) {
                System.out.println(music.getId() + " " + music.getMusicName());
            }
        }
    }

    private static void searchAlbum(AlbumManager albumManager, Scanner scanner) {
        System.out.println("Numarası ile albüm arayın: ");

        Integer albumIdToSearch = scanner.nextInt();

        try {
            Album album = albumManager.searchAlbumById(albumIdToSearch);
            System.out.println("Aradığınız albüm: " + album.getAlbumName() + " "
                    + album.getPrice() + " " + album.getAlbumArtist() + " " + album.getAlbumDate());
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private static void addAlbum(AlbumManager albumManager, Scanner scanner) {
        System.out.println("Yeni bir albüm ekleyin, sırasıya" +
                " numarasını, isimini" +
                " şarkıcı ismini ve fiyatını girin: ");

        Integer albumIdToAdd = scanner.nextInt();
        scanner.nextLine();
        String albumName = scanner.nextLine();
        String albumArtist = scanner.nextLine();
        Double albumPrice = scanner.nextDouble();

        albumManager.addAlbum(new Album(albumIdToAdd, new ArrayList<>(),
                albumName, albumArtist, LocalDate.now(), albumPrice));
    }

    private static void removeAlbum(AlbumManager albumManager, Scanner scanner) {
        System.out.println("Çıkarmak istediğiniz albümün numarasını girin: ");

        Integer albumIdToRemove = scanner.nextInt();

        try {
            Album album = albumManager.removeAlbumById(albumIdToRemove);
            System.out.println("Çıkardığınız albüm: " + album.getAlbumName() + " "
                    + album.getPrice() + " " + album.getAlbumArtist() + " " + album.getAlbumDate());
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }



    private static User authenticateUser(List<User> users, Scanner scanner, String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                while (!user.getPassword().equals(password)) {
                    System.out.println("Şifre Yanlış. Lütfen tekrar giriniz.");
                    password = scanner.nextLine();
                }
                System.out.println("Şifre doğru, Hoşgeldin.." + user.getUserName());
                return user;
            }
        }
        return null;
    }
}


