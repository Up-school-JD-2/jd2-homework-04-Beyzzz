import java.util.List;
import java.util.Objects;

public class User {
    private Integer id;
    private String userName;
    private String eMail;
    private String password;
    private Double balance;
    private List<Album> userAlbums;

    public User(Integer id, String accountName, String eMail, String password, Double balance, List<Album> userAlbums) {
        this.id = id;
        this.userName = accountName;
        this.eMail = eMail;
        this.password = password;
        this.balance = balance;

        this.userAlbums = userAlbums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<Album> getUserAlbums() {
        return userAlbums;
    }


    public Integer getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }


    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


}
