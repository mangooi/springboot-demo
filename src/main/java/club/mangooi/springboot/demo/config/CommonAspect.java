package club.mangooi.springboot.demo.config;

import club.mangooi.springboot.demo.utils.CommonUtils;
import club.mangooi.springboot.demo.utils.Constants;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CommonAspect {

    private Logger logger = LoggerFactory.getLogger(CommonAspect.class);

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void servicePointCut(){}

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controlPointCut(){}

    @Before("servicePointCut()")
    public void serviceBefore(JoinPoint joinPoint){
        logger.info(joinPoint.getStaticPart().toString());
    }



    @Before("controlPointCut()")
    public void controlBefore(JoinPoint joinPoint){
        logger.info(joinPoint.getStaticPart().toString());
    }

    @After("controlPointCut()")
    public void controlAfter(){
        HttpServletRequest request = CommonUtils.getCurrentRequest();
        Object o = request.getAttribute(Constants.SQL_SESSION);
        if (o == null) return;
        logger.info(o.toString());
        SqlSession sqlSession = (SqlSession) o;
        sqlSession.commit();
        sqlSession.close();
    }

    @AfterThrowing("controlPointCut()")
    public void controlAfterThrowing(){
        logger.error("error");
        HttpServletRequest request = CommonUtils.getCurrentRequest();
        Object o = request.getAttribute(Constants.SQL_SESSION);
        if (o == null) return;
        logger.error(o.toString());
        SqlSession sqlSession = (SqlSession) o;
        sqlSession.rollback();
        sqlSession.close();
    }
}
