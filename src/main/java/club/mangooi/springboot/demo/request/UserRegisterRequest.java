package club.mangooi.springboot.demo.request;

public class UserRegisterRequest {
    private String userId;
    private String userPhone;
    private String password;
    private String authority;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String userId, String userPhone, String password, String authority) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.password = password;
        this.authority = authority;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
