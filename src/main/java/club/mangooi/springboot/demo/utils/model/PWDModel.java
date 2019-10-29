package club.mangooi.springboot.demo.utils.model;

import lombok.Data;

@Data
public class PWDModel {
    private String hashedPassword;
    private String saltKey;

    public PWDModel() {
    }

    public PWDModel(String hashedPassword, String saltKey) {
        this.hashedPassword = hashedPassword;
        this.saltKey = saltKey;
    }

}
