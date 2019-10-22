package club.mangooi.springboot.demo.repository;



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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCoi() {
        return userCoi;
    }

    public void setUserCoi(String userCoi) {
        this.userCoi = userCoi;
    }
}
