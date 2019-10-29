package club.mangooi.springboot.demo.repository;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userId;
    private String userPhone;
    private int delFlag;

    public User() {
    }

    public User(int id, String userId, String userPhone, int delFlag) {
        this.id = id;
        this.userId = userId;
        this.userPhone = userPhone;
        this.delFlag = delFlag;
    }


}
