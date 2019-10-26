package club.mangooi.springboot.demo.service.base;

import club.mangooi.springboot.demo.utils.CommonUtils;
import club.mangooi.springboot.demo.utils.Constants;
import club.mangooi.springboot.demo.utils.SingletonMybatis;
import org.apache.ibatis.session.SqlSession;
import javax.servlet.http.HttpServletRequest;


public interface BaseService {

    default <T> T getMapper(Class<T> z) {
        HttpServletRequest request = CommonUtils.getCurrentRequest();
        Object temp = request.getAttribute(Constants.SQL_SESSION);
        SqlSession sqlSession;
        if(temp == null){
            sqlSession = SingletonMybatis.getSqlSession();
            request.setAttribute(Constants.SQL_SESSION, sqlSession);
        }else {
            sqlSession = (SqlSession) temp;
        }
        return sqlSession.getMapper(z);
    }
}
