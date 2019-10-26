package club.mangooi.springboot.demo.controller;


import club.mangooi.springboot.demo.annotation.Authorization;
import club.mangooi.springboot.demo.request.UserLoginRequest;
import club.mangooi.springboot.demo.request.UserRegisterRequest;
import club.mangooi.springboot.demo.service.UserService;
import club.mangooi.springboot.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @Authorization
    public String registerUser(UserRegisterRequest form) {
        return userService.register(form) ? TokenUtil.create(form.getUserId()) : "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @Authorization
    public String loginCheck(UserLoginRequest form) {
        return userService.login(form.getUserId(), form.getPassword()) ? TokenUtil.create(form.getUserId()) : "";
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
}
