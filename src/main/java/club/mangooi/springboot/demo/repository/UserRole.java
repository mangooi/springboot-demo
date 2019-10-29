package club.mangooi.springboot.demo.repository;

import lombok.Data;

import java.util.Date;

/**
 * USER_ID
 * PASSWORD
 * KEY
 * AUTHORITY
 * LAST_UPDATED_TIME
 * CREATED_TIME
 * VER
 */
@Data
public class UserRole {
    private String userId;
    private String hashedPassword;
    private String saltKey;
    private String authority;
    private Date lastUpdatedTime;
    private Date createdTime;
    private int ver;

    public UserRole() {
    }

    public UserRole(String userId, String hashedPassword, String saltKey, String authority, Date lastUpdatedTime, Date createdTime, int ver) {
        this.userId = userId;
        this.hashedPassword = hashedPassword;
        this.saltKey = saltKey;
        this.authority = authority;
        this.lastUpdatedTime = lastUpdatedTime;
        this.createdTime = createdTime;
        this.ver = ver;
    }
}
