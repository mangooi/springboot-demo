package club.mangooi.springboot.demo.bean;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }
}
