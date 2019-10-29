package club.mangooi.springboot.demo.repository;


import lombok.Data;

@Data
public class UserInfo {

    private String userId;
    private String userName;
    private String userCoi;

    public UserInfo(){
    }

    public UserInfo(String userId, String userName, String userCoi) {
        this.userId = userId;
        this.userName = userName;
        this.userCoi = userCoi;
    }

}
