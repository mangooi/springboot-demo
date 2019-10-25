package club.mangooi.springboot.demo.controller;


import club.mangooi.springboot.demo.repository.UserInfo;
import club.mangooi.springboot.demo.mapper.UserInfoMapper;
import club.mangooi.springboot.demo.utils.Constants;
import club.mangooi.springboot.demo.utils.SingletonMybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/index") //在类上使用RequestMapping，里面设置的value就是方法的父路径
public class Controller {

    @Autowired
    private HttpServletRequest request;

    private static SqlSessionFactory sqlSessionFactory;
    static {
        sqlSessionFactory =  SingletonMybatis.getSqlSessionFactory();
    }



    @RequestMapping  //如果方法上的RequestMapping没有value，则此方法默认被父路径调用
    public String index(){
        return "hello spring boot";
    }
    //这里体现了restful风格的请求，按照请求的类型，来进行增删查改。
    //设计restful api（其实也就是URL），不要有冗余，例如不要写成getUsers，URL中
    //最好不要有动词。
    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public List<UserInfo> getUsers(){
        List<UserInfo> listUserInfos;
        //获取一个连接
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            //得到映射器
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            //调用接口中的方法去执行xml文件中的SQL语句
            listUserInfos = userInfoMapper.getUsers();
            //要提交后才会生效
            sqlSession.commit();
        }
        //最后记得关闭连接

        return listUserInfos;
    }
    //这里用的是路径变量，就是{}括起来的，会当做变量读进来
    @RequestMapping(method = RequestMethod.GET,value = "/users/{userId}")
    public UserInfo getUser(@PathVariable String userId){
        UserInfo userInfo;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            userInfo = userInfoMapper.getByUserId(userId);
            sqlSession.commit();
        }
        return userInfo;
    }
    //RequestBody这个注解可以接收json数据
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public boolean setUser(@RequestBody String name){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            String userId = request.getAttribute(Constants.CURRENT_USER).toString();
            UserInfo userInfo = userInfoMapper.getByUserId(userId);
            userInfo.setUserName(userId);
            userInfoMapper.updateUser(userInfo);
            sqlSession.commit();
        }
        return true;
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/user/{userid}/{name}")
    public boolean updateUser(@PathVariable int userid,@PathVariable String name){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = new UserInfo();
            userInfoMapper.updateUser(userInfo);
            sqlSession.commit();
        }
        return true;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/users")
    public boolean deleteUsers(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            userInfoMapper.deleteAllUsers();
            sqlSession.commit();
        }
        return true;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{userId}")
    public boolean deleteUser(@PathVariable int userId){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            userInfoMapper.deleteUser(userId);
            sqlSession.commit();
        }
        return true;
    }




}