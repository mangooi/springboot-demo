package club.mangooi.springboot.demo.mapper;

import club.mangooi.springboot.demo.repository.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    UserInfo getByUserId(String userId);
    boolean insert(UserInfo userInfo);
    List<UserInfo> getUsers();
    boolean updateUser(UserInfo userInfo);
    boolean deleteUser(int id);
    boolean deleteAllUsers();

}
