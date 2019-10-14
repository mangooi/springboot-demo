package club.mangooi.springboot.demo.controller;


import club.mangooi.springboot.demo.request.UserLoginRequest;
import club.mangooi.springboot.demo.request.UserRegisterRequest;
import club.mangooi.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public boolean registerUser(UserRegisterRequest form){
        return userService.register(form);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    //@Authorization
    public boolean loginCheck(UserLoginRequest form){
        //System.out.println(request.getPassword());
        return userService.login(form.getUserId(),form.getPassword());
    }
}
