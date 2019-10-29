package club.mangooi.springboot.demo.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String userId;
    private String password;

    public UserLoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public UserLoginRequest() {
    }

}
