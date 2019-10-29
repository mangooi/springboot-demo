package club.mangooi.springboot.demo.service.impl;

import club.mangooi.springboot.demo.repository.User;
import club.mangooi.springboot.demo.repository.UserInfo;
import club.mangooi.springboot.demo.repository.UserRole;
import club.mangooi.springboot.demo.request.UserRegisterRequest;
import club.mangooi.springboot.demo.mapper.UserInfoMapper;
import club.mangooi.springboot.demo.mapper.UserMapper;
import club.mangooi.springboot.demo.mapper.UserRoleMapper;
import club.mangooi.springboot.demo.service.UserService;
import club.mangooi.springboot.demo.utils.PWDUtil;
import club.mangooi.springboot.demo.utils.model.PWDModel;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean register(UserRegisterRequest form) {
        //获取数据库连接
        UserMapper userMapper = getMapper(UserMapper.class);
        UserInfoMapper userInfoMapper = getMapper(UserInfoMapper.class);
        UserRoleMapper userRoleMapper = getMapper(UserRoleMapper.class);

        //密码加密
        PWDModel model = PWDUtil.initPwd(form.getPassword());

        //User
        User user = new User();
        user.setUserId(form.getUserId());
        user.setUserPhone(form.getUserPhone());

        //UserInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(form.getUserId());

        //UserRole
        UserRole userRole = new UserRole();
        userRole.setUserId(form.getUserId());
        userRole.setHashedPassword(model.getHashedPassword());
        userRole.setSaltKey(model.getSaltKey());
        userRole.setAuthority(form.getAuthority());

        //数据库操作
        userMapper.insert(user);
        userInfoMapper.insert(userInfo);
        userRoleMapper.register(userRole);


        return true;
    }

    @Override
    public boolean login(String id, String password) {
        UserRoleMapper userRoleMapper = getMapper(UserRoleMapper.class);
        PWDModel pwdModel = userRoleMapper.getPWDModel(id);
        return PWDUtil.checkPwd(pwdModel, password);
    }


}
