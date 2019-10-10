package club.mangooi.springboot.demo.service;

import club.mangooi.springboot.demo.request.UserRegisterRequest;

public interface UserService {
    boolean register(UserRegisterRequest form);
    boolean login(String id,String password);
}
