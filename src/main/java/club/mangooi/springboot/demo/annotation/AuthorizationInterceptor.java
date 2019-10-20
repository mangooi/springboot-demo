package club.mangooi.springboot.demo.annotation;

import club.mangooi.springboot.demo.utils.Constants;
import club.mangooi.springboot.demo.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.lang.reflect.Method;


@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("AuthorizationInterceptor.preHandle(...)");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(Authorization.class)== null) {
            if (!TokenUtil.check(String.valueOf(request.getAttribute(Constants.CURRENT_USER)), Constants.TOKEN_VALUE)) {
                throw new HTTPException(401);
            }
        }

        return true;
    }


}
