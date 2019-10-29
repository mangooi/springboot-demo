package club.mangooi.springboot.demo.request;

import lombok.Data;

@Data
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

}
