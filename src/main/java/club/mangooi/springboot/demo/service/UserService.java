package club.mangooi.springboot.demo.service;

import club.mangooi.springboot.demo.request.UserRegisterRequest;
import club.mangooi.springboot.demo.service.base.BaseService;

public interface UserService extends BaseService {
    boolean register(UserRegisterRequest form);
    boolean login(String id,String password);
}
