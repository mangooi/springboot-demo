package club.mangooi.springboot.demo.repository;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
