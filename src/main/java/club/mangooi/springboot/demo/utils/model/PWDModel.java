package club.mangooi.springboot.demo.utils.model;

public class PWDModel {
    private String hashedPassword;
    private String saltKey;

    public PWDModel() {
    }

    public PWDModel(String hashedPassword, String saltKey) {
        this.hashedPassword = hashedPassword;
        this.saltKey = saltKey;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSaltKey() {
        return saltKey;
    }

    public void setSaltKey(String saltKey) {
        this.saltKey = saltKey;
    }
}
