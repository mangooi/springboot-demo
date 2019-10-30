package club.mangooi.springboot.demo.config;

import club.mangooi.springboot.demo.annotation.Authorization;
import club.mangooi.springboot.demo.exception.PermissionForbiddenException;
import club.mangooi.springboot.demo.exception.UserNotLoginException;
import club.mangooi.springboot.demo.utils.Constants;
import club.mangooi.springboot.demo.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(Authorization.class) == null) {
            String currentUser = request.getParameter(Constants.CURRENT_USER);
            request.setAttribute(Constants.CURRENT_USER,currentUser);
            String tokenValue = request.getParameter(Constants.TOKEN_VALUE);
            if (currentUser == null) {
                throw new UserNotLoginException("please input userId:xxxx");
            }
            if (tokenValue == null){
                throw new UserNotLoginException("请先登录");
            }
            if (!TokenUtil.check(currentUser, tokenValue)) {
                System.out.println("Check Error");
                throw new PermissionForbiddenException("无权限");
            }
        }
        return true;
    }


}
