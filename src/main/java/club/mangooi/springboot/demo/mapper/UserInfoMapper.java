package club.mangooi.springboot.demo.mapper;

import club.mangooi.springboot.demo.bean.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    public UserInfo getById(int id);
    boolean insert(String userId);
    public List<UserInfo> getUsers();
    public boolean updateUser(UserInfo userInfo);
    public boolean deleteUser(int id);
    public boolean deleteAllUsers();

}
