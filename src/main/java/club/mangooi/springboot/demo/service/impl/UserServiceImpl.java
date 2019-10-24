package club.mangooi.springboot.demo.service.impl;

import club.mangooi.springboot.demo.repository.User;
import club.mangooi.springboot.demo.repository.UserInfo;
import club.mangooi.springboot.demo.repository.UserRole;
import club.mangooi.springboot.demo.request.UserRegisterRequest;
import club.mangooi.springboot.demo.mapper.UserInfoMapper;
import club.mangooi.springboot.demo.mapper.UserMapper;
import club.mangooi.springboot.demo.mapper.UserRoleMapper;
import club.mangooi.springboot.demo.service.UserService;
import club.mangooi.springboot.demo.utils.SingletonMybatis;
import club.mangooi.springboot.demo.utils.PWDUtil;
import club.mangooi.springboot.demo.utils.model.PWDModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean register(UserRegisterRequest form) {
        //获取数据库连接
        SqlSession sqlSession = SingletonMybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);

        //密码加密
        PWDModel model = PWDUtil.initPwd(form.getPassword());

        //User
        User user = new User();
        user.setUserId(form.getUserId());
        user.setUserPhone(form.getUserPhone());

        //UserInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(form.getUserId());

        //以下这部分以后封装
        UserRole userRole = new UserRole();
        userRole.setUserId(form.getUserId());
        userRole.setHashedPassword(model.getHashedPassword());
        userRole.setSaltKey(model.getSaltKey());
        userRole.setAuthority(form.getAuthority());
        Date date = new Date();
        userRole.setCreatedTime(date);
        userRole.setLastUpdatedTime(date);

        //数据库操作
        userMapper.insert(user);
        userInfoMapper.insert(userInfo);
        userRoleMapper.register(userRole);

        sqlSession.commit();
        sqlSession.close();

        return true;
    }

    @Override
    public boolean login(String id, String password) {
        //获取数据库连接
        SqlSession sqlSession = SingletonMybatis.getSqlSession();
        UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);
        PWDModel pwdModel = userRoleMapper.getPWDModel(id);
        //System.out.println(pwdModel.getHashedPassword()+pwdModel.getSaltKey());
        sqlSession.close();
        return PWDUtil.checkPwd(pwdModel, password);
    }

}
