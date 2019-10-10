package club.mangooi.springboot.demo.mapper;

import club.mangooi.springboot.demo.bean.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();
    List<User> getActiveUsers();
    List<User> getDeletedUsers();
    User getUserById(int id);
    User getUserByUserId(String userId);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(User user);
}
